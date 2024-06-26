/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import model.Empleado;

/**
 * PENDIENTE FALTAN DAR FUNCIONALIDAD A LOS BOTONES
 * @author Wilver
 */
public class dvgOpciones extends javax.swing.JDialog {

    /**
     * Creates new form dvgOpciones
     */
    public dvgOpciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void establecerEmpleado(Empleado empleado){
        this.txtNombre.setText(empleado.getNombre());
        this.txtId.setText( String.valueOf(empleado.getIdEmpleado() ) );
        this.txtUsuario.setText(empleado.getUsuario());                
        this.txtPuesto.setText(empleado.getPuestoNombre());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTresLineas = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnVentaRapida = new javax.swing.JButton();
        btnResultados = new javax.swing.JButton();
        btnMiNegocio = new javax.swing.JButton();
        btnChatDeSoporte = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        panelUsuarioLogueado = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Nombre1 = new javax.swing.JLabel();
        Nombre2 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JLabel();
        Nombre3 = new javax.swing.JLabel();
        Nombre4 = new javax.swing.JLabel();
        pswContraseña = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        Nombre5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OPCIONES ESPECIALIZADAS");

        panelTresLineas.setBackground(new java.awt.Color(81, 116, 218));
        panelTresLineas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        panelTresLineas.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 680, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (33).png"))); // NOI18N
        panelTresLineas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 220));

        jLabel56.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(204, 204, 204));
        jLabel56.setText("¡Comienza a registrar tu informacion!");
        panelTresLineas.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, 70));

        jLabel58.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Bienvenido a tu sistema de punto de venta");
        panelTresLineas.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 590, 90));

        btnReportes.setBackground(new java.awt.Color(81, 116, 218));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (43).png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorder(null);
        btnReportes.setEnabled(false);
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, -1, 140));

        btnCliente.setBackground(new java.awt.Color(81, 116, 218));
        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (34).png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.setBorder(null);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelTresLineas.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, 140));

        btnProductos.setBackground(new java.awt.Color(81, 116, 218));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (36).png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, -1, 140));

        btnCompras.setBackground(new java.awt.Color(81, 116, 218));
        btnCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (37).png"))); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.setBorder(null);
        btnCompras.setEnabled(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, -1, 140));

        btnVentaRapida.setBackground(new java.awt.Color(81, 116, 218));
        btnVentaRapida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVentaRapida.setForeground(new java.awt.Color(255, 255, 255));
        btnVentaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (38).png"))); // NOI18N
        btnVentaRapida.setText("Venta rapida");
        btnVentaRapida.setBorder(null);
        btnVentaRapida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentaRapida.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnVentaRapida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVentaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaRapidaActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnVentaRapida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, 140));

        btnResultados.setBackground(new java.awt.Color(81, 116, 218));
        btnResultados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnResultados.setForeground(new java.awt.Color(255, 255, 255));
        btnResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (39).png"))); // NOI18N
        btnResultados.setText("Resultados");
        btnResultados.setBorder(null);
        btnResultados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResultados.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnResultados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadosActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, 140));

        btnMiNegocio.setBackground(new java.awt.Color(81, 116, 218));
        btnMiNegocio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMiNegocio.setForeground(new java.awt.Color(255, 255, 255));
        btnMiNegocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (40).png"))); // NOI18N
        btnMiNegocio.setText("Mi negocio");
        btnMiNegocio.setBorder(null);
        btnMiNegocio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMiNegocio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMiNegocio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMiNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiNegocioActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnMiNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, -1, 140));

        btnChatDeSoporte.setBackground(new java.awt.Color(81, 116, 218));
        btnChatDeSoporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnChatDeSoporte.setForeground(new java.awt.Color(255, 255, 255));
        btnChatDeSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (41).png"))); // NOI18N
        btnChatDeSoporte.setText("Chat de soporte");
        btnChatDeSoporte.setBorder(null);
        btnChatDeSoporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChatDeSoporte.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnChatDeSoporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChatDeSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatDeSoporteActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnChatDeSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1, 140));

        btnAyuda.setBackground(new java.awt.Color(81, 116, 218));
        btnAyuda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (42).png"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setBorder(null);
        btnAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAyuda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnAyuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        panelTresLineas.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, -1, 140));

        panelUsuarioLogueado.setBackground(new java.awt.Color(0, 63, 100));
        panelUsuarioLogueado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Bienvenido");
        panelUsuarioLogueado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, -1));

        Nombre1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nombre1.setForeground(new java.awt.Color(102, 255, 255));
        Nombre1.setText("ID:");
        panelUsuarioLogueado.add(Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 30, -1));

        Nombre2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nombre2.setForeground(new java.awt.Color(102, 255, 255));
        Nombre2.setText("Puesto:");
        panelUsuarioLogueado.add(Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, -1));

        txtPuesto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPuesto.setForeground(new java.awt.Color(102, 204, 255));
        txtPuesto.setText("name p");
        panelUsuarioLogueado.add(txtPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 230, 30));

        Nombre3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nombre3.setForeground(new java.awt.Color(102, 255, 255));
        Nombre3.setText("Usuario:");
        panelUsuarioLogueado.add(Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, -1));

        Nombre4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nombre4.setForeground(new java.awt.Color(102, 255, 255));
        Nombre4.setText("Contraseña:");
        panelUsuarioLogueado.add(Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, -1));

        pswContraseña.setBackground(new java.awt.Color(0, 63, 100));
        pswContraseña.setForeground(new java.awt.Color(102, 204, 255));
        pswContraseña.setText("jPasswordField1");
        panelUsuarioLogueado.add(pswContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 160, -1));
        panelUsuarioLogueado.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 290, 10));
        panelUsuarioLogueado.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, 10));
        panelUsuarioLogueado.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 10));
        panelUsuarioLogueado.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, 10));

        Nombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nombre5.setForeground(new java.awt.Color(102, 255, 255));
        Nombre5.setText("Nombre:");
        panelUsuarioLogueado.add(Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 204, 255));
        txtNombre.setText("name");
        panelUsuarioLogueado.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 210, 30));

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(102, 204, 255));
        txtId.setText("id");
        panelUsuarioLogueado.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 250, 30));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 204, 255));
        txtUsuario.setText("user");
        panelUsuarioLogueado.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 220, 30));

        panelTresLineas.add(panelUsuarioLogueado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 340, 290));

        jLabel55.setBackground(new java.awt.Color(0, 63, 100));
        jLabel55.setOpaque(true);
        panelTresLineas.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelTresLineas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelTresLineas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnVentaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaRapidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentaRapidaActionPerformed

    private void btnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResultadosActionPerformed

    private void btnMiNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiNegocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMiNegocioActionPerformed

    private void btnChatDeSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatDeSoporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChatDeSoporteActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(dvgOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dvgOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dvgOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dvgOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dvgOpciones dialog = new dvgOpciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JLabel Nombre3;
    private javax.swing.JLabel Nombre4;
    private javax.swing.JLabel Nombre5;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnChatDeSoporte;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnMiNegocio;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnResultados;
    private javax.swing.JButton btnVentaRapida;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel panelTresLineas;
    private javax.swing.JPanel panelUsuarioLogueado;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPuesto;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
