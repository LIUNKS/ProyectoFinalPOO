package com.minerva.modelo;

import java.sql.ResultSet;

/**
 *
 * @author L
 */
public class Producto {
    private int productoID;
    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private int codigoBarras;
    
    private String ubicacionAlmacen;
    
    public Producto() {     
        consultarProductos();
    }
    
    // EJEMPLO PARA CONSULTAS 
    public void consultarProductos() {
        String consultaSQL = "SELECT * FROM producto";
        try (MySQLConnector conexionBD = new MySQLConnector()){
            ResultSet resultadoConsulta = conexionBD.consultaSQL(consultaSQL);
            while (resultadoConsulta.next()) {                
                String nombreProducto = resultadoConsulta.getString(2);
                System.out.println(nombreProducto);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }
      
}
