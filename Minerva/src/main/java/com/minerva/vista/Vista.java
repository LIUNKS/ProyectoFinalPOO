package com.minerva.vista;

import com.minerva.controlador.ControladorLogin;

/**
 *
 * @author L
 */
public class Vista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // EJEMPLO DE USO 
        ControladorLogin login = new ControladorLogin();
        
        boolean a = login.validarCredenciales("admin", "1234");
        
        System.out.println("");
        System.out.println("ESTA ES EL AREA DE LA VISTA");
        if (a) {
            System.out.println("CREDENCIALES VALIDAS");
        } else {
            System.out.println("CREDENCIALES NO VALIDAS");
        }
    }
      
}
