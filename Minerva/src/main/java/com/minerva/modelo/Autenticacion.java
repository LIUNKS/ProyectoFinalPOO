/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minerva.modelo;

/**
 *
 * @author L
 */
public interface Autenticacion {
    public boolean validarUsuarioDB(String usuario);
    public boolean validarCredenciales(String usuario, String contrasena);
}
