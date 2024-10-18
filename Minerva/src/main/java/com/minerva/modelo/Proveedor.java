package com.minerva.modelo;

/**
 *
 * @author L
 */
public class Proveedor {
    private int proveedorID;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public Proveedor() {
    }

    public Proveedor(int proveedorID, String nombre, String direccion, String telefono, String correo) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        if (proveedorID >= 0) {
            this.proveedorID = proveedorID;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
