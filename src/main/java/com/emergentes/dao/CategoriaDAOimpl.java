
package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO{

    @Override
    public void insert(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO categoria (codigo_categoria, nombre_categoria, descripcion) values (?, ?, ?)");
            ps.setInt(1, categoria.getCodigo_categoria());
            ps.setString(2, categoria.getNombre_categoria());
            ps.setString(3, categoria.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE categoria SET nombre_categoria = ?, descripcion = ? where codigo_categoria = ?");
            ps.setString(1, categoria.getNombre_categoria());
            ps.setString(2, categoria.getDescripcion());
            
            ps.setInt(3, categoria.getCodigo_categoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM categoria where codigo_categoria = ?");
            ps.setInt(1, codigo_categoria);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Categoria getByid(int codigo_categoria) throws Exception {
        Categoria cat = new Categoria();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categoria WHERE codigo_categoria = ?");
            ps.setInt(1, codigo_categoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cat.setCodigo_categoria(rs.getInt("codigo_categoria"));
                cat.setNombre_categoria(rs.getString("nombre_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cat;
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        List<Categoria> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = ps.executeQuery();
            
              lista = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria cat = new Categoria();
                
                cat.setCodigo_categoria(rs.getInt("codigo_categoria"));
                cat.setNombre_categoria(rs.getString("nombre_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
                lista.add(cat);
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
