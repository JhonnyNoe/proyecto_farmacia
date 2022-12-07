
package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.modelo.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Categoria cat = new Categoria();
            int codigo_categoria;
            CategoriaDAO dao = new CategoriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "edit":
                    codigo_categoria = Integer.parseInt(request.getParameter("codigo_categoria"));
                    cat = dao.getByid(codigo_categoria);
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_categoria = Integer.parseInt(request.getParameter("codigo_categoria"));
                    dao.delete(codigo_categoria);
                    response.sendRedirect("CategoriaControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("Categorias.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_categoria = Integer.parseInt(request.getParameter("codigo_categoria"));
        String nombre_categoria = request.getParameter("nombre_categoria");
        String descripcion = request.getParameter("descripcion");
        
        Categoria cat = new Categoria();
        
        cat.setCodigo_categoria(codigo_categoria);
        cat.setNombre_categoria(nombre_categoria);
        cat.setDescripcion(descripcion);
        
        CategoriaDAO dao = new CategoriaDAOimpl();
        
        if(codigo_categoria==0){
            try {
                //Nuevo registro
                dao.insert(cat);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(cat);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("CategoriaControlador");

    }
}
