/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_tienda;

/**
 *
 * @author Juan David
 */
public class Producto {
    String nombre;
    double precio;
    Categoria categoria;
    int cantidad;

    public Producto(String nombre, double precio, Categoria categoria, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public String mostrarInfo() {
        return "Producto: " + nombre + " " + precio + " " + categoria.mostrarInfo() + " " + cantidad;
    }
}
