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
        String query = "SELECT * FROM cliente";
        try (MySQLConnector sql = new MySQLConnector()){
            ResultSet datos = sql.consultaSQL(query);
            while (datos.next()) {
                System.out.println("hola");
                String dato = datos.getString(2);
                System.out.println(dato);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }
    
}
