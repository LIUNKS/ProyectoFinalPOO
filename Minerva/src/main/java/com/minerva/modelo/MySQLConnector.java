package com.minerva.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author L
 */
public class MySQLConnector {
    private Connection conectar = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "#";
    private static final String BD = "Apolo";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";
    
    private static final String URL = "jdbc:mysql://" + IP +":" + PUERTO + "/ " + BD;

    public MySQLConnector() {
    }
 
    public Connection establecerConexion() {
        try {
            Class.forName(DRIVER);
            conectar = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " ESTABLECIDA");
        } catch (Exception e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " FUERA DE LINEA");
            System.out.println("ERROR: " + e.toString());
        }
        
        return conectar;
    }
    
    public Connection cerrarConexion() {
        try {
            // SI CONECTAR ES DIFERENTE DE NULO Y DIFERENTE DE ABIERTO SE CIERRA LA CONEXION
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " CERRADA");
            }
        } catch (Exception e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " NO PUDO SER CERRADA");
            System.out.println("ERROR: " +  e.toString());
        }
        
        return conectar;
    }
}
