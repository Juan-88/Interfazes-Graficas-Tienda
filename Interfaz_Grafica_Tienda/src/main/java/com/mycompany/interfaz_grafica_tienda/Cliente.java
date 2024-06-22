/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_tienda;

/**
 *
 * @author Juan David
 */
public class Cliente {
    String nombre;
    String apellido;
    String idCliente;

    public Cliente(String nombre, String apellido, String idCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = idCliente;
    }

    public String mostrarInfo() {
        return "Cliente: " + nombre + " " + apellido + " " + idCliente;
    }
}
