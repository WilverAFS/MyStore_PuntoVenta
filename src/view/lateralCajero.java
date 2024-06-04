/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import controler.ControladorBD;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Cliente;
import model.Empleado;
import model.Producto;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
//import java.util.Date;

/**
 *
 * @author diego
 */
public class lateralCajero extends javax.swing.JFrame {
    //OK
    
    private vistaGeneral vG;
    
    //Declaracion de datos de la cuenta
    private List<Producto> listaCuenta; //Declaramos la cuenta
    private double totalCuenta; // Declaramos la vaiable para el total de la cuenta
    private Cliente clienteLogueado; 
    private Empleado empleadoLogueado;
    
    
    //Dialogos para los botones
    //ELIMINARLOS PARA HACER LOS DIALOGOS TEMPORALES EN LOS METODOS
    private dlcAplicarDescuento dcAplicarDescuento;
    private dlcCambiarCliente dcCambiarCliente;
    private dlcCobrarCuenta dcCobrarCuenta;
    private dlcTicket dcTicket;
    private dlcVerDisponibilidad dcVerDisponibilidad;
    private dlcCorteCaja dcCorteCaja;

    /**
     * Creates new form lateralCajero
     */
    //Constructo basico
    public lateralCajero() {
        initComponents();                
    }
    
    //CONTRUCTOR PRINCIPAL con acceso a la vista general
    public lateralCajero(vistaGeneral vG) {
        initComponents();                
        this.vG = vG;
        
        this.btnAplicarDescuento.setVisible(false);
        this.btnCancelarProducto.setVisible(false);
    }
    
    public void restablecerCuenta(){
        this.vG.limpiarCuenta();
    }
    
    public void abrirPDF(String nombrePDF) {
        try {
            File pdfFile = new File(nombrePDF);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }
            } else {
                System.out.println("File not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
}
    
    public JPanel getPanelLateralCajero(){ return this.panelLateralCajero;}
    
    //Posible DELET
    //public Empleado getEmpleadoLogeado(){        return this.vG.traerEmpleado();    }    
    //public Cliente getClienteLogueado(){        return this.vG.traerCliente();    }    
    
    public void cambiarClienteLogueado(Cliente nuevoCL){
        this.vG.establecerCliente(nuevoCL);
    }
    
    private void generarReporteCorteCaja() {
    String url = "jdbc:mysql://localhost:3306/mystore"; // Cambia esto por tu URL de conexión
    String username = "root"; // Cambia esto por tu usuario de base de datos
    String password = "WAFS%25"; // Cambia esto por tu contraseña de base de datos

    String sql = "SELECT v.folio_venta, v.fecha_v, v.hora_v, e.nombre_e, e.apellido_paterno_e, c.nombre_c, dv.codigo_producto, dv.descripcion, dv.cantidad, p.precio_venta_p " +
                 "FROM venta v " +
                 "JOIN empleado e ON v.id_empleado = e.id_empleado " +
                 "JOIN cliente c ON v.id_cliente = c.id_cliente " +
                 "JOIN descripcion_venta dv ON v.folio_venta = dv.folio_venta " +
                 "JOIN producto p ON dv.codigo_producto = p.codigo_producto " +
                 "WHERE v.fecha_v = CURDATE()";

    Document document = new Document();
    String pdfPath = "CorteCaja.pdf";
    try {
        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        document.open();
        document.add(new Paragraph("Reporte de Ventas Diarias\n\n"));

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            double totalEnCaja = 0;
            while (rs.next()) {
                int folioVenta = rs.getInt("folio_venta");
                Date fechaVenta = rs.getDate("fecha_v");
                Date horaVenta = rs.getTime("hora_v");
                String empleado = rs.getString("nombre_e") + " " + rs.getString("apellido_paterno_e");
                String cliente = rs.getString("nombre_c");
                int codigoProducto = rs.getInt("codigo_producto");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                double precioVenta = rs.getDouble("precio_venta_p");
                double totalVenta = cantidad * precioVenta;

                document.add(new Paragraph("Folio Venta: " + folioVenta));
                document.add(new Paragraph("Fecha: " + fechaVenta + " Hora: " + horaVenta));
                document.add(new Paragraph("Empleado: " + empleado));
                document.add(new Paragraph("Cliente: " + cliente));
                document.add(new Paragraph("Código Producto: " + codigoProducto));
                document.add(new Paragraph("Descripción: " + descripcion));
                document.add(new Paragraph("Cantidad: " + cantidad));
                document.add(new Paragraph("Precio Venta: $" + precioVenta));
                document.add(new Paragraph("Total Venta: $" + totalVenta));
                document.add(new Paragraph("\n"));

                totalEnCaja += totalVenta;
            }

            document.add(new Paragraph("Total en caja: $" + totalEnCaja));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
    } finally {
        document.close();
    }

    // Abrir el archivo PDF
    try {
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Awt Desktop is not supported!");
            }
        } else {
            System.out.println("File not found!");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateralCajero = new javax.swing.JPanel();
        btnAplicarDescuento = new javax.swing.JButton();
        btnCambiarCliente = new javax.swing.JButton();
        btnVerDisponibilidad = new javax.swing.JButton();
        btnReimprimirUltimoTicket = new javax.swing.JButton();
        btnCancelarCuentaActual = new javax.swing.JButton();
        btnCancelarProducto = new javax.swing.JButton();
        btnCobrarCuenta = new javax.swing.JButton();
        btnCorteCaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLateralCajero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de Caja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14))); // NOI18N

        btnAplicarDescuento.setBackground(new java.awt.Color(204, 204, 204));
        btnAplicarDescuento.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnAplicarDescuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (23).png"))); // NOI18N
        btnAplicarDescuento.setText("Aplicar descuento");
        btnAplicarDescuento.setEnabled(false);
        btnAplicarDescuento.setOpaque(true);
        btnAplicarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarDescuentoActionPerformed(evt);
            }
        });

        btnCambiarCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnCambiarCliente.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnCambiarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (31).png"))); // NOI18N
        btnCambiarCliente.setText("Cambar cliente");
        btnCambiarCliente.setOpaque(true);
        btnCambiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClienteActionPerformed(evt);
            }
        });

        btnVerDisponibilidad.setBackground(new java.awt.Color(204, 204, 204));
        btnVerDisponibilidad.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnVerDisponibilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (32).png"))); // NOI18N
        btnVerDisponibilidad.setText("Ver disponibilidad");
        btnVerDisponibilidad.setOpaque(true);
        btnVerDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDisponibilidadActionPerformed(evt);
            }
        });

        btnReimprimirUltimoTicket.setBackground(new java.awt.Color(204, 204, 204));
        btnReimprimirUltimoTicket.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnReimprimirUltimoTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (29).png"))); // NOI18N
        btnReimprimirUltimoTicket.setText("Reimprimir ultimo ticket");
        btnReimprimirUltimoTicket.setOpaque(true);
        btnReimprimirUltimoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReimprimirUltimoTicketActionPerformed(evt);
            }
        });

        btnCancelarCuentaActual.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelarCuentaActual.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnCancelarCuentaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (28).png"))); // NOI18N
        btnCancelarCuentaActual.setText("Cancelar cuenta actual");
        btnCancelarCuentaActual.setOpaque(true);
        btnCancelarCuentaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuentaActualActionPerformed(evt);
            }
        });

        btnCancelarProducto.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelarProducto.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnCancelarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (27).png"))); // NOI18N
        btnCancelarProducto.setText("Cancelar un producto");
        btnCancelarProducto.setEnabled(false);
        btnCancelarProducto.setOpaque(true);
        btnCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProductoActionPerformed(evt);
            }
        });

        btnCobrarCuenta.setBackground(new java.awt.Color(51, 255, 51));
        btnCobrarCuenta.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnCobrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (16).png"))); // NOI18N
        btnCobrarCuenta.setText("Cobrar cuenta");
        btnCobrarCuenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCobrarCuenta.setOpaque(true);
        btnCobrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarCuentaActionPerformed(evt);
            }
        });

        btnCorteCaja.setBackground(new java.awt.Color(255, 0, 0));
        btnCorteCaja.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (15).png"))); // NOI18N
        btnCorteCaja.setText("Corte de caja");
        btnCorteCaja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCorteCaja.setOpaque(true);
        btnCorteCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLateralCajeroLayout = new javax.swing.GroupLayout(panelLateralCajero);
        panelLateralCajero.setLayout(panelLateralCajeroLayout);
        panelLateralCajeroLayout.setHorizontalGroup(
            panelLateralCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralCajeroLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelLateralCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReimprimirUltimoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarCuentaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerDisponibilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAplicarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLateralCajeroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCobrarCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCorteCaja)
                .addGap(13, 13, 13))
        );
        panelLateralCajeroLayout.setVerticalGroup(
            panelLateralCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLateralCajeroLayout.createSequentialGroup()
                .addGroup(panelLateralCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCobrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCorteCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarCuentaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReimprimirUltimoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCambiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAplicarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        getContentPane().add(panelLateralCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClienteActionPerformed
        // TODO add your handling code here:
        /** 
        FCambiarCliente = new cambiarCliente();
        FCambiarCliente.setLocationRelativeTo(null);
        FCambiarCliente.setVisible(true);
        */
        this.dcCambiarCliente = new dlcCambiarCliente (new javax.swing.JFrame(), true, this);
        this.dcCambiarCliente.setLocationRelativeTo(null);
        this.dcCambiarCliente.setVisible(true);
        
    }//GEN-LAST:event_btnCambiarClienteActionPerformed

    private void btnVerDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDisponibilidadActionPerformed
        // PP
        this.dcVerDisponibilidad = new dlcVerDisponibilidad (new javax.swing.JFrame(), true);
        this.dcVerDisponibilidad.setLocationRelativeTo(null);
        this.dcVerDisponibilidad.setVisible(true);
    }//GEN-LAST:event_btnVerDisponibilidadActionPerformed

    private void btnReimprimirUltimoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReimprimirUltimoTicketActionPerformed
        // 
        ControladorBD conBD = new ControladorBD();
        String ultimoTicket = "Ticket_" + conBD.getnVenta() + ".pdf" ;        
        this.abrirPDF(ultimoTicket);        
    }//GEN-LAST:event_btnReimprimirUltimoTicketActionPerformed

    private void btnCancelarCuentaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuentaActualActionPerformed
        // READY
        
        //Hay que vaciar la lista de cuenta
        this.vG.limpiarCuenta();
    }//GEN-LAST:event_btnCancelarCuentaActualActionPerformed

    private void btnCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProductoActionPerformed
        // TODO add your handling code here:
        //Vista para esto por hacerce
        
        
        
    }//GEN-LAST:event_btnCancelarProductoActionPerformed

    private void btnCobrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarCuentaActionPerformed
        // READY        
        this.totalCuenta = this.vG.getTotal(); // Total de la cuenta desde la vista
        this.listaCuenta = this.vG.getListaCuenta(); //Lista de productos desde la vista        
        this.clienteLogueado = this.vG.traerCliente();
        this.empleadoLogueado = this.vG.traerEmpleado();
        //Restriccion de integridad
        if(this.listaCuenta.isEmpty()){ //No se permite el cobro si no hay nada que cobrar            
            //Mnsaje de error
            JOptionPane.showMessageDialog(null, "No puede cobrar una cuenta vacia", "CUENTA VACIA", 2); //Advertencia                            
        }else{
            //Hacemos una instancia de la clase dcCobrarCuenta
            this.dcCobrarCuenta = new dlcCobrarCuenta(this.empleadoLogueado, this.clienteLogueado, this.listaCuenta, this.totalCuenta);
            this.dcCobrarCuenta.establecerAcceso(this);
            this.dcCobrarCuenta.setLocationRelativeTo(null);
            this.dcCobrarCuenta.setVisible(true);            
           
        }       
        
    }//GEN-LAST:event_btnCobrarCuentaActionPerformed

    private void btnCorteCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteCajaActionPerformed
        // TODO add your handling code here:
        /**
        this.dcCorteCaja = new dlcCorteCaja(new javax.swing.JFrame(), true);
        this.dcCorteCaja.setLocationRelativeTo(null);
        this.dcCorteCaja.setVisible(true);
        */
        
        this.generarReporteCorteCaja();
        
    }//GEN-LAST:event_btnCorteCajaActionPerformed

    private void btnAplicarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarDescuentoActionPerformed
        // TODO add your handling code here:
        /**
        FCapturarDescuento = new capturarDescuento();
        FCapturarDescuento.setLocationRelativeTo(null);
        FCapturarDescuento.setVisible(true);
        */

        this.dcAplicarDescuento = new dlcAplicarDescuento (new javax.swing.JFrame(), true);
        this.dcAplicarDescuento.setLocationRelativeTo(null);
        this.dcAplicarDescuento.setVisible(true);

    }//GEN-LAST:event_btnAplicarDescuentoActionPerformed

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
            java.util.logging.Logger.getLogger(lateralCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lateralCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lateralCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lateralCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lateralCajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarDescuento;
    private javax.swing.JButton btnCambiarCliente;
    private javax.swing.JButton btnCancelarCuentaActual;
    private javax.swing.JButton btnCancelarProducto;
    private javax.swing.JButton btnCobrarCuenta;
    private javax.swing.JButton btnCorteCaja;
    private javax.swing.JButton btnReimprimirUltimoTicket;
    private javax.swing.JButton btnVerDisponibilidad;
    private javax.swing.JPanel panelLateralCajero;
    // End of variables declaration//GEN-END:variables
}
