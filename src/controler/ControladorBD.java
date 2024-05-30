/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import database.BaseDeDatos;
import database.ConexionBD;

 //LIBRERIAS NECESARIAS PARA CONECCION Y MOSTRAR  DATOS    
    import java.sql.Connection;

   // import java.sql.Statement;
    //import java.sql.ResultSet;
    import java.sql.SQLException;

//LIBRERIAS PARA MODIFICACION DE DATOS
    import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Wilver
 */
public class ControladorBD {
    
    private Connection con;
    private BaseDeDatos BD;
    
    int nCliente, nVenta, nEmpleado, nPuesto; 
    
    
    public ControladorBD( BaseDeDatos BD ){
        con = BD.getConexion();
        nCliente = BD.getClientes().size();
        nVenta = BD.getVentas().size();
        nEmpleado = BD.getEmpleados().size();
        nPuesto = BD.getPuestos().size();
    }
    
    //De prueba
    public ControladorBD( ){
        //Establece una nueva conexion
         BD = new BaseDeDatos();
        con = BD.getConexion();
        nCliente = BD.getClientes().size();
        nVenta = BD.getVentas().size();
        nEmpleado = BD.getEmpleados().size();
        nPuesto = BD.getPuestos().size();
    }
    
    //Metodos buscadores
    public Producto buscarProducto(int id){
        for(Producto p: BD.getProductos()){
            if(p.getCodigo() == id){                return p;            }        
        }
        return null;
    }
    
    public Empleado buscarEmpleado(int id){
        for(Empleado e: BD.getEmpleados()){
            if(e.getIdEmpleado() == id){    return e;  }
        }
        return null;
    }
    
    public Cliente buscarCliente(int id){
        for(Cliente c: BD.getClientes()){
            if(c.getId_cliente() == id){    return c;   }
        }
        return null;
    }
    
    public Cliente buscarTelefonoCliente(String tel){
        for(Cliente c: BD.getClientes()){
            if(c.getTelefono().equalsIgnoreCase(tel)){    return c;   }
        }
        return null;
    }
    
    public Puesto buscarPuesto(int id){
            for(Puesto p: BD.getPuestos()){
                if(p.getId_puesto() == id){     return p;   }
            }            
            return null;
    }
    
    public Venta buscarVenta(int folio){
        for(Venta v: BD.getVentas()){
            if( v.getFolio_venta() == folio ){  return v;   }
        }
        return null;
    }
    
    public List<DescripcionVenta> getDescripcionesXventa(int folio){
        List<DescripcionVenta> dV = new ArrayList<>();
        for(DescripcionVenta dVenta: BD.getDescripcionesVentas()){
            if(dVenta.getFolio_venta() == folio){
                dV.add(dVenta);
            }
        }
        return dV;
    }
    

    //Metodos getters con el numero total de elemetnos en la lista determinada
    public int getnCliente() {        return nCliente;    }
    public int getnVenta() {        return nVenta;    }
    public int getnEmpleado() {        return nEmpleado;    }
    public int getnPuesto() {        return nPuesto;    }
    public int getNPCategoria(int n){ return  BD.getNumProductoXCategoria(n); }
    
    //------------------------------------------------------------------//
    //Metodos de tipo INSERT para AÑADIR un registro
    
    public void insertarProducto(Producto producto){
        //INSERTAR UN REGISTRO EN LA TABLA PRODUCTO   desde un nuevo objeto de este tipo
        try{
            //INSERT INTO `mystore`.`producto` (`codigo_producto`, `nombre_p`, `precio_compra_p`, `precio_venta_p`, `categoria_p`, `descripcion_p`, `existencia_p`) VALUES ('100002', 'nombre', '1', '2', '1', 'des', '1');
            PreparedStatement ps =con.prepareStatement("INSERT INTO producto (codigo_producto, nombre_p, precio_compra_p, precio_venta_p, categoria_p, descripcion_p, existencia_p) VALUES (?,?,?,?,?,?,?)");
            
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecioC());
            ps.setDouble(4, producto.getPrecioV());
            ps.setInt(5, producto.getCategoria());
            ps.setString(6, producto.getDescripcion());
            ps.setInt(7, producto.getExistencia());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar el PRODUCTO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        }   
        
    }
    
    public void insertarCliente(Cliente cliente){
        try{
            //INSERT INTO `mystore`.`cliente` (`id_cliente`, `nombre_c`, `telefono_c`, `correo_c`) VALUES ('2', 'as', 'as', 'as');
            PreparedStatement ps =con.prepareStatement("INSERT INTO cliente (id_cliente, nombre_c, telefono_c, correo_c) VALUES (?,?,?,?)");
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar el CLIENTE en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        }     
    }
    
    public void insertarPuesto(Puesto puesto){
        try{
            //INSERT INTO `mystore`.`puesto` (`id_puesto`, `nombre`, `descripcion`, `sueldo`, `nivel`) VALUES ('1', 's', 'a', '1', '1');
            PreparedStatement ps =con.prepareStatement("INSERT INTO puesto ( id_puesto, nombre, descripcion, sueldo, nivel ) VALUES (?,?,?,?,?)");
            
            ps.setInt(1, puesto.getId_puesto());
            ps.setString(2, puesto.getNombre());
            ps.setString(3, puesto.getDescripcion());
            ps.setDouble(4, puesto.getSueldo());
            ps.setInt(5, puesto.getNivel());
            
            ps.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar el PUESTO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        }     
    }
    
    public void insertarEmpleado(Empleado empleado){
        try{
            //INSERT INTO `mystore`.`empleado` (`id_empleado`, `nombre_e`, `apellido_paterno_e`, `apellido_materno_e`, `usuario_e`, `contrasena_e`, `id_puesto`) VALUES ('a', 'a', 'a', 'a', 'a', 'a', 'a');
            PreparedStatement ps =con.prepareStatement("INSERT INTO empleado ( id_empleado, nombre_e, apellido_paterno_e, apellido_materno_e, usuario_e, contrasena_e, id_puesto ) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, empleado.getIdEmpleado());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidoP());
            ps.setString(4, empleado.getApellidoM());
            ps.setString(5, empleado.getUsuario());
            ps.setString(6, empleado.getContraseña());
            ps.setInt(7, empleado.getId_puesto());
            
            ps.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar el EMPLEADO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        }    
    }
    
    public void insertarVenta(Venta venta){
        //  INSERT INTO `mystore`.`venta` (`folio_venta`, `fecha_v`, `hora_v`, `id_empleado`, `id_cliente`) VALUES ('a', 's', 'a', 'a', '5');
        String query="INSERT INTO venta (folio_venta, fecha_v, hora_v, id_empleado, id_cliente) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps =con.prepareStatement(query);
            
            ps.setInt(1, venta.getFolio_venta());
            ps.setDate(2, venta.getFecha());
            ps.setTime(3, venta.getHora());
            ps.setInt(4, venta.getId_empleado());
            ps.setInt(5, venta.getId_cliente());
            
            ps.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar la VENTA en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        } 
    
    }
    
    public void insertarDescripcionVenta(DescripcionVenta dVenta){
        //  INSERT INTO mystore.descripcion_venta (folio_venta, codigo_producto, descripcion, cantidad) VALUES (1, 100001, 'Descripcion de pueba', 0 );
        String query="INSERT INTO descripcion_venta (folio_venta, codigo_producto, descripcion, cantidad) VALUES (?,?,?,?)";
        try{
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, dVenta.getFolio_venta());
            ps.setInt(2, dVenta.getCodigo_producto());
            ps.setString(3, dVenta.getDescripcion());
            ps.setInt(4, dVenta.getCantidad());
            
            ps.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            //Hacer la actualizacion y limpieza desde donde se llame este metodo;
        }
        catch(SQLException e){
            System.out.println("ERROR al insertar la DESCRIPCION DE VENTA en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "ACTUALIZACION FALLIDA", 0); //Error            
        } 
    }
    
    //------------------------------------------------------------------//
    //Metodos de tipo UPDATE para EDITAR
    
    public void editarProducto(Producto producto){
        //UPDATE `mystore`.`producto` SET `nombre_p` = 's', `precio_compra_p` = '1', `precio_venta_p` = '2', `categoria_p` = '2', `descripcion_p` = '1', `existencia_p` = '1' WHERE (`codigo_producto` = '400001');
        String query ="UPDATE producto SET nombre_p=?, precio_compra_p=?, precio_venta_p=?, categoria_p=?,  descripcion_p=?, existencia_p=?,  WHERE codigo_producto=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecioC());
            ps.setDouble(3, producto.getPrecioV());
            ps.setInt(4, producto.getCategoria());
            ps.setString(5, producto.getDescripcion());
            ps.setInt(6, producto.getExistencia());
            ps.setInt(7, producto.getCodigo());
            
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            
        } catch(SQLException e){
            System.out.println("ERROR al editar el PRODUCTO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
    }
    
    public void cambiarExistenciaxProducto(int id, int existencia){
        String query ="UPDATE producto SET existencia_p=?,  WHERE codigo_producto=? ";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, existencia);
            ps.setInt(2, id);
            
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
        } catch(SQLException e){
            System.out.println("ERROR al editar el PRODUCTO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
    
    }
    
    public void editarPuesto(Puesto x){
        //UPDATE `mystore`.`producto` SET `nombre_p` = 's', `precio_compra_p` = '1', `precio_venta_p` = '2', `categoria_p` = '2', `descripcion_p` = '1', `existencia_p` = '1' WHERE (`codigo_producto` = '400001');
        String query ="UPDATE puesto SET nombre=?, descripcion=?, sueldo=?, nivel=?,  WHERE id_puesto=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, x.getNombre());
            ps.setString(2, x.getDescripcion());
            ps.setDouble(3, x.getSueldo());
            ps.setInt(4, x.getNivel());
            ps.setInt(5, x.getId_puesto());
            
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            
        } catch(SQLException e){
            System.out.println("ERROR al editar el PUESTO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
    }
    
    
    public void editarCliente(Cliente cliente){
        //UPDATE `mystore`.`cliente` SET `nombre_c` = 'a', `telefono_c` = 'a', `correo_c` = 'a' WHERE (`id_cliente` = '2');
        String query ="UPDATE cliente SET nombre_c=?, telefono_c=?, correo_c=?, WHERE id_cliente=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNombre() );
            ps.setString(2, cliente.getTelefono() );
            ps.setString(3, cliente.getCorreo() );
            ps.setInt(4, cliente.getId_cliente() );
            
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            
        } catch(SQLException e){
            System.out.println("ERROR al editar el CLIENTE en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
        
    }
    
    public void editarEmpleado(Empleado empleado){
        //UPDATE `mystore`.`empleado` SET `nombre_e` = 'a', `apellido_paterno_e` = 'a', `apellido_materno_e` = 'a', `usuario_e` = 'a', `contrasena_e` = 'a', `id_puesto` = 'a' WHERE (`id_empleado` = '5');
        String query ="UPDATE empleado SET nombre_e=?, apellido_paterno_e=?, apellido_materno_e=?, usuario_e=?, contrasena_e=?, id_puesto=?, WHERE id_empleado=?";
        
         try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, empleado.getNombre() );
            ps.setString(2, empleado.getApellidoP() );
            ps.setString(3, empleado.getApellidoM() );
            ps.setString(4, empleado.getUsuario() );
            ps.setString(5, empleado.getContraseña() );
            ps.setInt(6, empleado.getId_puesto());
            ps.setInt(7, empleado.getIdEmpleado());
            
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            
        } catch(SQLException e){
            System.out.println("ERROR al editar el EMPLEAO en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
        
    }
    
    public void editarVenta(Venta venta){
        // UPDATE `mystore`.`venta` SET `fecha_v` = '2', `hora_v` = '2', `id_empleado` = '2', `id_cliente` = '2' WHERE (`folio_venta` = '1');
        String query ="UPDATE venta SET fecha_v=?, hora_v=?, id_empleado=?, id_cliente=?, WHERE folio_venta=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, venta.getFecha() );
            ps.setTime(2, venta.getHora() );
            ps.setInt(3, venta.getId_empleado() );
            ps.setInt(4, venta.getId_cliente() );
            ps.setInt(5,  venta.getFolio_venta() );
                    
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "ACTUALIZACION EXISTOSA", 1);
            
        } catch(SQLException e){
            System.out.println("ERROR al editar la VENTA en la BD: " + e);
            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos", "EDICION FALLIDA", 0); //Error            
        }    
        
    }
    
    
    //------------------------------------------------------------------//
    //Metodos de tipo DELETE para ELIMINAR un registro
    
    public void eliminarProducto(int id){
        String query="DELETE FROM producto WHERE codigo_producto = ?";
        
        if(JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar el producto?", "¿ELIMINAR PRODUCTO?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                try {                    
                    PreparedStatement ps = con.prepareStatement(query);                    
                    ps.setInt(1, id);
                    ps.executeUpdate();                    
                    JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al eliminar el producto en la BD " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado.");            
            }    
    }
    
    public void eliminarEmpleado(int id){
        String query = "DELETE FROM empleado WHERE id_empleado=?";
        
        if(JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar el empleado?", "¿ELIMINAR EMPLEADO?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                try {                    
                    PreparedStatement ps = con.prepareStatement(query);                    
                    ps.setInt(1, id);
                    ps.executeUpdate();                    
                    JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al eliminar el empleado en la BD " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado.");            
            }    
    }
    
    public void eliminarPuesto(int id){
        String query="DELETE FROM puesto WHERE id_puesto=?";
        
        if(JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar el puesto?", "¿ELIMINAR PUESTO?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                try {                    
                    PreparedStatement ps = con.prepareStatement(query);                    
                    ps.setInt(1, id);
                    ps.executeUpdate();                    
                    JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al eliminar el puesto en la BD " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado.");            
            }            
    }
    
    public void eliminarCliente(int id){
        String query="DELETE FROM clinete WHERE id_cliente=?";
        
        if(JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar el cliente?", "¿ELIMINAR CLIENTE?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                try {                    
                    PreparedStatement ps = con.prepareStatement(query);                    
                    ps.setInt(1, id);
                    ps.executeUpdate();                    
                    JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al eliminar el cliente en la BD " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado.");            
            }    
    }
    
    public void eliminarVenta(int id){
        String query="DELETE FROM venta WHERE id_venta=?";
        
        if(JOptionPane.showConfirmDialog(null,"¿Esta seguro de eliminar la venta?", "¿ELIMINAR VENTA?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                try {                    
                    PreparedStatement ps = con.prepareStatement(query);                    
                    ps.setInt(1, id);
                    ps.executeUpdate();                    
                    JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al eliminar la venta en la BD " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado.");            
            }    
    }
    
}
