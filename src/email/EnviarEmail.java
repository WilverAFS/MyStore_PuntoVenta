/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;


import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;





/**
 *
 * @author Wilver
 */
public class EnviarEmail {
    
    public void enviarCorreo(String correoElectronico, String direccionArchivo){    //ENVIAR UN PDF POR CORREO
        //  cuenta de correo o ip de servidor que usar/ en este caso BREVO
        String username = "75952e001@smtp-brevo.com"; // NO MODIFICAR
        String password = "mDNMhH6jAqdTICLv"; //NO MODIFICAR

        // Configuración del servidor SMTP de Brevo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-relay.brevo.com");
        props.put("mail.smtp.port", "587");

        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            
            File archivo = new File(direccionArchivo);
            if (!archivo.exists() || !archivo.isFile()) {
                System.out.println("El archivo no existe o no es un archivo válido.");
                return;
            }
            
            
            // Aqui se crea un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoElectronico)); //Correo del cliente
            message.setSubject("TICKET DIGITAL");
            
            // Aqui crearemos el cuerpo del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Tu ticket digital MY STORE esta aqui!  \n ESTIMADO CLIENTE \n Gracias por usar el servicio de TicketDigital de MY STORE. A continuacion, se presenta el comprobante de su compra.");
            
            //Agregar adjunto a enviar un pdf
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(direccionArchivo);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("Ticket.pdf");

            // Combinar el mensaje y el adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);
            // Enviar el mensaje
            Transport.send(message);            
            // Mensaje de confimacion que se ha enviado.
            System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }        
    }
    
    
    //CREAR METODO QUE RECIBA LA RUTA DEL ARCHIVO, CORREO DE DESTINO
    
    
     public static void main(String[] args) { //ENVIAR UN PDF POR CORREO
        //  cuenta de correo o ip de servidor que usar/ en este caso BREVO
        //75952e001@smtp-brevo.com
        String username = "75952e001@smtp-brevo.com"; //no modificar //
        String password = "mDNMhH6jAqdTICLv"; //no modificar //

        // Configuración del servidor SMTP de Brevo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-relay.brevo.com");
        props.put("mail.smtp.port", "587");

        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Aqui se crea un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wilverflores2004@gmail.com")); //Correo del cliente
            message.setSubject("TICKET DIGITAL");
//correo de prueba
//"//mystoretap@gmail.com"
//
            
            // Aqui crearemos el cuerpo del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Tu ticket digital MY STORE esta aqui!  \n ESTIMADO CLIENTE \n Gracias por usar el servicio de TicketDigital de MY STORE. A continuacion, se presenta el comprobante de su compra.");
            //messageBodyPart.setText("ESTIMADO CLIENTE");
            //messageBodyPart.setText("Gracias por usar el servicio de TicketDigital de MY STORE. A continuacion, se presenta el comprobante de su compra.");
            

            // en caso de enviar un pdf
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            
            //UBICACION DEL ARCHIVO PDF
            //C:\Users\Wilver\OneDrive\Documentos\NetBeansProjects\MySistem_PV
            String filePath = "C:\\Users\\Wilver\\OneDrive\\Documentos\\NetBeansProjects\\MySistem_PV\\ticket1.pdf";
            DataSource source = new FileDataSource(filePath);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("archivo.pdf");

            // Combinar el mensaje y el adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);
            
            // Mensaje de confimacion que se ha enviado.
            System.out.println("Correo enviado correctamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
}
