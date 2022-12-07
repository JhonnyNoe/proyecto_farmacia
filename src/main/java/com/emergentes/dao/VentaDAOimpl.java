
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO{

    @Override
    public void insert(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO venta (codigo_venta, fecha, codigo_producto, codigo_cliente, codigo_empleado, codigo_comprobante, descripcion, costo) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getCodigo_venta());
            ps.setDate(2, venta.getFecha());
            ps.setInt(3, venta.getCodigo_producto());
            ps.setInt(4, venta.getCodigo_cliente());
            ps.setInt(5, venta.getCodigo_empleado());
            ps.setInt(6, venta.getCodigo_comprobante());
            ps.setString(7, venta.getDescripcion());
            ps.setFloat(8, venta.getCosto());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE venta SET fecha = ?, codigo_producto = ?, codigo_cliente = ?, codigo_empleado = ?, codigo_comprobante = ?, descripcion = ?, costo = ? where codigo_venta = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDate(1, venta.getFecha());
            ps.setInt(2, venta.getCodigo_producto());
            ps.setInt(3, venta.getCodigo_cliente());
            ps.setInt(4, venta.getCodigo_empleado());
            ps.setInt(5, venta.getCodigo_comprobante());
            ps.setString(6, venta.getDescripcion());
            ps.setFloat(7, venta.getCosto());
                        
            ps.setInt(8, venta.getCodigo_venta());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_venta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM venta where codigo_venta = ?");
            ps.setInt(1, codigo_venta);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Venta getByid(int codigo_venta) throws Exception {
        Venta ven = new Venta();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM venta WHERE codigo_venta = ?");
            ps.setInt(1, codigo_venta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ven.setCodigo_venta(rs.getInt("codigo_venta"));
                ven.setFecha(rs.getDate("fecha"));
                ven.setCodigo_producto(rs.getInt("codigo_producto"));
                ven.setCodigo_cliente(rs.getInt("codigo_cliente"));
                ven.setCodigo_empleado(rs.getInt("codigo_empleado"));
                ven.setCodigo_comprobante(rs.getInt("codigo_comprobante"));
                ven.setDescripcion(rs.getString("descripcion"));
                ven.setCosto(rs.getFloat("costo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ven;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            String sql = "SELECT v.* ,p.nombre_producto as nombre_producto, c.nombre as nombre_cliente, e.nombre as nombre_empleado, co.descripcion as nombre_comprobante FROM venta v ";
            sql += "LEFT JOIN producto p ON v.codigo_producto = p.cod_producto ";
            sql += "LEFT JOIN cliente c ON v.codigo_cliente = c.codigo_cliente ";
            sql += "LEFT JOIN empleado e ON v.codigo_empleado = e.codigo_empleado ";
            sql += "LEFT JOIN comprobante co ON v.codigo_comprobante = co.codigo_comprobante";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Venta>();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setCodigo_venta(rs.getInt("codigo_venta"));
                ven.setFecha(rs.getDate("fecha"));
                ven.setCodigo_producto(rs.getInt("codigo_producto"));
                ven.setCodigo_cliente(rs.getInt("codigo_cliente"));
                ven.setCodigo_empleado(rs.getInt("codigo_empleado"));
                ven.setCodigo_comprobante(rs.getInt("codigo_comprobante"));
                ven.setDescripcion(rs.getString("descripcion"));
                ven.setCosto(rs.getFloat("costo"));
                
                ven.setNombre_producto(rs.getString("nombre_producto"));
                ven.setNombre_cliente(rs.getString("nombre_cliente"));
                ven.setNombre_empleado(rs.getString("nombre_empleado"));
                ven.setNombre_comprobante(rs.getString("nombre_comprobante"));
                
                lista.add(ven);
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
