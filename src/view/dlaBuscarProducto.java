/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controler.ControladorBD;
import javax.swing.JOptionPane;
import model.Producto;

/**
 *
 * @author Wilver
 */
public class dlaBuscarProducto extends javax.swing.JDialog {
    
    private ControladorBD con;
    private int id = -1;

    /**
     * Creates new form dlaBuscarProducto
     */
    public dlaBuscarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new ControladorBD();
    }
    
    public dlaBuscarProducto(java.awt.Frame parent, boolean modal, ControladorBD cbd) {
        super(parent, modal);
        initComponents();
        con = cbd;
    }
    
    private void limpiarCampos(){
        this.txtCategoria.setText("");
        this.txtDescripcion.setText("");
        this.txtExistencias.setText("");
        this.txtID.setText("");
        this.txtNombre.setText("");
        this.txtPrecioC.setText("");
        this.txtPrecioV.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuscarProducto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtID = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        txtPrecioC = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lbl3 = new javax.swing.JLabel();
        txtPrecioV = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lbl4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtExistencias = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUSCAR UN PRODUCTO");

        panelBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        panelBuscarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Buscar Producto");
        panelBuscarProducto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 4, 170, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelBuscarProducto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -5, 30, 40));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel8.setText("Producto:");
        panelBuscarProducto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelBuscarProducto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 370, 6));

        btnAceptar.setBackground(new java.awt.Color(0, 63, 100));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelBuscarProducto.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 130, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (8).png"))); // NOI18N
        panelBuscarProducto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 37, 60));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelBuscarProducto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, -1, 20));
        panelBuscarProducto.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 370, 10));

        lbl1.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl1.setText("Nombre:");
        panelBuscarProducto.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 40));

        txtNombre.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        panelBuscarProducto.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 270, 40));
        panelBuscarProducto.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 10));

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        panelBuscarProducto.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 240, -1));

        lbl2.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl2.setText("Precio de compra:  $");
        panelBuscarProducto.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 40));

        txtPrecioC.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        panelBuscarProducto.add(txtPrecioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 190, 40));
        panelBuscarProducto.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 320, 10));
        panelBuscarProducto.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 320, 10));

        lbl3.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl3.setText("Precio de venta:      $");
        panelBuscarProducto.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        txtPrecioV.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        panelBuscarProducto.add(txtPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 180, 40));
        panelBuscarProducto.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 320, 10));

        lbl4.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl4.setText("Categoria:");
        panelBuscarProducto.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 40));

        txtCategoria.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        panelBuscarProducto.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 240, 40));

        lbl5.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl5.setText("Descripcion:");
        panelBuscarProducto.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));
        panelBuscarProducto.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 320, 10));

        txtExistencias.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        panelBuscarProducto.add(txtExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 210, 40));

        lbl6.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        lbl6.setText("Existencias:");
        panelBuscarProducto.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 40));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        panelBuscarProducto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 320, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // READY
        if(txtID.getText().isBlank() || txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
            this.limpiarCampos();
        }else{
            
            try{
                id = Integer.parseInt(this.txtID.getText());
                Producto producto = con.buscarProducto(id);
                
                if(producto == null){
                    JOptionPane.showMessageDialog(null, "El CODIGO ingresado no corresponde a ningun producto", "PRODUCTO    NO ENCONTRADO", 2); //Advertencia
                    this.limpiarCampos();
                } else{
                    txtNombre.setText(producto.getNombre());
                    this.txtPrecioC.setText(String.valueOf(producto.getPrecioC()));
                    txtPrecioV.setText(String.valueOf(producto.getPrecioV()));
                    switch (producto.getCategoria()) {
                        case 1 -> txtCategoria.setText("Telefonia");
                        case 2 -> txtCategoria.setText("Computo");
                        case 3 -> txtCategoria.setText("Tablets");
                        case 4 -> txtCategoria.setText("Accesorios");
                        case 5 -> txtCategoria.setText("Otro");
                        default -> txtCategoria.setText("Desconocido");
                    }
                    txtDescripcion.setText(producto.getDescripcion());
                    this.txtExistencias.setText(String.valueOf(producto.getExistencia()));
                }                
                
            } catch(NumberFormatException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "El CODIGO ingresado no es una entrada valida", "ENTRADA INVALIDA", 2); //Advertencia
                this.limpiarCampos();                
            }         
        }
        
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(dlaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlaBuscarProducto dialog = new dlaBuscarProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JPanel panelBuscarProducto;
    private javax.swing.JLabel txtCategoria;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtExistencias;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPrecioC;
    private javax.swing.JLabel txtPrecioV;
    // End of variables declaration//GEN-END:variables
}
