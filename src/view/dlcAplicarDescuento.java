/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Wilver
 */
public class dlcAplicarDescuento extends javax.swing.JDialog {
    
    private dlcCobrarCuenta cobrarCuenta;
    private double total, descuento, totalFinal;

    /**
     * Creates new form dlcCapturarDescuento
     * @param parent
     * @param modal
     */
    public dlcAplicarDescuento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public dlcAplicarDescuento(java.awt.Frame parent, boolean modal, dlcCobrarCuenta cobrarCuenta) {
        super(parent, modal);
        initComponents();
        this.cobrarCuenta = cobrarCuenta;
    }
    
    public void setTotal(double total){
        this.total = total;        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDescuento = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("APLICAR DESCUENTO");

        panelDescuento.setBackground(new java.awt.Color(255, 255, 255));
        panelDescuento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        panelDescuento.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Slab", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descuento");
        panelDescuento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);
        panelDescuento.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 280, 40));

        txtPorcentaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPorcentaje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeActionPerformed(evt);
            }
        });
        panelDescuento.add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel8.setText("Porcentaje %:");
        panelDescuento.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel11.setText("Importe $: ");
        panelDescuento.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 60, 30));

        txtImporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        panelDescuento.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 150, 30));

        btnAceptar.setBackground(new java.awt.Color(0, 63, 100));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelDescuento.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeActionPerformed
        // TODO add your handling code here:
        if(this.txtPorcentaje.getText().isBlank() || txtPorcentaje.getText().isEmpty() ){
        JOptionPane.showMessageDialog(null, "Ingrese un PORCENTAJE de descuento ", "CAMPO INCOMPLETO", 2); //Advertencia  
        this.txtPorcentaje.setText("");
        }else{            
            try{                
                double porce = Double.parseDouble(txtPorcentaje.getText() );
                descuento = porce * total  / 100;
                totalFinal = total - descuento;
                this.txtImporte.setText(String.valueOf(descuento));            
                this.btnAceptar.setEnabled(true);
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "El dato ingresado no es una entrada valida", "ENTRADA INVALIDA", 2); //Advertencia
                this.txtPorcentaje.setText("");
            }       
        }
        
    }//GEN-LAST:event_txtPorcentajeActionPerformed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        // TODO add your handling code here:
        
        if(this.txtImporte.getText().isBlank() || txtImporte.getText().isEmpty() ){
        JOptionPane.showMessageDialog(null, "Ingrese un IMPORTE de descuento ", "CAMPO INCOMPLETO", 2); //Advertencia  
        this.txtImporte.setText("");
        }else{            
            try{                
                double des = Double.parseDouble(txtImporte.getText() );
                descuento = des*100/ total;
                totalFinal = total - des;
                this.txtPorcentaje.setText(String.valueOf(descuento));          
                this.btnAceptar.setEnabled(true);
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "El dato ingresado no es una entrada valida", "ENTRADA INVALIDA", 2); //Advertencia
                this.txtImporte.setText("");
            }       
        }
        
    }//GEN-LAST:event_txtImporteActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        //Enviar este dato a la ventana anterior              
        this.cobrarCuenta.setTotalFinal(totalFinal);
        this.cobrarCuenta.establecerCambio();
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
            java.util.logging.Logger.getLogger(dlcAplicarDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlcAplicarDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlcAplicarDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlcAplicarDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlcAplicarDescuento dialog = new dlcAplicarDescuento(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelDescuento;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
