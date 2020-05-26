
package dao;

import configuracion.ConectaBD;
import dto.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    PreparedStatement ps;
    ResultSet rs; 
    
    private static final ConectaBD cn = ConectaBD.abrir();
    
    public boolean Agregar(Cliente cl){
        String sql="INSERT INTO cliente(nombre, apellido, correo, clave, status, telefono, direccion)VALUES(?,?,?,?,?,?,?)";
        try {
             ps=cn.getCon().prepareStatement(sql);
             ps.setString(1, cl.getNombre());
             ps.setString(2, cl.getApellido());
             ps.setString(3, cl.getCorreo());
             ps.setString(4, cl.getClave());
             ps.setString(6, cl.getStatus());
             ps.setString(6, cl.getTelefono());
             ps.setString(7, cl.getDireccion());
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
        }finally{
            cn.cerrar();
        }return false;
    }
    
    public Cliente consultar(String correo, String clave){  
        Cliente cl=new Cliente();
      String sql="SELECT * FROM cliente WHERE correo=? and clave=? and status='A'";
    try{   
         ps = cn.getCon().prepareStatement(sql);
         ps.setString(1, correo);
         ps.setString(2, clave);
         rs = ps.executeQuery();   
       while(rs.next()){
            cl.setIdCliente(rs.getInt(1));
            cl.setNombre(rs.getString(2));
            cl.setApellido(rs.getString(3));
            cl.setCorreo(rs.getString(4));
            cl.setClave(rs.getString(5));
            cl.setStatus(rs.getString(6));
            cl.setTelefono(rs.getString(7));
            cl.setDireccion(rs.getString(8));
        }    
    }catch(Exception e){
        
    } finally{
     cn.cerrar();
    } return cl;
   } 
}
