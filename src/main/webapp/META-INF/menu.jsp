<%
    String opcion = request.getParameter("opcion");
%>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("empleados") ? "active" : "")%>" href="EmpleadoControlador">Empleados</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("clientes") ? "active" : "")%>" href="ClienteControlador">Clientes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("proveedores") ? "active" : "")%>" href="ProveedorControlador">Proveedor</a>
    </li> 
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("categorias") ? "active" : "")%>" href="CategoriaControlador">Categoria</a>
    </li> 
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("productos") ? "active" : "")%>" href="ProductoControlador">Producto</a>
    </li> 
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("comprobantes") ? "active" : "")%>" href="ComprobanteControlador">Comprobante</a>
    </li> 
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("ventas") ? "active" : "")%>" href="VentaControlador">Venta</a>
    </li> 
    <a href="Logout" class="btn btn-danger">Cerrar session</a>
</ul>
