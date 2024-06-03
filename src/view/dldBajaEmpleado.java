/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controler.ControladorBD;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import model.Empleado;

/**
 *
 * @author Wilver
 */
public class dldBajaEmpleado extends javax.swing.JDialog {
    
    ControladorBD con;

    /**
     * Creates new form dldBajaEmpleado
     */
    public dldBajaEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new ControladorBD();
    }
    
    public dldBajaEmpleado(java.awt.Frame parent, boolean modal, ControladorBD con) {
        super(parent, modal);
        initComponents();
        this.con = con;
    }
    
    public void limpiarCampos(){
        this.txtApellidoMaterno.setText("");
        this.txtApellidoPaterno.setText("");
        this.txtClave.setText("");
        this.txtNombre.setText("");
        this.txtPuesto.setText("");
        this.txtUsuario.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBajaDeEmpleados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnBaja = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BAJA DE EMPLEADO");

        panelBajaDeEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        panelBajaDeEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        jLabel3.setText("Baja de trabajador");
        panelBajaDeEmpleados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 170, 50));

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelBajaDeEmpleados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelBajaDeEmpleados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 420, 10));

        jLabel10.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel10.setText("ID:");
        panelBajaDeEmpleados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel8.setText("Nombre:");
        panelBajaDeEmpleados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));

        txtClave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtClave.setForeground(new java.awt.Color(204, 204, 204));
        txtClave.setText("clave del trabajador");
        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClaveFocusLost(evt);
            }
        });
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 270, 30));

        txtUsuario.setEnabled(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 270, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel11.setText("Usuario:");
        panelBajaDeEmpleados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 60, 30));

        jLabel13.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel13.setText("Puesto:");
        panelBajaDeEmpleados.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 50, 30));

        txtPuesto.setEnabled(false);
        txtPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuestoActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 270, 30));

        txtApellidoPaterno.setEnabled(false);
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 270, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel14.setText("Apellido paterno:");
        panelBajaDeEmpleados.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        txtApellidoMaterno.setEnabled(false);
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 270, 30));

        jLabel15.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel15.setText("Apellido materno:");
        panelBajaDeEmpleados.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 30));

        btnBaja.setBackground(new java.awt.Color(0, 63, 100));
        btnBaja.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnBaja.setText("Baja");
        btnBaja.setEnabled(false);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(btnBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 293, 90, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 63, 100));
        btnCancelar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 293, 90, 30));
        panelBajaDeEmpleados.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 420, 10));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelBajaDeEmpleados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (8).png"))); // NOI18N
        panelBajaDeEmpleados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 37, 60));

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelBajaDeEmpleados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBajaDeEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBajaDeEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 375, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        //Traer los datos del empleado y mostrarlos
        String i = txtClave.getText();
        if(i.isBlank() || i.isEmpty()){
            //Si no ingresa nada
            JOptionPane.showMessageDialog(null, "Ingrese un ID de trabajador", "CAMPO INCOMPLETO", 2); //Advertencia  
            limpiarCampos();
        } else {            
            try {
                int id = Integer.parseInt(this.txtClave.getText());
                Empleado empleado = con.buscarEmpleado(id);                
                if(empleado == null){
                    JOptionPane.showMessageDialog(null, "El ID ingresado no corresponde a ningun empleado", "EMPLEDO NO ENCONTRADO", 2); //Advertencia
                    limpiarCampos();                    
                } else{
                    this.btnBaja.setEnabled(true);
                    this.txtNombre.setText(empleado.getNombre());
                    this.txtApellidoMaterno.setText(empleado.getApellidoM());
                    this.txtApellidoPaterno.setText(empleado.getApellidoP());
                    this.txtPuesto.setText(String.valueOf(empleado.getId_puesto()));
                    this.txtUsuario.setText(empleado.getUsuario());
                }                
            } catch (HeadlessException | NumberFormatException e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "El ID ingresado no es valido a ningun empleado", "ID INVALIDO", 2); //Advertencia
                    limpiarCampos();
            }   
        }
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuestoActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusGained
        // TODO add your handling code here:
        this.txtClave.setForeground(Color.black);
        this.txtClave.setText("");
    }//GEN-LAST:event_txtClaveFocusGained

    private void txtClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusLost
        // TODO add your handling code here:        
        this.txtClave.setForeground(new Color (204,204,204));
    }//GEN-LAST:event_txtClaveFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
               
        if(this.txtClave.getText().isBlank() || this.txtClave.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un ID de trabajador", "CAMPO INCOMPLETO", 2); //Advertencia
        } else{
            try{
                int codigo = Integer.parseInt(txtClave.getText());
                con.eliminarEmpleado(codigo);
            } catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "ID de trabajador invalido", "CAMPO INCOMPLETO", 2); //Advertencia
            }
            
            this.dispose();
        }
    }//GEN-LAST:event_btnBajaActionPerformed

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
            java.util.logging.Logger.getLogger(dldBajaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dldBajaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dldBajaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dldBajaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dldBajaEmpleado dialog = new dldBajaEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBajaDeEmpleados;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
