/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_tienda;

/**
 *
 * @author Juan David
 */
public class ItemOrden {
    Producto producto;
    int cantidad;
    double subtotal;

    public ItemOrden(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.precio * cantidad;
    }

    public double calcularSubtotal() {
        return producto.precio * cantidad;
    }
}
