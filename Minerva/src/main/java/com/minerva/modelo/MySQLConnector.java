package com.minerva.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author L
 */
public class MySQLConnector {
    private Connection conexion = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "#";
    private static final String BD = "Apolo";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";
    
    private static final String URL = "jdbc:mysql://" + IP +":" + PUERTO + "/ " + BD;

    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    
    private ResultSet resultSet = null; 
    
    public MySQLConnector() {
    }
 
    private void establecerConexion() {
        try {
            // SE CARGA EL DRIVER 
            Class.forName(DRIVER);
            // SE ESTABLECE LA CONEXION
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);  
            
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " ESTABLECIDA");
        } catch (SQLException e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " RECHAZADA");
            System.out.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }
    
    private void cerrarConexion() {
        try {
            // SI CONECTAR ES DIFERENTE DE NULO Y DIFERENTE DE ABIERTO SE CIERRA LA CONEXION
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " CERRADA");
            } else {
                System.out.println("LA CONEXION CON LA BASE DE DATOS " + BD + " YA ESTABA CERRADA");
            }
        } catch (SQLException e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " NO PUDO SER CERRADA");
            System.out.println("ERROR: " + e.toString());
        }       
    }
    
    public ResultSet consultaSQL(String query) {
        establecerConexion();

        try {
            statement = conexion.createStatement();        
            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        } finally {
            cerrarConexion();
        }
        
        return resultSet;
    }
    
    // PARA EVITAR INYECCIONES O CONSULTAS DINAMICAS SQL PERO NO SE SI
    // DEBERIA IMPLEMENTARLO PARA ESTE PROYECTO XD
    // LO DEJO AQUI POR LAS DUDAS
    public ResultSet consultaSQLDinamicaString(String query, int numParametros, int parametro) {
        establecerConexion();
        
        try {
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(numParametros, parametro);
            resultSet = preparedStatement.executeQuery();

            cerrarConexion();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        } finally {
            cerrarConexion();
        }
        
        return resultSet;
    }
    
    public ResultSet consultaSQLDinamicaInt(String query, int numParametros, String parametro) {
        establecerConexion();
        
        try {
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(numParametros, parametro);
            resultSet = preparedStatement.executeQuery();

            cerrarConexion();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        } finally {
            cerrarConexion();
        }
        
        return resultSet;
    } 
}
