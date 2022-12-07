package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    public void insert (Cliente cliente) throws Exception;
    public void update (Cliente cliente) throws Exception;
    public void delete (int codigo_cliente) throws Exception;
    public Cliente getByid(int codigo_cliente) throws Exception;
    public List<Cliente> getAll() throws Exception;
}
