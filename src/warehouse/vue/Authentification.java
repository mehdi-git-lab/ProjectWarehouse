/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.vue;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
import DAO.OrderDAO;
import warehouse.Modele.SingletonConnection;
import DAO.UtilisateurDAO;
import DAO.WarehouseDAO;
import warehouse.controleur.OrderControleur;
import warehouse.controleur.UserControleur;
import warehouse.controleur.WarehouseControleur;

/**
 *
 * @author PC-MEHDI
 */
public class Authentification extends JFrame{
    private JFrame frame;
    private JTextField userNameFeild;
    private JPasswordField passwordFeild;
    private JPanel jpane;
    
    Connection cnx = null ;
    PreparedStatement prepared = null ;
    ResultSet resultat = null ;
    
    public Authentification(){
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        getFrame().setBounds(100,100,1000,500);
        getFrame().getContentPane().setLayout(null);
        cnx = SingletonConnection.getConnection();
        userNameFeild = new JTextField();
        userNameFeild.setBounds(415,175,250,26);
        getFrame().getContentPane().add(userNameFeild);
        userNameFeild.setColumns(10);
        JLabel LblUserName = new JLabel("USERNAME :");
        LblUserName.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblUserName.setBounds(326,184,100,20);
        getFrame().getContentPane().add(LblUserName);
        
        JLabel LblPassword = new JLabel("PASSWORD :");
        LblPassword.setFont(new Font("Source sans Pro",Font.PLAIN,14));
        LblPassword.setBounds(326,213,200,20);
        getFrame().getContentPane().add(LblPassword);
        JButton btnConnexion = new JButton("se Connecter");
        btnConnexion.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            String username = userNameFeild.getText().toString();
            String password = passwordFeild.getText().toString();       
            String sql ="select * from utilisateur where login= ? and password = ? "  ;
                try {
                    prepared = cnx.prepareStatement(sql);
                    prepared.setString(1,username);
                    prepared.setString(2,password);
                    resultat= prepared.executeQuery();
                    if(resultat.next()){
                        MenuForm frame = new MenuForm();
                        frame.getFrame().setVisible(true);
                        frame.getFrame().setLocationRelativeTo(null);
                    }else
                        JOptionPane.showMessageDialog(null, "login ou password incorrect");
                } catch (SQLException ex) {
                    Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
    
    });
    btnConnexion.setBounds(399,238,200,31);
        getFrame().getContentPane().add(btnConnexion);
    passwordFeild = new JPasswordField();
    passwordFeild.setBounds(415,206,250,26);
        getFrame().getContentPane().add(passwordFeild);
    
            
        
        
        

        
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
    
}
