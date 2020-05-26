
package dao;

import configuracion.ConectaBD;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {
    PreparedStatement ps;
    ResultSet rs; 
    private static final ConectaBD cn = ConectaBD.abrir();
    
    public Usuario validarUsuario(String codigo, String clave){
        Usuario usu=new Usuario();
        String sql="SELECT * FROM usuario WHERE codigo=? and clave=? and status='A'";
        try {
         ps = cn.getCon().prepareStatement(sql);
         ps.setString(1,codigo);
         ps.setString(2, clave);
         rs = ps.executeQuery();   
        if(rs.next()){
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setClave(rs.getString(3));
            usu.setCodigo(rs.getString(4));
            usu.setStatus(rs.getString(5));
        }
        } catch (Exception e) {
        }finally{
            cn.cerrar();
        }
        return usu;
    }
}
