package com.minerva.controlador;

import com.minerva.modelo.Vendedor;

/**
 *
 * @author L
 */
public class ControladorLogin {
    private String usuario;
    private String contraseña;
    private Vendedor vendedor = new Vendedor();

    public ControladorLogin() {
        
    }
    
    public boolean validarCredenciales(String usuario, String contrasena) {
        boolean credenciales = vendedor.validarCredenciales(usuario, contrasena);
        if (credenciales) {
            return true; // SI LA CONTRASEÑA ES VALIDA DEVUELVE TRUE
        }
        return false; // SI LA CONTRASEÑA NO ES VALIDA DEVUELVE FALSE
    }
    
    
}
