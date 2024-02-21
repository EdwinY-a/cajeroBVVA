package org.utl.cajero.core.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author pasit
 */
public class ConexionBD {
    Connection conn;
    
    public Connection open(){
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://127.0.0.1:3306/cajero?useSSL=false&"
                +"allowPublicKeyRetrieval=true&"
                +"useUnicode=true&characterEncoding=utf-8";
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public void close()
    {
        if (conn!= null) 
        {
            try {
                conn.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                System.out.println("Exception controlada.");
            }
        }
    }
}
