/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.util.Date;
//import java.util.List;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Wilver
 */
public class Venta {
    private int folio_venta, id_empleado, id_cliente;
    private Date fecha;
    private Time hora; 
    
    //Cosntructor vacio para pruebas
    public Venta() {
    }
       
    //Constructor completo    
    public Venta (int folio_venta, Date fecha, Time hora, int id_empleado, int id_cliente){
        this.folio_venta = folio_venta;
        this.fecha = fecha;
        this.hora = hora;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
    }

    //Metodos getters y setters
    public int getFolio_venta() {        return folio_venta;    }
    public int getId_empleado() {        return id_empleado;    }
    public int getId_cliente() {        return id_cliente;    }
    public Date getFecha() {        return fecha;    }
    public Time getHora() {        return hora;    }    
    public void setFolio_venta(int folio_venta) {       this.folio_venta = folio_venta;    }
    public void setId_empleado(int id_empleado) {        this.id_empleado = id_empleado;    }
    public void setId_cliente(int id_cliente) {        this.id_cliente = id_cliente;    }
    public void setFecha(Date fecha) {        this.fecha = fecha;    }
    public void setHora(Time hora) {        this.hora = hora;    }    
    
    
    
}
