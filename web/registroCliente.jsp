<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">La tiendita</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Controlador.do?accion=Home">Home</a>
      </li>
      <li class="nav-item">
           <a class="nav-link" href="Controlador.do?accion=Carrito"><i class="fas fa-cart-plus">(<label style="color: darkorange">${contador}</label>)</i>Carrito</a>
      </li>
    </ul>
      
     
  </div>
</nav>
        
      <br>
      
              <div class="container mt-8">
            <div class="row">
                <form action="Controlador.do" method="POST">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Registro Cliente</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdCliente">
                            <label>NOMBRE:</label>
                            <input type="text" name="txtNombre"><br>
                            <label>APELLIDO:</label>
                            <input type="text" name="txtApellido"><br>
                            <label>CORREO:</label>
                            <input type="email" name="txtCorreo"><br>
                            <label>CLAVE:</label>
                            <input type="password" name="txtClave"><br>
                        </div>
                        <div class="card-footer text-center">
                            <div>
                                <input type="reset" value="Limpiar campos">
                                <input type="submit" name="accion" value="Guardar"><br>
                                
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    </body>
</html>

