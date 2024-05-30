/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.ArrayList; 
import java.util.List;
import model.*; //Para los objetos de los modelos

 //LIBRERIAS NECESARIAS PARA CONECCION Y MOSTRAR  DATOS    
    import java.sql.Connection;
    //import javax.swing.table.DefaultTableModel;

   // import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

//LIBRERIAS PARA MODIFICACION DE DATOS
    import java.sql.PreparedStatement;
   // import javax.swing.JOptionPane;
/**
 *
 * @author Wilver
 */
public class BaseDeDatos {
    
    private ConexionBD conexion = new ConexionBD();
    private Connection con = conexion.conectar();
    //private int fila =0;   
    
    private List<Producto> productos;
    private List<Empleado> empleados;
    private List<Puesto> puestos;
    private List<Venta> ventas;
    private List<Cliente> clientes;
    private List<DescripcionVenta> descripcionesVentas;
        
    public BaseDeDatos() {
        //Sera necesario crear  listas para contener objetos de diferente tipo
        productos = new ArrayList<>();
        empleados = new ArrayList<>();
        ventas = new ArrayList<>();
        puestos = new ArrayList<>();
        clientes = new ArrayList<>();
        descripcionesVentas = new ArrayList<>();
        //Cargamos las listas con los objetos correspodientes de los datos de la BD
        cargarProductos();
        cargarEmpleados();
        cargarPuestos();
        cargarClientes();
        cargarVentas();
        cargarDescripcionesVentas();        
    }
    
    //Metodo para obtener esta conexion
    public Connection getConexion(){ return con;}
    
    //Metodos para obtener el numero de productos en una desterminada categoria//usar para definir los ID de productos
    public int getNumProductoXCategoria(int categoria){
        int n=0;
        for(Producto p: productos){
            if(p.getCategoria() == categoria){
                n++;
            }        
        }
        return n;
    }
    
    //Metodo para buscar un elemento de las listas por
    
    
    //Metodos getters y setters
    public List<Producto> getProductos() {         return productos;     }    
    public List<Puesto> getPuestos() {        return puestos;    }
    public List<Venta> getVentas() {        return ventas;    }
    public List<Cliente> getClientes() {        return clientes;    }
    public List<Empleado> getEmpleados() {        return empleados;    }  
    public List<DescripcionVenta> getDescripcionesVentas() {        return descripcionesVentas;    }    
    public void setProductos(List<Producto> productos) {        this.productos = productos;    }  
    public void setPuestos(List<Puesto> puestos) {        this.puestos = puestos;    }
    public void setVentas(List<Venta> ventas) {        this.ventas = ventas;    }
    public void setClientes(List<Cliente> clientes) {        this.clientes = clientes;    }
    public void setEmpleados(List<Empleado> empleados) {        this.empleados = empleados;    }
    public void setDescripcionesVentas(List<DescripcionVenta> descripcionesVentas) {        this.descripcionesVentas = descripcionesVentas;    }
    
    
    
    //Métodos para DESCARGAR DATOS  desde la BD
    private void cargarProductos(){
        String query = "SELECT * FROM producto";        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                //Creacion de un objeto de este tipo con la misma forma que en la BD por cada tupla existente en ella
                Producto producto = new Producto( 
                        rs.getInt(1),   //codigo_producto
                        rs.getString(2),  //nombre_p
                        rs.getDouble(3), //precio_compra_p
                        rs.getDouble(4), //precio_venta_p 
                        rs.getInt(5), //categoria_p
                        rs.getString(6),  // descripcion_p
                        rs.getInt(7)  //Existencia_p                        
                );
                //Lo añadimos a la lista de producos
                productos.add(producto);
            }
            //Bandera de confirmacion
            System.out.println("PRODUCTOS cargados correctamente");            
        }catch(SQLException e){
            System.out.println("ERROR en la carga de los PRODUCTOS: \n" + e);
        }
    }         
            
    private void cargarClientes(){
            String query = "SELECT * FROM cliente";
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                //Creacion de un objeto de este tipo con la misma forma que en la BD por cada tupla existente en ella
                Cliente cliente = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                //Lo añadimos a la lista de clientes
                clientes.add(cliente);
            }
            //Bandera de confirmacion
            System.out.println("CLIENTES cargados correctamente"); 
        } catch(SQLException e){
            System.out.println("ERROR en la carga de los CLIENTES: \n" + e);
        }
    }
    
    private void cargarPuestos(){
        String query = "SELECT * FROM puesto";
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                //Creacion de un objeto de este tipo con la misma forma que en la BD por cada tupla existente en ella
                Puesto puesto = new Puesto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                );
                //Lo añadimos a la lista de puestos
                puestos.add(puesto);
            }
            //Bandera de confirmacion
            System.out.println("PUESTOS cargados correctamente"); 
        } catch(SQLException e){
            System.out.println("ERROR en la carga de los PUESTOS: \n" + e);
        }
    }  
        
    private void cargarEmpleados(){
        String query = "SELECT * FROM empleado";
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                //Creacion de un objeto de este tipo con la misma forma que en la BD por cada tupla existente en ella
                Empleado empleado = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
                //Lo añadimos a la lista de empleados
                empleados.add(empleado);
            }
            //Bandera de confirmacion
            System.out.println("EMPLEADOS cargados correctamente"); 
        } catch(SQLException e){
            System.out.println("ERROR en la carga de los EMPLEADOS: \n" + e);
        }
    }
    
    private void cargarVentas(){
        String query = "SELECT * FROM venta";
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                Venta venta = new Venta(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getTime(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                ventas.add(venta);
            }
            //Bandera de confirmacion
            System.out.println("VENTAS cargadas correctamente"); 
        } catch(SQLException e){
            System.out.println("ERROR en la carga de las VENTAS: \n" + e);
        }
    }
    
    private void cargarDescripcionesVentas(){
        String query = "SELECT * FROM descripcion_venta";
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ){
                DescripcionVenta dVenta = new DescripcionVenta(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)
                );                
                descripcionesVentas.add(dVenta);
            }
            //Bandera de confirmacion
            System.out.println("DESCRIPCIONES_V cargadas correctamente"); 
        } catch(SQLException e){
            System.out.println("ERROR en la carga de las DESCRIPCIONES DE VENTAS: \n" + e);
        }
    }
    
}
