<%-- 
    Document   : carritoSinProducto
    Created on : 24-may-2020, 13:17:47
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ups...El carrito no tiene Productos!</h1>
        
        <div class="d-flex">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador.do" method="POST">
               <label>Agrega tus productos</label>
               <input type="submit" name="accion" value="Regresar" class="btn btn-danger"> 
                    </form>
                </div>   
            </div>
            
            
                
        </div>
    </body>
</html>
