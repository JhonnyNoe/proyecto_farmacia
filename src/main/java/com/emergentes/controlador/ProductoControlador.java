
package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.dao.ProveedorDAO;
import com.emergentes.dao.ProveedorDAOimpl;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Proveedor;
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

@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            CategoriaDAO daocategoria = new CategoriaDAOimpl();
            ProveedorDAO daoproveedor = new ProveedorDAOimpl();
            List<Categoria> lista_categoria = null;
            List<Proveedor> lista_proveedor = null;
            
            Producto pro = new Producto();
            int cod_producto;
            ProductoDAO dao = new ProductoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    lista_categoria = daocategoria.getAll();
                    lista_proveedor = daoproveedor.getAll();
                    request.setAttribute("lista_categoria", lista_categoria);
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    //
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_categoria = daocategoria.getAll();
                    lista_proveedor = daoproveedor.getAll();
                    request.setAttribute("lista_categoria", lista_categoria);
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    //
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    pro = dao.getByid(cod_producto);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
                    dao.delete(cod_producto);
                    response.sendRedirect("ProductoControlador");
                    break;
                case "view":
                    //optener la lista de registros
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("producto", lista);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_producto = Integer.parseInt(request.getParameter("cod_producto"));
        String nombre_producto = request.getParameter("nombre_producto");
        float precio_venta = Float.parseFloat(request.getParameter("precio_venta"));
        float precio_compra = Float.parseFloat(request.getParameter("precio_compra"));
        String fecha_vencimiento = request.getParameter("fecha_vencimiento");
        int stock = Integer.parseInt(request.getParameter("stock"));
        int codigo_categoria = Integer.parseInt(request.getParameter("codigo_categoria"));
        int codigo_proveedor = Integer.parseInt(request.getParameter("codigo_proveedor"));
        
        Producto pro = new Producto();
        
        pro.setCod_producto(cod_producto);
        pro.setNombre_producto(nombre_producto);
        pro.setPrecio_venta(precio_venta);
        pro.setPrecio_compra(precio_compra);
        pro.setFecha_vencimiento(convierteFecha(fecha_vencimiento));
        pro.setStock(stock);
        pro.setCodigo_categoria(codigo_categoria);
        pro.setCodigo_proveedor(codigo_proveedor);
        
        ProductoDAO dao = new ProductoDAOimpl();
        
        if(cod_producto==0){
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
        response.sendRedirect("ProductoControlador");
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
