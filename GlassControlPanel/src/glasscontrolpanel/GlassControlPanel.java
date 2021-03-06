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
 */
public class GlassControlPanel
{
    ////////////////////////////////////////////////
    //
    //      CONSTANTS / "MAGIC" NUMBERS
    //
    ////////////////////////////////////////////////
    static final int ID_OFFSET = 1 << 21;
    ////////////////////////////////////////////////
    static final int TIME_MESSAGE_ID             = 256 * ID_OFFSET;    // 0x200
    static final int MOTOR_MESSAGE_ID            = 296 * ID_OFFSET;    // 0x250
    static final int TORQUE_MESSAGE_ID           = 300 * ID_OFFSET;    // 0x258
    static final int STATE_MESSAGE_ID            = 304 * ID_OFFSET;    // 0x260
    static final int LAUNCH_PARAM_MESSAGE_ID     = 327 * ID_OFFSET;    // 0x28e
    static final int TENSION_MESSAGE_ID          = 448 * ID_OFFSET;    // 0x380
    static final int CABLE_ANGLE_MESSAGE_ID      = 464 * ID_OFFSET;    // 0x3a0
    static final int PARAM_REQUEST_MESSAGE_ID    = 312 * ID_OFFSET;    // 0x270    
    static final int CP_CONTROL_LEVER_RMT        = 328 * ID_OFFSET;    // 0x290
    static final int CP_CONTROL_LEVER_LCL        = 329 * ID_OFFSET;    // 0x292
    static final int CP_CONTROL_PANEL_INPUTS_RMT = 330 * ID_OFFSET;    // 0x294
    static final int CP_CONTROL_PANEL_INPUTS_LCL = 331 * ID_OFFSET;    // 0x296
    static final int CP_CONTROL_PANEL_OUTPUTS    = 336 * ID_OFFSET;    // 0x2a0
    static final int CONTROL_LEVER_MESSAGE_ID    = 641 * ID_OFFSET;    // 0x502
    
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
        gcpMessageControlLever.id = CP_CONTROL_LEVER_RMT;
        gcpMessageControlLever.dlc = 2;
        
        CanCnvt gcpMessageInputs = new CanCnvt();
        gcpMessageInputs.id = CP_CONTROL_PANEL_INPUTS_RMT;
        gcpMessageInputs.dlc = 2;

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
                } 
                else {
                    canIn.convert_msgtobin(msg);
                    if (canIn.id == TIME_MESSAGE_ID) {
                        current_sw = (short) cp.getGCPInteraction();
                        if (--countSW <= 0
                                || current_sw != prev_sw) {
                            gcpMessageInputs.set_short(current_sw, 0);
                            outstream.write(gcpMessageInputs.msg_prep());
                            prev_sw = current_sw;
                            countSW = SW_HEARTBEAT_COUNT;
                        }
                        current_CL = cp.getSlider();
                        if (--countCL <= 0 
                                || Math.abs(current_CL - prev_CL)
                                >= CL_DELTA_TOL) {
                            gcpMessageControlLever.set_halffloat(current_CL, 0);                            
                            outstream.write(gcpMessageControlLever.msg_prep()); 
                            prev_CL = current_CL;
                            countCL = CL_HEARTBEAT_COUNT;
                        }
                        outstream.flush();
                    }                    
                    /*    if( HEARTBEAT_COUNT_ID - count == 0 ||
                        cp.getState() != current_state ||
                        cp.getSlider() != current_lever_position)
                    {*/
                        canIn.convert_msgtobin(msg);

                        switch (canIn.id) 
                        {
                            case TIME_MESSAGE_ID:
                                gcpMessageControlLever.set_halffloat(cp.getSlider(), 0);
                                gcpMessageInputs.set_short(cp.getGCPInteraction(), 0);
                                outstream.write(gcpMessageControlLever.msg_prep());
                                outstream.write(gcpMessageInputs.msg_prep());
                                outstream.flush();
                                break;
                            case STATE_MESSAGE_ID:
                                int currentState = canIn.get_byte(0) & 0x1f;
                                cp.switchState(currentState);
                        }
                        //count = 0;
                        //current_state = cp.getState();
                    /*}
                        current_lever_position = cp.getSlider();
                    {
                        count++;
                    }*/
                }
            }
        } 
        catch (ConnectException ce)
        {
            System.out.println("Couldn't Connect To HUB-SERVER");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }    
    }
}