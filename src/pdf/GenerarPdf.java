/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JPanel;
import javax.swing.JTable;


/**
 *
 * @author Wilver
 */
public class GenerarPdf {
    
    public void generatePdfFromPanel(JPanel panel, String filePath) throws DocumentException {
        // Desactivar el scroll de la tabla temporalmente
        JTable table = null;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            if (panel.getComponent(i) instanceof JTable) {
                table = (JTable) panel.getComponent(i);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Desactivar el ajuste automático del ancho de las columnas
                break;
            }
        }

        // Ajustar el tamaño del panel para mostrar todos los datos
        if (table != null) {
            int numberOfRows = table.getRowCount();
            int rowHeight = table.getRowHeight();
            int additionalHeight = numberOfRows * rowHeight;
            panel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight() + additionalHeight));
            panel.revalidate();
            panel.repaint();
        }

        Document document = new Document(new com.itextpdf.text.Rectangle(panel.getWidth(), panel.getHeight()));
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            com.itextpdf.text.pdf.PdfContentByte cb = writer.getDirectContent();
            Graphics2D g2 = cb.createGraphics(panel.getWidth(), panel.getHeight());

            // Create a shape to clip the panel
            Shape oldClip = g2.getClip();
            g2.clip(new Rectangle2D.Double(0, 0, panel.getWidth(), panel.getHeight()));

            // Print the panel to the graphics context
            panel.printAll(g2);

            // Restore the old clipping
            g2.setClip(oldClip);
            g2.dispose();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
            // Restaurar el scroll de la tabla después de imprimir
            if (table != null) {
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // Restaurar el ajuste automático del ancho de las columnas
            }
        }
    }
        
        
    }