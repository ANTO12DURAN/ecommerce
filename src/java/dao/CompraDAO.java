
package dao;

import configuracion.ConectaBD;
import dto.Carrito;
import dto.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CompraDAO {
    PreparedStatement ps;
    ResultSet rs;
     
    private static final ConectaBD cn = ConectaBD.abrir();
     
   int idCompra;
    int r;
    String sql;
    
     
    public String GenerarSerie(){
        String numeroSerie="";
        String sql="SELECT max(nroserie) FROM compra";
        try {
            ps=cn.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroSerie=rs.getString(1);
            }  
        } catch (Exception e) {
        }finally{
            cn.cerrar();
        }
        return numeroSerie;
    } 
    
    public String IdCompras(){
        String idCompra="";
        sql="SELECT max(idCompra) FROM Compra";
        try {
             ps=cn.getCon().prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
                 idCompra=rs.getString(1);
             }
        } catch (Exception e) {
        }
        return idCompra;
}
   public int GenerarCompra(Compra c){
        sql="INSERT INTO compra(idcliente, idpago, idestado, montototal, fecha, nroserie) VALUES(?,?,?,?,?,?)";
        try {
              ps=cn.getCon().prepareStatement(sql);
              ps.setInt(1, c.getIdCliente());
              ps.setInt(2, c.getIdPago());
              ps.setInt(3, c.getIdEstado());
              ps.setDouble(4, c.getMontoTotal());
              ps.setString(5, c.getFechaCompra());
              ps.setString(6, c.getNroSerie());
              ps.executeUpdate(); 
       } catch (Exception e) {
       }
       return r;
   }
   public int GuardarDetalleCompra(Compra c, Carrito car){
       sql="INSERT INTO detalle(idcompra,idproducto,cantidad,subtatol) VALUES(?,?,?,?)";
        try {
            ps=cn.getCon().prepareStatement(sql);
            ps.setInt(1, c.getIdCompra());
            ps.setInt(2, car.getIdProducto());
            ps.setInt(3, car.getCantidad());
            ps.setDouble(4, car.getSubtotal());
            ps.executeUpdate(); 
       } catch (Exception e) {
       }
       
       return r;
   }
   
   //***********Lista Compra*******//
   public Compra listarIdCompra(int idCompra){
      Compra c=new Compra();
      sql="SELECT * FROM compra WHERE idcompra=?";
       try {
            ps=cn.getCon().prepareStatement(sql);
            ps.setInt(1, idCompra);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCompra(rs.getInt(1));
                c.setIdCliente(rs.getInt(2));
                c.setIdPago(rs.getInt(3));
                c.setIdEstado(rs.getInt(4));
                c.setMontoTotal(rs.getDouble(5));
                c.setFechaCompra(rs.getString(6));
                c.setNroSerie(rs.getString(7));
            }
       } catch (Exception e) {
       }
       return c;   
   }
 
    
}