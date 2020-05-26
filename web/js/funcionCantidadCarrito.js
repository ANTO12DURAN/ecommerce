$(document).ready(function(){
$("tr #Cantidad").click(function(){
        var idp=$(this).parent().find("#idpro").val();
        var cant=$(this).parent().find("#Cantidad").val();
         Actualizar(idp, cant);
        function Actualizar(idp, cant){
            var url="Controlador.do?accion=ActualizarCantidad";
             $.ajax({
            type: 'post',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function(data,textStatus,jqXHR){
               location.href="Controlador.do?accion=Carrito";
            }
        })
        }
        
       
    });
});



