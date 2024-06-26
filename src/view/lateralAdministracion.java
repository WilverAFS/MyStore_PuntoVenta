/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class lateralAdministracion extends javax.swing.JFrame {
    
    /**OK
     * NO HAY CONEXION DIRECTA
     * Creates new form lateralAdministracion
     */
    public lateralAdministracion() {
        initComponents();
        
        this.btnVerCompras.setVisible(false);
        this.btnModificarPuesto.setVisible(false);
        this.btnAgregarPuesto.setVisible(false);
        
    }
        
    public JPanel getPanelLateralAdministracion () { return this.panelLateralAdmin;}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateralAdmin = new javax.swing.JPanel();
        btnBuscarEmpleados = new javax.swing.JButton();
        btnAñadirEmpleado = new javax.swing.JButton();
        btnDarBajaEmpeado = new javax.swing.JButton();
        btnAgregarPuesto = new javax.swing.JButton();
        btnVerCompras = new javax.swing.JButton();
        btnEditarEmpleados = new javax.swing.JButton();
        btnModificarPuesto = new javax.swing.JButton();
        btnVerVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLateralAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Opciones De Administrador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14))); // NOI18N
        panelLateralAdmin.setPreferredSize(new java.awt.Dimension(330, 670));
        panelLateralAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarEmpleados.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarEmpleados.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnBuscarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (13).png"))); // NOI18N
        btnBuscarEmpleados.setText("Buscar Empleado");
        btnBuscarEmpleados.setOpaque(true);
        btnBuscarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadosActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnBuscarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 310, 60));

        btnAñadirEmpleado.setBackground(new java.awt.Color(51, 255, 51));
        btnAñadirEmpleado.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnAñadirEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (51).png"))); // NOI18N
        btnAñadirEmpleado.setText("Añadir empleado");
        btnAñadirEmpleado.setOpaque(true);
        btnAñadirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirEmpleadoActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnAñadirEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 60));

        btnDarBajaEmpeado.setBackground(new java.awt.Color(255, 0, 0));
        btnDarBajaEmpeado.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnDarBajaEmpeado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (28).png"))); // NOI18N
        btnDarBajaEmpeado.setText("Dar de baja empleado");
        btnDarBajaEmpeado.setOpaque(true);
        btnDarBajaEmpeado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaEmpeadoActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnDarBajaEmpeado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 310, 60));

        btnAgregarPuesto.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarPuesto.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnAgregarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (51).png"))); // NOI18N
        btnAgregarPuesto.setText("Agregar Puesto");
        btnAgregarPuesto.setEnabled(false);
        btnAgregarPuesto.setOpaque(true);
        btnAgregarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPuestoActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnAgregarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 310, 60));

        btnVerCompras.setBackground(new java.awt.Color(204, 204, 204));
        btnVerCompras.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnVerCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (15).png"))); // NOI18N
        btnVerCompras.setText("Ver compras");
        btnVerCompras.setEnabled(false);
        btnVerCompras.setOpaque(true);
        btnVerCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComprasActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnVerCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 310, 60));

        btnEditarEmpleados.setBackground(new java.awt.Color(204, 204, 204));
        btnEditarEmpleados.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnEditarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (23).png"))); // NOI18N
        btnEditarEmpleados.setText("Editar Empleados");
        btnEditarEmpleados.setOpaque(true);
        btnEditarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadosActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnEditarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 310, 60));

        btnModificarPuesto.setBackground(new java.awt.Color(204, 204, 204));
        btnModificarPuesto.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnModificarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (30).png"))); // NOI18N
        btnModificarPuesto.setText("Modificar Puesto");
        btnModificarPuesto.setEnabled(false);
        btnModificarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPuestoActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnModificarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 310, 60));

        btnVerVentas.setBackground(new java.awt.Color(204, 204, 204));
        btnVerVentas.setFont(new java.awt.Font("Roboto Slab", 0, 18)); // NOI18N
        btnVerVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (18).png"))); // NOI18N
        btnVerVentas.setText("Ver ventas");
        btnVerVentas.setOpaque(true);
        btnVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVentasActionPerformed(evt);
            }
        });
        panelLateralAdmin.add(btnVerVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 310, 60));

        getContentPane().add(panelLateralAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadosActionPerformed
        // TODO add your handling code here:
        //P
        dldBuscarEmpleado dialog = new dldBuscarEmpleado(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnBuscarEmpleadosActionPerformed

    private void btnAñadirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirEmpleadoActionPerformed
        // TODO add your handling code here:
        //Delete:  dldAltaEmpleado dialog = new dldAltaEmpleado(new javax.swing.JFrame(), true);
        //READY
        dvgAltaEmpleado dialog = new dvgAltaEmpleado(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAñadirEmpleadoActionPerformed

    private void btnDarBajaEmpeadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaEmpeadoActionPerformed
        //READY
        dldBajaEmpleado dialog = new dldBajaEmpleado(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnDarBajaEmpeadoActionPerformed

    private void btnAgregarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPuestoActionPerformed
        // TODO add your handling code here:
        dldAltaPuesto dialog = new dldAltaPuesto(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarPuestoActionPerformed

    private void btnVerComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComprasActionPerformed
        // TODO add your handling code here:
        dldVerCompras dialog = new dldVerCompras(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnVerComprasActionPerformed

    private void btnEditarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadosActionPerformed
        // R
        dldEditarEmpleado dialog = new dldEditarEmpleado(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnEditarEmpleadosActionPerformed

    private void btnModificarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPuestoActionPerformed
        // TODO add your handling code here:
        dldModificarPuesto dialog = new dldModificarPuesto(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);        
    }//GEN-LAST:event_btnModificarPuestoActionPerformed

    private void btnVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVentasActionPerformed
        // TODO add your handling code here:
        dialogoTabla dialog = new dialogoTabla(new javax.swing.JFrame(), true, 1);
        dialog.setLocationRelativeTo(null);        
        dialog.setVisible(true); 
    }//GEN-LAST:event_btnVerVentasActionPerformed

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
            java.util.logging.Logger.getLogger(lateralAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lateralAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lateralAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lateralAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lateralAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPuesto;
    private javax.swing.JButton btnAñadirEmpleado;
    private javax.swing.JButton btnBuscarEmpleados;
    private javax.swing.JButton btnDarBajaEmpeado;
    private javax.swing.JButton btnEditarEmpleados;
    private javax.swing.JButton btnModificarPuesto;
    private javax.swing.JButton btnVerCompras;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JPanel panelLateralAdmin;
    // End of variables declaration//GEN-END:variables
}
