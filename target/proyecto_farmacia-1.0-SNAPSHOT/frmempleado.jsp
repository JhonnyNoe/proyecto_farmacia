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
            <h1>Formulario de Empleados</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <form action="EmpleadoControlador" method="post">
                <input type="hidden" name="codigo_empleado" value="${empleado.codigo_empleado}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${empleado.nombre}" placeholder="Escriba su nombre">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Direccion</label>
                    <input type="text" class="form-control" name="direccion" value="${empleado.direccion}" placeholder="Escriba su direccion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cargo</label>
                    <input type="text" class="form-control" name="cargo" value="${empleado.cargo}" placeholder="Escriba su cargo">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Edad</label>
                    <input type="number" class="form-control" name="edad" value="${empleado.edad}" placeholder="Escriba su edad">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Telefono</label>
                    <input type="number" class="form-control" name="telefono" value="${empleado.telefono}" placeholder="Escriba su telefono">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Sueldo</label>
                    <input type="tel" step="any" class="form-control" name="sueldo" value="${empleado.sueldo}" placeholder="Escriba su sueldo">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
