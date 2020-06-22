package com.dis.practica1;

public class Producto {
	private String codigo;
	private String nombreProducto;
	private String descripcion;
	private String stock;
	private String pendientes;	
	private String pasillo;
	private String estanteria;
	private String estante;

	public Producto(String codigo, String nombreProducto, String descripcion, String stock, String pendientes,
					String pasillo, String estanteria, String estante) {
		super();
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.pendientes = pendientes;
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.estante = estante;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPendientes() {
		return pendientes;
	}

	public void setPendientes(String pendientes) {
		this.pendientes = pendientes;
	}	

	public String getPasillo() {
		return pasillo;
	}

	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}

	public String getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public String getEstante() {
		return estante;
	}

	public void setEstante(String estante) {
		this.estante = estante;
	}		
}