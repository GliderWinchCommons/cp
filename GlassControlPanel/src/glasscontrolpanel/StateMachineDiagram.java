package glasscontrolpanel;

//TODO: remove import *s
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Matt Dargen
 * @modifications: Johnny White
 * @modifications: Jacob Troxel
 */
public class StateMachineDiagram extends javax.swing.JPanel {

    JTextField last = new JTextField();
    
    public StateMachineDiagram() {
        statePics = new HashMap<>();
        loadPictures();
        initComponents();
    }
    
    public void updateState(int state)
    {
        stateLabel.setIcon(statePics.get(state));
    }
    
    private ImageIcon getScaledImage(ImageIcon img, int w)
    {
        float ratio = (float)(w) / img.getIconWidth();
        int h = (int) (img.getIconHeight() * ratio);
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img.getImage(), 0, 0, w, h, null);
        g2.dispose();
        return new ImageIcon(resizedImg);
    }
    
    private void loadPictures()
    {
        statePics.put(0, new ImageIcon(getClass().getResource("safe.png")));
        statePics.put(1, new ImageIcon(getClass().getResource("prep.png")));
        statePics.put(2, new ImageIcon(getClass().getResource("armed.png")));
        statePics.put(3, new ImageIcon(getClass().getResource("profile.png")));
        statePics.put(4, new ImageIcon(getClass().getResource("ramp.png")));
        statePics.put(5, new ImageIcon(getClass().getResource("constant.png")));
        statePics.put(6, new ImageIcon(getClass().getResource("recovery.png")));
        statePics.put(7, new ImageIcon(getClass().getResource("retrieve.png")));
        statePics.put(14, new ImageIcon(getClass().getResource("stop.png")));
        statePics.put(15, new ImageIcon(getClass().getResource("abort.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        stateLabel = new javax.swing.JLabel();
        stateLabel.setIcon(statePics.get(0)); // NOI18N
        add(stateLabel, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    
    }//GEN-LAST:event_formKeyPressed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        //updateState(getRandomState());
    }//GEN-LAST:event_jToggleButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel stateLabel;
    private HashMap<Integer,ImageIcon> statePics;
    // End of variables declaration//GEN-END:variables

}
