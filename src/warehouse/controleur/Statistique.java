/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.controleur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import warehouse.Modele.SingletonConnection;

/**
 *
 * @author PC-MEHDI
 */

public class Statistique extends Application { 

    
    public int entcal;
    public int in ,out ;
  
    public void start(Stage primaryStage) throws SQLException { 
        // CrÃ©ation du graphique. 
        final PieChart chart = new PieChart(); 
        
        in=coordonnees("IN");
        out=coordonnees("OUT");

        chart.setTitle("Statistique des Order"); 
        chart.getData().setAll(new PieChart.Data("IN", in), new PieChart.Data("OUT", out)); 
        // Montage de l'IU. 
        final StackPane root = new StackPane(); 
        root.getChildren().add(chart); 
        final Scene scene = new Scene(root, 500, 400); 
        primaryStage.setTitle("Statistique des Order"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
    
    public int  coordonnees (String chaine) throws SQLException{
            Connection cnx = SingletonConnection.getConnection();
            String requete = "select * from ORDERS where TYPEDELIVERY ='"+chaine+"'";
            Statement stmt = (Statement) cnx.createStatement();
            ResultSet   rs = stmt.executeQuery(requete);
        
  
      while (rs.next()) {

       entcal=rs.getInt(1);
      }
                 
        return entcal;
      
    }
  
    public void display (){

            launch(); 
    }

}