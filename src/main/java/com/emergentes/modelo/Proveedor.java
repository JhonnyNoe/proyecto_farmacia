
package com.emergentes.modelo;
public class Proveedor {
    private int codigo_proveedor;
    private String nombre_proveedor;
    private String direccion_proveedor;
    private int telefono;

    public Proveedor() {
    }

    public int getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(int codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigo_proveedor=" + codigo_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono=" + telefono + '}';
    }
    
}
