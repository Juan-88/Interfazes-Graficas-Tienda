import tkinter as tk
from tkinter import messagebox

class Cliente:
    def __init__(self, nombre, apellido, id_cliente):
        self.nombre = nombre
        self.apellido = apellido
        self.id_cliente = id_cliente

    def mostrar_info(self):
        return f"Cliente: {self.nombre} {self.apellido} {self.id_cliente}"
    
class Producto:
    def __init__(self, nombre, precio, categoria, cantidad):
        self.nombre = nombre
        self.precio = precio
        self.categoria = categoria
        self.cantidad = cantidad

    def mostrar_info(self):
        return f"Producto: {self.nombre} {self.precio} {self.categoria.mostrar_info()} {self.cantidad}"

class Categoria:
    def __init__(self, nombre):
        self.nombre = nombre

    def mostrar_info(self):
        return f"Categoria: {self.nombre}"        
    
class Itemorden:
    def __init__(self, producto, cantidad, subtotal):
        self.producto = producto
        self.cantidad = cantidad
        self.subtotal = subtotal

    def calcular_subtotal(self):
        self.subtotal = self.producto.precio * self.cantidad

class Orden:
    def __init__(self, cliente):
        self.cliente = cliente
        self.items = []
        self.total = 0.0

    def agregar_item(self, item):
        self.items.append(item)

    def calcular_total(self):
        self.total = sum(item.subtotal for item in self.items)

class Tienda:
    def __init__(self):
        self.productos = []
        self.clientes = []
        self.ordenes = []

    def registrar_cliente(self, cliente):
        self.clientes.append(cliente)

    def registrar_producto(self, producto):
        self.productos.append(producto)

    def registrar_orden(self, orden):
        self.ordenes.append(orden)

    def mostrar_productos(self):
        return '\n'.join([producto.mostrar_info() for producto in self.productos])
        
def registrar_producto():
    producto = Producto(entry_producto_nombre.get(), float(entry_producto_precio.get()), entry_producto_categoria.get(), int(entry_producto_cantidad.get()))
    tienda.registrar_producto(producto)

def registrar_cliente():
    cliente = Cliente(entry_cliente_nombre.get(), entry_cliente_apellido.get(), entry_cliente_id_cliente.get())
    tienda.registrar_cliente(cliente)

def registrar_orden():
    try:
        producto = next((producto for producto in tienda.productos if producto.nombre == entry_orden_nombre_producto.get()), None)
        cliente = next((cliente for cliente in tienda.clientes if cliente.id_cliente == entry_id_orden_cliente.get()), None)
        if producto and cliente:
            cantidad = int(entry_orden_cantidad.get())
            orden = Orden(cliente)
            item = Itemorden(producto, cantidad, producto.precio * cantidad)
            item.calcular_subtotal()
            orden.agregar_item(item)
            tienda.registrar_orden(orden)
            orden.calcular_total() 
            messagebox.showinfo("Éxito", "La orden se ha registrado con éxito")
        else:
            messagebox.showerror("Error", "No se encontró al cliente o el producto")
    except StopIteration:
        messagebox.showerror("Error", "No se pudo realizar la orden")

def mostrar_producto():
    info_productos = tienda.mostrar_productos()
    messagebox.showinfo("Productos en Tienda", info_productos if info_productos else "No hay productos registrados")


ventana = tk.Tk()
ventana.title("Sistema de Gestión de una Tienda")
ventana.configure(bg="blue")

tienda = Tienda()

tk.Label(ventana, text= "Registrar producto", bg="blue").grid(row=0, column=0, columnspan=2)

tk.Label(ventana, text= "Nombre", bg="blue").grid(row=1, column=0)
entry_producto_nombre = tk.Entry(ventana)
entry_producto_nombre.grid(row=1, column=1)

tk.Label(ventana, text="Precio", bg="blue").grid(row=2, column=0)
entry_producto_precio = tk.Entry(ventana)
entry_producto_precio.grid(row=2, column=1)

tk.Label(ventana, text="Categoría", bg="blue").grid(row=3, column=0)
entry_producto_categoria = tk.Entry(ventana)
entry_producto_categoria.grid(row=3, column=1)

tk.Label(ventana, text="Cantidad", bg="blue").grid(row=4, column=0)
entry_producto_cantidad = tk.Entry(ventana)
entry_producto_cantidad.grid(row=4, column=1)

boton1 = tk.Button(ventana, text="Registrar Producto", command=registrar_producto)
boton1.grid(row=5, column=0, columnspan=2)

tk.Label(ventana, text="Registrar Cliente", bg="blue").grid(row=6, column=0, columnspan=2)

tk.Label(ventana, text="Nombre del Cliente", bg="blue").grid(row=7, column=0)
entry_cliente_nombre = tk.Entry(ventana)
entry_cliente_nombre.grid(row=7, column=1)

tk.Label(ventana, text="Apellido del Cliente", bg="blue").grid(row=8, column=0)
entry_cliente_apellido = tk.Entry(ventana)
entry_cliente_apellido.grid(row=8, column=1)

tk.Label(ventana, text="ID del Cliente", bg="blue").grid(row=9, column=0)
entry_cliente_id_cliente = tk.Entry(ventana)
entry_cliente_id_cliente.grid(row=9, column=1)

boton2 = tk.Button(ventana, text="Registrar Cliente", command=registrar_cliente)
boton2.grid(row=10, column=0, columnspan=2)

tk.Label(ventana, text="Registrar Orden", bg="blue").grid(row=11, column=0, columnspan=2)

tk.Label(ventana, text="Nombre del Producto",bg="blue").grid(row=12, column=0)
entry_orden_nombre_producto = tk.Entry(ventana)
entry_orden_nombre_producto.grid(row=12, column=1)

tk.Label(ventana, text="ID del cliente", bg="blue").grid(row=13, column=0)
entry_id_orden_cliente = tk.Entry(ventana)
entry_id_orden_cliente.grid(row=13, column=1)

tk.Label(ventana, text="Cantidad de la Orden", bg="blue").grid(row=14, column=0)
entry_orden_cantidad = tk.Entry(ventana)
entry_orden_cantidad.grid(row=14, column=1)

boton3 = tk.Button(ventana, text="Registrar Orden", command=registrar_orden)
boton3.grid(row=15, column=0, columnspan=2)

boton4 = tk.Button(ventana, text="Mostrar Producto", command=mostrar_producto)
boton4.grid(row=16, column=0, columnspan=2)

ventana.mainloop()
