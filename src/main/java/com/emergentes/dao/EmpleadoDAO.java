
package com.emergentes.dao;

import com.emergentes.modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    public void insert (Empleado empleado) throws Exception;
    public void update (Empleado empleado) throws Exception;
    public void delete (int codigo_empleado) throws Exception;
    public Empleado getByid(int codigo_empleado) throws Exception;
    public List<Empleado> getAll() throws Exception;
}
