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
            <h1>Formulario de Productos</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="productos"/>
            </jsp:include>
            <br>
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="cod_producto" value="${producto.cod_producto}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre_producto" value="${producto.nombre_producto}" placeholder="Escriba su nombre">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Precio Venta</label>
                    <input type="tel" class="form-control" name="precio_venta" value="${producto.precio_venta}" placeholder="Escriba Precio Venta">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Precio Compra</label>
                    <input type="tel" class="form-control" name="precio_compra" value="${producto.precio_compra}" placeholder="Escriba Precio Compra">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Fecha Vencimiento</label>
                    <input type="text" class="form-control" name="fecha_vencimiento" value="${producto.fecha_vencimiento}" placeholder="Escriba Fecha Vencimiento">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Stock</label>
                    <input type="number" class="form-control" name="stock" value="${producto.stock}" placeholder="Escriba Stock">
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">Codigo Categoria</label>
                    <select name="codigo_categoria" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_categoria}">
                            <option value="${item.codigo_categoria}" 
                                    <c:if test="${producto.codigo_categoria == item.codigo_categoria}">
                                        selected
                                    </c:if>>${item.nombre_categoria}</option>
                        </c:forEach> 
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Codigo Proveedor</label>
                    <select name="codigo_proveedor" class="form-control">
                        <option valu="">--Seleccione--</option>
                        <c:forEach var="item" items="${lista_proveedor}">
                            <option value="${item.codigo_proveedor}" 
                                    <c:if test="${producto.codigo_proveedor == item.codigo_proveedor}">
                                        selected
                                    </c:if>>${item.nombre_proveedor}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
