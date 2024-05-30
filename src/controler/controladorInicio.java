/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.Usuario;
import view.centroAdministracion;
import view.centroAlmacen;
import view.centroCajero;
import view.lateralAdministracion;
import view.lateralAlmacen;
import view.lateralCajero;
import view.login;
import view.vistaGeneral;
import view.vistaInicial;

/**
 *
 * @author Wilver
 */
//UNICO FUNCIONAL 100%  

public class controladorInicio  implements ActionListener  {
    
    private login vLogin;
    private Usuario mUsuario;
    private vistaGeneral vGeneral;
    private vistaInicial vInicio;
    private JPanel pL, pG; 
    
    
    //Constructor principal
    public controladorInicio (vistaInicial vInicio, login vLogin, Usuario mUsuario, vistaGeneral vGeneral){    
    this.vLogin = vLogin;
    this.mUsuario = mUsuario;
    this.vGeneral = vGeneral;
    this.vInicio= vInicio;        
    //Damos Forma a los paneles
    this.pL = vLogin.getPanelVistaLogin();
    this.pG = vGeneral.getPanelVistaGeneral();
    
    //Agrgamos el evento al boton.
    this.vLogin.getBtnEntrar().addActionListener(this);
    }
    
       
    public void iniciar(){       
        vInicio.setTitle("INICIAR SESION");
        vInicio.setSize(this.vGeneral.getSize());
        vInicio.add(pL);
        vInicio.revalidate();
        vInicio.repaint();
        vInicio.setLocationRelativeTo(null);
        vInicio.setVisible(true);
    }
    
    
    public void definirVista(){
        int nivel = mUsuario.getNivel();
        switch (nivel){
            case 1 -> { //Vista de usuario nivel 1 = CAJERO
                vGeneral.getPanelCentral().add(new centroCajero().getPanelCentroCajero());
                vGeneral.getPanelLateral().add(new lateralCajero().getPanelLateralCajero());
                vGeneral.activarNivelUsuario(nivel);
                
            }
            case 2 -> { //Vista de usuario nivel 2 = ALMACEN
                vGeneral.getPanelCentral().add(new centroAlmacen().getPanelCentroAlmacen());
                vGeneral.getPanelLateral().add(new lateralAlmacen().getPanelLateralAlmacen());
                vGeneral.activarNivelUsuario(nivel);
                
            }
            case 3 -> {//Vista de usuario nivel 3 = ADMINISTRACION
                vGeneral.getPanelCentral().add( new centroAdministracion().getPanelCentroAsministracion());
                vGeneral.getPanelLateral().add(new lateralAdministracion().getPanelLateralAdministracion());
                vGeneral.activarNivelUsuario(nivel);
                
            }
            case 10 -> { //Vista de usuario nivel 10 = SUPER ADMIN
                
                //this.vGeneral.getBotonCambiarVista().setVisible(true);
                //this.vGeneral.getBotonCambiarVista().setEnabled(true);
                this.vGeneral.getPanelCentral().setVisible(false);
                this.vGeneral.getPanelLateral().setVisible(false);
                vGeneral.activarNivelUsuario(nivel);
                
            }
            default -> System.out.println("Error fatal en el nivel de usuario, revisarlo desde el construtor o en la base de datos");        
        }                
    }
    
    public void verificarUsuario(String usuario, String contraseña){
        int n = mUsuario.getNivel();
        if(mUsuario.validarUsuario(usuario, contraseña)){            
            vLogin.mostrarMensaje("Bienvenido usuario de nivel: " + n );//Si es verdadero se permite el acceso            
            //Sustitucion de vista
            this.vInicio.remove(pL);            
            this.vInicio.setTitle("My Store General");
            this.vInicio.add(pG);            
            this.vInicio.revalidate();
            this.vInicio.repaint();                                   
        } else {
            vLogin.mostrarMensaje("Error en las credenciales"); // Si es falso entonces se muestra el mensaje
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        this.definirVista();        
        this.verificarUsuario(vLogin.getUsuario(), vLogin.getContraseña()); 
    }
    
}
