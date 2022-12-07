
package com.emergentes.controlador;
import com.emergentes.dao.ProveedorDAO;
import com.emergentes.dao.ProveedorDAOimpl;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Proveedor pro = new Proveedor();
            int codigo_proveedor;
            ProveedorDAO dao = new ProveedorDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("proveedor", pro);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "edit":
                    codigo_proveedor = Integer.parseInt(request.getParameter("codigo_proveedor"));
                    pro = dao.getByid(codigo_proveedor);
                    request.setAttribute("proveedor", pro);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_proveedor = Integer.parseInt(request.getParameter("codigo_proveedor"));
                    dao.delete(codigo_proveedor);
                    response.sendRedirect("ProveedorControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Proveedor> lista = dao.getAll();
                    request.setAttribute("proveedor", lista);
                    request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_proveedor = Integer.parseInt(request.getParameter("codigo_proveedor"));
        String nombre_proveedor = request.getParameter("nombre_proveedor");
        String direccion_proveedor = request.getParameter("direccion_proveedor");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        
        Proveedor pro = new Proveedor();
        
        pro.setCodigo_proveedor(codigo_proveedor);
        pro.setNombre_proveedor(nombre_proveedor);
        pro.setDireccion_proveedor(direccion_proveedor);
        pro.setTelefono(telefono);
        
        ProveedorDAO dao = new ProveedorDAOimpl();
        
        if(codigo_proveedor==0){
            try {
                //Nuevo registro
                dao.insert(pro);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(pro);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("ProveedorControlador");
    }
}
