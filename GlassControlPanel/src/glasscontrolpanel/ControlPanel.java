/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasscontrolpanel;

import java.util.Arrays;

/**
 *
 * @author Johnny White
 */

/**
 *
 * @author  troy
 * @author  Johnny White
 * @date    November 3, 2014
 */
public class ControlPanel extends javax.swing.JFrame {
    // control panel bit-mapping
    static final int SW_SAFE        = 1 << 15;      // active low
    static final int SW_ACTIVE      = 1 << 14;      // active low
    static final int PB_ARM         = 1 << 13;      // active low
    static final int PB_PREP        = 1 << 12;      // active low
    static final int CL_RST_NO      = 1 << 11;      // low at rest
    static final int CL_FS_NO       = 1 << 8;       // low at full scale
    static final int PB_0_TENSION   = 1 << 4;       // active low
    static final int PB_0_ODOMETER  = 1 << 3;       // active low
    static final int PB_BRAKE       = 1 << 2;       // active low
    static final int PB_GUILLOTINE  = 1 << 1;       // active low
    static final int SW_EMERGENCY   = 1 << 0;       // active low

    /**
     * Creates new form controlPanel
     */
    public ControlPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    

    private void initComponents() {

        sasSwitch = new javax.swing.JToggleButton();
        prepRecButton = new javax.swing.JButton();
        controlLever = new javax.swing.JSlider();
        tensionButton = new javax.swing.JButton();
        odometerButton = new javax.swing.JButton();
        armDisarmButton = new javax.swing.JButton();
        gSwitch = new javax.swing.JButton();
        brakeSwitch = new javax.swing.JButton();
        emergencyStop = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LED_Display = new javax.swing.JTextArea();
        stateDiagramPanel = new StateMachineDiagram();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        armDisarmButton.setBackground(new java.awt.Color(255, 0, 0));
        armDisarmButton.setText("Arm/Disarm");
        armDisarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armDisarmButtonActionPerformed(evt);
            }
        });

        prepRecButton.setBackground(new java.awt.Color(255, 255, 0));
        prepRecButton.setText("Retrieve/Prep");

        controlLever.setOrientation(javax.swing.JSlider.VERTICAL);
        controlLever.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        controlLever.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tensionButton.setBackground(new java.awt.Color(255, 102, 0));
        tensionButton.setText("Zero Tension");

        odometerButton.setBackground(new java.awt.Color(255, 102, 0));
        odometerButton.setText("Zero Odometer");
        odometerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odometerButtonActionPerformed(evt);
            }
        });

        sasSwitch.setBackground(new java.awt.Color(0, 255, 255));
        sasSwitch.setText("Safe/Operate");

        gSwitch.setBackground(new java.awt.Color(204, 51, 255));
        gSwitch.setText("Guillotine");
        gSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gSwitchActionPerformed(evt);
            }
        });

        brakeSwitch.setBackground(new java.awt.Color(204, 51, 255));
        brakeSwitch.setText("Brake");

        emergencyStop.setBackground(new java.awt.Color(255, 0, 51));
        emergencyStop.setText("Stop");

        //stateDiagramPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        /*javax.swing.GroupLayout stateDiagramPanelLayout = new javax.swing.GroupLayout(stateDiagramPanel);
        stateDiagramPanel.setLayout(stateDiagramPanelLayout);
        stateDiagramPanelLayout.setHorizontalGroup(
            stateDiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        stateDiagramPanelLayout.setVerticalGroup(
            stateDiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );*/
        LED_Display.setColumns(20);
        LED_Display.setRows(4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlLever, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sasSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(armDisarmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tensionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emergencyStop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prepRecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(odometerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brakeSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(stateDiagramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(controlLever, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stateDiagramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emergencyStop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(gSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(brakeSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tensionButton)
                                    .addComponent(odometerButton)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sasSwitch)
                            .addComponent(prepRecButton)
                            .addComponent(armDisarmButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void armDisarmButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void odometerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void gSwitchActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (true) {
                    javax.swing.UIManager.setLookAndFeel("Nimbus");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
    }
    //pre: Assumes all ASCII inputs are 20 characters or less 
    public void updateLCDDisplay(byte[] cb_input){
        //Initialize rows
        byte[] input            = new byte[8];
        byte[] location         = new byte[1];
        CanCnvt canIn           = new CanCnvt();
        String msg              = new String();
        int row_loc             = 0;
        int col_loc             = 0;
        int range_value         = 0;
        String default_string   = "                    "; //row of twenty spaces
        String row1             = default_string;
        String row2             = default_string;
        String row3             = default_string;
        String row4             = default_string;
        
        //get ASCII inputs
        if(cb_input.length <= input.length){
            input = Arrays.copyOfRange(cb_input, 1, 8);
            location = Arrays.copyOfRange(cb_input, 0, 0);
        }
        else{
            System.out.println("Error: CanBus Message Size Error");
        }
        //Check the message's intended location        
        //Check intended ROW
        if(isBitSet(location[0], 5) && !isBitSet(location[0], 6) &&
                !isBitSet(location[0], 7)){                         //001
           row_loc = 1;
        }
        if(!isBitSet(location[0], 5) && isBitSet(location[0], 6) &&
                !isBitSet(location[0], 7)){                         //010
            row_loc = 2;
        }
        if(isBitSet(location[0], 5) && isBitSet(location[0], 6) &&
                !isBitSet(location[0], 7)){                         //011
            row_loc = 3;
        }
        if(!isBitSet(location[0], 5) && !isBitSet(location[0], 6) &&
                isBitSet(location[0], 7)){                          //100
            row_loc = 4;
        }        
        
        
        //check intended COLUMN
        if(isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00001
            col_loc = 1;
        }
        if(!isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00011
            col_loc = 2;
        }
        if(isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                         //00011
            col_loc = 3;
        }
        if(!isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00100
            col_loc = 4;
        }
        if(isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00101
            col_loc = 5;
        }
        if(!isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00110
            col_loc = 6;
        }
        if(isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //00111
            col_loc = 7;
        }
        if(!isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01000
            col_loc = 8;
        }
        if(isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01001
            col_loc = 9;
        }
        if(!isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01010
            col_loc = 10;
        }
        if(isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01011
            col_loc = 11;
        }
        if(!isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01100
            col_loc = 12;
        }
        if(isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01101
            col_loc = 13;
        }
        if(!isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01110
            col_loc = 14;
        }
        if(isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && isBitSet(location[0], 3) &&
                !isBitSet(location[0], 4)){                          //01111
            col_loc = 15;
        }
        if(!isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                isBitSet(location[0], 4)){                          //10000
            col_loc = 16;
        }
        if(isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                isBitSet(location[0], 4)){                          //10001
            col_loc = 17;
        }
        if(!isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                isBitSet(location[0], 4)){                          //10010
            col_loc = 18;
        }
        if(isBitSet(location[0], 0) && isBitSet(location[0], 1) &&
                !isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                isBitSet(location[0], 4)){                          //10011
            col_loc = 19;
        }
        if(!isBitSet(location[0], 0) && !isBitSet(location[0], 1) &&
                isBitSet(location[0], 2) && !isBitSet(location[0], 3) &&
                isBitSet(location[0], 4)){                          //10100
            col_loc = 20;
        }
    for(int i = 0; i < input.length; i++){
        if (input[i] > 0){
            msg += ((char) input[i]);
        }
    }
    range_value = row_loc * col_loc;
    LED_Display.replaceRange(msg, range_value, range_value);    
}
    
    private static Boolean isBitSet(byte b, int bit)
    {
        return (b & (1 << bit)) != 0;
        //shouldn't this just be:
        //return b & (1 << bit)?  this is basic logic...
    }

    public int getGCPInteraction() {
        int result = 0x0000;
        if (getSlider() < 0.02)
        {
            result |= CL_RST_NO;
        }
        if (getSlider() > 0.98)
        {
            result |= CL_FS_NO;
        }
        if (armDisarmButton.getModel().isPressed())
        {
            result |= PB_ARM;
        }
        if (prepRecButton.getModel().isPressed())
        {
            result |= PB_PREP;
        }
        if (sasSwitch.isSelected())
        {
            result |= SW_ACTIVE;
        } else {
            result |= SW_SAFE;
        }
        if (tensionButton.getModel().isPressed())
        {
            result |= PB_0_TENSION;
        }
        if (odometerButton.getModel().isPressed())
        {
            result |= PB_0_ODOMETER;
        }
        if (brakeSwitch.getModel().isPressed())
        {
            result |= PB_BRAKE;
        }
        if (gSwitch.getModel().isPressed())
        {
            result |= PB_GUILLOTINE;
        }
        if (emergencyStop.isSelected())
        {
            result |= SW_EMERGENCY;
        }        
        return ~result;
    }
    
//    public void updateStateDiagramDisplay(){
//        stateDiagramPanel.updateState(getState());
//    }
    
    public float getSlider() {
        return (float) (controlLever.getValue() / 100.0);
    }
    
    public boolean getArmDisarmButton(){
        return (boolean) (armDisarmButton.isSelected());
    }
    
    public boolean getsasSwitch(){
        return (boolean) (sasSwitch.isSelected());
    }
    
    public boolean getPrepRecButton(){
        return (boolean) (prepRecButton.isSelected());
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea LED_Display;
    private javax.swing.JButton brakeSwitch;
    private javax.swing.JSlider controlLever;
    private javax.swing.JToggleButton emergencyStop;
    private javax.swing.JButton gSwitch;
    private javax.swing.JButton armDisarmButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton odometerButton;
    private javax.swing.JButton prepRecButton;
    private javax.swing.JToggleButton sasSwitch;
    private javax.swing.JPanel stateDiagramPanel;
    private javax.swing.JButton tensionButton;
    // End of variables declaration                       
}