/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import warehouse.Modele.IUtilisateur;
import warehouse.Modele.SingletonConnection;
import warehouse.Modele.Utilisateur;

/**
 *
 * @author PC-MEHDI
 */
public class UtilisateurDAO implements IUtilisateur{

    @Override
    public void addUtilisateur(Utilisateur u) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into utilisateur(nom,prenom,login,password)"
                    + "values (?,?,?,?)");
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUtilisateur(Utilisateur u) {
         Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("delete utilisateur where id =?  "); 
            ps.setLong(1, u.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}    
    }

    @Override
    public void updateUtilisateur(Utilisateur u) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement
        ("update utilisateur set nom =? ,prenom = ? ,login =? ,  password=? where id =?  "); 
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            ps.setLong(5, u.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}  
    }

    @Override
    public List<Utilisateur> getUtilisateur() {
        ArrayList utilisateurs = new ArrayList();
       Utilisateur utilisateur;
        try {
         Connection conn = SingletonConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select id,nom,prenom,login,password from utilisateur");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               utilisateur = new Utilisateur();
               utilisateur.setId(rs.getInt(1));
               utilisateur.setNom(rs.getString(2));
               utilisateur.setPrenom(rs.getString(3));
               utilisateur.setLogin(rs.getString(4));
               utilisateur.setPassword(rs.getString(5));
               utilisateurs.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
    


    
    
    
}
 