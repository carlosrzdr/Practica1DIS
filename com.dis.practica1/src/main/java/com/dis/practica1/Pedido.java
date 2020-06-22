package com.dis.practica1;

public class Pedido {
    private String id;
    private String codigo;
    private String info;
    private String cantidad;
    private String destinatario;
    private String fecha;
    private String calle;
    private String numero;
    private String codigoPostal;
    private String poblacion;
    private String pais;

    public Pedido(String id, String codigo, String info, String cantidad, String destinatario, String fecha,
                  String calle, String numero, String codigoPostal, String poblacion, String pais) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.info = info;
        this.cantidad = cantidad;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.poblacion = poblacion;
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}