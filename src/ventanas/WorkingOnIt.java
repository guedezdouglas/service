/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author guede
 */
public class WorkingOnIt extends javax.swing.JFrame {

        /**
         * Creates new form WorkingOnIt
         */
        public WorkingOnIt() {
                initComponents();
                
                this.setLocationRelativeTo(null);
                
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
                Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lblWallpaper.getWidth(),
                        lblWallpaper.getHeight(), Image.SCALE_DEFAULT));
                lblWallpaper.setIcon(icono);
                this.repaint();
        }
        
        @Override
        public Image getIconImage() {
                Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
                return retValue;
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblWallpaper = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblWallpaper.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
                lblWallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblWallpaper.setText("Working On it");
                lblWallpaper.setToolTipText("");
                lblWallpaper.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(WorkingOnIt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(WorkingOnIt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(WorkingOnIt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(WorkingOnIt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new WorkingOnIt().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel lblWallpaper;
        // End of variables declaration//GEN-END:variables
}
