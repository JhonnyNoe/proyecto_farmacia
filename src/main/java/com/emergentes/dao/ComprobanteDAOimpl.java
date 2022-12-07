
package com.emergentes.dao;

import com.emergentes.modelo.Comprobante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteDAOimpl extends ConexionDB implements ComprobanteDAO{

    @Override
    public void insert(Comprobante comprobante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO comprobante (codigo_comprobante, descripcion) values (?, ?)");
            ps.setInt(1, comprobante.getCodigo_comprobante());
            ps.setString(2, comprobante.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Comprobante comprobante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE comprobante SET descripcion = ? where codigo_comprobante = ?");
            ps.setString(1, comprobante.getDescripcion());
            
            ps.setInt(2, comprobante.getCodigo_comprobante());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_comprobante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM comprobante where codigo_comprobante = ?");
            ps.setInt(1, codigo_comprobante);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Comprobante getByid(int codigo_comprobante) throws Exception {
        Comprobante com = new Comprobante();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM comprobante WHERE codigo_comprobante = ?");
            ps.setInt(1, codigo_comprobante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                com.setCodigo_comprobante(rs.getInt("codigo_comprobante"));
                com.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return com;
    }

    @Override
    public List<Comprobante> getAll() throws Exception {
        List<Comprobante> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM comprobante");
            ResultSet rs = ps.executeQuery();
            
              lista = new ArrayList<Comprobante>();
            while (rs.next()) {
                Comprobante com = new Comprobante();
                
                com.setCodigo_comprobante(rs.getInt("codigo_comprobante"));
                com.setDescripcion(rs.getString("descripcion"));
                lista.add(com);
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
