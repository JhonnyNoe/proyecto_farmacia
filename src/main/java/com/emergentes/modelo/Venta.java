package com.emergentes.modelo;

import java.sql.Date;

public class Venta {
    private int codigo_venta;
    private Date fecha;
    private int codigo_producto;
    private int codigo_cliente;
    private int codigo_empleado;
    private int codigo_comprobante;
    private String descripcion;
    private float costo;
    
    private String nombre_producto;
    private String nombre_cliente;
    private String nombre_empleado;
    private String nombre_comprobante;

    public Venta() {
    }

    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public int getCodigo_comprobante() {
        return codigo_comprobante;
    }

    public void setCodigo_comprobante(int codigo_comprobante) {
        this.codigo_comprobante = codigo_comprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getNombre_comprobante() {
        return nombre_comprobante;
    }

    public void setNombre_comprobante(String nombre_comprobante) {
        this.nombre_comprobante = nombre_comprobante;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo_venta=" + codigo_venta + ", fecha=" + fecha + ", codigo_producto=" + codigo_producto + ", codigo_cliente=" + codigo_cliente + ", codigo_empleado=" + codigo_empleado + ", codigo_comprobante=" + codigo_comprobante + ", descripcion=" + descripcion + ", costo=" + costo + ", nombre_producto=" + nombre_producto + ", nombre_cliente=" + nombre_cliente + ", nombre_empleado=" + nombre_empleado + ", nombre_comprobante=" + nombre_comprobante + '}';
    }
}
