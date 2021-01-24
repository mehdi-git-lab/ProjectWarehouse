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
public class OrderForm extends JFrame{
   
    public JFrame frame;
    public JTextField idFeild;
    public JComboBox fldTYPEDELIVERY;
    public JDateChooser  fldDATEDELIVERY;
    public JDateChooser fldDEADLINE;
    public JTextField fldDISTINATION;
    public JComboBox fldIDWAREHOUSE;
    public JButton btnAdd;
    public JButton btnUpd;
    public JButton btnDel;
    public JButton btnUser;
    public JButton btnRef;
    public JTable  tabUser;
    private JPanel jpane;

    
    Connection cnx = null ;
    PreparedStatement prepared = null ;
    ResultSet resultat = null ;
    WarehouseDAO  warehouseDAO = null ;
    
    public OrderForm(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        getFrame().setBounds(100,100,1000,500);
        getFrame().getContentPane().setLayout(null);
        cnx = SingletonConnection.getConnection();
        List<Warehouse> warehouses = warehouseDAO.listWarehouse();
        idFeild = new JTextField();
        idFeild.setBounds(200,20,250,26);
       // getFrame().getContentPane().add(idFeild);
        fldTYPEDELIVERY = new JComboBox();
        fldTYPEDELIVERY.addItem("IN");
        fldTYPEDELIVERY.addItem("OUT");
        fldTYPEDELIVERY.setBounds(200,50,250,26);
        getFrame().getContentPane().add(fldTYPEDELIVERY);
        fldDATEDELIVERY = new JDateChooser();
        fldDATEDELIVERY.setBounds(200,80,250,26);
        getFrame().getContentPane().add(fldDATEDELIVERY);
        fldDEADLINE = new JDateChooser();
        fldDEADLINE.setBounds(200,110,250,26);
        getFrame().getContentPane().add(fldDEADLINE);
        fldDISTINATION = new JTextField();
        fldDISTINATION.setBounds(200,140,250,26);
        getFrame().getContentPane().add(fldDISTINATION);
        fldIDWAREHOUSE = new JComboBox();
        for(Warehouse warehouse : warehouses)
        fldIDWAREHOUSE.addItem(warehouse.getId().toString().concat("|| ").concat(warehouse.getLOCALIZATION()));
        fldIDWAREHOUSE.setBounds(200,170,250,26);
        getFrame().getContentPane().add(fldIDWAREHOUSE);
       
        
        JLabel LblId = new JLabel("identifier :");
        LblId.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblId.setBounds(50,20,100,20);
        //getFrame().getContentPane().add(LblId);
        
        JLabel LblTypDel = new JLabel("TYPE DELIVERY :");
        LblTypDel.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblTypDel.setBounds(50,50,100,20);
        getFrame().getContentPane().add(LblTypDel);
        
        JLabel LblDateDel = new JLabel("DATE DELIVERY :");
        LblDateDel.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblDateDel.setBounds(50,80,100,20);
        getFrame().getContentPane().add(LblDateDel);
        
        JLabel LblDeadLine = new JLabel("DEADLINE :");
        LblDeadLine.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblDeadLine.setBounds(50,110,100,20);
        getFrame().getContentPane().add(LblDeadLine);
        
        
        JLabel LblDistination = new JLabel("DISTINATION :");
        LblDistination.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblDistination.setBounds(50,140,150,20);
        getFrame().getContentPane().add(LblDistination);
        
         JLabel LblWarehouse = new JLabel("WAREHOUSE :");
        LblWarehouse.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblWarehouse.setBounds(50,170,100,20);
        getFrame().getContentPane().add(LblWarehouse);
        
        
        
        btnAdd = new JButton("Ajouter");
        btnAdd.setBounds(500,50,250,26);
        getFrame().getContentPane().add(btnAdd);
        
        btnUpd = new JButton("Modifier");
        btnUpd.setBounds(500,80,250,26);
        getFrame().getContentPane().add(btnUpd);
        
        
        btnDel = new JButton("supprimer");
        btnDel.setBounds(500,110,250,26);
        getFrame().getContentPane().add(btnDel);
        
        
        btnRef = new JButton("Actualisier");
        btnRef.setBounds(500,140,250,26);
        getFrame().getContentPane().add(btnRef);
      
        tabUser = new JTable();
        JScrollPane jScrollPane = new JScrollPane(tabUser);
        jScrollPane.setBounds(20,230,800,300);
        getFrame().getContentPane().add(jScrollPane);
        tabUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabUser.getSelectedRow();
                idFeild.setText(String.valueOf(tabUser.getValueAt(i, 0)));
                fldTYPEDELIVERY.setSelectedItem(String.valueOf(tabUser.getValueAt(i, 1)));
                fldDATEDELIVERY.setDate((Date) tabUser.getValueAt(i, 2));
                fldDEADLINE.setDate((Date)tabUser.getValueAt(i, 3));
                fldDISTINATION.setText(String.valueOf(tabUser.getValueAt(i, 4))); 
                fldIDWAREHOUSE.setSelectedItem(String.valueOf(tabUser.getValueAt(i, 5)));


            }
        });
 
    }
 

     public JFrame getFrame() {
        return frame;
    }
     
    
}
