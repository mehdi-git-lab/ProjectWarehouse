/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.vue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.*;
import warehouse.Modele.SingletonConnection;

/**
 *
 * @author PC-MEHDI
 */
public class WarehouseForm extends JFrame{
    public JFrame frame;
    public JTextField localizationFeild;
    public JTextField idFeild;
    public JTextField volumeFeild;
    public JTextField capaciteFeild;
    public JTextField nbempFeild;
    public JComboBox statusFeild;
    public JComboBox availabilityFeild;
    public JButton btnAdd;
    public JButton btnUpd;
    public JButton btnDel;
    public JButton btnUser;
    public JButton btnRef;
    public JTable tabUser;
    private JPanel jpane;

    
    Connection cnx = null ;
    PreparedStatement prepared = null ;
    ResultSet resultat = null ;
    
    public WarehouseForm(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        getFrame().setBounds(100,100,1000,500);
        getFrame().getContentPane().setLayout(null);
        cnx = SingletonConnection.getConnection();
        idFeild = new JTextField();
        idFeild.setBounds(200,20,250,26);
       // getFrame().getContentPane().add(idFeild);
        localizationFeild = new JTextField();
        localizationFeild.setBounds(200,50,250,26);
        getFrame().getContentPane().add(localizationFeild);
        volumeFeild = new JTextField();
        volumeFeild.setBounds(200,80,250,26);
        getFrame().getContentPane().add(volumeFeild);
        capaciteFeild = new JTextField();
        capaciteFeild.setBounds(200,110,250,26);
        getFrame().getContentPane().add(capaciteFeild);
        nbempFeild = new JTextField();
        nbempFeild.setBounds(200,140,250,26);
        getFrame().getContentPane().add(nbempFeild);
        statusFeild = new JComboBox();
        statusFeild.addItem("Valid");
        statusFeild.addItem("inValid");
        statusFeild.setBounds(200,170,250,26);
        getFrame().getContentPane().add(statusFeild);
        availabilityFeild = new JComboBox();
        availabilityFeild.addItem("OUI");
        availabilityFeild.addItem("NON");
        availabilityFeild.setBounds(200,200,250,26);
        getFrame().getContentPane().add(availabilityFeild);
        
        JLabel LblId = new JLabel("identifier :");
        LblId.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblId.setBounds(50,20,100,20);
        //getFrame().getContentPane().add(LblId);
        
        JLabel LblLocalization = new JLabel("localization :");
        LblLocalization.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblLocalization.setBounds(50,50,100,20);
        getFrame().getContentPane().add(LblLocalization);
        
        JLabel LblVolume = new JLabel("volume :");
        LblVolume.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblVolume.setBounds(50,80,100,20);
        getFrame().getContentPane().add(LblVolume);
        
        JLabel LblCapacite = new JLabel("capacite :");
        LblCapacite.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblCapacite.setBounds(50,110,100,20);
        getFrame().getContentPane().add(LblCapacite);
        
        
        JLabel LblNbEmp = new JLabel("nombre d'employés :");
        LblNbEmp.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblNbEmp.setBounds(50,140,150,20);
        getFrame().getContentPane().add(LblNbEmp);
        
         JLabel LblStatus = new JLabel("statut :");
        LblStatus.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblStatus.setBounds(50,170,100,20);
        getFrame().getContentPane().add(LblStatus);
        
         JLabel LblAvailability = new JLabel("availability :");
        LblAvailability.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblAvailability.setBounds(50,200,100,20);
        getFrame().getContentPane().add(LblAvailability);
        
        
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
                localizationFeild.setText(String.valueOf(tabUser.getValueAt(i, 1)));
                volumeFeild.setText(String.valueOf(tabUser.getValueAt(i, 2)));
                capaciteFeild.setText(String.valueOf(tabUser.getValueAt(i, 3)));
                nbempFeild.setText(String.valueOf(tabUser.getValueAt(i, 4))); 
                statusFeild.setSelectedItem(String.valueOf(tabUser.getValueAt(i, 5)));
                availabilityFeild.setSelectedItem(String.valueOf(tabUser.getValueAt(i, 6)));


            }
        });
 
    }
 

     public JFrame getFrame() {
        return frame;
    }
     
    
}
