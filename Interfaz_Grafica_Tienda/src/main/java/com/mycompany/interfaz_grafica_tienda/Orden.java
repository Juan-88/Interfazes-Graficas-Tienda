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

public class Orden {
    Cliente cliente;
    ArrayList<ItemOrden> items;
    double total;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarItem(ItemOrden item) {
        items.add(item);
    }

    public double calcularTotal() {
        total = items.stream().mapToDouble(item -> item.subtotal).sum();
        return total;
    }
}