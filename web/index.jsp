<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>La Tiendita</title>
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
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                <br>
                     <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h2>${p.getNombre()}</h2>
                        </div>
                        <div class="card-body text-center">
                            <i>$.${p.getPrecio()}</i><br>
                            <img src="ControladorProductoImg.do?id=${p.getIdProducto()}" width="200" height="180"/>
                        </div>
                        <div class="card-footer text-center">
                            <label>${p.getDescripcion()}</label>
                            <div>
                                <a href="Controlador.do?accion=AgregarCarrito&id=${p.getIdProducto()}" class="btn btn-outline-info">Agregar Carrito</a>
                                <a href="Controlador.do?accion=Comprar&id=${p.getIdProducto()}" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
                           
                </c:forEach>            
            </div>
        </div> 
        
    <footer>
        <div class="text-center">
            <br>
            <a href="Validar.do?accion=LoginUsuario">Administrador</a>
        </div>
    </footer>
        
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
