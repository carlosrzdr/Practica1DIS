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

    public void loadXml() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        String filePath = "almacen.xml";
        File xmlFile = new File(filePath);
        document = dBuilder.parse(xmlFile);

        almacen = document.getElementsByTagName("Almacen").item(0);
        productos = document.getElementsByTagName("Productos").item(0);
        clientes = document.getElementsByTagName("Clientes").item(0);
        pedidos = document.getElementsByTagName("Pedidos").item(0);
    }
}