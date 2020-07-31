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
 * @author guede
 */
public class FichaEquipoTec extends javax.swing.JFrame {

        int validar = 0, IDCliente_update = 0, IDEquipo = 0;
        String user, nombre_cliente;

        /**
         * Creates new form FichaEquipo
         */
        public FichaEquipoTec() {
                initComponents();
                user = VentanaLogin.user;
                IDEquipo = GestionEquipos.IDEquipo_update;

                try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement(
                                "select * from equipos where id_equipos = '" + IDEquipo + "'");
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {

                                IDCliente_update = rs.getInt("id_clientes");
                                boxTipodeEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                                boxStatus.setSelectedItem(rs.getString("estatus"));
                                boxMarca.setSelectedItem(rs.getString("marca"));
                                txtNombredelCliente.setText(nombre_cliente);
                                txtModelo.setText(rs.getString("modelo"));
                                txtSerial.setText(rs.getString("num_serie"));
                                txtUltimaModificacion.setText(rs.getString("ultima_modificacion"));
                                txtObservaciones.setText(rs.getString("observaciones"));
                                txtComentarios.setText(rs.getString("comentarios_tecnicos"));

                                String dia = "", mes = "", year = "";
                                dia = rs.getString("dia_ingreso");
                                mes = rs.getString("mes_ingreso");
                                year = rs.getString("year_ingreso");
                                txtFecha.setText(mes + " / " + dia + " / " + year);
                                jLabel8.setText("Detalles Tecnicos por: " + rs.getString("revision_tecnica"));
                        }
                } catch (SQLException e) {
                        System.err.println("Error al obtener la info del equipo. \n " + e);
                }
                
                try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement(
                                "select nombre_cliente from clientes where id_clientes = '" + IDCliente_update + "'");
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                                nombre_cliente = rs.getString("nombre_cliente");
                        }
                        cn.close();
                } catch (SQLException e) {
                        System.err.println("Error al obtener nombre del cliente.\n " + e);
                }

                txtNombredelCliente.setText(nombre_cliente);
                this.setTitle("Equipo del CLiente - " + nombre_cliente);
                this.setLocationRelativeTo(null);
                this.setSize(650, 650);
                this.setResizable(false);
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

                jLabel2 = new javax.swing.JLabel();
                txtNombredelCliente = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                boxTipodeEquipo = new javax.swing.JComboBox<>();
                jLabel6 = new javax.swing.JLabel();
                boxMarca = new javax.swing.JComboBox<>();
                jLabel4 = new javax.swing.JLabel();
                txtModelo = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                txtSerial = new javax.swing.JTextField();
                jLabel7 = new javax.swing.JLabel();
                jScrollPaneObservaciones = new javax.swing.JScrollPane();
                txtObservaciones = new javax.swing.JTextPane();
                jLabel8 = new javax.swing.JLabel();
                jScrollPaneComentarios = new javax.swing.JScrollPane();
                txtComentarios = new javax.swing.JTextPane();
                jLabel9 = new javax.swing.JLabel();
                txtUltimaModificacion = new javax.swing.JTextField();
                jLabel10 = new javax.swing.JLabel();
                txtFecha = new javax.swing.JTextField();
                lblFooter = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                botonActualizarEquipo = new javax.swing.JButton();
                jLabel11 = new javax.swing.JLabel();
                boxStatus = new javax.swing.JComboBox<>();
                lblWallpaper = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setIconImage(getIconImage());
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(197, 224, 224));
                jLabel2.setText("Nombre del Cliente:");
                getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

                txtNombredelCliente.setEditable(false);
                txtNombredelCliente.setBackground(new java.awt.Color(255, 255, 255));
                getContentPane().add(txtNombredelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, -1));

                jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(197, 224, 224));
                jLabel3.setText("Tipo de Equipo:");
                getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

                boxTipodeEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desktop", "Laptop", "Printer", "Server" }));
                boxTipodeEquipo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boxTipodeEquipoActionPerformed(evt);
                        }
                });
                getContentPane().add(boxTipodeEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 100, -1));

                jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(197, 224, 224));
                jLabel6.setText("Marca:");
                getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

                boxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hewlett-Packard", "Dell", "Asus", "MSI", "GIGABYTE", "Alienware", "CyberPowerPC", "Samsung", "Acer", "Adata", "Sony", "Razer", "Lenovo", "LG", "Microsoft", "Epson", "Toshiba", "Xerox", "Others" }));
                boxMarca.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boxMarcaActionPerformed(evt);
                        }
                });
                getContentPane().add(boxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 130, -1));

                jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(197, 224, 224));
                jLabel4.setText("Modelo:");
                getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));
                getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 200, -1));

                jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(197, 224, 224));
                jLabel5.setText("Numero de serie:");
                getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));
                getContentPane().add(txtSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 200, -1));

                jLabel7.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel7.setForeground(new java.awt.Color(197, 224, 224));
                jLabel7.setText("Falla y Observaciones reportados:");
                getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 150, -1, -1));

                jScrollPaneObservaciones.setViewportView(txtObservaciones);

                getContentPane().add(jScrollPaneObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 170, 270, 150));

                jLabel8.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(197, 224, 224));
                jLabel8.setText("Falla y Observaciones reportados:");
                getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 330, -1, -1));

                jScrollPaneComentarios.setViewportView(txtComentarios);

                getContentPane().add(jScrollPaneComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 350, 270, 150));

                jLabel9.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel9.setForeground(new java.awt.Color(197, 224, 224));
                jLabel9.setText("Ultima modificacion por:");
                getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

                txtUltimaModificacion.setEditable(false);
                txtUltimaModificacion.setBackground(new java.awt.Color(255, 255, 255));
                getContentPane().add(txtUltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 200, -1));

                jLabel10.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel10.setForeground(new java.awt.Color(197, 224, 224));
                jLabel10.setText("Fecha de Ingreso:");
                getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 80, -1, -1));

                txtFecha.setEditable(false);
                txtFecha.setBackground(new java.awt.Color(255, 255, 255));
                getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 110, 130, -1));

                lblFooter.setForeground(new java.awt.Color(197, 224, 224));
                lblFooter.setText("Creado por Gamer Studio ©");
                getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, -1, -1));

                jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(197, 224, 224));
                jLabel1.setText("Informacion de Equipos");
                getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, -1, -1));

                botonActualizarEquipo.setText("Actualizar Equipo");
                botonActualizarEquipo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                botonActualizarEquipoActionPerformed(evt);
                        }
                });
                getContentPane().add(botonActualizarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 135, -1));

                jLabel11.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
                jLabel11.setForeground(new java.awt.Color(197, 224, 224));
                jLabel11.setText("Estatus");
                getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

                boxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "En Revision", "Reparado", "No Reparado", "Entregado" }));
                boxStatus.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boxStatusActionPerformed(evt);
                        }
                });
                getContentPane().add(boxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 120, -1));
                getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 650));

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void boxTipodeEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipodeEquipoActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_boxTipodeEquipoActionPerformed

    private void boxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMarcaActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_boxMarcaActionPerformed

    private void botonActualizarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarEquipoActionPerformed

            int validar = 0;
            String modelo = "", serial = "", observaciones = "", tipo_equipo = "", marca = "", estatus = "", detaTecnico = "";

            modelo = txtModelo.getText().trim();
            serial = txtSerial.getText().trim();
            observaciones = txtObservaciones.getText();
            tipo_equipo = boxTipodeEquipo.getSelectedItem().toString();
            marca = boxMarca.getSelectedItem().toString();
            estatus = boxStatus.getSelectedItem().toString();
            detaTecnico = txtComentarios.getText();

            if (modelo.equals("")) {
                    txtModelo.setBackground(Color.MAGENTA);
                    validar++;
            }
            if (serial.equals("")) {
                    txtSerial.setBackground(Color.MAGENTA);
                    validar++;
            }
            if (txtObservaciones.equals("")) {
                    validar++;
            }

            if (validar != 0) {
                    JOptionPane.showMessageDialog(null, "Debe Llenar todos los campos.");
            } else {
                    try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement(
                                    "update equipos set tipo_equipo =?, marca =?, modelo =?, num_serie =?, "
                                            + "observaciones =?, estatus =?, ultima_modificacion =?, comentarios_tecnicos =?, "
                                            + "revision_tecnica =? where id_equipos = '" + IDEquipo + "'");

                            pst.setString(1, tipo_equipo);
                            pst.setString(2, marca);
                            pst.setString(3, modelo);
                            pst.setString(4, serial);
                            pst.setString(5, observaciones);
                            pst.setString(6, estatus);
                            pst.setString(7, user);
                            pst.setString(8, detaTecnico);
                            pst.setString(9, user);

                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa.");
                            txtModelo.setBackground(Color.GREEN);
                            txtSerial.setBackground(Color.GREEN);
                            txtComentarios.setBackground(Color.GREEN);
                            this.dispose();

                            cn.close();

                    } catch (SQLException e) {
                            System.err.println("Error al actualizar equipo.\n" + e);
                    }
            }
    }//GEN-LAST:event_botonActualizarEquipoActionPerformed

        private void boxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStatusActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_boxStatusActionPerformed

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
                        java.util.logging.Logger.getLogger(FichaEquipoTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(FichaEquipoTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(FichaEquipoTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(FichaEquipoTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new FichaEquipoTec().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton botonActualizarEquipo;
        private javax.swing.JComboBox<String> boxMarca;
        private javax.swing.JComboBox<String> boxStatus;
        private javax.swing.JComboBox<String> boxTipodeEquipo;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JScrollPane jScrollPaneComentarios;
        private javax.swing.JScrollPane jScrollPaneObservaciones;
        private javax.swing.JLabel lblFooter;
        private javax.swing.JLabel lblWallpaper;
        private javax.swing.JTextPane txtComentarios;
        private javax.swing.JTextField txtFecha;
        private javax.swing.JTextField txtModelo;
        private javax.swing.JTextField txtNombredelCliente;
        private javax.swing.JTextPane txtObservaciones;
        private javax.swing.JTextField txtSerial;
        private javax.swing.JTextField txtUltimaModificacion;
        // End of variables declaration//GEN-END:variables
}
