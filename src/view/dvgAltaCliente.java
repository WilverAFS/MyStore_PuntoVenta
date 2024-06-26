/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controler.ControladorBD;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Wilver
 */
public class dvgAltaCliente extends javax.swing.JDialog {
    
    
    /**OK
     * Creates new form dvgAltaCliente
     */
    public dvgAltaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAltaDeCliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNumTelefono = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR NUEVO CLIENTE");

        panelAltaDeCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelAltaDeCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        jLabel3.setText("Agregar cliente");
        panelAltaDeCliente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelAltaDeCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelAltaDeCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 420, 10));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nombre: ");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelAltaDeCliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        txtClave.setBackground(new java.awt.Color(204, 204, 204));
        txtClave.setForeground(new java.awt.Color(102, 102, 102));
        txtClave.setText("000001");
        txtClave.setBorder(null);
        txtClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtClaveMousePressed(evt);
            }
        });
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        panelAltaDeCliente.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 80, 20));

        btnCancelar.setBackground(new java.awt.Color(0, 63, 100));
        btnCancelar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelAltaDeCliente.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, -1));
        panelAltaDeCliente.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 420, 10));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 63, 100));
        jLabel9.setText("MY STORE");
        panelAltaDeCliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (8).png"))); // NOI18N
        panelAltaDeCliente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 37, 60));

        jLabel10.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel10.setText("Clave:");
        panelAltaDeCliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelAltaDeCliente.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 270, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Num de Telefono: ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelAltaDeCliente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 30));

        txtNumTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumTelefonoActionPerformed(evt);
            }
        });
        txtNumTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumTelefonoKeyPressed(evt);
            }
        });
        panelAltaDeCliente.add(txtNumTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, 30));

        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });
        panelAltaDeCliente.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 270, 30));

        jLabel12.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Correo electronico: ");
        panelAltaDeCliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 30));

        btnAgregar.setBackground(new java.awt.Color(0, 63, 100));
        btnAgregar.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelAltaDeCliente.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAltaDeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAltaDeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 314, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveMousePressed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNumTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumTelefonoActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ControladorBD conbd = new ControladorBD();
        int id = conbd.getnCliente() +1;
        String nombre = txtNombre.getText();
        String tel = txtNumTelefono.getText();
        String correo = txtCorreoElectronico.getText();
        if( nombre.isEmpty() || nombre.isBlank() || tel.isEmpty() || tel.isBlank() || correo.isBlank() || correo.isEmpty()  ){
            JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor", "CAMPOS INCOMPLETOS", 2); //Advertencia
        } else {
            Cliente nuenvoCliente = new Cliente(id, nombre, tel, correo);
            conbd.insertarCliente(nuenvoCliente);            
        }
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNumTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumTelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumTelefonoKeyPressed

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
            java.util.logging.Logger.getLogger(dvgAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dvgAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dvgAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dvgAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dvgAltaCliente dialog = new dvgAltaCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelAltaDeCliente;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumTelefono;
    // End of variables declaration//GEN-END:variables
}
