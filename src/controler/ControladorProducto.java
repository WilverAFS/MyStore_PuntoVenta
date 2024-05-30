/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import database.BaseDeDatos;
import java.util.List;
import model.Producto;

/**
 *
 * @author Wilver
 */
public class ControladorProducto {
    
    private List<Producto> productos;
    private Producto producto;
    
            //Controlador sin conexion
    public ControladorProducto (){        
        BaseDeDatos bd = new BaseDeDatos();
        this.productos = bd.getProductos();        
    }
    
        //Controlador con lista de productos
    public ControladorProducto (List<Producto> productos){      
        this.productos = productos;
    }
    
    public Producto bucarProducto(int id){
        for(Producto p: productos){
            if(p.getCodigo() == id ){
                //this.producto=p;
                return p;
            }
        }
        return null;
    }
    
    public Producto bucarProducto(String id){
        int n = Integer.parseInt(id);
        for(Producto p: productos){
            if(p.getCodigo() == n ){
                //this.producto=p;
                return p;
            }
        }
        return null;
    }
    
    public boolean existeProducto(int id){
        for(Producto p: productos){
            if(p.getCodigo() == id ){
                return true;
            }
        }
        return false;
    }
    
    public boolean existeProducto(String id){
        int n = Integer.parseInt(id);
        for(Producto p: productos){
            if(p.getCodigo() == n ){
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
