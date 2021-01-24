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
public class UserForm extends JFrame{
    public JFrame frame;
    public JTextField nameFeild;
    public JTextField idFeild;
    public JTextField prenomFeild;
    public JTextField loginFeild;
    public JPasswordField passwordFeild;
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
    
    public UserForm(){
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
        nameFeild = new JTextField();
        nameFeild.setBounds(200,50,250,26);
        getFrame().getContentPane().add(nameFeild);
        prenomFeild = new JTextField();
        prenomFeild.setBounds(200,80,250,26);
        getFrame().getContentPane().add(prenomFeild);
        loginFeild = new JTextField();
        loginFeild.setBounds(200,110,250,26);
        getFrame().getContentPane().add(loginFeild);
        passwordFeild = new JPasswordField();
        passwordFeild.setBounds(200,140,250,26);
        getFrame().getContentPane().add(passwordFeild);
        
        JLabel LblId = new JLabel("identifier :");
        LblId.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblId.setBounds(50,20,100,20);
        //getFrame().getContentPane().add(LblId);
        
        JLabel LblName = new JLabel("Nom :");
        LblName.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblName.setBounds(50,50,100,20);
        getFrame().getContentPane().add(LblName);
        
        JLabel LblPrenom = new JLabel("Prenom :");
        LblPrenom.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblPrenom.setBounds(50,80,100,20);
        getFrame().getContentPane().add(LblPrenom);
        
        JLabel LblLogin = new JLabel("Login :");
        LblLogin.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblLogin.setBounds(50,110,100,20);
        getFrame().getContentPane().add(LblLogin);
        
        
        JLabel LblPWD = new JLabel("PassWord :");
        LblPWD.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblPWD.setBounds(50,150,100,20);
        getFrame().getContentPane().add(LblPWD);
        
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
        jScrollPane.setBounds(20,180,800,300);
        getFrame().getContentPane().add(jScrollPane);
        tabUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabUser.getSelectedRow();
                idFeild.setText(String.valueOf(tabUser.getValueAt(i, 0)));
                nameFeild.setText(String.valueOf(tabUser.getValueAt(i, 1)));
                prenomFeild.setText(String.valueOf(tabUser.getValueAt(i, 2)));
                loginFeild.setText(String.valueOf(tabUser.getValueAt(i, 3)));

                
                
            }
        });
 
    }
 

     public JFrame getFrame() {
        return frame;
    }
     
    
}
