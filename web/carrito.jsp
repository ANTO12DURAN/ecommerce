<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                   display: none; 
                } 
            }
        </style>
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
        <a class="nav-link" href="Controlador.do?accion=Home">Home <span class="sr-only">(current)</span></a>
      </li>
     
      <li class="nav-item">
          <a class="nav-link" href="Controlador.do?accion=defaul">Seguir Comprando</a>
      </li>
    </ul>
    
      <ul class="navbar-nav">
           <li class="nav-item">
               <div class="d-flex">
               <a class="nav-link" href="Controlador.do?accion=Salir">
                   salir
               </a> 
               </div>
               
            </li>
      </ul>
     
  </div>
</nav>
        <br>
        
        
        
        <div class="d-flex">
            <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <form action="Controlador.do" method="POST">
                                <label>INGRESAR DATOS:</label>
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-outline-info">
                            <input type="submit" name="accion" value="Modificar" class="btn btn-outline-info">
                            </form>
                        </div>
                        <div class="card-body">
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Cliente:</label>     
                                </div>
                            <div class="col-sm-9">
                                <input type="text" value="${cliente.getNombre()} ${cliente.getApellido()}" readonly="" class="form-control ">
                            </div>  
                            </div>
                            
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Ced/Pass:</label>     
                                </div>
                            <div class="col-sm-9">
                                <input type="text" value="12345" readonly="" class="form-control ">
                            </div>  
                            </div>
                            
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Correo:</label>     
                                </div>
                            <div class="col-sm-9">
                                <input type="text" value="${cliente.getCorreo()} " readonly="" class="form-control ">
                            </div>  
                            </div>
                            
                             <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Telefono:</label>     
                                </div>
                            <div class="col-sm-9">
                                <input type="text" value="${cliente.getTelefono()} " readonly="" class="form-control ">
                            </div>  
                            </div>
                            
                             <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Direccion:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <textarea name="txtDireccion" rows="4" cols="20" readonly="" class="form-control">
                                        ${cliente.getDireccion()}
                                     </textarea>
                            </div>  
                            </div>
                            
                            
                        </div>
                        
                    </div>
            </div> 
                            
                            
            <div class="d-flex"> 
           
            
                <div class="col-sm-12">
                    
                    <div class="card">
                        
                        <div class="card-body">
                            <div class="d-flex">
                                <div class="col-sm-2 mr-auto">
                                <label>Fecha :</label>
                                <input type="text" name="txtFecha" value="hoy" readonly="" class="form-control mr-auto">  
                                </div>
                                <div class="col-sm-3 ml-auto">
                                 <label>Nro.Control :</label>
                                <input type="text" name="txtNroSerie" value="${nroserie}" readonly="" class="form-control ml-auto">
                                </div>     
                            </div>
                             <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>ARTICULO</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>SUBTOTAL</th>
                                <th class="accion">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                            <tr>
                                <td>${car.getItem()}</td>
                                <td>${car.getIdProducto()}</td>
                                <td>${car.getDescripcion()}</td>
                                <td>$.${car.getPrecioCompra()}0</td>
                                <td>
                                    <center>${car.getCantidad()}</center>    
                        <%--
                                    <input type="hidden" id="idpro" value="${car.getIdProducto()}">
                                    <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                        --%>   
                                </td>
                                <td>$.${car.getSubtotal()}0</td>
                                <td class="parte01">
                                    <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                    <a href="#" id="btnEliminar" >Eliminar</a>
                                   
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                        </div>
                        <div class="card-footer">
                               <div class="d-flex">
                        <div class="col-sm-8">
                            <label>SubTotal:</label>     
                        </div>
                    <div class="col-sm-4">
                        <input type="text" value="$.${totalPagar}0" readonly="" class="form-control ">
                    </div>  
                    </div>
                    
                    <div class="d-flex">
                        <div class="col-sm-8">
                            <label>Costo de Envio:</label> 
                        </div>
                         <div class="col-sm-4">
                            <input type="text" value="$.0.00" readonly="" class="form-control">
                        </div>
                        
                    </div>
                     <div class="d-flex">
                        <div class="col-sm-8">
                             <label>Total a Pagar:</label>
                        </div>
                         <div class="col-sm-4">
                            <input type="text" value="$.${totalPagar}0"  readonly="" class="form-control">
                        </div>
                     </div>
                       
                        <div class="card-footer"> 
                             <div class="d-flex">
     
                                
                                 <div class="col-sm-5">
                                     <a href="Controlador.do?accion=TipoPago" class="btn btn-outline-info">
                                         Tipo de Pago
                                     </a>
                                </div> 
                                 <div class="col-sm-3">
                                     <input type="text" name="txtIdPago" value="${pago.getDescripcion()}"  readonly="" class="form-control">
                                </div>
                                <div class="col-sm-3">
  
                                    <input type="hidden" value="${pago.getIdPago()}"  readonly="" class="form-control">   
                                </div>                              
                            </div>
                        </div>
                        
                        
                        </div>
                        
                    </div>
                        <br>
                            <div class="col-sm-4">
                                 <a href="Controlador.do?accion=GenerarCompra" class="btn btn-danger btn-block text-center">Generar Compra</a>
                                
                            </div>
               
            </div> 
                           
                    </div>
                   
                       
                                  </div>   
                                 <div class="col-sm-4">
                                 <a href="#" onclick="print()" class="btn btn-danger btn-outline-info text-center">Imprimir</a>
                                
                                  </div>   
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/funciones.js" type="text/javascript"></script>
<script src="js/funcionCantidadCarrito.js" type="text/javascript"></script>
    </body>
</html>
