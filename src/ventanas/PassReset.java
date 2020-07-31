/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author doug1as
 */
public class PassReset extends javax.swing.JFrame {

        String user = "", user_update = "";

        /**
         * Creates new form PassReset
         */
        public PassReset() {
                initComponents();
                user = VentanaLogin.user;

                setTitle("Restaurar Contraseña a " + user);
                setLocationRelativeTo(null);
                setResizable(false);
                setSize(260, 330);

                try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement(
                                "select password from usuarios where username = '" + user + "'");
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                                user_update = rs.getString("password");
                        }

                } catch (SQLException e) {
                        System.err.println("Error al obtener password." + e);
                }

                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

                lblTitle = new javax.swing.JLabel();
                txtActualPass = new javax.swing.JPasswordField();
                txtNewPass = new javax.swing.JPasswordField();
                txtNewPass2 = new javax.swing.JPasswordField();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                botonCambiar = new javax.swing.JButton();
                lblFooter = new javax.swing.JLabel();
                lblWallpaper = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setIconImage(getIconImage());
                setMinimumSize(new java.awt.Dimension(260, 300));
                setPreferredSize(new java.awt.Dimension(220, 300));
                setResizable(false);
                setSize(new java.awt.Dimension(260, 330));
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
                lblTitle.setForeground(new java.awt.Color(197, 224, 224));
                lblTitle.setText("Password Reset");
                getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
                getContentPane().add(txtActualPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 180, -1));
                getContentPane().add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 180, -1));
                getContentPane().add(txtNewPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, -1));

                jLabel1.setForeground(new java.awt.Color(197, 224, 224));
                jLabel1.setText("Contraseña Actual:");
                getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

                jLabel2.setForeground(new java.awt.Color(197, 224, 224));
                jLabel2.setText("Nueva Contraseña:");
                getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

                jLabel3.setForeground(new java.awt.Color(197, 224, 224));
                jLabel3.setText("Confirmar Contraseña");
                getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

                botonCambiar.setText("Cambiar");
                botonCambiar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                botonCambiarActionPerformed(evt);
                        }
                });
                getContentPane().add(botonCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 80, -1));

                lblFooter.setForeground(new java.awt.Color(240, 240, 240));
                lblFooter.setText("Creado por Gamer Studio ©");
                getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, -1, -1));
                getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 330));

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void botonCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarActionPerformed

            String newpass, newpass2, actualpass;
            actualpass = txtActualPass.getText().trim();
            newpass = txtNewPass.getText().trim();
            newpass2 = txtNewPass2.getText().trim();

            if (actualpass.equals(user_update)) {
                    if (newpass.equals("") && newpass2.equals("")) {

                            if (newpass.equals("")) {

                                    txtNewPass.setBackground(Color.MAGENTA);

                            }
                            if (newpass2.equals("")) {

                                    txtNewPass2.setBackground(Color.MAGENTA);
                            }
                            JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios.");
                            Limpiar();

                    } else {

                            if (newpass.equals(newpass2)) {

                                    try {

                                            Connection cn = Conexion.conectar();
                                            PreparedStatement pst = cn.prepareStatement(
                                                    "update usuarios set password =? where username = '" + user + "'");

                                            pst.setString(1, newpass);

                                            pst.executeUpdate();
                                            cn.close();

                                            txtNewPass.setBackground(Color.GREEN);
                                            txtNewPass2.setBackground(Color.GREEN);
                                            JOptionPane.showMessageDialog(null, "La contraseña fue restaurada correctamente.");
                                            Limpiar();
                                            this.dispose();

                                    } catch (SQLException e) {

                                            System.err.println("Error al restaurar password. " + e);
                                            JOptionPane.showMessageDialog(null, "Error al restaurar password, contacte al administrador. " + e);

                                    }

                            } else {

                                    JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir.");
                                    txtNewPass2.setBackground(Color.MAGENTA);
                                    Limpiar();
                            }
                    }
            } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el password actual correctamente");
                    txtActualPass.setBackground(Color.MAGENTA);
                    Limpiar();
            }

    }//GEN-LAST:event_botonCambiarActionPerformed

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
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(PassReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(PassReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(PassReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(PassReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new PassReset().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton botonCambiar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel lblFooter;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JLabel lblWallpaper;
        private javax.swing.JPasswordField txtActualPass;
        private javax.swing.JPasswordField txtNewPass;
        private javax.swing.JPasswordField txtNewPass2;
        // End of variables declaration//GEN-END:variables

        public void Limpiar(){
                txtActualPass.setText("");
                txtNewPass.setText("");
                txtNewPass2.setText("");
        }
}
