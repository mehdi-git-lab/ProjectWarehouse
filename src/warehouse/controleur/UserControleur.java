/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.controleur;
import DAO.UtilisateurDAO;
import warehouse.vue.*;
import warehouse.Modele.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC-MEHDI
 */
public class UserControleur implements ActionListener {
    UserForm userForm = new UserForm();
    UtilisateurDAO userModel = new UtilisateurDAO();
    
  

    public UserControleur(UserForm userForm,UtilisateurDAO userModel) {
        this.userForm=userForm;
        this.userModel=userModel;
        this.userForm.btnAdd.addActionListener(this);
        this.userForm.btnRef.addActionListener(this);
          this.userForm.btnUpd.addActionListener(this);
        this.userForm.btnDel.addActionListener(this);
    }

    public void ListUser (JTable tabUser){
          String columnas[]={"identifier","Nom","Prnom","Login"};
        DefaultTableModel modTab = new DefaultTableModel(columnas,0);
        tabUser.setModel(modTab);
        Object[] columna = new Object[4];
        List<Utilisateur> users = userModel.getUtilisateur();
        int numRow = userModel.getUtilisateur().size();
        for(int i=0; i<numRow ; i++){
            columna [0]= users.get(i).getId();
            columna [1]= users.get(i).getNom();
            columna [2]= users.get(i).getPrenom();
            columna [3]= users.get(i).getLogin();
            modTab.addRow(columna);
        }        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==userForm.btnAdd){
            String nom = userForm.nameFeild.getText();
            String prenom = userForm.prenomFeild.getText();
            String login = userForm.loginFeild.getText();
            String passWord = userForm.passwordFeild.getText();
            Utilisateur u = new Utilisateur();
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setLogin(login);
            u.setPassword(passWord);
            userModel.addUtilisateur(u);
            ListUser(userForm.tabUser);

            
        }else
        if (e.getSource()==userForm.btnRef){
            ListUser(userForm.tabUser);
        }else
        if (e.getSource()==userForm.btnUpd){
            String id = userForm.idFeild.getText();
            String nom = userForm.nameFeild.getText();
            String prenom = userForm.prenomFeild.getText();
            String login = userForm.loginFeild.getText();
            String passWord = userForm.passwordFeild.getText();
            Utilisateur u = new Utilisateur();
            u.setId(Long.valueOf(id));
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setLogin(login);
            u.setPassword(passWord);
            userModel.updateUtilisateur(u);
            ListUser(userForm.tabUser);

        }else
        if (e.getSource()==userForm.btnDel){
            String id = userForm.idFeild.getText();
            String nom = userForm.nameFeild.getText();
            String prenom = userForm.prenomFeild.getText();
            String login = userForm.loginFeild.getText();
            String passWord = userForm.passwordFeild.getText();
            Utilisateur u = new Utilisateur();
            u.setId(Long.valueOf(id));
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setLogin(login);
            u.setPassword(passWord);
            userModel.deleteUtilisateur(u);
            ListUser(userForm.tabUser);

        }
            
   }
   


}
