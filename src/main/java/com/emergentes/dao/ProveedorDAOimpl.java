package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO{

    @Override
    public void insert(Proveedor proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO proveedor (codigo_proveedor, nombre_proveedor, direccion_proveedor, telefono) values (?, ?, ?, ?)");
            ps.setInt(1, proveedor.getCodigo_proveedor());
            ps.setString(2, proveedor.getNombre_proveedor());
            ps.setString(3, proveedor.getDireccion_proveedor());
            ps.setInt(4, proveedor.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE proveedor SET nombre_proveedor = ?, direccion_proveedor = ?, telefono = ? where codigo_proveedor = ?");
            ps.setString(1, proveedor.getNombre_proveedor());
            ps.setString(2, proveedor.getDireccion_proveedor());
            ps.setInt(3, proveedor.getTelefono());
            
            ps.setInt(4, proveedor.getCodigo_proveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM proveedor where codigo_proveedor = ?");
            ps.setInt(1, codigo_proveedor);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Proveedor getByid(int codigo_proveedor) throws Exception {
        Proveedor pro = new Proveedor();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedor WHERE codigo_proveedor = ?");
            ps.setInt(1, codigo_proveedor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setCodigo_proveedor(rs.getInt("codigo_proveedor"));
                pro.setNombre_proveedor(rs.getString("nombre_proveedor"));
                pro.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                pro.setTelefono(rs.getInt("telefono"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedor");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Proveedor>();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                
                pro.setCodigo_proveedor(rs.getInt("codigo_proveedor"));
                pro.setNombre_proveedor(rs.getString("nombre_proveedor"));
                pro.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                pro.setTelefono(rs.getInt("telefono"));
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
