/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-MEHDI
 */
public class SingletonConnection {
    
     private static Connection connection ;

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }
     
     private SingletonConnection(){
     }
    
       
     static{
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Warehouse","sa");
                System.out.println("connexion effectuer");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
     
            } catch (SQLException ex) {
             Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

   
    
    
}
