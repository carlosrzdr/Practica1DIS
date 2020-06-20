package com.dis.practica1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Almacen {
    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public Almacen() {
        productos = new ArrayList<Producto>();
        clientes = new ArrayList<Cliente>();
        pedidos = new ArrayList<Pedido>();
    }

    public void addProducto() throws IOException {
        String codigo;
        String nombreProducto;
        String descripcion;
        String stock;
        String pendientes;	
        String pasillo;
        String estanteria;
	    String estante;
        
        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Código: ");
        codigo = in.readLine();

        System.out.print("Nombre: ");
        nombreProducto = in.readLine();

        System.out.print("Descripción: ");
        descripcion = in.readLine();

        System.out.print("Stock: ");
        stock = in.readLine();

        System.out.print("Pendientes: ");
        pendientes = in.readLine();

        System.out.print("Pasillo: ");
        pasillo = in.readLine();

        System.out.print("Estantería: ");
        estanteria = in.readLine();

        System.out.print("Estante: ");
        estante = in.readLine();

        productos.add(new Producto(codigo, nombreProducto, descripcion, stock, pendientes, pasillo, estanteria, estante));
    }

    public void addCliente() throws IOException {
        String id;
        String nombre;
        String apellidos;
        String email;
        String telefono;	
        String calle;
        String numero;
        String codigoPostal;
        String poblacion;
        String pais;

        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Id del cliente: ");
        id = in.readLine();

        System.out.print("Nombre: ");
        nombre = in.readLine();

        System.out.print("Apellidos: ");
        apellidos = in.readLine();

        System.out.print("Email: ");
        email = in.readLine();

        System.out.print("Telefono: ");
        telefono = in.readLine();

        System.out.print("Calle: ");
        calle = in.readLine();

        System.out.print("Número: ");
        numero = in.readLine();

        System.out.print("Código postal: ");
        codigoPostal = in.readLine();

        System.out.print("Población: ");
        poblacion = in.readLine();

        System.out.print("País: ");
        pais = in.readLine();

        clientes.add(new Cliente(id, nombre, apellidos, email, telefono, calle, numero, codigoPostal, poblacion, pais));
    }

    public void addPedido() throws IOException {
        String id;
        String codigo;
        String info;
        String cantidad;
        String destinatario;
        String fecha;	
        String calle;
        String numero;
        String codigoPostal;
        String poblacion;
        String pais;

        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Id del pedido: ");
        id = in.readLine();
        
        System.out.print("Código del pedido: ");
        codigo = in.readLine();

        System.out.print("Información: ");
        info = in.readLine();

        System.out.print("Cantidad: ");
        cantidad = in.readLine();
        
        System.out.print("Destinatario: ");
        destinatario = in.readLine();

        System.out.print("Fecha: ");
        fecha = in.readLine();
        
        System.out.print("Calle: ");
        calle = in.readLine();

        System.out.print("Número: ");
        numero = in.readLine();
        
        System.out.print("Código postal: ");
        codigoPostal = in.readLine();
        
        System.out.print("Población: ");
        poblacion = in.readLine();
        
        System.out.print("País: ");
        pais = in.readLine();

        pedidos.add(new Pedido(id, codigo, info, cantidad, destinatario, fecha, calle, numero, codigoPostal, poblacion, pais));
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}