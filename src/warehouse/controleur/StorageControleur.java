/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.List;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import warehouse.Modele.Order;
import DAO.OrderDAO;
import warehouse.vue.StorageForm;

/**
 *
 * @author PC-MEHDI
 */
public class StorageControleur implements ActionListener {
    StorageForm storageForm = new StorageForm();
    OrderDAO orderDAO = new OrderDAO();    
      

    public StorageControleur(StorageForm storageForm,OrderDAO orderDAO) {
        this.storageForm=storageForm;
        this.orderDAO=orderDAO;
        this.storageForm.btnRef.addActionListener(this);
        this.storageForm.btnStat.addActionListener(this);

    }

    public void ListWharehouse (JTable tabUser){

          String columnas[]={"identifier","TYPE DELIVERY","DATE DELIVERY","DEADLINE","DISTINATION","WAREHOUSE"};
        DefaultTableModel modTab = new DefaultTableModel(columnas,0);
        tabUser.setModel(modTab);
        Object[] columna = new Object[6];
        String warehouse =  (String) storageForm.fldIDWAREHOUSE.getSelectedItem();
        String idWarehouse = warehouse.substring(0,warehouse.indexOf("|"));
        List<Order> orders = orderDAO.getOrder(Long.valueOf(idWarehouse));
        int numRow = orders.size();
        for(int i=0; i<numRow ; i++){
            columna [0]= orders.get(i).getId();
            columna [1]= orders.get(i).getTypeDelivery();
            columna [2]= orders.get(i).getDateDelivery();
            columna [3]= orders.get(i).getDeadLine();
            columna [4]= orders.get(i).getDistination();
            columna [5]= orders.get(i).getIdWareHouse().getId()+"|| "+orders.get(i).getIdWareHouse().getLOCALIZATION();
            

            modTab.addRow(columna);
        }        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        if (e.getSource()==storageForm.btnRef){
            ListWharehouse(storageForm.tabUser);
      
        }else 
            if (e.getSource()==storageForm.btnStat){
            Statistique stat = new Statistique();
            stat.display();
      
        }
    }
    
}
