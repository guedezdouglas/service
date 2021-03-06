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
import java.util.Calendar;

/**
 *
 * @author guede
 */
public class NuevoEquipo extends javax.swing.JFrame {

    int IDCliente_update = 0;
    String user = "", nom_cliente = "";

    /**
     * Creates new form NuevoEquipo
     */
    public NuevoEquipo() {
        initComponents();
        user = VentanaLogin.user;
        IDCliente_update = GestionClientes.IDCliente_update;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente from clientes where id_clientes = '" + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                nom_cliente = rs.getString("nombre_cliente");

            }
        } catch (SQLException e) {

            System.err.println("Error al consultar nombre del cliente " + e);
        }

        txtNombredelCliente.setText(nom_cliente);
        setTitle("Registrar nuevo equipo para: " + nom_cliente);
        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
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

        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombredelCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSerial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxTipodeEquipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        boxMarca = new javax.swing.JComboBox<>();
        botonRegistrarEquipo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneObservaciones.setViewportView(txtObservaciones);

        getContentPane().add(jScrollPaneObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 300, 200));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(197, 224, 224));
        jLabel1.setText("Registro de Equipos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(197, 224, 224));
        jLabel2.setText("Nombre del Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtNombredelCliente.setEditable(false);
        txtNombredelCliente.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtNombredelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(197, 224, 224));
        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 200, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(197, 224, 224));
        jLabel5.setText("Numero de serie:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));
        getContentPane().add(txtSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 200, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 224, 224));
        jLabel3.setText("Tipo de Equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        boxTipodeEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desktop", "Laptop", "Printer", "Server" }));
        boxTipodeEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipodeEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(boxTipodeEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(197, 224, 224));
        jLabel6.setText("Marca:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        boxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hewlett-Packard", "Dell", "Asus", "MSI", "GIGABYTE", "Alienware", "CyberPowerPC", "Samsung", "Acer", "Adata", "Sony", "Razer", "Lenovo", "LG", "Microsoft", "Epson", "Toshiba", "Xerox", "Others" }));
        boxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(boxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 215, 130, -1));

        botonRegistrarEquipo.setText("Registrar Equipo");
        botonRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 315, 135, -1));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(197, 224, 224));
        jLabel7.setText("Falla y Observaciones reportados:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        lblFooter.setForeground(new java.awt.Color(197, 224, 224));
        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEquipoActionPerformed

        int validar = 0;
        String dia_ingreso, mes_ingreso, year_ingreso, modelo, serial, observaciones, tipo_equipo, marca, estatus;
        
        tipo_equipo = boxTipodeEquipo.getSelectedItem().toString();
        modelo = txtModelo.getText().trim();
        serial = txtSerial.getText().trim();
        marca = boxMarca.getSelectedItem().toString();
        observaciones = txtObservaciones.getText();
        estatus = "Nuevo Ingreso";
        
        Calendar calendar = Calendar.getInstance();
        
        dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH));
        year_ingreso = Integer.toString(calendar.get(Calendar.YEAR));   
                
        if (modelo.equals("")) {
            txtModelo.setBackground(Color.MAGENTA);
            validar++;
        }
        if (serial.equals("")) {
            txtSerial.setBackground(Color.MAGENTA);
            validar++;
        }
        if (observaciones.equals("")) {
            txtObservaciones.setText("Sin Observaciones");
        }

        if (validar != 0) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los Campos.");

        } else {

            // Inicia la conexion a la base de datos....
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                // Agregando los datos a la base de datos...
                pst.setInt(1, 0);
                pst.setInt(2, IDCliente_update);
                pst.setString(3, tipo_equipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, serial);
                pst.setString(7, dia_ingreso);
                pst.setString(8, mes_ingreso);
                pst.setString(9, year_ingreso);
                pst.setString(10, observaciones);
                pst.setString(11, estatus);
                pst.setString(12, user);
                pst.setString(13, "");
                pst.setString(14, "");

                pst.executeUpdate();
                cn.close();
                
                txtNombredelCliente.setBackground(Color.GREEN);
                txtModelo.setBackground(Color.GREEN);
                txtSerial.setBackground(Color.GREEN);
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso.");

            } catch (Exception e) {

                System.err.println("Error al registrar equipo.\n" + e);
                JOptionPane.showMessageDialog(null, "Error al registrar equipo.\nContacte al Administrador.\n" + e);

            }

        }


    }//GEN-LAST:event_botonRegistrarEquipoActionPerformed

    private void boxTipodeEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipodeEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTipodeEquipoActionPerformed

    private void boxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMarcaActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarEquipo;
    private javax.swing.JComboBox<String> boxMarca;
    private javax.swing.JComboBox<String> boxTipodeEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombredelCliente;
    private javax.swing.JTextPane txtObservaciones;
    private javax.swing.JTextField txtSerial;
    // End of variables declaration//GEN-END:variables
}
