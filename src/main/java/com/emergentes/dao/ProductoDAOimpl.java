
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO{

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO producto (cod_producto, nombre_producto, precio_venta, precio_compra, fecha_vencimiento, stock, codigo_categoria, codigo_proveedor) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, producto.getCod_producto());
            ps.setString(2, producto.getNombre_producto());
            ps.setFloat(3, producto.getPrecio_venta());
            ps.setFloat(4, producto.getPrecio_compra());
            ps.setDate(5, producto.getFecha_vencimiento());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getCodigo_categoria());
            ps.setInt(8, producto.getCodigo_proveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE producto SET nombre_producto = ?, precio_venta = ?, precio_compra = ?, fecha_vencimiento = ?, stock = ?, codigo_categoria = ?, codigo_proveedor = ? where cod_producto = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre_producto());
            ps.setFloat(2, producto.getPrecio_venta());
            ps.setFloat(3, producto.getPrecio_compra());
            ps.setDate(4, producto.getFecha_vencimiento());
            ps.setInt(5, producto.getStock());
            ps.setInt(6, producto.getCodigo_categoria());
            ps.setInt(7, producto.getCodigo_proveedor());
            
            ps.setInt(8, producto.getCod_producto());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int cod_producto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM producto where cod_producto = ?");
            ps.setInt(1, cod_producto);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getByid(int cod_producto) throws Exception {
        Producto pro = new Producto();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM producto WHERE cod_producto = ?");
            ps.setInt(1, cod_producto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setCod_producto(rs.getInt("cod_producto"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setPrecio_venta(rs.getFloat("precio_venta"));
                pro.setPrecio_compra(rs.getFloat("precio_compra"));
                pro.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                pro.setStock(rs.getInt("stock"));
                pro.setCodigo_categoria(rs.getInt("codigo_categoria"));
                pro.setCodigo_proveedor(rs.getInt("codigo_proveedor"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        try {
            this.conectar();
            String sql = "SELECT p.* ,c.nombre_categoria as nombre_categoria, pr.nombre_proveedor as nombre_proveedor FROM producto p ";
            sql += "LEFT JOIN categoria c ON p.codigo_categoria = c.codigo_categoria ";
            sql += "LEFT JOIN proveedor pr ON p.codigo_proveedor = pr.codigo_proveedor";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Producto>();
            while (rs.next()) {
                Producto pro = new Producto();
                
                pro.setCod_producto(rs.getInt("cod_producto"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setPrecio_venta(rs.getFloat("precio_venta"));
                pro.setPrecio_compra(rs.getFloat("precio_compra"));
                pro.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                pro.setStock(rs.getInt("stock"));
                pro.setCodigo_categoria(rs.getInt("codigo_categoria"));
                pro.setCodigo_proveedor(rs.getInt("codigo_proveedor"));
                pro.setNombre_categoria(rs.getString("nombre_categoria"));
                pro.setNombre_proveedor(rs.getString("nombre_proveedor"));
                lista.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
