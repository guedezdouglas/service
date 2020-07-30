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
public class FichaUsuario extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;

    /**
     * Creates new form FichaUsuario
     */
    public FichaUsuario() {
        initComponents();
        user = VentanaLogin.user;
        user_update = GestionUsuario.user_update;
        setLocationRelativeTo(null);
        setSize(650, 430);
        this.setTitle("Informacion de Usuario." + user_update + " Sesion - " + user);
        this.setResizable(false);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lblWallpaper.getWidth(),
                lblWallpaper.getHeight(), Image.SCALE_DEFAULT));
        lblWallpaper.setIcon(icono);
        this.repaint();

        lblTitulo.setText("Informacion de Usuario " + user_update);

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where username = '" + user_update + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ID = rs.getInt("id_usuarios");
                txtNombre.setText(rs.getString("nombre_usuario"));
                txteMail.setText(rs.getString("email"));
                txtPhone.setText(rs.getString("telefono"));
                txtUser.setText(rs.getString("username"));
                txtHowMadeIt.setText(rs.getString("registrado_por"));

                boxNiveles.setSelectedItem(rs.getString("tipo_nivel"));
                boxEstatus.setSelectedItem(rs.getString("estatus"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en cargar usuario " + e);
            JOptionPane.showMessageDialog(null, "Falla no fatal, contacte al administrador del sistema. - " + e);
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txteMail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        boxNiveles = new javax.swing.JComboBox<>();
        boxEstatus = new javax.swing.JComboBox<>();
        txtHowMadeIt = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonCambioPass = new javax.swing.JButton();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Fira Mono", 0, 26)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(197, 224, 224));
        lblTitulo.setText("Informacion de Usuario");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblFooter.setForeground(new java.awt.Color(197, 224, 224));
        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(197, 224, 224));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 224, 224));
        jLabel3.setText("eMail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(197, 224, 224));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(197, 224, 224));
        jLabel5.setText("Nivel:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(197, 224, 224));
        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(197, 224, 224));
        jLabel7.setText("Estatus");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Fira Sans", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(197, 224, 224));
        jLabel8.setText("Registrado por:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 200, -1));
        getContentPane().add(txteMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 200, -1));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 200, -1));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 200, -1));

        boxNiveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "Tecnico" }));
        boxNiveles.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                boxNivelesComponentAdded(evt);
            }
        });
        getContentPane().add(boxNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, -1));

        boxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(boxEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 100, -1));

        txtHowMadeIt.setEditable(false);
        txtHowMadeIt.setBackground(new java.awt.Color(255, 255, 255));
        txtHowMadeIt.setEnabled(false);
        getContentPane().add(txtHowMadeIt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 200, -1));

        botonActualizar.setText("Actualizar Usuario");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 200, -1));

        botonCambioPass.setText("Restablecer Password");
        botonCambioPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambioPassActionPerformed(evt);
            }
        });
        getContentPane().add(botonCambioPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 200, -1));

        lblWallpaper.setPreferredSize(new java.awt.Dimension(650, 430));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxNivelesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_boxNivelesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNivelesComponentAdded

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        int permisos_box, estatus_box, validacion = 0;
        String nombre, email, phone, username, pass, permisos_string = "", estatus = "";

        nombre = txtNombre.getText().trim();
        email = txteMail.getText().trim();
        phone = txtPhone.getText().trim();
        username = txtUser.getText().trim();
        permisos_box = boxNiveles.getSelectedIndex() + 1;
        estatus_box = boxEstatus.getSelectedIndex() + 1;

        if (nombre.equals("")) {

            txtNombre.setBackground(Color.MAGENTA);
            validacion++;

        }
        if (email.equals("")) {

            txteMail.setBackground(Color.MAGENTA);
            validacion++;

        }
        if (phone.equals("")) {

            txtPhone.setBackground(Color.MAGENTA);
            validacion++;

        }
        if (username.equals("")) {

            txtUser.setBackground(Color.MAGENTA);
            validacion++;

        }

        if (validacion == 0) {

            if (permisos_box == 1) {

                permisos_string = "Administrador";

            } else if (permisos_box == 2) {

                permisos_string = "Vendedor";

            } else if (permisos_box == 3) {

                permisos_string = "Tecnico";

            }

            if (estatus_box == 1) {

                estatus = "Activo";

            } else if (estatus_box == 2) {

                estatus = "Inactivo";
            }

            try {

                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "select username from usuarios where username = '" + username + "' and not id_usuarios = '" + ID + "'");

                ResultSet rs = pst2.executeQuery();

                if (rs.next()) {

                    txtUser.setBackground(Color.MAGENTA);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponibles.");
                    cn2.close();

                } else {

                    try (Connection cn3 = Conexion.conectar()) {
                        PreparedStatement pst3 = cn3.prepareStatement(
                                "update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=? "
                                + "where id_usuarios = '" + ID + "'");

                        pst3.setString(1, nombre);
                        pst3.setString(2, email);
                        pst3.setString(3, phone);
                        pst3.setString(4, username);
                        pst3.setString(5, permisos_string);
                        pst3.setString(6, estatus);

                        pst3.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("Error actualizando usuario. \n" + e);
                        JOptionPane.showMessageDialog(null, "Error al actualizar el usuario contacte con el administrador \n" + e);
                    }

                    JOptionPane.showMessageDialog(null, "Modificacion Exitosa.");

                }

            } catch (SQLException e) {
                System.err.println("Error actualizando usuario.\n\n " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar el usuario contacte con el administrador\n\n " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonCambioPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambioPassActionPerformed
        
        PassReset pr = new PassReset();
        pr.setVisible(true);
        
        
    }//GEN-LAST:event_botonCambioPassActionPerformed

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
            java.util.logging.Logger.getLogger(FichaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCambioPass;
    private javax.swing.JComboBox<String> boxEstatus;
    private javax.swing.JComboBox<String> boxNiveles;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JTextField txtHowMadeIt;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txteMail;
    // End of variables declaration//GEN-END:variables
}
