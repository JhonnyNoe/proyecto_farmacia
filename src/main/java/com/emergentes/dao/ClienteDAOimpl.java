
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO{

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cliente (codigo_cliente, nombre, direccion, telefono) values (?, ?, ?, ?)");
            ps.setInt(1, cliente.getCodigo_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE cliente SET nombre = ?, direccion = ?, telefono = ? where codigo_cliente = ?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setInt(3, cliente.getTelefono());
            
            ps.setInt(4, cliente.getCodigo_cliente());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cliente where codigo_cliente = ?");
            ps.setInt(1, codigo_cliente);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cliente getByid(int codigo_cliente) throws Exception {
        Cliente cli = new Cliente();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente WHERE codigo_cliente = ?");
            ps.setInt(1, codigo_cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cli = new Cliente();
                
                cli.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
                lista.add(cli);
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
