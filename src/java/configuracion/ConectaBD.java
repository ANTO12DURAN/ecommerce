package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonieta
 */
public class ConectaBD {
    public static ConectaBD instance;
    private Connection con;
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "TIENDA";
    private String pass = "TIENDA1";
    
    private ConectaBD(){
       
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try {
                con = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }
    public static ConectaBD abrir(){
        if (instance == null){
            instance = new ConectaBD();
        } return instance;
    }
    public void cerrar(){
        instance = null;
    }
}

