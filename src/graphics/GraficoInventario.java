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
public class GraficoInventario extends JFrame{
    
    
    //CONSTRUCTO
    public GraficoInventario() {
        super("GRAFICO DE INVENTARIO POR CATEGORIA");        
        DefaultCategoryDataset dataset = createDataset();
        
        // Aqui se va a crear el grafico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                "Existencia de Productos por Categoría",
                "Categoría",
                "Existencia",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Crea el panei para el grafico
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
        
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Aqui se conceta a la database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystore", "root", "WAFS%25");
            Statement stmt = con.createStatement();

            // Consulta SQL para obtener la existencia por categoría
            String query = "SELECT categoria_p AS categoria, SUM(existencia_p) AS existencia "
                    + "FROM producto "
                    + "GROUP BY categoria_p";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int categoria = rs.getInt("categoria");
                int existencia = rs.getInt("existencia");
                String nombreCategoria = getNombreCategoria(categoria);
                dataset.addValue(existencia, "Existencia", nombreCategoria);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

private String getNombreCategoria(int categoria) {
        return switch (categoria) {
            case 1 -> "Telefonía";
            case 2 -> "Computo";
            case 3 -> "Tablets";
            case 4 -> "Accesorios";
            case 5 -> "Otros";
            default -> "Categoría Desconocida";
        };
}
    
//Prueba
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficoInventario example = new GraficoInventario();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    
}
