package com.emergentes.modelo;
public class Categoria {
    private int codigo_categoria;
    private String nombre_categoria;
    private String descripcion;

    public Categoria() {
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codigo_categoria=" + codigo_categoria + ", nombre_categoria=" + nombre_categoria + ", descripcion=" + descripcion + '}';
    }
    
}
