<%
    if(session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FARMACIA</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Empleados</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="empleados"/>
            </jsp:include>
            <br>
            <a href="EmpleadoControlador?action=add" class="btn btn-primary btn-sm" ><i class="fa-solid fa-circle-plus"></i> Nuevo</a>

            <table class="table table-striped">
                <tr>
                    <th>Codigo empleado</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Cargo</th>
                    <th>Edad</th>
                    <th>Telefono</th>
                    <th>Sueldo</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${empleados}">
                    <tr>
                        <td>${item.codigo_empleado}</td>
                        <td>${item.nombre}</td>
                        <td>${item.direccion}</td>
                        <td>${item.cargo}</td>
                        <td>${item.edad}</td>
                        <td>${item.telefono}</td>
                        <td>${item.sueldo}</td>
                        <td><a href="EmpleadoControlador?action=edit&codigo_empleado=${item.codigo_empleado}"><i class="fa-solid fa-pen-to-square"></i><a/></td>
                        <td><a href="EmpleadoControlador?action=delete&codigo_empleado=${item.codigo_empleado}" onclick="return(confirm('Esta Seguro'))">
                                <i class="fa-solid fa-trash"></i>
                                <a/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>