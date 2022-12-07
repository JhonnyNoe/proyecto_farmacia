
package com.emergentes.controlador;

import com.emergentes.dao.EmpleadoDAO;
import com.emergentes.dao.EmpleadoDAOimpl;
import com.emergentes.modelo.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/EmpleadoControlador"})
public class EmpleadoControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
            Empleado emp = new Empleado();
            int codigo_empleado;
            EmpleadoDAO dao = new EmpleadoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                    break;
                case "edit":
                    codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
                    emp = dao.getByid(codigo_empleado);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
                    dao.delete(codigo_empleado);
                    response.sendRedirect("EmpleadoControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Empleado> lista = dao.getAll();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");
        int edad = Integer.parseInt(request.getParameter("edad"));
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        float sueldo = Float.parseFloat(request.getParameter("sueldo"));
        
        Empleado emp = new Empleado();
        
        emp.setCodigo_empleado(codigo_empleado);
        emp.setNombre(nombre);
        emp.setDireccion(direccion);
        emp.setCargo(cargo);
        emp.setEdad(edad);
        emp.setTelefono(telefono);
        emp.setSueldo(sueldo);
        
        EmpleadoDAO dao = new EmpleadoDAOimpl();
        
        if(codigo_empleado==0){
            try {
                //Nuevo registro
                dao.insert(emp);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(emp);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("EmpleadoControlador");
    }
}
