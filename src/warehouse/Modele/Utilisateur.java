/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.Modele;

import java.io.Serializable;

/**
 *
 * @author PC-MEHDI
 */
public class Utilisateur implements Serializable{
    private long  id ;
    private String nom  ;
    private String prenom  ;
    private String login  ;
    private String password  ;
    
    public Utilisateur(long id, String nom, String prenom, String login, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public Utilisateur(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public Utilisateur() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the PRENOM
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param PRENOM the PRENOM to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    


    
}
