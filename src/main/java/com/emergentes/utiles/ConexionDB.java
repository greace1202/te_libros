package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    static String driver = "com.mysql.jdbcDriver";
    static String url = "jdbc:mysql://localhost:3306/db_biblioteca";
    static String usuario = "root";
    static String password = "admin";

    Connection conn = null;

    public ConexionDB()  {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK" + conn);
            }
            
        }catch (SQLException ex) {
            System.out.println("Error de SQl" + ex.getMessage());
        }catch(ClassNotFoundException ex){
        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);    
        }   
    }
    public Connection conectar()
    {
    return conn;
    }
    
    public void desconectar(){
    try{
        conn.close();             
        }catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
