/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.util.ArrayList;

/**
 *
 * @author Wilver
 */
public class Producto {
    private String  nombre, descripcion;
    private int codigo, existencia, categoria;
    private double precioC, precioV; 
    
    //1-telefonia, 2-Computo, 3-Tablets, 4-Acesorios y 5.-Otros. Catalogo por categorias

    //constructor de prueba
    public Producto() {
        this.codigo = 001;
        this.nombre = "PeraPod";
        this.descripcion = "Telefono celular de 256 GB";
        this.categoria = 1;        
        this.precioC = 5000.00;
        this.precioV = 6000.00;
        this.existencia = 10;
    }
    
    //Constructor completo    
    public Producto(int codigo, String nombre,  double precioC, double precioV, int categoria, String descripcion,int existencia) {
        this.codigo = codigo;
        this.nombre = nombre;        
        this.precioC = precioC;
        this.precioV = precioV;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.existencia = existencia;
    }
    
    //Metodos getters y setters
    public String getNombre() {         return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getDescripcion() {        return descripcion;    } 
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;    }
    public int getCategoria() {        return categoria;    }
    public void setCategoria(int categoria) {        this.categoria = categoria;    }
    public int getCodigo() {        return codigo;    }
    public void setCodigo(int codigo) {        this.codigo = codigo;    }
    public int getExistencia() {        return existencia;    }
    public void setExistencia(int existencia) {        this.existencia = existencia;    }
    public double getPrecioC() {        return precioC;    }
    public void setPrecioC(double precioC) {        this.precioC = precioC;    }
    public double getPrecioV() {        return precioV;    }
    public void setPrecioV(double precioV) {        this.precioV = precioV;    }
    
    public String getCategoriaNombre(){
        String c ="Desconocido";
        switch (categoria) {
            case 1 -> c="Telefonia";
            case 2 -> c="Computo";
            case 3 -> c="Tablets";
            case 4 -> c="Accesorios";
            case 5 -> c="Otro";
            default -> c="Desconocido";
        }
        return c;
    }
    
    
}
