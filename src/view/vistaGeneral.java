/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.ControladorBD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Empleado;
import model.Producto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;


/**
 *@author diego & wilver
 */
public class vistaGeneral extends javax.swing.JFrame {          
    
    //Variables para la venta
    private ControladorBD con = new ControladorBD(); //Iniciamos conexion a la BD
    private int id =-1; //Id para el buscador
    //Entes
    private Empleado empleadoLogueado;
    private Cliente clienteLogueado;
    //Datos de la cuenta
    private List<Producto> listaCuenta = new ArrayList<>(); //Iniciamos una cuenta vacia
    private double total=0; //Iniciamos la varibel para el total de la cuenta
    
    //Inicializamos los aspectos visuales de la caja
    private centroCajero cCaja = new centroCajero(); //Inicializamos el centro para ser usada
    private lateralCajero lCaja = new lateralCajero(this); //Inicializamos el lateral de caja mandando el acceso a this
    private JTable tablaCuenta = cCaja.getTablaCuenta(); //Traemos la Tabla de cuenta        
        
    //dialogos de los botones principales
    private dvgVentaCliente dVenta;
    private dvgOpciones dOpciones;
    private dvgConsultarPrecio dConsultarPrecio;
    private dvgAltaCliente dAltaCliente;
    private dvgAltaProducto dAltaProducto;
    private dvgMovimientosAlmacen dMovimientosAlmacen;
    private dvgImprimirReporte dImprimirReporte;
    private dvgGrafica dGrafica;
    private dvgAltaEmpleado dAltaEmpleado;
    
   
    //CONTRUCTOR PRINCIPAL invocado por el controlador general
    public vistaGeneral() {
        initComponents();
        this.btnCambiarVista.setEnabled(false);
        this.btnCambiarVista.setVisible(false);
        this.setLocationRelativeTo(null); 
        this.activarBotones(false);
        crearModelo();
        //RELOJ FUNCIONAL del sistema
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFechaYHora();
            }
        });
        timer.start();
    }
    
    //Constructor para hacer pruebas inicializar con un nivel de usuario
    public vistaGeneral(int n) {
        initComponents();
        this.setLocationRelativeTo(null);
        //desactivamos todos los botones
        this.activarBotones(false);
        this.activarVistaUsuario(n); 
        crearModelo();
        //Inicializamos el reloj
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFechaYHora();
            }
        });
        timer.start();
    }
    
    
    //Algunos metodos getters y setters
    public JPanel getPanelVistaGeneral(){return this.panelVistaGeneral;}
    public JPanel getPanelCentral(){ return this.panelCentral;}
    public JPanel getPanelLateral(){ return this.panelLateral;} 
    
    //Necesarios para acceder a los datos de la venta
    public List<Producto> getListaCuenta() {         return  this.listaCuenta;     }    
    public Double getTotal(){ return total;}    
    public void establecerEmpleado (Empleado empleado) { this.empleadoLogueado = empleado ;}
    public Empleado traerEmpleado () {return this.empleadoLogueado; }    
    public void establecerCliente (Cliente cliente){ this.clienteLogueado = cliente; }
    public Cliente traerCliente(){ return this.clienteLogueado; }
    
    //Metodo que limpia los campos de entrada de datos
    private void limpiarCampo(){
        this.txtBuscar.setText("");
    }
    
    //Reinicia la cuenta de productsp
    public void limpiarCuenta(){
        //Por crea un metodo que limpie la lista de los producto en la venta 
        this.listaCuenta.removeAll(listaCuenta);
        total=0;
        this.actualizarTabla();
    }
    
    public void removerProducto(int codigoProducto){
        //Buscarlo en la cuenta
        boolean productoExiste = false;
        for(Producto p: listaCuenta){
            if(p.getCodigo() == codigoProducto){ //Buscar el producto
                productoExiste=true;
                int uni = p.getExistencia();
                if( uni>1 ) { p.setExistencia(uni--); }
                else{ listaCuenta.remove(p); } //Eliminarlo de la lista si solo es uno                
                break;
            }
        }
        
        if(!productoExiste){
            JOptionPane.showMessageDialog(null, "El producto no se encuentra en la cuenta", "CANCELAR PRODUCTO", 2); //Advertencia
        }
        
        this.actualizarTabla();
    }
    
    //Pendiente
    private void actualizaCentro(int nivel){
        //Metodo que vuelve a invocar la tabla central segun el nivel cuando se haga una modificacion directa en la base de datos
        //Convertir a public cuando sea implementado
    }
    
    //Inicializa la modelo para la tabla de cuenta vacia
    private void crearModelo(){        
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("IMPORTE");  
        this.tablaCuenta.setModel(modelo);           
    }
    
    //Revalida los datos de la tabla de cuenta
    private void actualizarTabla(){
        DefaultTableModel nmodelo = new DefaultTableModel( );        
        nmodelo.addColumn("CODIGO");
        nmodelo.addColumn("NOMBRE");
        nmodelo.addColumn("PRECIO UNITARIO");
        nmodelo.addColumn("CANTIDAD");
        nmodelo.addColumn("IMPORTE");          
        
        String datos[] = new String [5];
        for(Producto p:  listaCuenta ){            
            datos[0] = String.valueOf(p.getCodigo());
            datos[1] = p.getNombre();
            datos[2] = String.valueOf(p.getPrecioV());            
            datos[3] = String.valueOf(p.getExistencia()); 
            datos[4] = String.valueOf(p.getImporte());
            nmodelo.addRow(datos);
        }        
        this.tablaCuenta.setModel(nmodelo);          
        cCaja.setTotal(total); //Cada que se actualiza la tabla se vuelve a enviar el total
    }
    
    //Activa o desactiva todos los botones 
    private void activarBotones(boolean b){
        this.btnVenta.setEnabled(b);
        this.btnAltaDeClientes.setEnabled(b);
        this.btnConsultarPrecio.setEnabled(b);
        this.btnAltaDeProducto.setEnabled(b);
        this.btnMovimientosDeAlmacen.setEnabled(b);
        this.btnAltaDeTrabajadores.setEnabled(b);        
        this.btnGraficas.setEnabled(b);
        this.btnImprimirReportes.setEnabled(b);
        //this.btnOk.setEnabled(b);
        this.txtBuscar.setEnabled(b);
        this.btnCambiarVista.setEnabled(b);
        this.btnCambiarVista.setVisible(b);
        //this.btnOk.setVisible(b);
        this.txtBuscar.setVisible(b);
        this.lblLupa.setVisible(b);
    }
    
    ///Activa los botones correspondientes al nivel de usuario en el login
    public void activarNivelUsuario(int n){
        if(n==1){
            this.btnVenta.setEnabled(true);
            this.btnAltaDeClientes.setEnabled(true);
            this.btnConsultarPrecio.setEnabled(true);
            //this.btnOk.setEnabled(true);
            //this.btnOk.setVisible(true);
            this.txtBuscar.setEnabled(true);
            this.txtBuscar.setVisible(true);
            this.lblLupa.setVisible(true);
        }
        if(n==2){
            this.btnAltaDeProducto.setEnabled(true);
            this.btnMovimientosDeAlmacen.setEnabled(true);
        }
        if(n==3){
            this.btnAltaDeTrabajadores.setEnabled(true);        
            this.btnGraficas.setEnabled(true);
            this.btnImprimirReportes.setEnabled(true);
        }
        if(n==10){            
            this.activarBotones(true);
        }           
    }
    
    
    //Activa los paneles correspondientes al nivel de usuario -> configurar en el login tmb por default el de caja
    public final void activarVistaUsuario(int nivel){        
        switch (nivel) { //Vista de usuario nivel 1 = CAJERO
            case 1 ->{
                this.panelCentral.add( cCaja.getPanelCentroCajero());
                this.panelLateral.add(lCaja.getPanelLateralCajero() );
                this.activarNivelUsuario(nivel);
            }            
            case 2 ->{// //Vista de usuario nivel 2 = ALMACEN
                this.panelCentral.add(new centroAlmacen().getPanelCentroAlmacen() );
                this.panelLateral.add(new lateralAlmacen().getPanelLateralAlmacen() );
                this.activarNivelUsuario(nivel);                
            }
            case 3 -> { //Vista de usuario nivel 3 = ADMINISTRACION
                this.panelCentral.add(new centroAdministracion().getPanelCentroAsministracion());
                this.panelLateral.add(new lateralAdministracion().getPanelLateralAdministracion());
                this.activarNivelUsuario(nivel);                
            }
            case 10 -> { //Vista de usuario nivel 3 = ADMINISTRACION
                this.panelCentral.setVisible(true);
                this.panelLateral.setVisible(true);
                this.activarNivelUsuario(nivel);
            }
            default -> {
                System.out.println("Error fatal en el nivel de usuario, revisarlo desde el construtor o en la base de datos");                                 
            }
        }        
    }

    
    //Define la fecha y hora en el sistema
    private void actualizarFechaYHora(){        
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaFormateada = ahora.format(formatoFecha);
        String horaFormateada = ahora.format(formatoHora);
        //Enviamos los datos del tiempo a las etiquetas
        lblFecha.setText("Fecha:  " + fechaFormateada);
        lblHora.setText("Hora:  " + horaFormateada);
    }  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVistaGeneral = new javax.swing.JPanel();
        btnTresLineas = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblLupa = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnConsultarPrecio = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnAltaDeClientes = new javax.swing.JButton();
        btnAltaDeProducto = new javax.swing.JButton();
        btnMovimientosDeAlmacen = new javax.swing.JButton();
        btnImprimirReportes = new javax.swing.JButton();
        btnGraficas = new javax.swing.JButton();
        btnAltaDeTrabajadores = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        btnCambiarVista = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MY STORE");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelVistaGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTresLineas.setBackground(new java.awt.Color(0, 63, 100));
        btnTresLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (12).png"))); // NOI18N
        btnTresLineas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTresLineasMouseClicked(evt);
            }
        });
        btnTresLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresLineasActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnTresLineas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscar.setText("Ingresar producto");
        txtBuscar.setBorder(null);
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarMousePressed(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 900, 40));

        lblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (13).png"))); // NOI18N
        panelVistaGeneral.add(lblLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (11).png"))); // NOI18N
        panelVistaGeneral.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 51));
        jLabel14.setOpaque(true);
        panelVistaGeneral.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1390, 10));

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MY STORE");
        panelVistaGeneral.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (8).png"))); // NOI18N
        panelVistaGeneral.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -10, 37, 60));

        jLabel8.setBackground(new java.awt.Color(0, 63, 100));
        jLabel8.setOpaque(true);
        panelVistaGeneral.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 1400, 20));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("MY STORE 1.000.001 (Punto de Venta)");
        panelVistaGeneral.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 153));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("Hora:  10:10:10");
        panelVistaGeneral.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 50, 140, 30));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setOpaque(true);
        panelVistaGeneral.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1040, 40));

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("MY STORE 1.000.001 (Punto de Venta)");
        panelVistaGeneral.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnConsultarPrecio.setBackground(new java.awt.Color(102, 204, 255));
        btnConsultarPrecio.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnConsultarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (18).png"))); // NOI18N
        btnConsultarPrecio.setText("Consultar precio");
        btnConsultarPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnConsultarPrecio.setOpaque(true);
        btnConsultarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPrecioActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnConsultarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 180, 60));

        btnVenta.setBackground(new java.awt.Color(102, 204, 255));
        btnVenta.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (17).png"))); // NOI18N
        btnVenta.setText("Cliente");
        btnVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnVenta.setOpaque(true);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 60));

        btnAltaDeClientes.setBackground(new java.awt.Color(102, 204, 255));
        btnAltaDeClientes.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnAltaDeClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (19).png"))); // NOI18N
        btnAltaDeClientes.setText("Alta de clientes");
        btnAltaDeClientes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnAltaDeClientes.setOpaque(true);
        btnAltaDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaDeClientesActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnAltaDeClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 60));

        btnAltaDeProducto.setBackground(new java.awt.Color(255, 153, 153));
        btnAltaDeProducto.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnAltaDeProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (20).png"))); // NOI18N
        btnAltaDeProducto.setText("Alta de producto");
        btnAltaDeProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnAltaDeProducto.setOpaque(true);
        btnAltaDeProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaDeProductoActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnAltaDeProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, 60));

        btnMovimientosDeAlmacen.setBackground(new java.awt.Color(255, 153, 153));
        btnMovimientosDeAlmacen.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnMovimientosDeAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (22).png"))); // NOI18N
        btnMovimientosDeAlmacen.setText("Movimientos de almacen");
        btnMovimientosDeAlmacen.setEnabled(false);
        btnMovimientosDeAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnMovimientosDeAlmacen.setOpaque(true);
        btnMovimientosDeAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosDeAlmacenActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnMovimientosDeAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 240, 60));

        btnImprimirReportes.setBackground(new java.awt.Color(255, 51, 255));
        btnImprimirReportes.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnImprimirReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (24).png"))); // NOI18N
        btnImprimirReportes.setText("Imprimir reportes");
        btnImprimirReportes.setEnabled(false);
        btnImprimirReportes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnImprimirReportes.setOpaque(true);
        btnImprimirReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirReportesActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnImprimirReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 190, 60));

        btnGraficas.setBackground(new java.awt.Color(255, 51, 255));
        btnGraficas.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnGraficas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (25).png"))); // NOI18N
        btnGraficas.setText("Graficas");
        btnGraficas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnGraficas.setOpaque(true);
        btnGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficasActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnGraficas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 60));

        btnAltaDeTrabajadores.setBackground(new java.awt.Color(255, 51, 255));
        btnAltaDeTrabajadores.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnAltaDeTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/pngegg (26).png"))); // NOI18N
        btnAltaDeTrabajadores.setText("Alta de trabajadores");
        btnAltaDeTrabajadores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnAltaDeTrabajadores.setOpaque(true);
        btnAltaDeTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaDeTrabajadoresActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnAltaDeTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 200, 60));

        jLabel52.setBackground(new java.awt.Color(0, 63, 100));
        jLabel52.setOpaque(true);
        panelVistaGeneral.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 45));

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        panelVistaGeneral.add(panelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1030, 480));

        panelLateral.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        panelVistaGeneral.add(panelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, 330, 670));

        btnCambiarVista.setBackground(new java.awt.Color(255, 51, 51));
        btnCambiarVista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCambiarVista.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarVista.setText("Cambiar nivel  de vista");
        btnCambiarVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarVistaActionPerformed(evt);
            }
        });
        panelVistaGeneral.add(btnCambiarVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 200, 60));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 153));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha.setText("Fecha:  2024-01-01");
        panelVistaGeneral.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 150, 30));

        getContentPane().add(panelVistaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMousePressed
        //TODO
    }//GEN-LAST:event_txtBuscarMousePressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // Ready
        //Trae el producto con el mismo codigo
        String codigo = this.txtBuscar.getText();
        if(codigo.isBlank() || codigo.isEmpty()){ //Si no ingreso un codigo o ingreso solo espacios entonces...
            JOptionPane.showMessageDialog(null, "Ingrese un CODIGO de producto", "CAMPO INCOMPLETO", 2); //Advertencia
            this.limpiarCampo();
        }else{            
            try{
                id = Integer.parseInt(codigo);
                Producto producto = con.buscarProducto(id);                
                if(producto == null){ //Si el producto con ese codigo existe o no
                    JOptionPane.showMessageDialog(null, "El CODIGO ingresado no corresponde a ningun producto", "PRODUCTO    NO ENCONTRADO", 2); //Advertencia
                    this.limpiarCampo();
                }else{//Si el producto existe entonces..
                    //Hacemos una copia del producto pero con los datos del anterior                     
                    Producto nuevoP = new Producto( producto);
                    nuevoP.setExistencia(1); //Utilisaremos existencia del nuevo producto para contarlos en la venta;
                    total = total + nuevoP.getPrecioV();
                    //NOTA: al hacer la venta final es necesario sacarlos del inventario con ayuda del metodo disminuir stock                  
                    
                    //Ver si el mismo producto esta en la lista 
                    boolean productoExiste = false;
                    for(Producto p: listaCuenta){                        
                        if(p.getCodigo() == nuevoP.getCodigo()){ //SI ya esta solo aumentamos en uno su valor
                            p.addExistencia();
                            productoExiste = true;
                            break;
                            //this.actualizarTabla();  //Revalidamos la tabla 
                        }                        
                    }
                    
                    if(!productoExiste){ //Si el producto no existe lo agregamos
                        this.listaCuenta.add(nuevoP);
                    }
                    
                    this.actualizarTabla(); //Revalidamos la tabla al final                    
                }
                
            } catch (NumberFormatException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "El CODIGO ingresado no es una entrada valida", "ENTRADA INVALIDA", 2); //Advertencia
                this.limpiarCampo();        
            }
            
        }
        
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnConsultarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPrecioActionPerformed
        // TODO add your handling code here:        
        this.dConsultarPrecio = new dvgConsultarPrecio(new javax.swing.JFrame(), true);
        this.dConsultarPrecio.setLocationRelativeTo(null);
        this.dConsultarPrecio.setVisible(true);
    }//GEN-LAST:event_btnConsultarPrecioActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:
        this.dVenta = new dvgVentaCliente( new javax.swing.JFrame(), true );
        //Enviar el clienteLogueado para dar acceso a sus datos
        this.dVenta.establecerCliente(clienteLogueado);
        this.dVenta.setLocationRelativeTo(null);
        this.dVenta.setVisible(true);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnAltaDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaDeClientesActionPerformed
        // TODO add your handling code here:        
        this.dAltaCliente = new dvgAltaCliente(new javax.swing.JFrame(), true);
        this.dAltaCliente.setLocationRelativeTo(null);
        this.dAltaCliente.setVisible(true);
    }//GEN-LAST:event_btnAltaDeClientesActionPerformed

    private void btnAltaDeProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaDeProductoActionPerformed
        // TODO add your handling code here:
        this.dAltaProducto = new dvgAltaProducto(new javax.swing.JFrame(), true);
        this.dAltaProducto.setLocationRelativeTo(null);
        this.dAltaProducto.setVisible(true);
    }//GEN-LAST:event_btnAltaDeProductoActionPerformed

    private void btnMovimientosDeAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosDeAlmacenActionPerformed
        // TODO add your handling code here:
         
        this.dMovimientosAlmacen = new dvgMovimientosAlmacen(new javax.swing.JFrame(), true);
        this.dMovimientosAlmacen.setLocationRelativeTo(null);
        this.dMovimientosAlmacen.setVisible(true);
    }//GEN-LAST:event_btnMovimientosDeAlmacenActionPerformed

    private void btnImprimirReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirReportesActionPerformed
        // TODO add your handling code here:
        this.dImprimirReporte = new dvgImprimirReporte(new javax.swing.JFrame(), true);
        this.dImprimirReporte.setLocationRelativeTo(null);
        this.dImprimirReporte.setVisible(true);
    }//GEN-LAST:event_btnImprimirReportesActionPerformed

    private void btnGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficasActionPerformed
        // TODO add your handling code here:
        this.dGrafica = new dvgGrafica(new javax.swing.JFrame(), true);
        this.dGrafica.setLocationRelativeTo(null);
        this.dGrafica.setVisible(true);
    }//GEN-LAST:event_btnGraficasActionPerformed

    private void btnAltaDeTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaDeTrabajadoresActionPerformed
        // TODO add your handling code here:
        
        this.dAltaEmpleado = new dvgAltaEmpleado(new javax.swing.JFrame(), true);
        this.dAltaEmpleado.setLocationRelativeTo(null);
        this.dAltaEmpleado.setVisible(true);
    }//GEN-LAST:event_btnAltaDeTrabajadoresActionPerformed

    private void btnTresLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresLineasActionPerformed
        // TODO add your handling code here:
        
        this.dOpciones = new dvgOpciones(new javax.swing.JFrame(), true);
        //Enviar datos del empleado logueado
        this.dOpciones.establecerEmpleado(empleadoLogueado);
        this.dOpciones.setLocation(WIDTH, WIDTH);
        this.dOpciones.setVisible(true);
    }//GEN-LAST:event_btnTresLineasActionPerformed

    private void btnTresLineasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTresLineasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTresLineasMouseClicked

    private void btnCambiarVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarVistaActionPerformed
        // TODO add your handling code here:
        dvgSuper dialog = new dvgSuper(new javax.swing.JFrame(), true, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        //Acceso al panel de cambio de vista
    }//GEN-LAST:event_btnCambiarVistaActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        // TODO add your handling code here:
        this.txtBuscar.setForeground(Color.black);
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        // TODO add your handling code here:
        Color c = new Color(204,204,204);
        this.txtBuscar.setForeground(c);
        this.txtBuscar.setText("Ingresar producto");
    }//GEN-LAST:event_txtBuscarFocusLost

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
            java.util.logging.Logger.getLogger(vistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaGeneral(10).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaDeClientes;
    private javax.swing.JButton btnAltaDeProducto;
    private javax.swing.JButton btnAltaDeTrabajadores;
    private javax.swing.JButton btnCambiarVista;
    private javax.swing.JButton btnConsultarPrecio;
    private javax.swing.JButton btnGraficas;
    private javax.swing.JButton btnImprimirReportes;
    private javax.swing.JButton btnMovimientosDeAlmacen;
    private javax.swing.JButton btnTresLineas;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelVistaGeneral;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
