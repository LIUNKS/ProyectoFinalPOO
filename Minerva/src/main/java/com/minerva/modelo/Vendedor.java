package com.minerva.modelo;

import java.sql.ResultSet;

/**
 *
 * @author A
 */
public class Vendedor implements Autenticacion{
    private int VendedorID;
    private String Nombres;
    private String Usuario;
    private String Contrasena;

    public Vendedor() {
    }

    public Vendedor(int VendedorID, String Nombres, String Usuario, String Contrasena) {
        this.VendedorID = VendedorID;
        this.Nombres = Nombres;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public int getVendedorID() {
        return VendedorID;
    }

    public void setVendedorID(int VendedorID) {
        if (VendedorID>=0) {
            this.VendedorID = VendedorID;
        }
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        if (Usuario!=null) {
           this.Usuario = Usuario;
        }
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        if (Contrasena!=null) {
           this.Contrasena = Contrasena;
        }
    }
    
    // VALIDA SI EL USUARIO EXISTE EN LA BASE DE DATOS
    @Override
    public boolean validarUsuarioDB(String usuario) {
        final String CONSULTA_SQL = "SELECT Usuario FROM vendedor WHERE Usuario=?";
        ResultSet resultadoConsulta;
        
        try (MySQLConnector conexionDB = new MySQLConnector()){
            resultadoConsulta = conexionDB.consultaSQLDinamica(CONSULTA_SQL, 1, usuario);
            
            while (resultadoConsulta.next()) {        
                String usuarioDB = resultadoConsulta.getString("Usuario");
                if (usuarioDB.equals(usuario)) {
                    System.out.println("El usuario existe");
                    return true; // Retorna true si el usuario existe en la base de datos
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }       
        return false; // Retorna false si el usuario no existe en la base de datos
    }
    
    // VALIDA EL USUARIO Y CONTRASEÑA
    @Override
    public boolean validarCredenciales(String usuario, String contrasena) { 
        // VALIDAMOS SI EL USUARIO EXISTE EN EL IF 
        if (validarUsuarioDB(usuario)) {
            final String CONSULTA_SQL = "SELECT Contrasena FROM vendedor WHERE Usuario=?";
            ResultSet resultadoConsulta;

            try (MySQLConnector conexionDB = new MySQLConnector()){
                
                resultadoConsulta = conexionDB.consultaSQLDinamica(CONSULTA_SQL, 1, usuario);
                
                while (resultadoConsulta.next()) {        
                    String contrasenaDB = resultadoConsulta.getString("Contrasena");
                    
                    if (contrasenaDB.equals(contrasena)) {
                        System.out.println("Credenciales validas");
                        return true;  // Retorna true si las credenciales son validas
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
            }
        }        
        return false; // Retorna false si las credenciales son invalidas
    }
    
    
    
}
