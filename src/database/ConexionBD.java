/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wilver
 */
public class ConexionBD {
    Connection con;    
    public static final String URL = "jdbc:mysql://localhost:3306/mystore";
    public static final String USER = "root";
    public static final String CLAVE = "WAFS%25";
    
    public Connection conectar(){
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("CONECTADO a mystore bd");
        } catch (SQLException e) {
            System.out.println("ERROR en la CONEXION de la bd: \n" + e);
        }
        return con;
    }   
    
}
