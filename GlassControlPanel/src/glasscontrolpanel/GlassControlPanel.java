package glasscontrolpanel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JToggleButton;
/**
 * @author Johnny White
 * Modifications by Jacob Troxel
 * Modifications by George Moore
 */
public class GlassControlPanel
{
    ////////////////////////////////////////////////
    //
    //      CONSTANTS / "MAGIC" NUMBERS
    //
    ////////////////////////////////////////////////
    static final int ID_OFFSET = 21;
    ////////////////////////////////////////////////
    static final int ID_SCALE = 1 << ID_OFFSET;
    static final int TIME_MESSAGE_ID = 256 * ID_SCALE;              // 0x200
    static final int MOTOR_MESSAGE_ID = 292 * ID_SCALE;             // 0x248
    static final int TORQUE_COMMAND_MESSAGE_ID = 300 * ID_SCALE;    // 0x258
    static final int STATE_MESSAGE_ID = 304 * ID_SCALE;             // 0x260
    static final int PARAM_REQUEST_MESSAGE_ID = 312 * ID_SCALE;     // 0x270 
    static final int LAUNCH_PARAM_MESSAGE_ID = 320 * ID_SCALE;      // 0x280
    static final int CP_CL_RMT_MESSAGE_ID = 328 * ID_SCALE;         // 0x290
    static final int CP_CL_LCL_MESSAGE_ID = 329 * ID_SCALE;         // 0x292
    static final int CP_INPUTS_RMT_MESSAGE_ID = 330 * ID_SCALE;     // 0x294
    static final int CP_INPUTS_LCL_MESSAGE_ID = 331 * ID_SCALE;     // 0x296
    static final int CP_OUTPUTS_MESSAGE_ID = 336 * ID_SCALE;        // 0x2A0
    static final int ORIENTATION_ID = 385 * ID_SCALE;               // 0x302
    static final int DRUM_MESSAGE_ID = 432 * ID_SCALE;              // 0x360
    static final int TENSION_MESSAGE_ID = 448 * ID_SCALE;           // 0x380
    static final int CABLE_ANGLE_MESSAGE_ID = 464 * ID_SCALE;       // 0x3a0
    static final int ZERO_ODOMETER_ID = 672 * ID_OFFSET;            // 0x540
    static final int ZERO_TENSIOMETER_ID = 681 * ID_OFFSET;         // 0x552
    static final int DENSITY_ALTITUDE_ID = 689 * ID_SCALE;          // 0x562
    static final int WIND_ID = 690 * ID_SCALE;                      // 0x564
    static final int BATTERY_SYSTEM_ID = 704 * ID_SCALE;            // 0x580    
    
    static final int CL_HEARTBEAT_COUNT = 60;  //  control lever heartbeat count
    static final int SW_HEARTBEAT_COUNT = 51;  //  switch heartbeat count 
    static final float CL_DELTA_TOL = 0.005f;
    ////////////////////////////////////////////////
    static final String HUBSERVER_ADDRESS = "147.222.165.75";       //HUB-SERVER
    //static final String HUBSERVER_ADDRESS = "127.0.0.1";       // GeorgeHUB-SERVER

    static final int HUBSERVER_PORT = 32123;
    ////////////////////////////////////////////////
    //
    //      MAIN LOOP
    //      - Listen for TIME Messages,
    //        and reply with two of our own.
    //
    ////////////////////////////////////////////////
    private static BufferedWriter writer;
    
    public static void main(String args[]) throws InterruptedException
    {
        CanCnvt gcpMessageControlLever = new CanCnvt();
        gcpMessageControlLever.id = CP_CL_RMT_MESSAGE_ID;
        gcpMessageControlLever.dlc = 2;
        
        CanCnvt gcpMessageInputs = new CanCnvt();
        gcpMessageInputs.id = CP_INPUTS_RMT_MESSAGE_ID;
        gcpMessageInputs.dlc = 2;
        
        CanCnvt gcpMessage0Tensiomenter = new CanCnvt();
        gcpMessage0Tensiomenter.id = ZERO_TENSIOMETER_ID;
        gcpMessage0Tensiomenter.set_byte(1, 0);
        gcpMessage0Tensiomenter.dlc = 1;
        
        CanCnvt gcpMessage0Odometer = new CanCnvt();
        gcpMessage0Odometer.id = ZERO_TENSIOMETER_ID;
        gcpMessage0Odometer.set_byte(1, 0);
        gcpMessage0Odometer.dlc = 1;
        
        CanCnvt canIn = new CanCnvt();
        String msg;
        
        ControlPanel cp = new ControlPanel();
        cp.setVisible(true);

        float current_lever_position = cp.getSlider();
        short prev_sw = -1;
        short current_sw;
        float prev_CL = 0;
        float current_CL;
        //int lastMessage;
        
        try
        {            
            Socket connection = new Socket(HUBSERVER_ADDRESS, HUBSERVER_PORT);
            connection.setTcpNoDelay(true);

            BufferedReader instream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            OutputStreamWriter outstream = new OutputStreamWriter(connection.getOutputStream());
            writer = new BufferedWriter(outstream);
            cp.setWriter(writer);
            System.out.println("Connected");
            int countCL = 0;
            int countSW = 0;
            while (true)
            {
                if ((msg = instream.readLine()) == null)
                {
                    System.out.println("Null message received");
                } else
                {
                    canIn.convert_msgtobin(msg);
                    //System.out.println(" Message Received " + canIn.id + " " +TIME_MESSAGE_ID );
                    if (canIn.id == TIME_MESSAGE_ID)
                    {
                        //System.out.println("Time Message Received " + canIn.id);
                        current_sw = (short) cp.getGCPInteraction();
                        if (--countSW <= 0
                                || current_sw != prev_sw)
                        {
                            gcpMessageInputs.set_short(current_sw, 0);
                            outstream.write(gcpMessageInputs.msg_prep());
                            prev_sw = current_sw;
                            countSW = SW_HEARTBEAT_COUNT;
                        }
                        current_CL = cp.getSlider();
                        if (--countCL <= 0
                                || Math.abs(current_CL - prev_CL)
                                >= CL_DELTA_TOL)
                        {
                            gcpMessageControlLever.set_halffloat(current_CL, 0);
                            outstream.write(gcpMessageControlLever.msg_prep());
                            prev_CL = current_CL;
                            countCL = CL_HEARTBEAT_COUNT;
                        }
                        outstream.flush();
                    }
                    if (canIn.id == STATE_MESSAGE_ID) {
                        int currentState = canIn.get_byte(0) & 0x1f;
                        cp.switchState(currentState);
                    }
                }
            }
        } 
        catch (ConnectException ce) {
            System.out.println("Couldn't Connect To HUB-SERVER");
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
