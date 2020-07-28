/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author doug1as
 */
public class NuevoCliente extends javax.swing.JFrame {

    String user;

    /**
     * Creates new form NuevoCliente
     */
    public NuevoCliente() {
        initComponents();
        user = VentanaLogin.user;
        this.setTitle("Registrar nuevo cliente. Sesion - " + user);

        this.setLocationRelativeTo(null);
        this.setSize(650, 430);
        this.setResizable(false);

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txteMail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        lblFooter = new javax.swing.JLabel();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(197, 224, 224));
        jLabel1.setText("Registro de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(197, 224, 224));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 224, 224));
        jLabel3.setText("eMail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(197, 224, 224));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(197, 224, 224));
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 200, -1));
        getContentPane().add(txteMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 200, -1));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 200, -1));

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new_add_user_info_16706(1).png"))); // NOI18N
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 234, 120, 100));

        lblFooter.setForeground(new java.awt.Color(197, 224, 224));
        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        int validacion = 0;
        String nombre, direccion, email, phone;
        
        nombre = txtNombre.getText().trim();
        direccion = txtDireccion.getText().trim();
        email = txteMail.getText().trim();
        phone = txtPhone.getText().trim();
        
        if (nombre.equals("")) {
            
            txtNombre.setBackground(Color.MAGENTA);
            validacion++;
            
        }
        if (direccion.equals("")) {
            
            txtDireccion.setBackground(Color.MAGENTA);
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
        
        if (validacion != 0) {
            
            JOptionPane.showMessageDialog(null, "Debe Completar todos los campos.");
            
        } else {
            
            try {
                
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                "insert into clientes values (?,?,?,?,?,?)");
                
                pst.setInt(1, 0);
                pst.setString(2, nombre);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, direccion);
                pst.setString(6, user);
                
                pst.executeUpdate();
                pst.close();
                
                Limpiar();
                
                txtNombre.setBackground(Color.GREEN);
                txtDireccion.setBackground(Color.GREEN);
                txtPhone.setBackground(Color.GREEN);
                txteMail.setBackground(Color.GREEN);
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso.");
                
            } catch (SQLException e) {
                
                System.err.println("Error al agregar Cliente " + e);
                JOptionPane.showMessageDialog(null, "Error al agregar nuevo cliente, contacte al administrador. " + e);
                
            }
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txteMail;
    // End of variables declaration//GEN-END:variables


    public void Limpiar(){
        
        txtNombre.setText("");
        txtDireccion.setText("");
        txtPhone.setText("");
        txteMail.setText("");
        
    }
}
