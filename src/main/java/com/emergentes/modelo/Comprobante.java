
package com.emergentes.modelo;
public class Comprobante {
    private int codigo_comprobante;
    private String descripcion;

    public Comprobante() {
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

    @Override
    public String toString() {
        return "Comprobante{" + "codigo_comprobante=" + codigo_comprobante + ", descripcion=" + descripcion + '}';
    }
    
}
