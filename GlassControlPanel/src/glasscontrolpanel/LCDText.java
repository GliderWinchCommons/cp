/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasscontrolpanel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Johnny White
 */
public class LCDText extends javax.swing.JPanel{

    JTextField msg = new JTextField();
    
    public LCDText() {;
        initComponents();   
    }
    byte[] byteArray    = new byte[8];
    byte[] position     = new byte[1];
    byte[] message      = new byte[7];

    private void initComponents() {

        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        lcd_display = new javax.swing.JTextArea();

        lcd_display.setColumns(20);
        lcd_display.setRows(5);
        jScrollPane1.setViewportView(lcd_display);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea lcd_display;
    
}
