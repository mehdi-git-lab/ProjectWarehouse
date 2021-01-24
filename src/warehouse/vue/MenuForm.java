/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.*;
import DAO.OrderDAO;
import warehouse.Modele.SingletonConnection;
import DAO.UtilisateurDAO;
import DAO.WarehouseDAO;
import warehouse.controleur.OrderControleur;
import warehouse.controleur.StorageControleur;
import warehouse.controleur.UserControleur;
import warehouse.controleur.WarehouseControleur;

/**
 *
 * @author PC-MEHDI
 */
public class MenuForm extends JFrame  {
    public JFrame frame;
    public JButton btnUti;
    public JButton btnWhare;
    public JButton btnOrder;
    public JButton btnStorage;
 
    
    Connection cnx = null ;
    PreparedStatement prepared = null ;
    ResultSet resultat = null ;
    
    public MenuForm(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        getFrame().setBounds(100,100,1500,1000);
        getFrame().getContentPane().setLayout(null);
        cnx = SingletonConnection.getConnection();
        
        btnUti = new JButton("gestion des utilisateurs");
        btnUti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                        UtilisateurDAO utDAO = new UtilisateurDAO();
                        UserForm frameUti = new UserForm();
                        UserControleur userCnt = new UserControleur(frameUti, utDAO);
                        frameUti.getFrame().setVisible(true);
                        frameUti.getFrame().setLocationRelativeTo(null);
            }
    
    });
        btnUti.setBounds(50,20,500,100);
        getFrame().getContentPane().add(btnUti);
        
        btnWhare = new JButton("gestion des entrepôts");
        btnWhare.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                        WarehouseDAO wareDAO = new WarehouseDAO();
                        WarehouseForm wareframe = new WarehouseForm();
                        WarehouseControleur warehouseCnt = new WarehouseControleur(wareframe, wareDAO);
                        wareframe.getFrame().setVisible(true);
                        wareframe.getFrame().setLocationRelativeTo(null);
            }
    
    });
        btnWhare.setBounds(700,20,500,100);
        getFrame().getContentPane().add(btnWhare);
        
        
        btnOrder = new JButton("gestion des Ordres");
        btnOrder.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                        OrderDAO orderDAO = new OrderDAO();
                        OrderForm orderframe = new OrderForm();
                        OrderControleur OrderCnt = new OrderControleur(orderframe, orderDAO);
                        orderframe.getFrame().setVisible(true);
                        orderframe.getFrame().setLocationRelativeTo(null);
            }
    
    });
        btnOrder.setBounds(50,300,500,100);
        getFrame().getContentPane().add(btnOrder);
        
        btnStorage = new JButton("Storage");
        btnStorage.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                        OrderDAO orderDAO = new OrderDAO();
                        StorageForm storageframe = new StorageForm();
                        StorageControleur storageCnt = new StorageControleur(storageframe, orderDAO);
                        storageframe.getFrame().setVisible(true);
                        storageframe.getFrame().setLocationRelativeTo(null);
            }
    
    });
        btnStorage.setBounds(700,300,500,100);

        getFrame().getContentPane().add(btnStorage);    

    }
 

     public JFrame getFrame() {
        return frame;
    }
     
    
}
