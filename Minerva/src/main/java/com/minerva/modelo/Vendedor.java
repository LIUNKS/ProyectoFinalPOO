package com.minerva.modelo;

/**
 *
 * @author A
 */
public class Vendedor {
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
    
}
