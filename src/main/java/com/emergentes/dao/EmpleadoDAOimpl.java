package com.emergentes.dao;
import com.emergentes.modelo.Empleado;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOimpl extends ConexionDB implements EmpleadoDAO{

    @Override
    public void insert(Empleado empleado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO empleado (codigo_empleado, nombre, direccion, cargo, edad, telefono, sueldo) values (?, ?, ?, ?, ?, ?,?)");
            ps.setInt(1, empleado.getCodigo_empleado());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDireccion());
            ps.setString(4, empleado.getCargo());
            ps.setInt(5, empleado.getEdad());
            ps.setInt(6, empleado.getTelefono());
            ps.setFloat(7, empleado.getSueldo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE empleado SET nombre = ?, direccion = ?, cargo = ?, edad = ?, telefono = ?, sueldo = ? where codigo_empleado = ?");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDireccion());
            ps.setString(3, empleado.getCargo());
            ps.setInt(4, empleado.getEdad());
            ps.setInt(5, empleado.getTelefono());
            ps.setFloat(6, empleado.getSueldo());
            
            ps.setInt(7, empleado.getCodigo_empleado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int codigo_empleado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM empleado where codigo_empleado = ?");
            ps.setInt(1, codigo_empleado);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Empleado getByid(int codigo_empleado) throws Exception {
        Empleado emp = new Empleado();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM empleado WHERE codigo_empleado = ?");
            ps.setInt(1, codigo_empleado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp.setCodigo_empleado(rs.getInt("codigo_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCargo(rs.getString("cargo"));
                emp.setEdad(rs.getInt("edad"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setSueldo(rs.getFloat("sueldo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return emp;
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        List<Empleado> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM empleado");
            ResultSet rs = ps.executeQuery();
            
              lista = new ArrayList<Empleado>();
            while (rs.next()) {
                Empleado emp = new Empleado();
                
                emp.setCodigo_empleado(rs.getInt("codigo_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCargo(rs.getString("cargo"));
                emp.setEdad(rs.getInt("edad"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setSueldo(rs.getFloat("sueldo"));
                lista.add(emp);
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
