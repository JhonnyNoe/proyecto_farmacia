package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import java.util.List;

public interface CategoriaDAO {
    public void insert (Categoria categoria) throws Exception;
    public void update (Categoria categoria) throws Exception;
    public void delete (int codigo_categoria) throws Exception;
    public Categoria getByid(int codigo_categoria) throws Exception;
    public List<Categoria> getAll() throws Exception;
}
