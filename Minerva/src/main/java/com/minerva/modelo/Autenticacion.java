package com.minerva.modelo;

/**
 *
 * @author L
 */
public interface Autenticacion {
    public boolean validarUsuarioDB(String usuario);
    public boolean validarCredenciales(String usuario, String contrasena);
}
