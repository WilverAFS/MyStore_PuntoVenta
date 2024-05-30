/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wilver
 */
public class DescripcionVenta {
    private int folio_venta, codigo_producto, cantidad;
    private String descripcion;
    
    //Constructor de prueba
    public DescripcionVenta(){
        this.folio_venta=0;
        this.codigo_producto=1;
        this.descripcion ="Observacion de la venta";
        this.cantidad=1;
    }
    
    //Contructor completo
    public DescripcionVenta(int folio_venta, int codigo_producto, String descripcion, int cantidad){
        this.folio_venta = folio_venta;
        this.codigo_producto = codigo_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public int getFolio_venta() {        return folio_venta;    }
    public int getCodigo_producto() {        return codigo_producto;    }
    public int getCantidad() {        return cantidad;    }
    public String getDescripcion() {        return descripcion;    }
    public void setFolio_venta(int folio_venta) {        this.folio_venta = folio_venta;    }
    public void setCodigo_producto(int codigo_producto) {        this.codigo_producto = codigo_producto;    }
    public void setCantidad(int cantidad) {        this.cantidad = cantidad;    }
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;    }
        
    
}
