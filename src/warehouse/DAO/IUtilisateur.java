/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.Modele;

import java.util.List;

/**
 *
 * @author PC-MEHDI
 */
public interface IUtilisateur {
    
    public void addUtilisateur(Utilisateur u);
    public void deleteUtilisateur(Utilisateur u);
    public void updateUtilisateur(Utilisateur u);
    public List<Utilisateur> getUtilisateur();    

    
    
}
