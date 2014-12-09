/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastercontroller;

import java.awt.Color;

/**
 *
 * @author  troy
 * @author  Johnny White
 * @date    November 3, 2014
 */
public class ControlPanel extends javax.swing.JFrame {

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents(){

        states = new javax.swing.ButtonGroup();
        prepLed = new javax.swing.JRadioButton();
        armedLed = new javax.swing.JRadioButton();
        profileLed = new javax.swing.JRadioButton();
        rampLed = new javax.swing.JRadioButton();
        constantLed = new javax.swing.JRadioButton();
        recoveryLed = new javax.swing.JRadioButton();
        controlLever = new javax.swing.JSlider();
        initButton = new javax.swing.JToggleButton();
        prepRecButton = new javax.swing.JButton();
        odometerButton = new javax.swing.JButton();
        tensionButton = new javax.swing.JButton();
        sasSwitch = new javax.swing.JToggleButton();
        gabSwitch = new javax.swing.JToggleButton();
        emergencyStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        states.add(prepLed);
        prepLed.setSelected(true);
        prepLed.setText("Prep");
        prepLed.setForeground(Color.red);

        states.add(armedLed);
        armedLed.setText("Armed");
        armedLed.setForeground(Color.blue);

        states.add(profileLed);
        profileLed.setText("Profile");
        profileLed.setForeground(Color.blue);
        
        states.add(rampLed);
        rampLed.setText("Ramp");
        rampLed.setForeground(Color.blue);

        states.add(constantLed);
        constantLed.setText("Constant");
        constantLed.setForeground(Color.blue);

        states.add(recoveryLed);
        recoveryLed.setText("Recovery");
        recoveryLed.setForeground(Color.blue);

        initButton.setText("Arm Launch");
        initButton.setSelected(false);
        
        prepRecButton.setText("Prep/Recieve");
        prepRecButton.setSelected(false);
        
        odometerButton.setText("Odometer");
        odometerButton.setSelected(false);
        
        tensionButton.setText("Tension");
        tensionButton.setSelected(false);
        
        sasSwitch.setText("Safe-Active Switch");
        sasSwitch.setSelected(false);
        
        gabSwitch.setText("Guillotine and Brake Switch");
        gabSwitch.setSelected(false);
        
        emergencyStop.setText("Emergency Stop");
        emergencyStop.setForeground(Color.red);
        emergencyStop.setSelected(false);

        controlLever.setOrientation(javax.swing.JSlider.VERTICAL);
        controlLever.setValue(25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recoveryLed)
                    .addComponent(constantLed)
                    .addComponent(rampLed)
                    .addComponent(profileLed)
                    .addComponent(prepLed)
                    .addComponent(armedLed))
                .addGap(18, 18, 18)
                .addComponent(controlLever, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(initButton)
                    .addComponent(prepRecButton))
                .addGap(18, 18, 18)
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(odometerButton)    
                    .addComponent(tensionButton)) 
                .addGap(18, 18, 18)
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sasSwitch)    
                    .addComponent(gabSwitch)
                    .addComponent(emergencyStop))        
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prepLed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(armedLed)
                .addGap(4, 4, 4)
                .addComponent(profileLed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rampLed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(constantLed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recoveryLed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(initButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(prepRecButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(odometerButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tensionButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sasSwitch)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(gabSwitch)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emergencyStop))   
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlLever, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

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
                if ("CDE/Modif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
    }
    
    public float getSlider() {
        return (float) (controlLever.getValue() / 100.0);
    }
    
    public boolean getInitButton(){
        return (boolean) (initButton.isSelected()); 
    }
    
    public boolean getPrepRecButton(){
        return (boolean) (prepRecButton.isSelected()); 
    }
    
    public void setStateLed(int state) {
        while (getInitButton() == true){
            switch (state) {
                case 0: // prep
                    prepLed.setSelected(true);
                    prepLed.setForeground(Color.red);

                    break;
                case 1: // armed
                    armedLed.setSelected(true);
                    armedLed.setForeground(Color.red);
                    break;
                case 2: // profile 1
                case 3: // profile 2
                    profileLed.setSelected(true);
                    profileLed.setForeground(Color.red);
                    break;
                case 4: // ramp
                    rampLed.setSelected(true);
                    rampLed.setForeground(Color.red);
                    break;
                case 5: // constant
                    constantLed.setSelected(true);
                    constantLed.setForeground(Color.red);
                    break;
                case 6: // recovery
                    recoveryLed.setSelected(true);
                    recoveryLed.setForeground(Color.red);
                    break;
            }
        }
    }

    // Variables declaration - do not modify//
    private javax.swing.JRadioButton armedLed;
    private javax.swing.JRadioButton constantLed;
    private javax.swing.JSlider controlLever;
    private javax.swing.JRadioButton prepLed;
    private javax.swing.JRadioButton profileLed;
    private javax.swing.JRadioButton rampLed;
    private javax.swing.JRadioButton recoveryLed;
    private javax.swing.JToggleButton initButton;
    private javax.swing.JButton prepRecButton;
    
    private javax.swing.JButton odometerButton;
    private javax.swing.JButton tensionButton;
    private javax.swing.JToggleButton sasSwitch;
    private javax.swing.JToggleButton gabSwitch;
    private javax.swing.JButton emergencyStop;
    private javax.swing.ButtonGroup states;
    // End of variables declaration                   
}
