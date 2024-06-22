/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_tienda;

/**
 *
 * @author Juan David
 */
import java.util.ArrayList;

public class Tienda {
    ArrayList<Producto> productos;
    ArrayList<Cliente> clientes;
    ArrayList<Orden> ordenes;

    public Tienda() {
        productos = new ArrayList<>();
        clientes = new ArrayList<>();
        ordenes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void registrarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public String mostrarProductos() {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : productos) {
            sb.append(producto.mostrarInfo()).append("\n");
        }
        return sb.toString();
    }
}