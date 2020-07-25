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
            "select id_equipos, tipo_equipo, marca, num_serie, estatus where id_clientes = '" + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();
            
            tablaEquipos = new JTable(model);
            scrollpaneequipo.setViewportView(tablaEquipos);
            
            model.addColumn(" # ");
            model.addColumn("Tipo Equipo");
            model.addColumn("Marca");
            model.addColumn("Serial");
            model.addColumn("Estatus");
            
            while(rs.next()){
                
                Object[] fila = new Object[5];
                
                for (int i = 0; i < 5; i++) {
                    
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al llenado de la tabla equipos. " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar tabla de equipos " + e);
        }
        
        tablaEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_poimt = tablaEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if (fila_poimt > -1) {
                    
                    ID_equipo = (int)model.getValueAt(fila_poimt, columna_point);
                    JOptionPane.showMessageDialog(null, e);
                    
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
        jLabel4.setForeground(new java.awt.Color(107, 107, 177));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(107, 107, 177));
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 235, -1, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 255, 200, -1));

        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(197, 224, 224));
        lblTitulo.setText("Informacion del Cliente");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(107, 107, 177));
        jLabel6.setText("Ultima Modificacion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

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
        getContentPane().add(botonActualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 330, 135, -1));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonImprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirClientesActionPerformed

    }//GEN-LAST:event_botonImprimirClientesActionPerformed

    private void botonRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEquipoActionPerformed
        
        NuevoEquipo equipo = new NuevoEquipo();
        equipo.setVisible(true);
        
    }//GEN-LAST:event_botonRegistrarEquipoActionPerformed

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