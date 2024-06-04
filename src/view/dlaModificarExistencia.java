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
public class dlaModificarExistencia extends javax.swing.JDialog {
    //OK    //private ControladorBD con;
    private int id =-1;
    private Producto producto;
    /**
     * Creates new form dlaModificarExistencia
     */
    public dlaModificarExistencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void limpiarCampos(){
        this.txtNombre.setText("Producto");
        this.txtDescripcion.setText("Descripcion");
        this.txtID.setText("");
        this.txtExistencia.setText("0");
        //this.spRestar.setValue(0);
        this.spSumar.setValue(0);
        this.btnAceptar.setEnabled(false);
        //this.spRestar.setEnabled(false);
        this.spSumar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEdicionDeProductos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spSumar = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEdicionDeProductos.setBackground(new java.awt.Color(255, 255, 255));
        panelEdicionDeProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelEdicionDeProductos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, 20));
        panelEdicionDeProductos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 310, 10));

        btnCancelar.setBackground(new java.awt.Color(0, 63, 100));
        btnCancelar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelEdicionDeProductos.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 383, 90, 30));

        btnAceptar.setBackground(new java.awt.Color(0, 63, 100));
        btnAceptar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelEdicionDeProductos.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 383, 90, 30));

        jLabel13.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel13.setText("Codigo:");
        panelEdicionDeProductos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 60, 30));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelEdicionDeProductos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 370, 10));

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        jLabel3.setText("Modificar productos en stock");
        panelEdicionDeProductos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 30));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        panelEdicionDeProductos.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 30));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescripcion.setRows(5);
        txtDescripcion.setText("Descripcion");
        jScrollPane1.setViewportView(txtDescripcion);

        panelEdicionDeProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 310, 90));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setText("Producto");
        panelEdicionDeProductos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 310, 20));

        txtExistencia.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        txtExistencia.setText("0");
        panelEdicionDeProductos.add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 150, 20));

        jLabel16.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel16.setText("En stock actualmente: ");
        panelEdicionDeProductos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 20));

        spSumar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        spSumar.setEnabled(false);
        panelEdicionDeProductos.add(spSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 130, 30));

        jLabel17.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel17.setText("Añadir o quitar");
        panelEdicionDeProductos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 100, -1));
        panelEdicionDeProductos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 370, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEdicionDeProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEdicionDeProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        ControladorBD conbd = new ControladorBD();        
        int valor= (int) spSumar.getValue();
        
        if(this.txtID.getText().isBlank() || this.txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
            this.limpiarCampos();
        } else{                        
            int nuevaE= producto.getExistencia() + valor;
            
            if( nuevaE< 0 ){
                //No se pueden quitar mas productos de los que esxisten
                JOptionPane.showMessageDialog(null, "No puede quitar mas productos de los hay en stock", "ERROR DE STOCK", 0); //Error
                this.spSumar.setValue(0);
            } else{
                conbd.cambiarExistenciaxProducto(id, nuevaE);
            this.dispose();
            }            
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
        ControladorBD conbd = new ControladorBD();
        if(txtID.getText().isBlank() || txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
            this.limpiarCampos();
        }else{
            try{
                id = Integer.parseInt(this.txtID.getText());                
                producto = conbd.buscarProducto(id);
                if (producto == null) {
                    JOptionPane.showMessageDialog(null, "El CODIGO ingresado no corresponde a ningun producto", "PRODUCTO    NO ENCONTRADO", 2); //Advertencia
                    this.limpiarCampos();
                } else {
                    txtNombre.setText(producto.getNombre());
                    txtDescripcion.setText(producto.getDescripcion());
                    this.txtExistencia.setText(String.valueOf(producto.getExistencia()) );
                    this.spSumar.setEnabled(true);
                    this.btnAceptar.setEnabled(true);
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
            java.util.logging.Logger.getLogger(dlaModificarExistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlaModificarExistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlaModificarExistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlaModificarExistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlaModificarExistencia dialog = new dlaModificarExistencia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelEdicionDeProductos;
    private javax.swing.JSpinner spSumar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtExistencia;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
