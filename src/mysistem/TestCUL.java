/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysistem;

import model.*;
import view.*;
import controler.*;

/**
 *
 * @author Wilver
 */
public class TestCUL {

    //Funaciona con sustitucion de JFrame
    
    public static void main(String ... args){
        
        //Para la implementacion final tener en cuenta el uso de ArrayList  y arreglos para multiples objetos del mismo tipo;
        Usuario mUsuario = new Usuario(1);
        login vLogin=new login();
        vistaGeneral vGeneral= new vistaGeneral();
        ControladorUsuarioLogin cUL = new ControladorUsuarioLogin(mUsuario, vLogin, vGeneral);
        cUL.iniciar();
        
        
        
    }
    
}
