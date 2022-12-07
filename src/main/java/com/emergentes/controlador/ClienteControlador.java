
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Cliente cli = new Cliente();
            int codigo_cliente;
            ClienteDAO dao = new ClienteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "edit":
                    codigo_cliente = Integer.parseInt(request.getParameter("codigo_cliente"));
                    cli = dao.getByid(codigo_cliente);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_cliente = Integer.parseInt(request.getParameter("codigo_cliente"));
                    dao.delete(codigo_cliente);
                    response.sendRedirect("ClienteControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_cliente = Integer.parseInt(request.getParameter("codigo_cliente"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        
        Cliente cli = new Cliente();
        
        cli.setCodigo_cliente(codigo_cliente);
        cli.setNombre(nombre);
        cli.setDireccion(direccion);
        cli.setTelefono(telefono);
        
        ClienteDAO dao = new ClienteDAOimpl();
        
        if(codigo_cliente==0){
            try {
                //Nuevo registro
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("ClienteControlador");
    }
}
