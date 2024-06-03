/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wilver
 */
public class Cliente {
    private String nombre, telefono, correo;
    private int id_cliente;

    //Constructor de pruebas
    public Cliente() {        
        this.nombre = "Cliente Wilver";
        this.telefono = "9512525298";
        this.correo = "wilverflores2004@gmail.com";
        this.id_cliente = 1234;
    }

    //Constructor completo
    public Cliente (int id_cliente, String nombre, String telefono, String correo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_cliente() {        return id_cliente;    }
    public void setId_cliente(int id_cliente) {        this.id_cliente = id_cliente;    }
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getTelefono() {        return telefono;    }
    public void setTelefono(String telefono) {        this.telefono = telefono;    }
    public String getCorreo() {        return correo;    }
    public void setCorreo(String correo) {        this.correo = correo;    }    
    
}
