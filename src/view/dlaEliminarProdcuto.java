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
public class dlaEliminarProdcuto extends javax.swing.JDialog {
    
    private ControladorBD con;
    private int id=-1;
    /**
     * Creates new form dlaEliminarProdcuto
     */
    public dlaEliminarProdcuto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new ControladorBD();
    }
    
    public dlaEliminarProdcuto(java.awt.Frame parent, boolean modal, ControladorBD cbd) {
        super(parent, modal);
        initComponents();
        con = cbd;
    }
    
    private void limpiarCampos(){
        this.txtID.setText("");
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");
        this.txtPrecioVenta.setText("");
        this.txtprecioCompra.setText("");
        this.spExistencia.setValue(0);
        this.cmbCategoria.setSelectedIndex(0);
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEliminarProducto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtprecioCompra = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        spExistencia = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEliminarProducto.setBackground(new java.awt.Color(255, 255, 255));
        panelEliminarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelEliminarProducto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, 20));
        panelEliminarProducto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 420, 10));

        btnCancelar.setBackground(new java.awt.Color(0, 63, 100));
        btnCancelar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 90, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 63, 100));
        btnEliminar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 90, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel13.setText("Existencia");
        panelEliminarProducto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 70, 20));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDescripcion.setEnabled(false);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 270, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel11.setText("Categoria:");
        panelEliminarProducto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 70, 20));

        jLabel15.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel15.setText("Precio de venta:");
        panelEliminarProducto.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 20));

        txtPrecioVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrecioVenta.setEnabled(false);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 270, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel14.setText("Precio de compra:");
        panelEliminarProducto.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 20));

        txtprecioCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtprecioCompra.setEnabled(false);
        txtprecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioCompraActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(txtprecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 270, 30));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 270, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel8.setText("Nombre:");
        panelEliminarProducto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 60, 20));

        jLabel10.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel10.setText("Codigo:");
        panelEliminarProducto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 60, -1));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelEliminarProducto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 420, 10));

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        jLabel3.setText("Eliminacion de productos");
        panelEliminarProducto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 220, 50));

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelEliminarProducto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        jLabel16.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel16.setText("Descricion:");
        panelEliminarProducto.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 70, 20));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        panelEliminarProducto.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 110, 30));

        cmbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Telefonia", "Computo", "Tablets", "Accesorios", "Otros" }));
        cmbCategoria.setEnabled(false);
        panelEliminarProducto.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 110, 30));

        spExistencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        spExistencia.setEnabled(false);
        panelEliminarProducto.add(spExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(this.txtID.getText().isBlank() || this.txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
        } else{
            this.con.eliminarProducto(id);            
        }
        
        this.dispose();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtprecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioCompraActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
                    txtprecioCompra.setText(String.valueOf(producto.getPrecioC()));
                    txtPrecioVenta.setText(String.valueOf(producto.getPrecioV()));
                    cmbCategoria.setSelectedIndex(producto.getCategoria() - 1);
                    txtDescripcion.setText(producto.getDescripcion());
                    spExistencia.setValue(producto.getExistencia());
                    this.btnEliminar.setEnabled(true);
                }                
                
            } catch(NumberFormatException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "El CODIGO ingresado no es una entrada valida", "ENTRADA INVALIDA", 2); //Advertencia
                this.limpiarCampos();                
            }            
        }
        
    }//GEN-LAST:event_txtIDActionPerformed

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
            java.util.logging.Logger.getLogger(dlaEliminarProdcuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlaEliminarProdcuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlaEliminarProdcuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlaEliminarProdcuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlaEliminarProdcuto dialog = new dlaEliminarProdcuto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelEliminarProducto;
    private javax.swing.JSpinner spExistencia;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtprecioCompra;
    // End of variables declaration//GEN-END:variables
}
