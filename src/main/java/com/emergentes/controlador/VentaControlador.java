package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.dao.ComprobanteDAO;
import com.emergentes.dao.ComprobanteDAOimpl;
import com.emergentes.dao.EmpleadoDAO;
import com.emergentes.dao.EmpleadoDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Comprobante;
import com.emergentes.modelo.Empleado;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            ProductoDAO daoproducto = new ProductoDAOimpl();
            ClienteDAO daocliente = new ClienteDAOimpl();
            EmpleadoDAO daoempleado = new EmpleadoDAOimpl();
            ComprobanteDAO daocomprobante = new ComprobanteDAOimpl();
            
            List<Producto> lista_producto = null;
            List<Cliente> lista_cliente = null;
            List<Empleado> lista_empleado = null;
            List<Comprobante> lista_comprobante = null;
            
            Venta ven = new Venta();
            int codigo_venta;
            VentaDAO dao = new VentaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    lista_producto = daoproducto.getAll();
                    lista_cliente = daocliente.getAll();
                    lista_empleado = daoempleado.getAll();
                    lista_comprobante = daocomprobante.getAll();
                    request.setAttribute("lista_producto", lista_producto);
                    request.setAttribute("lista_cliente", lista_cliente);
                    request.setAttribute("lista_empleado", lista_empleado);
                    request.setAttribute("lista_comprobante", lista_comprobante);
                    //
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_producto = daoproducto.getAll();
                    lista_cliente = daocliente.getAll();
                    lista_empleado = daoempleado.getAll();
                    lista_comprobante = daocomprobante.getAll();
                    request.setAttribute("lista_producto", lista_producto);
                    request.setAttribute("lista_cliente", lista_cliente);
                    request.setAttribute("lista_empleado", lista_empleado);
                    request.setAttribute("lista_comprobante", lista_comprobante);
                    //
                    codigo_venta = Integer.parseInt(request.getParameter("codigo_venta"));
                    ven = dao.getByid(codigo_venta);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "delete":
                    codigo_venta = Integer.parseInt(request.getParameter("codigo_venta"));
                    dao.delete(codigo_venta);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("Venta", lista);
                    request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo_venta = Integer.parseInt(request.getParameter("codigo_venta"));
        String fecha = request.getParameter("fecha");
        int codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
        int codigo_cliente = Integer.parseInt(request.getParameter("codigo_cliente"));
        int codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
        int codigo_comprobante = Integer.parseInt(request.getParameter("codigo_comprobante"));
        String descripcion = request.getParameter("descripcion");
        float costo = Float.parseFloat(request.getParameter("costo"));
        
        Venta ven = new Venta();
        
        ven.setCodigo_venta(codigo_venta);
        ven.setFecha(convierteFecha(fecha));
        ven.setCodigo_producto(codigo_producto);
        ven.setCodigo_cliente(codigo_cliente);
        ven.setCodigo_empleado(codigo_empleado);
        ven.setCodigo_comprobante(codigo_comprobante);
        ven.setDescripcion(descripcion);
        ven.setCosto(costo);
        
        VentaDAO dao = new VentaDAOimpl();
        
        if(codigo_venta==0){
            try {
                //Nuevo registro
                dao.insert(ven);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
            
        }
        else{
            try {
                //Edicion de registro
                dao.update(ven);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("VentaControlador");
    }
    public Date convierteFecha(String fecha){
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date (fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }
}
