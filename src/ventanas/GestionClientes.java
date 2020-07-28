/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class GestionClientes extends javax.swing.JFrame {
    
    String user;
    public static int IDCliente_update = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form GestionClientes
     */
    public GestionClientes() {
        initComponents();
        user = VentanaLogin.user;
        
        this.setTitle("Gestion de Usuarios. Sesion - " + user);
        this.setLocationRelativeTo(null);
        this.setSize(650, 430);
        this.setResizable(false);
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lblWallpaper.getWidth(),
                lblWallpaper.getHeight(), Image.SCALE_DEFAULT));
        lblWallpaper.setIcon(icono);
        this.repaint();
        
        try {
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_clientes, nombre_cliente, email_cliente, tel_cliente, ultima_modificacion from clientes");
            
            ResultSet rs = pst.executeQuery();
            
            tablaClientes = new JTable(model);
            jScrollPane1.setViewportView(tablaClientes);
            
            model.addColumn(" # ");
            model.addColumn("Nombre Cliente");
            model.addColumn(" eMail ");
            model.addColumn("Telefono");
            model.addColumn("Ultima Modificacion");
            
            while (rs.next()) {
                Object[] fila = new Object[5];
                
                for (int i = 0; i < 5; i++) {
                    
                    fila[i] = rs.getObject(i + 1);
                    
                }
                model.addRow(fila);
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al extraer datos a la tabla clientes " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de clientes.\n Contacte con el administrador " + e);
        }
        
        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point = tablaClientes.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if (fila_point > -1) {
                    IDCliente_update = (int)model.getValueAt(fila_point, columna_point);
                    FichaCliente fliente = new FichaCliente();
                    fliente.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Cliente # " + IDCliente_update);
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

        lblFooter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        lblWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFooter.setForeground(new java.awt.Color(197, 224, 224));
        lblFooter.setText("Creado por Gamer Studio ©");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        jLabel1.setFont(new java.awt.Font("Fira Mono", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(197, 224, 224));
        jLabel1.setText("Clientes Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 635, 250));
        getContentPane().add(lblWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblWallpaper;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
