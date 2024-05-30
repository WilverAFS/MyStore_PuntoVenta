/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutable;

import controler.ControladorAlfa;
import controler.ControladorBD;
//import controler.controladorInicio;
import database.BaseDeDatos;
//import model.Empleado;
//import model.Usuario;
import view.login;
import view.vistaGeneral;
import view.vistaInicial;

/**
 *
 * @author Wilver
 */
public class Prueba1 {
    
    public static void main(String ... args){
                
        //Objetos de tipo Model con datos de la BD
        BaseDeDatos BD = new BaseDeDatos();
        
        //Realizar acciones sobre la BD
        ControladorBD cBD= new ControladorBD( BD);
        
        
        
        //Objetos de tipo View
        login vLogin=new login();        
        vistaGeneral vGeneral= new vistaGeneral();        
        vistaInicial vInicio = new vistaInicial();
        
        //Verficar el envio del usuario
        // public ControladorAlfa(vistaInicial vInicio, login vLogin, vistaGeneral vGeneral, List<Empleado> listaEmpleados ){        
        ControladorAlfa cAlfa = new ControladorAlfa(vInicio, vLogin, vGeneral, BD.getEmpleados()); 
        cAlfa.iniciar();
                
    }
    
}
