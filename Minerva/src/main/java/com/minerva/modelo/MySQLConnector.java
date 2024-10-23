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
public class MySQLConnector implements AutoCloseable{
    private Connection conexion = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "#";
    private static final String BD = "Apolo";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";
    
    private static final String URL = "jdbc:mysql://" + IP +":" + PUERTO + "/ " + BD;
    
    // VARIABLES PARA LAS QUERY
    private PreparedStatement preparedStatement  = null;
    private Statement statement  = null;
    
    // VARIABLE PARA GUARDAR EL RESULTADO DE LA BASE DE DATOS
    private ResultSet resultSet  = null; 
    
    public MySQLConnector() {
        
    }
    
    // METODO PARA HACER CONSULTAS SQL SIMPLES 
    public ResultSet consultaSQL(String query) {
        establecerConexion();

        try {
            statement = conexion.createStatement();        
            resultSet = statement.executeQuery(query);

            return resultSet; 
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        } 
        return null; // Retorna null si hay un error

    }
    
    // METODO PARA HACER CONSULTAS SQL DINAMICAS 
    public ResultSet consultaSQLDinamica(String query, int numParametros, Object parametro) {
        establecerConexion();

        try {
            preparedStatement = conexion.prepareStatement(query);

            // Determinar el tipo de parámetro y establecerlo en el PreparedStatement
            if (parametro instanceof Integer) {
                preparedStatement.setInt(numParametros, (Integer) parametro);
            } else if (parametro instanceof String) {
                preparedStatement.setString(numParametros, (String) parametro);
            } else {
                throw new IllegalArgumentException("Tipo de parámetro no soportado");
            }

            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }

        return null; // Retorna null si hay un error
    }
 
    private void establecerConexion() {
        try {
            // SE CARGA EL DRIVER 
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " ESTABLECIDA");
        } catch (SQLException e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " RECHAZADA");
            System.out.println("ERROR: " + e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.toString());
        }
    }
    
    private void cerrarConexion() {
        try {
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

    @Override
    public void close() {       
        cerrarRecursos();
        cerrarConexion();       
    }
    
    private void cerrarRecursos() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (statement != null) {
                resultSet.close();
            }
            System.out.println("RECURSOS CERRADOS");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

}
