/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wilver
 */
public class Usuario {
    
    private String usuario, contraseña;
    private int nivel;

    //constructor de prueba
    public Usuario() {
        this.usuario="admin";
        this.contraseña="a123";
        this.nivel=10;        
    }
    
    //Constructor de prueba
    public Usuario(int nivel) {
        this.usuario="admin";
        this.contraseña="a123";
        this.nivel=nivel;        
    }
    
   //Consructor  completo
    public Usuario(String usuario, String contraseña, int nivel) {        
        this.usuario = usuario;
        this.contraseña = contraseña;
        if(nivel==0){this.nivel=10;} else {this.nivel = nivel;}
    }

    public String getUsuario() {         return usuario;    }
    public void setUsuario(String usuario) {        this.usuario = usuario;    }
    public String getContraseña() {        return contraseña;    }
    public void setContraseña(String contraseña) {        this.contraseña = contraseña;    }
    public int getNivel() {         return nivel;    }
    public void setNivel(int nivel) {        this.nivel = nivel;    }
    
    public boolean validarUsuario(String nombreUsuario, String contrasena) {
        return this.usuario.equals(nombreUsuario) && this.contraseña.equals(contrasena);
        //Comprueba las credenciales proporcinadas con las de este usuario
    }
    
}
