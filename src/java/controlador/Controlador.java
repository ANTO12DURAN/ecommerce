
package controlador;

import configuracion.GenerarSerie;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DetalleDAO;
import dao.PagoDAO;
import dao.ProductoDAO;
import dto.Carrito;
import dto.Cliente;
import dto.Compra;
import dto.Detalle;
import dto.Pago;
import dto.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class Controlador extends HttpServlet {

    ProductoDAO pdao=new ProductoDAO();
    ArrayList<Producto> productos=new ArrayList<>();
    Producto p=new Producto();
    
    ArrayList<Carrito> listaCarrito=new ArrayList<>();
    Carrito car;
    double totalPagar=0.0;
    
    ArrayList<Detalle> listaDetalle=new ArrayList<>();
    DetalleDAO ddao=new DetalleDAO();
    Detalle detalle;
    
    ClienteDAO cldao=new ClienteDAO();
    ArrayList<Cliente> clientes=new ArrayList<>();
    Cliente cl=new Cliente();
    
    CompraDAO cdao=new CompraDAO();
    Compra c=new Compra();
    String numeroserie;
    
    PagoDAO tpdao=new PagoDAO();
    Pago pago=new Pago();
    int Pago;
    
    String status="A";
    int cantidad=1;
    int item=1;
    int pos;
    int idp;
    int res=0;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion= request.getParameter("accion");
 
        productos = pdao.listarProducto();
 
        switch(accion){
            case "Home":
                
                request.setAttribute("productos", productos);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break; 
            case "AgregarProducto":
                request.setAttribute("Cliente", cl);
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                pos=0; //para saber la posicion
                cantidad=1;
                idp=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarIdProducto(idp); //buscamos
                if(listaCarrito.size()>0){
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos=i; //estamos conociendo la posicion del producto seleccionado
                        }
                    }
                    if(idp==listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    }else{
                        item= item+1;
                        car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                        car.setItem(item);
                        car.setIdProducto(p.getIdProducto());
                        car.setNombre(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad *p.getPrecio());
                        listaCarrito.add(car);
                    }
                }else{
                item= item+1;
                car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad *p.getPrecio());
                listaCarrito.add(car);    
                } 
                request.setAttribute("pago", pago);
                request.setAttribute("cliente", cl);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador.do?accion=Home").forward(request, response);
                break;
            case "Carrito":
                if(listaCarrito.size()==0){
                    request.getRequestDispatcher("carritoSinProducto.jsp").forward(request, response);
                }else
                totalPagar=0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                }
                 
                numeroserie = cdao.GenerarSerie();
                if(numeroserie==null){
                    numeroserie="00000001";
                    request.setAttribute("nroserie", numeroserie);
                } else{
                    int incrementar=Integer.parseInt(numeroserie);
                    GenerarSerie gs=new GenerarSerie();
                    numeroserie= gs.NumeroSerie(incrementar);
                    request.setAttribute("nroserie", numeroserie);
                }
                
                request.setAttribute("cliente", cl);
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                request.setAttribute("nroserie", numeroserie);
                break;
            case "Comprar":
                totalPagar=0.0;
              idp = Integer.parseInt(request.getParameter("id"));
              p=pdao.listarIdProducto(idp);
             
              
               pos=0; //para saber la posicion
                cantidad=1;
                idp=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarIdProducto(idp); //buscamos
                if(listaCarrito.size()>0){
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos=i; //estamos conociendo la posicion del producto seleccionado
                        }
                    }
                    if(idp==listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                         for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                }
                    }else{
                        item= item+1;
                        car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                        car.setItem(item);
                        car.setIdProducto(p.getIdProducto());
                        car.setNombre(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad *p.getPrecio());
                        listaCarrito.add(car);
                         for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                }
                    }
                }else{
                item= item+1;
                car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad *p.getPrecio());
                listaCarrito.add(car);    
                 for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                }
                }  
                 
                numeroserie = cdao.GenerarSerie();
                if(numeroserie==null){
                    numeroserie="00000001";
                    request.setAttribute("nroserie", numeroserie);
                } else{
                    int incrementar=Integer.parseInt(numeroserie);
                    GenerarSerie gs=new GenerarSerie();
                    numeroserie= gs.NumeroSerie(incrementar);
                    request.setAttribute("nroserie", numeroserie);
                }
               
                request.setAttribute("nroserie", numeroserie);
                request.setAttribute("cliente", cl);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "Delete":
                int idproducto= Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; listaCarrito.size() < 10; i++) {
                    if(listaCarrito.get(i).getIdProducto()==idproducto){
                        listaCarrito.remove(i);
                    }
                }
                
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "GenerarCompra": 
                //actualiza el stock del producto
                  for (int i = 0; i < listaCarrito.size(); i++) {
                    p=new Producto();
                    int cantidad=listaCarrito.get(i).getCantidad();
                    int idProducto=listaCarrito.get(i).getIdProducto();
                    pdao=new ProductoDAO();
                    p=pdao.listarIdProducto(idProducto);
                    int stockActual= (p.getStock() - cantidad);
                    pdao.ActualizarStock(idProducto, stockActual);
                }          
                
                //guardar compra
                if(cl.getIdCliente()==0){
                    request.getRequestDispatcher("loginCliente.jsp").forward(request, response);
                }
                if(pago.getIdPago()== 0){
                        request.getRequestDispatcher("tipoPago.jsp").forward(request, response);
                    }    
               c.setIdCliente(cl.getIdCliente());
               c.setIdPago(pago.getIdPago());
               c.setIdEstado(1);                  //proximas entregas rastreo de la compra...pendiente, en proceso, entregado, cancelado,
               c.setMontoTotal(totalPagar);
               c.setFechaCompra("23-15-2020");
               c.setNroSerie(numeroserie);
               res=cdao.GenerarCompra(c);
                
                //guardar detalle 
             int idc=Integer.parseInt(cdao.IdCompras());
                for (int i = 0; i < listaCarrito.size(); i++) {
                    car=new Carrito();
                    c.setIdCompra(idc);
                    car.setIdProducto(listaCarrito.get(i).getIdProducto());
                    car.setCantidad(listaCarrito.get(i).getCantidad());
                    car.setSubtotal(listaCarrito.get(i).getSubtotal());
                    res=cdao.GuardarDetalleCompra(c, car);   
                }
               
               //guardar detalle 
             
               
                //revisar este comando.... :-/
                if(res==0){
                    request.getRequestDispatcher("Controlador.do?accion=ImprimirComprobante").forward(request, response);
                } else
                    request.getRequestDispatcher("errorGenerarCompra.jsp").forward(request, response);
                        
                 
                break;
            case "ImprimirComprobante":
                request.getRequestDispatcher("imprimirComprobante.jsp").forward(request, response);
                break;
            case "Ingresar":
                request.getRequestDispatcher("loginCliente.jsp").forward(request, response);
                break;
            case "RegistroCliente":
                request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
                break;
            case "Regresar":
                request.getRequestDispatcher("Controlador.do?accion=Home").forward(request, response);
                break;
                case "Aceptar": 
            String correo=request.getParameter("txtCorreo");
            String clave=request.getParameter("txtClave"); 
             
            cl = cldao.consultar(correo, clave);
            if(cl.getCorreo()!=null){
                request.setAttribute("cliente", cl);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.setAttribute("productos", productos);
                
                request.getRequestDispatcher("Controlador.do?accion=Carrito").forward(request, response);  
            } else
                request.getRequestDispatcher("Controlador.do?accion=Ingresar").forward(request, response);
                    break;
            case "Guardar":
                status="A";
                //recibo los datos de la vista 
                String nombre=request.getParameter("txtNombre");
                String apellido=request.getParameter("txtApellido");
                String correoCliente=request.getParameter("txtCorreo");
                String claveCliente=request.getParameter("txtClave");
                
                cl.setNombre(nombre);
                cl.setApellido(apellido);
                cl.setCorreo(correoCliente);
                cl.setClave(claveCliente);
                cl.setStatus(status);
                if(cldao.Agregar(cl)){
                     request.getRequestDispatcher("Controlador.do?accion=Home").forward(request, response);
                } else
                     request.getRequestDispatcher("errorGuardarCliente.jsp").forward(request, response);
                   
                  break;
            case "TipoPago":
                request.getRequestDispatcher("tipoPago.jsp").forward(request, response);
                break;
            case "Pago":
                //leemos la vista
                int tPago=Integer.parseInt(request.getParameter("txtTipoPago"));
                pago= tpdao.consultar(tPago);
                   if(pago!=null){
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("Controlador.do?accion=Carrito").forward(request, response); 
                   }  else
                request.getRequestDispatcher("Controlador.do?accion=Pago").forward(request, response);
                 
                break;
            case "Salir":
                String correo1 = null;
                String clave1 = null;
                cl = cldao.consultar(correo1, clave1);
                request.setAttribute("cliente", cl);
                request.getRequestDispatcher("Controlador.do?accion=Carrito").forward(request, response);
                break;
            default:
                
              
                request.setAttribute("nroserie", numeroserie);
                request.setAttribute("cliente", cl);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
