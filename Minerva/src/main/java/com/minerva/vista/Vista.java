package com.minerva.vista;

import com.minerva.controlador.ControladorLogin;
import com.minerva.modelo.Producto;
import com.minerva.modelo.Vendedor;

/**
 *
 * @author L
 */
public class Vista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
