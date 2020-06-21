package com.dis.practica1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Xml {
    private Document document;
    private Node almacen;
    private Node productos;
    private Node clientes;
    private Node pedidos;

    public Xml() {
    }

    public void newXml() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        document = dBuilder.newDocument();

        almacen = document.createElement("Almacen");
        productos = document.createElement("Productos");
        clientes = document.createElement("Clientes");
        pedidos = document.createElement("Pedidos");

        document.appendChild(almacen);
        almacen.appendChild(productos);
        almacen.appendChild(clientes);
        almacen.appendChild(pedidos);
    }

    public void loadXml(Almacen alm_logico) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        String filePath = "almacen.xml";
        File xmlFile = new File(filePath);
        document = dBuilder.parse(xmlFile);

        almacen = document.getElementsByTagName("Almacen").item(0);
        productos = document.getElementsByTagName("Productos").item(0);
        clientes = document.getElementsByTagName("Clientes").item(0);
        pedidos = document.getElementsByTagName("Pedidos").item(0);

        loadProductos(alm_logico);
        loadClientes(alm_logico);
        loadPedidos(alm_logico);
    }

    private void loadProductos(Almacen alm_logico) {
        String codigo;
        String nombreProducto;
        String descripcion;
        String stock;
        String pendientes;	
        String pasillo;
        String estanteria;
	    String estante;
        
        for(int i = 0; i < productos.getChildNodes().getLength(); i++) {
            codigo = productos.getChildNodes().item(i).getAttributes().item(0).getTextContent();
            nombreProducto = productos.getChildNodes().item(i).getChildNodes().item(0).getTextContent();
            descripcion = productos.getChildNodes().item(i).getChildNodes().item(1).getTextContent();
            stock = productos.getChildNodes().item(i).getChildNodes().item(2).getTextContent();
            pendientes = productos.getChildNodes().item(i).getChildNodes().item(3).getTextContent();
            pasillo = productos.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(0).getTextContent();
            estanteria = productos.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(1).getTextContent();
            estante = productos.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(2).getTextContent();
            
            alm_logico.getProductos().add(new Producto(codigo, nombreProducto, descripcion, stock, pendientes, pasillo, estanteria, estante));
        }
    }

    private void loadClientes(Almacen alm_logico) {
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

        for(int i = 0; i < clientes.getChildNodes().getLength(); i++) {
            id = clientes.getChildNodes().item(i).getAttributes().item(0).getTextContent();
            nombre = clientes.getChildNodes().item(i).getChildNodes().item(0).getTextContent();
            apellidos = clientes.getChildNodes().item(i).getChildNodes().item(1).getTextContent();
            email = clientes.getChildNodes().item(i).getChildNodes().item(2).getTextContent();
            telefono = clientes.getChildNodes().item(i).getChildNodes().item(3).getTextContent();
            calle = clientes.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(0).getTextContent();
            numero = clientes.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(1).getTextContent();
            codigoPostal = clientes.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(2).getTextContent();
            poblacion = clientes.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(3).getTextContent();
            pais = clientes.getChildNodes().item(i).getChildNodes().item(4).getChildNodes().item(4).getTextContent();

            alm_logico.getClientes().add(new Cliente(id, nombre, apellidos, email, telefono, calle, numero, codigoPostal, poblacion, pais));
        }
    }

    private void loadPedidos(Almacen alm_logico) {
        String id;
        String codigo_producto;
        String info;
        String cantidad;
        String destinatario;
        String fecha;	
        String calle;
        String numero;
        String codigoPostal;
        String poblacion;
        String pais;

        for(int i = 0; i < pedidos.getChildNodes().getLength(); i++) {
            id = pedidos.getChildNodes().item(i).getAttributes().item(0).getTextContent();
            codigo_producto = pedidos.getChildNodes().item(i).getChildNodes().item(0).getAttributes().item(0).getTextContent();
            info = pedidos.getChildNodes().item(i).getChildNodes().item(0).getChildNodes().item(0).getTextContent();
            cantidad = pedidos.getChildNodes().item(i).getChildNodes().item(0).getChildNodes().item(1).getTextContent();
            destinatario = pedidos.getChildNodes().item(i).getChildNodes().item(1).getTextContent();
            fecha = pedidos.getChildNodes().item(i).getChildNodes().item(2).getTextContent();
            calle = pedidos.getChildNodes().item(i).getChildNodes().item(3).getChildNodes().item(0).getTextContent();
            numero = pedidos.getChildNodes().item(i).getChildNodes().item(3).getChildNodes().item(1).getTextContent();
            codigoPostal = pedidos.getChildNodes().item(i).getChildNodes().item(3).getChildNodes().item(2).getTextContent();
            poblacion = pedidos.getChildNodes().item(i).getChildNodes().item(3).getChildNodes().item(3).getTextContent();
            pais = pedidos.getChildNodes().item(i).getChildNodes().item(3).getChildNodes().item(4).getTextContent();

            alm_logico.getPedidos().add(new Pedido(id, codigo_producto, info, cantidad, destinatario, fecha, calle, numero, codigoPostal, poblacion, pais));
        }
    }
}