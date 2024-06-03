/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.itextpdf.text.DocumentException;
import view.flcTicket;
/**

/**
 *
 * @author Wilver
 */
public class prueba_main {
    
    
    public static void main(String[] args) {
        // Ejemplo de uso
        flcTicket dialog = new flcTicket();
        //dialog.valoresPrueba();
        dialog.setVisible(true);
        

        // Generar el PDF
        GenerarPdf pdfGenerator = new GenerarPdf();
        
        try {
            pdfGenerator.generatePdfFromPanel(dialog.getPanelTicket(), "ticket1.pdf");
        } catch (DocumentException e) {
            e.printStackTrace();
            
            System.out.println(e);
        }
        
        
    }
    
    
    
}
