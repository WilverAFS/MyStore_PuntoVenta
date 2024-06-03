/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Wilver
 */
public class GraficoMenosVendido extends JFrame {
    
    
    public GraficoMenosVendido() {            
        super("PRODUCTOS MENOS VENDIDOS");        
        DefaultCategoryDataset dataset = createDataset();
        // Aqui va a crear la grafica
        JFreeChart chart = ChartFactory.createBarChart(
                "Producto menos vendido",
                "Producto",
                "Cantidad Vendida",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        // Aqui crea el panel para la grafica
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }    

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Aqui hace la coneccion a la database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystore", "root", "WAFS%25");
            Statement stmt = con.createStatement();

            // Consulta SQL  para obtener el producto menos vendido
            String query = "SELECT p.nombre_p AS producto_nombre, SUM(dv.cantidad) AS cantidad_vendida " +
                           "FROM descripcion_venta dv " +
                           "JOIN producto p ON dv.codigo_producto = p.codigo_producto " +
                           "GROUP BY p.nombre_p " +
                           "ORDER BY cantidad_vendida ASC " + // Ordenar de forma ascendente
                           "LIMIT 1"; // Limitar los resultados a 1

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String productoNombre = rs.getString("producto_nombre");
                int cantidadVendida = rs.getInt("cantidad_vendida");
                dataset.addValue(cantidadVendida, "Productos", productoNombre);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
    
    
    
    //Prueba
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficoMenosVendido example = new GraficoMenosVendido();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    
    
}
