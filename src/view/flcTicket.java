/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.itextpdf.text.DocumentException;
import controler.ControladorBD;
import email.EnviarEmail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.DescripcionVenta;
import model.Empleado;
import model.Producto;
import model.Venta;
import pdf.GenerarPdf;

/**
 *
 * @author Wilver
 */
public class flcTicket extends javax.swing.JFrame {
    //TICKET PARA IMPRESION EN PDF
    private String nombreTicket;
    //Declaracion de variables
    private Cliente clienteLogueado;  
    private Empleado empleadoLogueado;
    private double pago;
    private double total;
    private double totalFinal;
    private double cambio;
    private List<Producto> listaCuenta; 
    
    private Date fechaActual;
    private Time horaActual; 
    
    //Creacion de una venta
    private Venta venta;
    private List<DescripcionVenta> listaDescripcion = new ArrayList<>();
    
    
    /**
     * Creates new form flcTicket
     */
    //Constructor de pruebas
    public flcTicket() {
        initComponents();
       valoresPrueba();
       this.pack();
       
       this.empleadoLogueado = new Empleado();
       this.clienteLogueado = new Cliente();
       totalFinal = 1500;
       pago = 2000;
       cambio = pago-totalFinal;
       
       this.establecerTiempo();
        this.lblNombreCajero.setText(empleadoLogueado.getNombre());
        this.lblNombreCliente.setText("Cliente: " + clienteLogueado.getNombre() );        
        this.lblTotal.setText(String.valueOf(totalFinal));
        this.lblPago.setText(String.valueOf(pago));
        this.lblCambio.setText(String.valueOf(cambio));                
        this.lblFolioVenta.setText( "FolioVenta 0001");            
    }
    
    //CONSTRUCTO PRINCIPAL con datos
    public flcTicket(Empleado empleado, Cliente cliente, List<Producto> listaCuenta, double totalFinal, double pago, double cambio) {
        initComponents();
        this.empleadoLogueado = empleado;
        this.clienteLogueado = cliente;
        this.listaCuenta = listaCuenta;
        this.totalFinal = totalFinal;
        this.pago = pago;
        this.cambio = cambio; //Tambien se puede calcular aqui
        this.crearTicket();
        
        //Al final imprimir en PDF
        this.imprimirPDF();
        
        // Mandar correo después de 5 segundos
        this.enviarCorreo();
       
    }
    
    public void setEmpleadoLogueado(Empleado empleado){        this.empleadoLogueado = empleado;    }    
    public void setClienteLogueado(Cliente cliente){        this.clienteLogueado = cliente;    }        
    
    public JPanel getPanelTicket(){        return this.panelTicket;    }
    
    
//Crea el ticket con los valores correspondientes
    private void crearTicket(){
        this.valoresCuenta();
        this.establecerTiempo();
        this.lblNombreCajero.setText(empleadoLogueado.getNombre());
        this.lblNombreCliente.setText("Cliente: " + clienteLogueado.getNombre() );        
        this.lblTotal.setText(String.valueOf(totalFinal));
        this.lblPago.setText(String.valueOf(pago));
        this.lblCambio.setText(String.valueOf(cambio));                
        //Esto hacerlo al crear la venta
        //this.lblFolioVenta.setText( String.valueOf(venta.getFolio_venta()) );                
        
        //Crear la venta
        this.crearVenta();
        this.subirDatos(); //Los guardamos en la BD
    }
    
    //Optiene la fechayhora del sistema los guarda e imprime en el ticket
    private void establecerTiempo(){ //Independiente
        LocalDateTime ahora = LocalDateTime.now();
        fechaActual = Date.valueOf(ahora.toLocalDate()); //Guarda la fecha como SQL.Date
        horaActual = Time.valueOf(ahora.toLocalTime()); //Guarda la fecha como SQL.Time               
        this.lblFechaVenta.setText(fechaActual.toString()); //Muestra la fecha en el ticket
        this.lblHoraVenta.setText( horaActual.toString()); //Muestra lo hora en el ticket
    }
    
    private void crearVenta(){        
        //CREAMOS una VENTA con los valores de esta        
        ControladorBD con = new ControladorBD();         
        int id = con.getnVenta() + 1 ;  //Para el folio hacemos una conexion y obtener la longitud de elementos
        this.venta = new Venta(id, fechaActual, horaActual, empleadoLogueado.getIdEmpleado(), clienteLogueado.getId_cliente() );                
                
        //CREARMOS la lista de DETALLES para una venta
        for(Producto p: listaCuenta){
            DescripcionVenta dVenta = new DescripcionVenta( venta.getFolio_venta(), p.getCodigo(), "-", p.getExistencia() ); 
            this.listaDescripcion.add(dVenta);
        }
        
        this.lblFolioVenta.setText("FOLIO: " + String.valueOf(id));                
    }    
    
    private void subirDatos(){
        //Guarda la informacion de esta venta y su descripcion a la base de datos
        ControladorBD con = new ControladorBD(); 
        con.insertarVenta(venta);
        for(DescripcionVenta dV: listaDescripcion){
            con.insertarDescripcionVenta(dV);            
        }
    }
    
    
    private void valoresPrueba(){
        String datos[] = new String[4];         
        //modelo para la tabla
        DefaultTableModel modelo =new DefaultTableModel(new Object[]{"Articulo", "Precio", "Unidades", "Subtotal"}, 0);
        this.tabla.setModel(modelo); //Enviamos el modelo a la tabla
        
        //Alineacion a la dereche con las columnas de valores numericos
        DefaultTableCellRenderer alineacionDerecha = new DefaultTableCellRenderer();
        alineacionDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alineacionDerecha);
        tabla.getColumnModel().getColumn(2).setCellRenderer(alineacionDerecha);
        tabla.getColumnModel().getColumn(3).setCellRenderer(alineacionDerecha);
        
        String data[] = new String [5];        
        for(int i=0; i<10; i++){
            data[0] = "Producto1";
            data[1] =  "$120.00";
            data[2] = "3";
            data[3] = "$360.00";            
            modelo.addRow(data); //Enviamos una fila al modelo;
        }   
    }
    
    //Hace la tabla del ticket con los datos de la lista de cuenta
    private void valoresCuenta( ){
        DefaultTableModel modelo =new DefaultTableModel(new Object[]{"Articulo", "Precio", "Unidades", "Subtotal"}, 0);
        this.tabla.setModel(modelo); //Enviamos el modelo a la tabla        
        //Alineacion a la dereche con las columnas de valores numericos
        DefaultTableCellRenderer alineacionDerecha = new DefaultTableCellRenderer();
        alineacionDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alineacionDerecha);
        tabla.getColumnModel().getColumn(2).setCellRenderer(alineacionDerecha);
        tabla.getColumnModel().getColumn(3).setCellRenderer(alineacionDerecha);
        
        String data[] = new String[5];        
        for(Producto p: listaCuenta){
            data[0] = p.getNombre();
            data[1] = String.valueOf(p.getPrecioV());
            data[2] = String.valueOf(p.getExistencia());
            data[3] = String.valueOf(p.getImporte());            
            modelo.addRow(data); //Enviamos una fila de datos al modelo
        }        
        
    }
    
    private void imprimirPDF() {
        GenerarPdf pdf = new GenerarPdf();
        nombreTicket = "Ticket_" + this.venta.getFolio_venta() + ".pdf";
        try {
            pdf.generatePdfFromPanel(this.panelTicket, nombreTicket);
        } catch (DocumentException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR en la generacion del pdf para este ticket", "GENERAR PDF", 0); // Error         
        }
    }
       
    private void enviarCorreo() {
        if (this.clienteLogueado.getId_cliente() != 1) {
            try {
                String correo = this.clienteLogueado.getCorreo();
                String nombreArchivo = nombreTicket;

                File archivo = new File(nombreArchivo);
                if (!archivo.exists()) {
                    throw new FileNotFoundException("El archivo PDF no fue encontrado.");
                }

                String ubicacionArchivo = archivo.getAbsolutePath();
                EnviarEmail sendEmail = new EnviarEmail();
                sendEmail.enviarCorreo(correo, ubicacionArchivo);

            } catch (FileNotFoundException e) {
                System.out.println("No fue posible enviar el correo");
                System.out.println(e);
            } catch (IOException e) {
                System.out.println("Ocurrió un error inesperado");
                System.out.println(e);
            }
        } else {
            System.out.println("Este cliente no tiene correo");
        }

    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tabla = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblNombreEmpresa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRfcEmpresa = new javax.swing.JLabel();
        lblSucursalEmpresa = new javax.swing.JLabel();
        lblDireccionEmpresa = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        panelDesgloce = new javax.swing.JPanel();
        lblPago = new javax.swing.JLabel();
        lblHoraVenta = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblNombreCajero = new javax.swing.JLabel();
        lblFolioVenta = new javax.swing.JLabel();
        lblFechaVenta = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPaneTitle = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        setTitle("TICKTE DE COMPRA");
        setAlwaysOnTop(true);

        panelTicket.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 63, 100));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 63, 100));
        jLabel2.setOpaque(true);

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANT.", "ARTICULO", "PRECIO UNI", "SUBTOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreEmpresa.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(0, 63, 100));
        lblNombreEmpresa.setText("MY STORE SA DE CV");
        panelDatos.add(lblNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (9).png"))); // NOI18N
        panelDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, 70));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("--------------------------------------------------------------------------------");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 20));

        lblRfcEmpresa.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblRfcEmpresa.setText("R. F. C. DMRH041224-RHM");
        panelDatos.add(lblRfcEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        lblSucursalEmpresa.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblSucursalEmpresa.setText("SUCURSAL OAXACA 1 (001)");
        panelDatos.add(lblSucursalEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 20));

        lblDireccionEmpresa.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblDireccionEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccionEmpresa.setText("Calzada Francisco I. Madero 1332");
        panelDatos.add(lblDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 150, 290, 20));

        lblNombreCliente.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblNombreCliente.setText("Cliente: Publico general");
        panelDatos.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 280, 20));

        panelDesgloce.setBackground(new java.awt.Color(255, 255, 255));

        lblPago.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblPago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPago.setText("0.00");

        lblHoraVenta.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblHoraVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHoraVenta.setText("21:23:00");

        lblCambio.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCambio.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel14.setText("TOTAL M.N. $");

        lblTotal.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");

        lblPuntos.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setText("0.00");

        jLabel17.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel17.setText("Efectivo $");

        jLabel19.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel19.setText("Cambio $");

        jLabel18.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel18.setText("CAMBIO EN MONEDERO:");

        jLabel20.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        jLabel20.setText("LE ATENDIO:");

        lblNombreCajero.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblNombreCajero.setText("ROQUE HERNANDEZ DIEGO");

        lblFolioVenta.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblFolioVenta.setText("FOLIO: 000001");

        lblFechaVenta.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lblFechaVenta.setText("19/05/2024");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (50).png"))); // NOI18N
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelDesgloceLayout = new javax.swing.GroupLayout(panelDesgloce);
        panelDesgloce.setLayout(panelDesgloceLayout);
        panelDesgloceLayout.setHorizontalGroup(
            panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesgloceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDesgloceLayout.createSequentialGroup()
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lblFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lblFolioVenta))
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel24))
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDesgloceLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDesgloceLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDesgloceLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDesgloceLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDesgloceLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDesgloceLayout.setVerticalGroup(
            panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDesgloceLayout.createSequentialGroup()
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDesgloceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE))
        );

        scrollPaneTitle.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneTitle.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Articulo", "Precio", "Unidades", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTitle.setViewportView(tabla1);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDesgloce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTicketLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPaneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(scrollPaneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(panelDesgloce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(flcTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flcTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flcTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flcTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flcTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblDireccionEmpresa;
    private javax.swing.JLabel lblFechaVenta;
    private javax.swing.JLabel lblFolioVenta;
    private javax.swing.JLabel lblHoraVenta;
    private javax.swing.JLabel lblNombreCajero;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblRfcEmpresa;
    private javax.swing.JLabel lblSucursalEmpresa;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDesgloce;
    private javax.swing.JPanel panelTicket;
    private javax.swing.JScrollPane scrollPaneTitle;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
