
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import java.util.List;

public interface VentaDAO {
    public void insert (Venta venta) throws Exception;
    public void update (Venta venta) throws Exception;
    public void delete (int codigo_venta) throws Exception;
    public Venta getByid(int codigo_venta) throws Exception;
    public List<Venta> getAll() throws Exception;
}
