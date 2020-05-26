<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : agregarProducto
    Created on : 17-may-2020, 15:35:13
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Producto</title>
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
      
      <ul class="navbar-nav">
           <li class="nav-item">
               <a class="nav-link" href="#">
               </a> 
            </li>
          <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            ${usuario.getNombre()} Bienvenido al sistema
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador.do?accion=Salir">salir</a>
        </div>
      </li>
      </ul>
  </div>
</nav>
        
       
        <table>
            <tbody>
                <tr>
                    <td>
        <div class="container mt-8">
            <div class="row">
                <form action="Validar.do" method="POST" enctype="multipart/form-data">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Agregar Producto</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdProducto" value="${producto.getIdProducto()}">
                            <label>CODIGO:</label>
                            <input type="text" name="txtCodigo" value="${producto.getCodProducto()}"><br>
                            <label>NOMBRE:</label>
                            <input type="text" name="txtNombre" value="${producto.getNombre()}"><br>
                            <label>IMAGEN:</label>
                            <input type="file" name="fileImagen" value="${producto.getImagen()}"><br>
                            <label>DESCRIPCION:</label>
                            <input type="text" name="txtDescripcion" value="${producto.getDescripcion()}"><br>
                            <label>PRECIO:</label>
                            <input type="text" name="txtPrecio" value="${producto.getPrecio()}"><br>
                            <label>STOCK:</label>
                            <input type="text" name="txtStock" value="${producto.getStock()}"><br>
                            <label>CATEGORIA:</label>
                            <select name="txtCategoria" value="${producto.getIdCategoria()}">
                                <option>1</option>
                                <option>2</option>
                            </select>
                            
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
              
                                <input type="reset" value="Limpiar campos">
                                <input type="submit" name="accion" value="Guardar">
                                <input type="submit" name="accion" value="Actualizar"><br>
                                <input type="submit" name="accion" value="Listar">
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>           
            </div>
        </div>  
                        
                    </td>
                    <td>
                        <div class="container mt-4">
                            <form action="Validar.do" method="POST">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>CODIGO</th>
                                    <th>NOMBRE</th>
                                    <th>IMAGEN</th>
                                    <th>DESCRIPCION</th>
                                    <th>PRECIO</th>
                                    <th>STOCK</th>
                                    <th>CATEGORIA</th>
                                    <th>STATUS</th>
                                    <th>ACCION</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="p" items="${productos}">
                                <tr>
                                    <td>${p.getIdProducto()}</td>
                                    <td>${p.getCodProducto()}</td>
                                    <td>${p.getNombre()}</td>
                                    <td>
                                        <img src="ControladorProductoImg.do?id=${p.getIdProducto()}" width="80" height="60"/>
                                    </td>
                                    <td>${p.getDescripcion()}</td>
                                    <td>${p.getPrecio()}</td>
                                    <td>${p.getStock()}</td>
                                    <td>${p.getIdCategoria()}</td>
                                    <td>${p.getStatus()}</td>
                                    <td>
                                        <form action="Validar.do" method="POST">
                                        <input type="hidden" name="id" value="${p.getIdProducto()}" >
                                        <input type="submit" name="accion" value="Editar">
                                        <input type="submit" name="accion" value="Eliminar">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </form>      
                        </div>
                        
                    </td>
                </tr>
              
            </tbody>
        </table>

        
        
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
