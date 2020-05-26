package dao;

import configuracion.ConectaBD;
import dto.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ProductoDAO {
    PreparedStatement ps;
     ResultSet rs;
    int r;
     
     private static final ConectaBD cn = ConectaBD.abrir();
     
     public ArrayList<Producto> listarProducto(){
         
         ArrayList<Producto> productos=new ArrayList<>();
         String sql="SELECT * FROM producto WHERE status='A'"; // falta where status='A' lo quite para pruebas
         try {
            ps = cn.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto pro=new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setCodProducto(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setImagen(rs.getBinaryStream(4));
                pro.setDescripcion(rs.getString(5));
                pro.setPrecio(rs.getDouble(6));
                pro.setStock(rs.getInt(7));
                pro.setIdCategoria(rs.getInt(8));
                pro.setStatus(rs.getString(9));
                productos.add(pro);
            }
         } catch (Exception e) {
            System.out.println("No se encontro Registro");
            e.printStackTrace();
         }finally{
             cn.cerrar();
         }
        return productos; 
     } 
     public ArrayList<Producto> listar(){
         
         ArrayList<Producto> productos=new ArrayList<>();
         String sql="SELECT * FROM producto"; // falta where status='A' lo quite para pruebas
         try {
            ps = cn.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto pro=new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setCodProducto(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setImagen(rs.getBinaryStream(4));
                pro.setDescripcion(rs.getString(5));
                pro.setPrecio(rs.getDouble(6));
                pro.setStock(rs.getInt(7));
                pro.setIdCategoria(rs.getInt(8));
                pro.setStatus(rs.getString(9));
                productos.add(pro);
            }
         } catch (Exception e) {
            System.out.println("No se encontro Registro");
            e.printStackTrace();
         }finally{
             cn.cerrar();
         }
        return productos; 
     } 
     
     public void listarProductoImg(int idProducto, HttpServletResponse response){
         String sql="SELECT * FROM producto WHERE idproducto="+idProducto;
         InputStream flujoEntrada = null;
         OutputStream flujoSalida = null;
         BufferedInputStream almacenadoFlujoEntrada = null;
         BufferedOutputStream almacenadoFlujoSalida = null;
         response.setContentType("imagen/*"); //?
              try {
             flujoSalida = response.getOutputStream();     
             ps = cn.getCon().prepareStatement(sql);
             rs = ps.executeQuery();
             if(rs.next()){
                flujoEntrada = rs.getBinaryStream("imagen"); //nombre en la bd
            }
            almacenadoFlujoEntrada = new BufferedInputStream(flujoEntrada);
            almacenadoFlujoSalida = new BufferedOutputStream(flujoSalida);
            int i = 0; 
            while((i=almacenadoFlujoEntrada.read())!= -1){
            almacenadoFlujoSalida.write(i);
        }
         } catch (Exception e) {
         }
     }
     public Producto listarIdProducto(int idProducto){
      String sql="SELECT * FROM producto WHERE idproducto="+idProducto;
      Producto pro=new Producto();
         try {
             ps = cn.getCon().prepareStatement(sql); 
             rs = ps.executeQuery();
             while(rs.next()){                
                pro.setIdProducto(rs.getInt(1));
                pro.setCodProducto(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setImagen(rs.getBinaryStream(4));
                pro.setDescripcion(rs.getString(5));
                pro.setPrecio(rs.getDouble(6));
                pro.setStock(rs.getInt(7));
                pro.setIdCategoria(rs.getInt(8));
                pro.setStatus(rs.getString(9));
             }
         } catch (Exception e) {
         }finally{
             cn.cerrar();
         }
         return pro;
     }
     
     public int ActualizarStock(int idProducto, int stock){
         String sql="UPDATE producto SET stock=? WHERE idproducto=?";
         try {
              ps = cn.getCon().prepareStatement(sql);
              ps.setInt(1, stock);
              ps.setInt(2, idProducto);
              ps.executeUpdate();
              
              
         } catch (Exception e) {
         }return r;
     }
     
     //**********Operaciones  CRUD ************************//
     
     public boolean Agregar(Producto p){
         String sql="INSERT INTO producto(codigo, nombre, imagen, descripcion, precio, stock, idcategoria, status) VALUES(?,?,?,?,?,?,?,?)";
         try {
             ps=cn.getCon().prepareStatement(sql);
             ps.setString(1, p.getCodProducto());
             ps.setString(2, p.getNombre());
             ps.setBlob(3, p.getImagen());
             ps.setString(4, p.getDescripcion());
             ps.setDouble(5, p.getPrecio());
             ps.setInt(6, p.getStock());
             ps.setInt(7, p.getIdCategoria());
             ps.setString(8, p.getStatus());
             ps.executeUpdate();
             return true;
         } catch (Exception e) {
         }finally{
             cn.cerrar();
         } 
         return false;
     }
     public boolean Actualizar(Producto p){
         String sql="UPDATE producto SET codigo=?, nombre=?, imagen=?, descripcion=?, precio=?, stock=?  WHERE idproducto=?";
           int r=0;   
         try {
             ps=cn.getCon().prepareStatement(sql);
             ps.setString(1, p.getCodProducto());
             ps.setString(2, p.getNombre());
             ps.setBlob(3, p.getImagen());
             ps.setString(4, p.getDescripcion());
             ps.setDouble(5, p.getPrecio());
             ps.setInt(6, p.getStock());
             ps.setInt(7, p.getIdProducto());
             r=ps.executeUpdate();
             if(r==1){
                return true;
            }else{
                return false;
            }
         } catch (Exception e) {
         }finally{
                cn.cerrar();
            }
         return false;
     }
     public boolean Eliminar(Producto p){
         String sql="UPDATE producto SET status='E' WHERE idproducto=?";
           try {
              ps=cn.getCon().prepareStatement(sql);
              ps.setInt(1,p.getIdProducto());
                ps.executeUpdate();
             return true;
         } catch (Exception e) {
         }finally{
               cn.cerrar();
           }
         return false;
     }
   //prueba de comandos  
   /* public static void main (String[] args){
        ProductoDAO pdao=new ProductoDAO();
        for (Producto p : pdao.listarProducto()) {
            System.out.println(p.getNombre());
        }
    }
    */
}
