/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.vue;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.*;
import warehouse.Modele.SingletonConnection;
import warehouse.Modele.Warehouse;
import DAO.WarehouseDAO;

/**
 *
 * @author PC-MEHDI
 */
public class StorageForm extends JFrame{
   
    public JFrame frame;
    public JComboBox fldIDWAREHOUSE;
    public JButton btnRef;
    public JButton btnStat;
    public JTable  tabUser;
    private JPanel jpane;

    
    Connection cnx = null ;
    PreparedStatement prepared = null ;
    ResultSet resultat = null ;
    WarehouseDAO  warehouseDAO = null ;
    
    public StorageForm(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        getFrame().setBounds(100,100,1500,1000);
        getFrame().getContentPane().setLayout(null);
        cnx = SingletonConnection.getConnection();
        List<Warehouse> warehouses = warehouseDAO.listWarehouse();
        
       // getFrame().getContentPane().add(idFeild);
        fldIDWAREHOUSE = new JComboBox();
        for(Warehouse warehouse : warehouses)
        fldIDWAREHOUSE.addItem(warehouse.getId().toString().concat("|| ").concat(warehouse.getLOCALIZATION()));
        fldIDWAREHOUSE.setBounds(200,20,400,26);
        getFrame().getContentPane().add(fldIDWAREHOUSE);
        btnRef = new JButton("Chercher");
        btnRef.setBounds(610,20,250,26);
        getFrame().getContentPane().add(btnRef);
        btnStat = new JButton("Statistique");
        btnStat.setBounds(900,20,250,26);
        getFrame().getContentPane().add(btnStat);
        tabUser = new JTable();
        JScrollPane jScrollPane = new JScrollPane(tabUser);
        jScrollPane.setBounds(20,80,1000,500);
        getFrame().getContentPane().add(jScrollPane);
   
 
    }
 

     public JFrame getFrame() {
        return frame;
    }
     
    
}
