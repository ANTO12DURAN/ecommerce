/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.javafx.scene.control.skin.DoubleFieldSkin;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import dto.Producto;
import dto.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Validar extends HttpServlet {

    ProductoDAO pdao=new ProductoDAO();
    ArrayList<Producto> productos=new ArrayList<>();
    Producto p=new Producto();
    String status="A";
    
    UsuarioDAO usudao=new UsuarioDAO();
    ArrayList<Usuario> usuarios=new ArrayList<>();
    Usuario usu=new Usuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion= request.getParameter("accion");
        
        productos = pdao.listarProducto();
        int idp;
        
        
        switch(accion){
            case "LoginUsuario":
                request.getRequestDispatcher("loginUsuario.jsp").forward(request, response);
                break;
            case "Regresar":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Ingresar":
                //recibimos datos de la vista
                String codigoUsuario=request.getParameter("txtCodigo");
                String clave=request.getParameter("txtClave");
           
                usu = usudao.validarUsuario(codigoUsuario,clave);
                
                if(usu.getCodigo()!=null){
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request, response);  
                }
                  
                break;
            case "AgregarProducto":
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                break;
            case "Listar":
                productos= pdao.listar();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                break;
            case "Guardar":
                status="A";
                //recibo los datos de la vista 
                //int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
                String codigo = request.getParameter("txtCodigo");
                String nombre = request.getParameter("txtNombre");
                Part part = request.getPart("fileImagen");
                InputStream flujoEntrada = part.getInputStream();
                String descripcion = request.getParameter("txtDescripcion");
                double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock = Integer.parseInt(request.getParameter("txtStock"));
                int idCategoria = Integer.parseInt(request.getParameter("txtCategoria"));
                //comparamos con modelos 
                //p.setIdProducto(idProducto);
                p.setCodProducto(codigo);
                p.setNombre(nombre);
                p.setImagen(flujoEntrada);
                p.setDescripcion(descripcion);
                p.setPrecio(precio);
                p.setStock(stock);
                p.setIdCategoria(idCategoria);
                p.setStatus(status);
               if( pdao.Agregar(p)){
                    request.getRequestDispatcher("Validar.do?accion=Listar").forward(request, response);
               }
                     request.getRequestDispatcher("errorAgregarProducto.jsp").forward(request, response);
                break;
            case "Editar": //solo edita los productos activos los eliminados pailas
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarIdProducto(idp);
                request.setAttribute("producto", p);
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                break;
            case "Eliminar":
                idp = Integer.parseInt(request.getParameter("id"));
                p.setIdProducto(idp);
                pdao.Eliminar(p);
                request.getRequestDispatcher("Validar.do?accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                 status="A";
                //recibo los datos de la vista 
                int idProducto1 = Integer.parseInt(request.getParameter("txtIdProducto"));
                String codigo1 = request.getParameter("txtCodigo");
                String nombre1 = request.getParameter("txtNombre");
                Part part1 = request.getPart("fileImagen");
                InputStream flujoEntrada1 = part1.getInputStream();
                String descripcion1 = request.getParameter("txtDescripcion");
                double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                int idCategoria1 = Integer.parseInt(request.getParameter("txtCategoria"));
                //comparamos con modelos 
                p.setIdProducto(idProducto1);
                p.setCodProducto(codigo1);
                p.setNombre(nombre1);
                p.setImagen(flujoEntrada1);
                p.setDescripcion(descripcion1);
                p.setPrecio(precio1);
                p.setStock(stock1);
                p.setIdCategoria(idCategoria1);
                p.setStatus(status);
                pdao.Actualizar(p);
                request.getRequestDispatcher("Validar.do?accion=Listar").forward(request, response);
                break;
            default:
                
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
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
