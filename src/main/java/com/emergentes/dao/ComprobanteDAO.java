
package com.emergentes.dao;

import com.emergentes.modelo.Comprobante;
import java.util.List;

public interface ComprobanteDAO {
    public void insert (Comprobante comprobante) throws Exception;
    public void update (Comprobante comprobante) throws Exception;
    public void delete (int codigo_comprobante) throws Exception;
    public Comprobante getByid(int codigo_comprobante) throws Exception;
    public List<Comprobante> getAll() throws Exception;
}
