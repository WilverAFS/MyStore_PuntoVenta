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
 *OK ESTABLECE SU PROPIA CONEXION
 * @author Wilver
 */
public class GraficoMasVendido  extends JFrame{
    
         //CONSTRUCTO
    public GraficoMasVendido() {
        super("PRODUCTOS MAS VENDIDOS");         
        DefaultCategoryDataset dataset = createDataset();
        // Aqui va a crear el grafico
        JFreeChart chart = ChartFactory.createBarChart(
                "Producto más vendido",
                "Producto",
                "Cantidad Vendida",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Aqui crea el panel para el grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);                
        createDataset();                
    }

    
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Aqui se conecta a la database
            
            //MODIFICAR LAS CREDENCIALES
            //ENVIAR LA CONECIOXION CON CONTROLADORBD
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystore", "root", "WAFS%25");
            Statement stmt = con.createStatement();

            // Consulta SQL 
            String query = "SELECT p.nombre_p AS producto_nombre, SUM(dv.cantidad) AS cantidad_vendida " +
                           "FROM descripcion_venta dv " +
                           "JOIN producto p ON dv.codigo_producto = p.codigo_producto " +
                           "GROUP BY p.nombre_p " +
                           "ORDER BY cantidad_vendida DESC";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String productoNombre = rs.getString("producto_nombre");
                int cantidadVendida = rs.getInt("cantidad_vendida");
                dataset.addValue(cantidadVendida, "Productos", productoNombre);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            //Aqui mostrar error en la conexion
        }
        return dataset;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraficoMasVendido example = new GraficoMasVendido();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    
    
}
