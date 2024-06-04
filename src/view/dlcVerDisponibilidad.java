/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controler.ControladorBD;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.Producto;

/**
 *
 * @author Wilver
 */
public class dlcVerDisponibilidad extends javax.swing.JDialog {
    
    int id=-1;

    /**OK
     * Creates new form dlcVerDisponibilidad
     */
    public dlcVerDisponibilidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void limpiarCampos(){
        this.txtID.setText("");
        this.lblDescripcion.setText("Descripcion: " );
        this.lblNombre.setText("Nombre: ");
        this.lblPrecio.setText("0.00");
        this.lblUnidades.setText("0");
        this.lblEstado.setText("Disponible");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        panelVerDisponibilidad = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        lblUnidades = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblDescripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DISPONIBILIDAD DE PRODUCTO");

        panelVerDisponibilidad.setBackground(new java.awt.Color(255, 255, 255));
        panelVerDisponibilidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        jLabel3.setText("Ver disponibilidad");
        panelVerDisponibilidad.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 4, 170, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelVerDisponibilidad.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -5, 30, 40));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelVerDisponibilidad.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 370, 6));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel8.setText("Producto:");
        panelVerDisponibilidad.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setBorder(null);
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDMousePressed(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        panelVerDisponibilidad.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 250, 30));
        panelVerDisponibilidad.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 370, 10));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelVerDisponibilidad.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (8).png"))); // NOI18N
        panelVerDisponibilidad.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 37, 60));

        btnAceptar.setBackground(new java.awt.Color(0, 63, 100));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelVerDisponibilidad.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 90, -1));

        lblEstado.setFont(new java.awt.Font("Roboto Slab", 1, 24)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(51, 255, 51));
        lblEstado.setText("Disponible");
        panelVerDisponibilidad.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        lblUnidades.setText("0");
        panelVerDisponibilidad.add(lblUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 50, -1));

        lblNombre.setText("Nombre:");
        panelVerDisponibilidad.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 320, 20));

        jLabel10.setText("Precio $");
        panelVerDisponibilidad.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, -1));

        jLabel11.setText("Unidades disponibles:");
        panelVerDisponibilidad.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        lblPrecio.setText("0.00");
        panelVerDisponibilidad.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 70, -1));
        panelVerDisponibilidad.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, 10));

        lblDescripcion.setText("Descripcion:");
        panelVerDisponibilidad.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 320, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMousePressed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
        
        if(txtID.getText().isBlank() || txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
            limpiarCampos();
        }else{
            
            try{
                id = Integer.parseInt(txtID.getText());
                ControladorBD cbd = new ControladorBD();
                Producto p = cbd.buscarProducto(id);
                if(p == null){
                    JOptionPane.showMessageDialog(null, "El CODIGO ingresado no corresponde a ningun producto", "PRODUCTO NO ENCONTRADO", 2); //Advertencia
                    this.limpiarCampos();
                }else{
                    
                    this.lblDescripcion.setText("Descripcion: " + p.getDescripcion());
                    this.lblNombre.setText("Nombre: " + p.getNombre() );
                    this.lblPrecio.setText("0.00" + String.valueOf(p.getPrecioV()));                    
                    int uni = p.getExistencia();
                    this.lblUnidades.setText( String.valueOf(uni));
                    if(uni<1){
                        this.lblEstado.setText("Agotado");
                        this.lblEstado.setForeground(Color.red);
                    }
                }
                
            } catch(Exception e){
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
            java.util.logging.Logger.getLogger(dlcVerDisponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlcVerDisponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlcVerDisponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlcVerDisponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlcVerDisponibilidad dialog = new dlcVerDisponibilidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblUnidades;
    private javax.swing.JPanel panelVerDisponibilidad;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
