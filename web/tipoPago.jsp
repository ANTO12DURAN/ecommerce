<%-- 
    Document   : tipoPago
    Created on : 25-may-2020, 12:46:14
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
    </head>
    <body>
        <h1>Tipo de Pago!</h1>
        <h2>Tienes 2 tipos de Pago:</h2>
        <br><h3>Efectivo: Este metodo se realiza contra/Entrega, con ello pagas tus productos cuando los recibes.</h3>
        <br><h3>Tranferencia: Por los momentos manejamos Bancolombia</h3>
        
        <label>Selecciona tu tipo de Pago!!</label>
        <br>
      <div class="container mt-8">
            <div class="row">
                <form action="Controlador.do" method="POST" enctype="multipart/form-data">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>FORMA DE PAGO</h4>
                        </div>
                        <div class="card-body text-center">
                          
                            <label>Pago:</label>
                            <select name="txtTipoPago">
                                    <option value="1">EFECTIVO</option>
                                    <option value="2">TRANSFERENCIA</option>
                            </select>
                            
                            
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
              
                                <input type="reset" value="Limpiar campos">
                                
                                <input type="submit" name="accion" value="Pago">
                                <input type="submit" name="accion" value="Regresar"><br>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>           
            </div>
        </div> 
        
    </body>
</html>
