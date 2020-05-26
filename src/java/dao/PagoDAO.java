
package dao;

import configuracion.ConectaBD;
import dto.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PagoDAO {
    
    PreparedStatement ps;
    ResultSet rs; 
    
    private static final ConectaBD cn = ConectaBD.abrir();
    
    public Pago consultar(int idPago){
        Pago pago=new Pago();
        String sql="SELECT * FROM pago WHERE idpago=?";
        try {
        ps = cn.getCon().prepareStatement(sql);
        ps.setInt(1, idPago);
        rs = ps.executeQuery(); 
        while(rs.next()){
            pago.setIdPago(rs.getInt(1));
            pago.setDescripcion(rs.getString(2));
        }
        } catch (Exception e) {
        }finally{
            cn.cerrar();
        }
        return pago;
    }
    
    //prueba de comandos  
   
}
