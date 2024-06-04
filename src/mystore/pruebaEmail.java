/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mystore;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Wilver
 */
public class pruebaEmail {
    
    private void crearCartaE(String username, String password, Session session){
        
        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wilverafs@outlook.com")); // Correo del cliente
            message.setSubject("TICKET DIGITAL");

            // Crear el cuerpo del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Tu ticket digital MY STORE está aquí!  \n ESTIMADO CLIENTE \n Gracias por usar el servicio de TicketDigital de MY STORE. A continuación, se presenta el comprobante de su compra.");

            // Adjuntar archivo
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            String filePath = "C:\\Users\\Wilver\\OneDrive\\Documentos\\NetBeansProjects\\MySistem_PV\\CorteCaja.pdf";
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

            // Mensaje de confirmación de que se ha enviado
            System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    
    }
    
        //Purebas
     public static void main(String[] args) { 
         
       // Configuración del servidor SMTP de Brevo
        String username = "75952e001@smtp-brevo.com";
        String password = "mDNMhH6jAqdTICLv";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-relay.brevo.com");
        props.put("mail.smtp.port", "587");
        
        // Habilitar la depuración para ver los detalles del envío del correo
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


       pruebaEmail pe= new pruebaEmail();
       pe.crearCartaE(username, password, session);
        
    }
    
    
    
    
}
