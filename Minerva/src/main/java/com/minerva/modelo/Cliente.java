package com.minerva.modelo;

/**
 *
 * @author L
 */
public class Cliente {
    private int clienteID;
    private String nombres;
    private int edad;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int clienteID, String nombres, int edad, String telefono, String direccion) {
        this.clienteID = clienteID;
        this.nombres = nombres;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public int getclienteID() {
        return clienteID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     
}
