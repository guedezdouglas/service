/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import clases.Conexion;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author guede
 */
public class GraficaEquipos extends javax.swing.JFrame {
        boolean bandera = false;

        /**
         * Creates new form GraficaEquipos
         */
        public GraficaEquipos() {
                initComponents();
                this.setSize(650, 430);
                this.setResizable(false);
                this.setLocationRelativeTo(null);
                
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
                Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lblWallpaper.getWidth(),
                        lblWallpaper.getHeight(), Image.SCALE_DEFAULT));
                lblWallpaper.setIcon(icono);
                this.repaint();
                
                try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement("SELECT COUNT(id_equipos) as Contador, marca FROM equipos GROUP BY marca");
                } catch (Exception e) {
                }
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
                setIconImage(getIconImage());
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

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
                        java.util.logging.Logger.getLogger(GraficaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(GraficaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(GraficaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(GraficaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new GraficaEquipos().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel lblWallpaper;
        // End of variables declaration//GEN-END:variables

        public void Paint(Graphics g){
                super.paint(g);
                
        }
}
