/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wilver
 */
public class Empleado  extends Usuario{

    private String  nombre, apellidoP, apellidoM;
    private int idEmpleado, id_puesto;
    private Puesto puestoE;

    //Constructor de prueba nv10
    public Empleado( ) {
        this.idEmpleado = 1;
        this.nombre = "Arturo";
        this.apellidoP = "Ramirez";
        this.apellidoM = "Hernandez";
        this.id_puesto = 1;
    }
    
    //Constructor de prueba nv asignado
    public Empleado(int nivel ) {
        super(nivel);
        this.idEmpleado = 1;
        this.nombre = "Arturo";
        this.apellidoP = "Ramirez";
        this.apellidoM = "Hernandez";
        this.id_puesto = 1;
    }

    //Constructor completo
    public Empleado(int idEmpleado, String nombre, String apellidoP, String apellidoM, String usuario, String contraseña, int id_puesto) {
        super(usuario, contraseña, id_puesto);
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.id_puesto = id_puesto;
    }
    
    //Constructor completo con relacion a otros objs
    public Empleado(int idEmpleado, String nombre, String apellidoP, String apellidoM, String usuario, String contraseña, Puesto puesto) {
        super(usuario, contraseña, puesto.getNivel());
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.puestoE=puesto;
    }
    //Metodos getters y setters
    public int getIdEmpleado() {         return idEmpleado;    }
    public void setIdEmpleado(int idEmpleado) {        this.idEmpleado = idEmpleado;    } 
    public String getNombre() {       return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getApellidoP() {        return apellidoP;    }
    public void setApellidoP(String apellidoP) {        this.apellidoP = apellidoP;    }
    public String getApellidoM() {        return apellidoM;    }
    public void setApellidoM(String apellidoM) {         this.apellidoM = apellidoM;    }
    public int getId_puesto() {        return id_puesto;    }
    public void setId_puesto(int id_puesto) {        this.id_puesto = id_puesto;    }

    //Agregar los metodos que pueda manejar
    
    
}
