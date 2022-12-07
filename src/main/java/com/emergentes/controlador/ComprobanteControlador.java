
package com.emergentes.controlador;
import com.emergentes.dao.ComprobanteDAO;
import com.emergentes.dao.ComprobanteDAOimpl;
import com.emergentes.modelo.Comprobante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ComprobanteControlador", urlPatterns = {"/ComprobanteControlador"})
public class ComprobanteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
            Comprobante com = new Comprobante();
            int codigo_comprobante;
            ComprobanteDAO dao = new ComprobanteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("comprobante", com);
                    request.getRequestDispatcher("frmcomprobante.jsp").forward(request, response);
                    break;
                case "edit":
                    codigo_comprobante = Integer.parseInt(request.getParameter("codigo_comprobante"));
                    com = dao.getByid(codigo_comprobante);
                    request.setAttribute("comprobante", com);
                    request.getRequestDispatcher("frmcomprobante.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_comprobante = Integer.parseInt(request.getParameter("codigo_comprobante"));
                    dao.delete(codigo_comprobante);
                    response.sendRedirect("ComprobanteControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Comprobante> lista = dao.getAll();
                    request.setAttribute("comprobantes", lista);
                    request.getRequestDispatcher("Comprobantes.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_comprobante = Integer.parseInt(request.getParameter("codigo_comprobante"));
        String descripcion = request.getParameter("descripcion");
        
        Comprobante com = new Comprobante();
        
        com.setCodigo_comprobante(codigo_comprobante);
        com.setDescripcion(descripcion);
        
        ComprobanteDAO dao = new ComprobanteDAOimpl();
        
        if(codigo_comprobante==0){
            try {
                //Nuevo registro
                dao.insert(com);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(com);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("ComprobanteControlador");

    }
}
