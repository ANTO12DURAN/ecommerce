<%-- 
    Document   : LoginUsuario
    Created on : 21-may-2020, 23:53:05
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body>
        
        
        <div class="container mt-8">
            <div class="row">
                <form action="Validar.do" method="POST" enctype="multipart/form-data">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Ingresar Al Sistema</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdProducto" value="${producto.getIdProducto()}">
                            <label>CODIGO:</label>
                            <input type="text" name="txtCodigo"><br>
                            <label>CLAVE:</label>
                            <input type="password" name="txtClave"><br>
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
              
                                <input type="reset" value="Limpiar campos">
                                <input type="submit" name="accion" value="Ingresar">
                                <input type="submit" name="accion" value="Regresar"><br>
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>           
            </div>
        </div> 
        
        
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
