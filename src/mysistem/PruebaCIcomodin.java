/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysistem;

import controler.controladorInicio;
import model.Empleado;
import model.Usuario;
import view.login;
import view.vistaGeneral;
import view.vistaInicial;

/**
 *
 * @author Wilver
 */
public class PruebaCIcomodin {
    
    
    public static void main(String ... args){
        
        //Usuario mUsuario = new Usuario(1); //Nivel 1 para cajero
        Empleado mEmpleado = new Empleado(10);        
        Usuario mUsuario = mEmpleado;
        login vLogin=new login();
        vistaGeneral vGeneral= new vistaGeneral();
        vistaInicial vInicio = new vistaInicial();
        
        //Verficar el envio del usuario
        controladorInicio cInicio = new controladorInicio(vInicio, vLogin, mUsuario, vGeneral );
        cInicio.iniciar();
                
    }
    
    
}
