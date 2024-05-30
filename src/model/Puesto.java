/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wilver
 */
public class Puesto {
    private int id_puesto, nivel; //En futuras referencias este sera el nivel asignador al empleado
    private String nombre, descripcion;
    private double sueldo;

    //Constructor de pruebas
    public Puesto() {
    }

    //Constructor completo
    public Puesto(int id_puesto, String nombre, String descripcion, double sueldo, int nivel) {
        this.id_puesto = id_puesto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
        this.nivel = nivel;
    }
    
    //Metodors getters y setters
    public int getId_puesto() {        return id_puesto;    }
    public void setId_puesto(int id_puesto) {        this.id_puesto = id_puesto;    }
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getDescripcion() {        return descripcion;    }
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;    }
    public double getSueldo() {        return sueldo;    }
    public void setSueldo(double sueldo) {        this.sueldo = sueldo;    }      
    public int getNivel() {        return nivel;    }
    public void setNivel(int nivel) {        this.nivel = nivel;    }
    
    
}
