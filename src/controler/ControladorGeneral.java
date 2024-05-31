/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import database.BaseDeDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import model.Empleado;
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

public class ControladorGeneral  implements ActionListener  {
    
    private login vLogin;
    private vistaGeneral vGeneral;
    private vistaInicial vInicio;
    private JPanel pL, pG;     
    
    private BaseDeDatos BD;
    private List<Empleado> listaEmpleados;
    
    
    //Contructor especializado que comprueba el inicio de sesion DELET
    public ControladorGeneral(vistaInicial vInicio, login vLogin, vistaGeneral vGeneral, List<Empleado> listaEmpleados ){
        this.vInicio= vInicio;    
        this.vLogin = vLogin;
        this.vGeneral = vGeneral;
        this.listaEmpleados = listaEmpleados;         
         //Damos Forma a los paneles para ser sustituidos en Inicio
        this.pL = vLogin.getPanelVistaLogin();
        //this.pG = vGeneral.getPanelVistaGeneral();
        //Agrgamos el evento al boton.
        this.vLogin.getBtnEntrar().addActionListener(this);
    }    
    
    
    //CONTRUCTOR MAESTRO SIN REQUISITOS 
    public ControladorGeneral(){
        //Inicializa sus propias vistas
        this.vInicio= new vistaInicial();    
        this.vLogin = new login();        
        this.vGeneral = new vistaGeneral();
        //Datos de la BD
        BD = new BaseDeDatos();
        listaEmpleados = BD.getEmpleados();        
         //Damos Forma a los paneles para ser sustituidos en Inicio
        this.pL = vLogin.getPanelVistaLogin();
        //Agrgamos el evento al boton.
        this.vLogin.getBtnEntrar().addActionListener(this);
    }    
    
    
       
    public void iniciar(){       
        //Hace visible los paneles de login  en el Inicio
        vInicio.setTitle("INICIAR SESION");
        vInicio.setSize(this.vGeneral.getSize());
        vInicio.add(pL);
        vInicio.revalidate();
        vInicio.repaint();
        vInicio.setLocationRelativeTo(null);
        vInicio.setVisible(true);
    }    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento del boton ENTRAR al iniciar sesion
        //Hacer un check por si estan vacios
        this.verificarUsuario(vLogin.getUsuario(), vLogin.getContraseña()); 
    }
    
    //revisar
    public void verificarUsuario(String usuario, String contraseña){
        boolean existe = false;        
        int nivel=0;
        //Verifica las credenciales dadas y muestra las vistas correspondientes si existe
        for( Empleado empleado: listaEmpleados ){ //Recorremos la lista de empleado
            if(empleado.validarUsuario(usuario, contraseña)  ){ 
                //Si es true econtramos al empleado y definimos el nivel de vista segun esta coincidencia
                existe = true;
                nivel = empleado.getNivel();
                break; //Salimos del bucle al encontrarlo ahorrando recursos
            }
        }        
        if(existe){ //Si ecxiste inicializamos todo
                this.iniciarVista(nivel);
        } else {
            vLogin.mostrarMensaje("ERROR  en las credenciales");
        }        
    }
    
    public void iniciarVista(int nivel){
        vLogin.mostrarMensaje("Bienvenido usuario de nivel: " + nivel );
        //vGeneral = new vistaGeneral(nivel);        
        vGeneral.activarVistaUsuario(nivel);
        pG = vGeneral.getPanelVistaGeneral();        
        
        //---vGeneral.activarVistaUsuario(nivel);
        //Sustitucion de vista        
        this.vInicio.remove(pL);
        this.vInicio.setTitle("My Store General");
        this.vInicio.add(pG);
        this.vInicio.revalidate();
        this.vInicio.repaint();
        //ejercutar el metodo para activarVista
    }    
    
}
