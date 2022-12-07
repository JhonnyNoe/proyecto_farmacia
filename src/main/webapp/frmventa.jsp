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
            <h1>Formulario de Ventas</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <br>
            <form action="VentaControlador" method="post">
                <input type="hidden" name="codigo_venta" value="${venta.codigo_venta}">
                <div class="form-group">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha" value="${venta.fecha}" placeholder="Escriba Fecha">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Producto</label>
                    <select name="codigo_producto" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_producto}">
                            <option value="${item.cod_producto}" 
                                    <c:if test="${venta.codigo_producto == item.cod_producto}">
                                        selected
                                    </c:if>>${item.nombre_producto}</option>
                        </c:forEach> 
                    </select>
                </div>     
                <div class="form-group">
                    <label for="" class="form-label">Cliente</label>
                    <select name="codigo_cliente" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_cliente}">
                            <option value="${item.codigo_cliente}" 
                                    <c:if test="${venta.codigo_cliente == item.codigo_cliente}">
                                        selected
                                    </c:if>>${item.nombre}</option>
                        </c:forEach> 
                    </select>
                </div>   
                <div class="form-group">
                    <label for="" class="form-label">Empleado</label>
                    <select name="codigo_empleado" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_empleado}">
                            <option value="${item.codigo_empleado}" 
                                    <c:if test="${venta.codigo_empleado == item.codigo_empleado}">
                                        selected
                                    </c:if>>${item.nombre}</option>
                        </c:forEach> 
                    </select>
                </div>   
                <div class="form-group">
                    <label for="" class="form-label">Comprobante</label>
                    <select name="codigo_comprobante" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_comprobante}">
                            <option value="${item.codigo_comprobante}" 
                                    <c:if test="${venta.codigo_comprobante == item.codigo_comprobante}">
                                        selected
                                    </c:if>>${item.descripcion}</option>
                        </c:forEach> 
                    </select>
                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${venta.descripcion}" placeholder="Escriba descripcion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Costo</label>
                    <input type="tel" class="form-control" name="costo" value="${venta.costo}" placeholder="Escriba Costo">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
