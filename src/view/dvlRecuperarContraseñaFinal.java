/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

/**
 *
 * @author Wilver
 */
public class dvlRecuperarContraseñaFinal extends javax.swing.JDialog {

    /**
     * Creates new form dvlRecuperarContraseñaFinal
     */
    public dvlRecuperarContraseñaFinal(java.awt.Frame parent, boolean modal) {
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

        panelFinalRecuperarContraseña = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VER CONTRASEÑA");

        panelFinalRecuperarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        panelFinalRecuperarContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelFinalRecuperarContraseña.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (45).png"))); // NOI18N
        panelFinalRecuperarContraseña.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        btnOk.setBackground(new java.awt.Color(255, 255, 51));
        btnOk.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        panelFinalRecuperarContraseña.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, -1));

        txtContraseña.setText("jPasswordField1");
        panelFinalRecuperarContraseña.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel9.setText("Está es la contraseña de tu usuario.");
        panelFinalRecuperarContraseña.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFinalRecuperarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFinalRecuperarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(dvlRecuperarContraseñaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dvlRecuperarContraseñaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dvlRecuperarContraseñaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dvlRecuperarContraseñaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dvlRecuperarContraseñaFinal dialog = new dvlRecuperarContraseñaFinal(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelFinalRecuperarContraseña;
    private javax.swing.JPasswordField txtContraseña;
    // End of variables declaration//GEN-END:variables
}
