
package com.emergentes.modelo;

import java.sql.Date;

public class Producto {
    private int cod_producto;
    private String nombre_producto;
    private float precio_venta;
    private float precio_compra;
    private Date fecha_vencimiento;
    private int stock;
    private int codigo_categoria;
    private int codigo_proveedor;
    private String nombre_categoria;
    private String nombre_proveedor;

    public Producto() {
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(int codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "cod_producto=" + cod_producto + ", nombre_producto=" + nombre_producto + ", precio_venta=" + precio_venta + ", precio_compra=" + precio_compra + ", fecha_vencimiento=" + fecha_vencimiento + ", stock=" + stock + ", codigo_categoria=" + codigo_categoria + ", codigo_proveedor=" + codigo_proveedor + ", nombre_categoria=" + nombre_categoria + ", nombre_proveedor=" + nombre_proveedor + '}';
    }
    
}
