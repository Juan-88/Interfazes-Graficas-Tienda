/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.interfaz_grafica_tienda;

/**
 *
 * @author Juan David
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interfaz_Grafica_Tienda extends JFrame {
    private final Tienda tienda;

    private final JTextField entryProductoNombre;
    private final JTextField entryProductoPrecio;
    private final JTextField entryProductoCategoria;
    private final JTextField entryProductoCantidad;
    private final JTextField entryClienteNombre;
    private final JTextField entryClienteApellido;
    private final JTextField entryClienteIdCliente;
    private final JTextField entryOrdenNombreProducto;
    private final JTextField entryIdOrdenCliente;
    private final JTextField entryOrdenCantidad;

    public Interfaz_Grafica_Tienda() {
        tienda = new Tienda();
        setTitle("Sistema de Gestión de una Tienda");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 2));
        getContentPane().setBackground(Color.BLUE);

        JLabel label1 = new JLabel("Registrar producto");
        label1.setForeground(Color.WHITE);
        add(label1);
        add(new JLabel(""));

        JLabel label2 = new JLabel("Nombre");
        label2.setForeground(Color.WHITE);
        add(label2);
        entryProductoNombre = new JTextField();
        add(entryProductoNombre);

        JLabel label3 = new JLabel("Precio");
        label3.setForeground(Color.WHITE);
        add(label3);
        entryProductoPrecio = new JTextField();
        add(entryProductoPrecio);

        JLabel label4 = new JLabel("Categoría");
        label4.setForeground(Color.WHITE);
        add(label4);
        entryProductoCategoria = new JTextField();
        add(entryProductoCategoria);

        JLabel label5 = new JLabel("Cantidad");
        label5.setForeground(Color.WHITE);
        add(label5);
        entryProductoCantidad = new JTextField();
        add(entryProductoCantidad);

        JButton boton1 = new JButton("Registrar Producto");
        boton1.addActionListener((ActionEvent e) -> {
            registrarProducto();
        });
        add(boton1);
        add(new JLabel(""));

        JLabel label6 = new JLabel("Registrar Cliente");
        label6.setForeground(Color.WHITE);
        add(label6);
        add(new JLabel(""));

        JLabel label7 = new JLabel("Nombre del Cliente");
        label7.setForeground(Color.WHITE);
        add(label7);
        entryClienteNombre = new JTextField();
        add(entryClienteNombre);

        JLabel label8 = new JLabel("Apellido del Cliente");
        label8.setForeground(Color.WHITE);
        add(label8);
        entryClienteApellido = new JTextField();
        add(entryClienteApellido);

        JLabel label9 = new JLabel("ID del Cliente");
        label9.setForeground(Color.WHITE);
        add(label9);
        entryClienteIdCliente = new JTextField();
        add(entryClienteIdCliente);

        JButton boton2 = new JButton("Registrar Cliente");
        boton2.addActionListener((ActionEvent e) -> {
            registrarCliente();
        });
        add(boton2);
        add(new JLabel(""));

        JLabel label10 = new JLabel("Registrar Orden");
        label10.setForeground(Color.WHITE);
        add(label10);
        add(new JLabel(""));

        JLabel label11 = new JLabel("Nombre del Producto");
        label11.setForeground(Color.WHITE);
        add(label11);
        entryOrdenNombreProducto = new JTextField();
        add(entryOrdenNombreProducto);

        JLabel label12 = new JLabel("ID del Cliente");
        label12.setForeground(Color.WHITE);
        add(label12);
        entryIdOrdenCliente = new JTextField();
        add(entryIdOrdenCliente);

        JLabel label13 = new JLabel("Cantidad de la Orden");
        label13.setForeground(Color.WHITE);
        add(label13);
        entryOrdenCantidad = new JTextField();
        add(entryOrdenCantidad);

        JButton boton3 = new JButton("Registrar Orden");
        boton3.addActionListener((ActionEvent e) -> {
            registrarOrden();
        });
        add(boton3);
        add(new JLabel(""));

        JButton boton4 = new JButton("Mostrar Producto");
        boton4.addActionListener((ActionEvent e) -> {
            mostrarProducto();
        });
        add(boton4);
        add(new JLabel(""));

        setVisible(true);
    }

    private void registrarProducto() {
        try {
            String nombre = entryProductoNombre.getText();
            double precio = Double.parseDouble(entryProductoPrecio.getText());
            String categoriaNombre = entryProductoCategoria.getText();
            int cantidad = Integer.parseInt(entryProductoCantidad.getText());
            Categoria categoria = new Categoria(categoriaNombre);
            Producto producto = new Producto(nombre, precio, categoria, cantidad);
            tienda.registrarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto registrado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos del producto.");
        }
    }

    private void registrarCliente() {
        String nombre = entryClienteNombre.getText();
        String apellido = entryClienteApellido.getText();
        String idCliente = entryClienteIdCliente.getText();
        Cliente cliente = new Cliente(nombre, apellido, idCliente);
        tienda.registrarCliente(cliente);
        JOptionPane.showMessageDialog(this, "Cliente registrado correctamente.");
    }

    private void registrarOrden() {
        try {
            String nombreProducto = entryOrdenNombreProducto.getText();
            String idCliente = entryIdOrdenCliente.getText();
            Producto producto = tienda.productos.stream().filter(p -> p.nombre.equals(nombreProducto)).findFirst().orElse(null);
            Cliente cliente = tienda.clientes.stream().filter(c -> c.idCliente.equals(idCliente)).findFirst().orElse(null);
            if (producto != null && cliente != null) {
                int cantidad = Integer.parseInt(entryOrdenCantidad.getText());
                Orden orden = new Orden(cliente);
                ItemOrden item = new ItemOrden(producto, cantidad);
                orden.agregarItem(item);
                orden.calcularTotal();
                tienda.registrarOrden(orden);
                JOptionPane.showMessageDialog(this, "Orden registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró al cliente o el producto.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos de la orden.");
        }
    }

    private void mostrarProducto() {
        String infoProductos = tienda.mostrarProductos();
        JOptionPane.showMessageDialog(this, infoProductos.isEmpty() ? "No hay productos registrados" : infoProductos);
    }

    public static void main(String[] args) {
        new Interfaz_Grafica_Tienda();
    }
}