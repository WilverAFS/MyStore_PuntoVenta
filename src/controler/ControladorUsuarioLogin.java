/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import view.login;
import view.vistaGeneral;

/**
 *
 * @author Wilver
 */
//FUNCIONALIDAD AL 70% SUSTITUIBLE

public class ControladorUsuarioLogin implements ActionListener {
    private login vLogin;
    private Usuario mUsuario;
    private vistaGeneral vGeneral;
    
    //Constructor
    public ControladorUsuarioLogin(Usuario mUsuario, login vLogin, vistaGeneral vGeneral){
    this.vLogin = vLogin;
    this.mUsuario = mUsuario;
    this.vGeneral = vGeneral;
    this.vLogin.getBtnEntrar().addActionListener(this);    
    }
    
    public void iniciar(){
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e){         
        this.verificarUsuario(vLogin.getUsuario(), vLogin.getContraseña());
    }
    
   
    //Metodo para verificar las credenciales dadas y cambiar las vistas
    public void verificarUsuario(String usuario, String contraseña){
        if(mUsuario.validarUsuario(usuario, contraseña)){
            vLogin.mostrarMensaje("Bienvenido usuario de nivel" + mUsuario.getNivel());//Si es verdadero se permite el acceso 
            vGeneral.setVisible(true);//Mostrar la nueva vista
            vLogin.setVisible(false); //Ocultar la anterior vista
        } else {
            vLogin.mostrarMensaje("Error en las credenciales"); // Si es falso entonces se muestra el mensaje
        }    
    }
    
    
    
}
