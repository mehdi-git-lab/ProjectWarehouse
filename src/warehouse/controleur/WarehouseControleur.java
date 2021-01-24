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
import warehouse.Modele.Warehouse;
import DAO.WarehouseDAO;
import warehouse.vue.WarehouseForm;

/**
 *
 * @author PC-MEHDI
 */
public class WarehouseControleur implements ActionListener {
    WarehouseForm wrehouseForm = new WarehouseForm();
    WarehouseDAO warehouseDAO = new WarehouseDAO();    

    public WarehouseControleur(WarehouseForm wrehouseForm,WarehouseDAO warehouseDAO) {
        this.wrehouseForm=wrehouseForm;
        this.warehouseDAO=warehouseDAO;
        this.wrehouseForm.btnAdd.addActionListener(this);
        this.wrehouseForm.btnRef.addActionListener(this);
          this.wrehouseForm.btnUpd.addActionListener(this);
        this.wrehouseForm.btnDel.addActionListener(this);
    }

    public void ListWharehouse (JTable tabUser){
          String columnas[]={"identifier","LOCALIZATION","VOLUME","CAPACITE","NBEMP","STATUS","AVAILABILITY"};
        DefaultTableModel modTab = new DefaultTableModel(columnas,0);
        tabUser.setModel(modTab);
        Object[] columna = new Object[7];
        List<Warehouse> warehouses = warehouseDAO.getWarehouse();
        int numRow = warehouses.size();
        for(int i=0; i<numRow ; i++){
            columna [0]= warehouses.get(i).getId();
            columna [1]= warehouses.get(i).getLOCALIZATION();
            columna [2]= warehouses.get(i).getVOLUME();
            columna [3]= warehouses.get(i).getCAPACITE();
            columna [4]= warehouses.get(i).getNBEMP();
            columna [5]= warehouses.get(i).getSTATUS();
            columna [6]= warehouses.get(i).getAVAILABILITY();

            modTab.addRow(columna);
        }        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==wrehouseForm.btnAdd){
            String localization = wrehouseForm.localizationFeild.getText();
            String volume = wrehouseForm.volumeFeild.getText();
            String capacite = wrehouseForm.capaciteFeild.getText();
            String nbemp = wrehouseForm.nbempFeild.getText();
            String status = (String) wrehouseForm.statusFeild.getSelectedItem();
            String availability = (String) wrehouseForm.availabilityFeild.getSelectedItem();
            Warehouse w = new Warehouse();
            w.setLOCALIZATION(localization);
            w.setVOLUME(Long.valueOf(volume));
            w.setCAPACITE(Long.valueOf(capacite));
            w.setNBEMP(Long.valueOf(nbemp));
            w.setSTATUS(status);
            w.setAVAILABILITY(availability);
            warehouseDAO.addWarehouse(w);
            ListWharehouse(wrehouseForm.tabUser);

            
        }else
        if (e.getSource()==wrehouseForm.btnRef){
            ListWharehouse(wrehouseForm.tabUser);
        }else
        if (e.getSource()==wrehouseForm.btnUpd){
            String id = wrehouseForm.idFeild.getText();
            String localization = wrehouseForm.localizationFeild.getText();
            Long volume = Long.parseLong(wrehouseForm.volumeFeild.getText());
            Long capacite = Long.parseLong(wrehouseForm.capaciteFeild.getText());
            Long nbemp = Long.parseLong(wrehouseForm.nbempFeild.getText());
            String status = (String) wrehouseForm.statusFeild.getSelectedItem();
            String availability = (String) wrehouseForm.availabilityFeild.getSelectedItem();
            Warehouse w = new Warehouse();
            w.setId(Long.valueOf(id));
            w.setLOCALIZATION(localization);
            w.setVOLUME(Long.valueOf(volume));
            w.setCAPACITE(Long.valueOf(capacite));
            w.setNBEMP(Long.valueOf(nbemp));
            w.setSTATUS(status);
            w.setAVAILABILITY(availability);
            warehouseDAO.updateWarehouse(w);
            ListWharehouse(wrehouseForm.tabUser);

        }else
        if (e.getSource()==wrehouseForm.btnDel){
              String id = wrehouseForm.idFeild.getText();
            String localization = wrehouseForm.localizationFeild.getText();
            Long volume = Long.parseLong(wrehouseForm.volumeFeild.getText());
            Long capacite = Long.parseLong(wrehouseForm.capaciteFeild.getText());
            Long nbemp = Long.parseLong(wrehouseForm.nbempFeild.getText());
            String status = (String) wrehouseForm.statusFeild.getSelectedItem();
            String availability = (String) wrehouseForm.availabilityFeild.getSelectedItem();
            Warehouse w = new Warehouse();
           w.setId(Long.valueOf(id));
            w.setLOCALIZATION(localization);
            w.setVOLUME(Long.valueOf(volume));
            w.setCAPACITE(Long.valueOf(capacite));
            w.setNBEMP(Long.valueOf(nbemp));
            w.setSTATUS(status);
            w.setAVAILABILITY(availability);
            warehouseDAO.deleteWarehouse(w);
            ListWharehouse(wrehouseForm.tabUser);

        }
            
   }
   

    
}
