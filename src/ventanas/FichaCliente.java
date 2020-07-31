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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guede
 */
public class FichaCliente extends javax.swing.JFrame {

    int IDCliente_update;
    public static int ID_equipo = 0;
    String user;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form FichaCliente
     */
    public FichaCliente() {
        initComponents();
        user = VentanaLogin.user;
        IDCliente_update = GestionClientes.IDCliente_update;

        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lblWallpaper.getWidth(),
                lblWallpaper.getHeight(), Image.SCALE_DEFAULT));
        lblWallpaper.setIcon(icono);
        this.repaint();

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from clientes where id_clientes = '" + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setTitle("Informacion de Cliente - '" + rs.getString("nombre_cliente") + "' / Sesion - " + user);
                lblTitulo.setText("Informacion del Cliente - " + rs.getString("nombre_cliente"));
                txtNombre.setText(rs.getString("nombre_cliente"));
                txtDireccion.setText(rs.getString("direccion_cliente"));
                txtPhone.setText(rs.getString("tel_cliente"));
                txteMail.setText(rs.getString("email_cliente"));
                txtUltimaModificacion.setText(rs.getString("ultima_modificacion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al obtener los datos del usuario.\n" + e);
            JOptionPane.showMessageDialog(null, "Error al obtener datos del cliente " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipos, tipo_equipo, marca, num_serie, estatus from equipos where id_clientes = '" + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();

            tablaEquipos = new JTable(model);
            scrollpaneequipo.setViewportView(tablaEquipos);

            model.addColumn(" # ");
            model.addColumn("Tipo Equipo");
            model.addColumn("Marca");
            model.addColumn("Serial");
            model.addColumn("Estatus");

            while (rs.next()) {

                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {

                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenado de la tabla equipos.\n " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar tabla de equipos\n " + e);
        }

        tablaEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_poimt = tablaEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_poimt > -1) {
                    ID_equipo = (int) model.getValueAt(fila_poimt, columna_point);
                    FichaEquipo fichaEquipo = new FichaEquipo();
                    fichaEquipo.setVisible(true);
                }
            }
        });
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

        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txteMail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblFooter = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUltimaModificacion = new javax.swing.JTextField();
        scrollpaneequipo = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        botonImprimirClientes = new javax.swing.JButton();
        botonRegistrarEquipo = new javax.swing.JButton();
        botonActualizarCliente = new javax.swing.JButton();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(197, 224, 224));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 224, 224));
        jLabel3.setText("eMail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(txteMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(197, 224, 224));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(197, 224, 224));
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 235, -1, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 255, 200, -1));

        lblFooter.setForeground(new java.awt.Color(197, 224, 224));
        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(197, 224, 224));
        lblTitulo.setText("Informacion del Cliente");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(197, 224, 224));
        jLabel6.setText("Ultima Modificacion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txtUltimaModificacion.setEditable(false);
        txtUltimaModificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtUltimaModificacion.setEnabled(false);
        getContentPane().add(txtUltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, -1));

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpaneequipo.setViewportView(tablaEquipos);

        getContentPane().add(scrollpaneequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 410, 180));

        botonImprimirClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_report_16751.png"))); // NOI18N
        botonImprimirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirClientesActionPerformed(evt);
            }
        });
        getContentPane().add(botonImprimirClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 265, 120, 100));

        botonRegistrarEquipo.setText("Registrar Equipo");
        botonRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 280, 135, -1));

        botonActualizarCliente.setText("Actualizar Cliente");
        botonActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 330, 135, -1));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonImprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirClientesActionPerformed

        Document doc = new Document();

        try {

            String ruta = System.clearProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Reportes/Clientes/" + txtNombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n Informacion del Cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            doc.open();
            doc.add(header);
            doc.add(parrafo);

            PdfPTable tablapdf = new PdfPTable(5);
            tablapdf.addCell("ID");
            tablapdf.addCell("Nombre");
            tablapdf.addCell("eMail");
            tablapdf.addCell("Telefono");
            tablapdf.addCell("Direccion");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes where id_clientes = '" + IDCliente_update + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {

                        tablapdf.addCell(rs.getString(1));
                        tablapdf.addCell(rs.getString(2));
                        tablapdf.addCell(rs.getString(3));
                        tablapdf.addCell(rs.getString(4));
                        tablapdf.addCell(rs.getString(5));

                    } while (rs.next());

                    doc.add(tablapdf);
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos Registrados. \n \n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                doc.add(parrafo2);

                PdfPTable tablaEquipos = new PdfPTable(4);

                tablaEquipos.addCell("ID Equipo");
                tablaEquipos.addCell("Tipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Estatus");

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipos, tipo_equipo, marca, estatus from equipos where id_clientes = '" + IDCliente_update + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        do {
                            tablaEquipos.addCell(rs2.getString(1));
                            tablaEquipos.addCell(rs2.getString(2));
                            tablaEquipos.addCell(rs2.getString(3));
                            tablaEquipos.addCell(rs2.getString(4));
                        } while (rs2.next());
                        doc.add(tablaEquipos);
                    }
                } catch (SQLException e) {
                    System.err.println("Error al cargar datos del equipo en tabla de equipos \n" + e);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener datos del cliente. \n " + e);
            }

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");
        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF \n Contacte al Administrador \n ");
        }

    }//GEN-LAST:event_botonImprimirClientesActionPerformed

    private void botonRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEquipoActionPerformed

        NuevoEquipo equipo = new NuevoEquipo();
        equipo.setVisible(true);

    }//GEN-LAST:event_botonRegistrarEquipoActionPerformed

    private void botonActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarClienteActionPerformed

        int validar = 0;
        String nombre, email, phone, address;

        nombre = txtNombre.getText().trim();
        email = txteMail.getText().trim();
        phone = txtPhone.getText().trim();
        address = txtDireccion.getText();

        if (nombre.equals("")) {
            txtNombre.setBackground(Color.MAGENTA);
            validar++;
        }
        if (email.equals("")) {
            txteMail.setBackground(Color.MAGENTA);
            validar++;
        }
        if (phone.equals("")) {
            txtPhone.setBackground(Color.MAGENTA);
            validar++;
        }
        if (address.equals("")) {
            txtDireccion.setBackground(Color.MAGENTA);
            validar++;
        }

        if (validar != 0) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");

        } else {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update clientes set nombre_cliente =?, email_cliente =?, tel_cliente =?, direccion_cliente =?, ultima_modificacion =?"
                        + " where id_clientes = '" + IDCliente_update + "'");

                pst.setString(1, nombre);
                pst.setString(2, email);
                pst.setString(3, phone);
                pst.setString(4, address);
                pst.setString(5, user);

                pst.executeUpdate();
                txtDireccion.setBackground(Color.GREEN);
                txtNombre.setBackground(Color.GREEN);
                txtPhone.setBackground(Color.GREEN);
                txteMail.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                this.dispose();
                cn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar cliente, contacte con el administrador\n " + e);
                System.err.println("Error al actualizar cliente. " + e);
            }
        }
    }//GEN-LAST:event_botonActualizarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(FichaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarCliente;
    private javax.swing.JButton botonImprimirClientes;
    private javax.swing.JButton botonRegistrarEquipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JScrollPane scrollpaneequipo;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUltimaModificacion;
    private javax.swing.JTextField txteMail;
    // End of variables declaration//GEN-END:variables
}
