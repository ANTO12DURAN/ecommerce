
package dao;

import configuracion.ConectaBD;
import dto.Detalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DetalleDAO {
     PreparedStatement ps;
    ResultSet rs;
     String sql;
     int r;
    private static final ConectaBD cn = ConectaBD.abrir();
    
    public int GuardarDetalleCompra(Detalle d){
       sql="INSERT INTO detalle(idcompra,idproducto,cantidad,subtatol) VALUES(?,?,?,?)";
        try {
            ps=cn.getCon().prepareStatement(sql);
            //ps.setInt(1, d.getIdDetalle()); auto-incrementable
            ps.setInt(1, d.getIdCompra());
            ps.setInt(2, d.getIdCompra());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getSubtotal());
            
            ps.executeUpdate(); 
       } catch (Exception e) {
       }
       
       return r;
   }
}
