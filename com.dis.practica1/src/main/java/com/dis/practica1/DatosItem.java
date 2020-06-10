package com.dis.practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dis.practica1.Cliente;
import com.dis.practica1.Pedido;
import com.dis.practica1.Producto;

public class DatosItem {
	
	public static Producto datosProducto() throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Producto producto = new Producto(); 
		
		System.out.print("Código: "); producto.setCodigo(in.readLine());
		System.out.print("Nombre: "); producto.setNombreProducto(in.readLine());
		System.out.print("Descripción: "); producto.setDescripcion(in.readLine());
		System.out.print("Stock: "); producto.setStock(in.readLine());
		System.out.print("Pendientes: "); producto.setPendientes(in.readLine());
		System.out.print("Pasillo: "); producto.setPasillo(in.readLine());
		System.out.print("Estantería: "); producto.setEstanteria(in.readLine());
		System.out.print("Estante: "); producto.setEstante(in.readLine());
		
		return producto;
	}
	
	public static Cliente datosCliente() throws IOException{
    	java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	Cliente cliente = new Cliente();
    	
    	System.out.print("Id del cliente: "); cliente.setId(in.readLine());
    	System.out.print("Nombre: "); cliente.setNombre(in.readLine());
    	System.out.print("Apellidos: "); cliente.setApellidos(in.readLine());
    	System.out.print("Email: "); cliente.setEmail(in.readLine());
    	System.out.print("Telefono: "); cliente.setTelefono(in.readLine());
    	System.out.print("Calle: "); cliente.setCalle(in.readLine());
    	System.out.print("Número: "); cliente.setNumero(in.readLine());
    	System.out.print("Código postal: "); cliente.setCodigoPostal(in.readLine());
    	System.out.print("Población: "); cliente.setPoblacion(in.readLine());
    	System.out.print("País: "); cliente.setPais(in.readLine());
    	
    	return cliente;
    }
	
	public static Pedido datosPedido() throws IOException {
    	java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	Pedido pedido = new Pedido();
    	
    	System.out.print("Id del pedido: "); pedido.setId(in.readLine());
    	System.out.print("Código del pedido: "); pedido.setCodigo(in.readLine());
    	System.out.print("Información: "); pedido.setInfo(in.readLine());
    	System.out.print("Cantidad: "); pedido.setCantidad(in.readLine());
    	System.out.print("Destinatario: "); pedido.setDestinatario(in.readLine());
    	System.out.print("Fecha: "); pedido.setFecha(in.readLine());
    	System.out.print("Calle: "); pedido.setCalle(in.readLine());
    	System.out.print("Número: "); pedido.setNumero(in.readLine());
    	System.out.print("Código postal: "); pedido.setCodigoPostal(in.readLine());
    	System.out.print("Población: "); pedido.setPoblacion(in.readLine());
    	System.out.print("País: "); pedido.setPais(in.readLine());
    	    	
    	return pedido;
    }
}