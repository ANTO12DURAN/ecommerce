$(document).ready(function(){
    $("tr #btnEliminar").click(function(){
        var idp=$(this).parent().find("#idp").val();
                swal({
          title: "¿Esta seguro de Eliminar?",
          text: "una vez eliminado, Ud puede agregarlo de nuevo!",
          icon: "warning",
          buttons: true,
          dangerMode: true,
        })
        .then((willDelete) => {
          if (willDelete) {
               Eliminar(idp);
            swal("¡Articulo eliminado de la lista!", {
              icon: "success",
            }).then((willDelete)=>{
                if(willDelete){
                  parent.location.href="Controlador.do?accion=Carrito"  
                }
            });
          } else {
            swal("Registro no fue eliminado!");
          }
        });
       
    });
    function Eliminar(idp){
        var url="Controlador.do?accion=Delete";
        $.ajax({
            type: 'post',
            url: url,
            data: "idp="+idp,
            success: function(data,textStatus,jqXHR){
               
            }
        })
    }
    
    
});


