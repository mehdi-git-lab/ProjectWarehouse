/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import warehouse.Modele.Order;
import DAO.OrderDAO;
import warehouse.vue.OrderForm;

/**
 *
 * @author PC-MEHDI
 */
public class OrderControleur implements ActionListener {
    OrderForm orderForm = new OrderForm();
    OrderDAO orderDAO = new OrderDAO();    

    public OrderControleur(OrderForm orderForm,OrderDAO orderDAO) {
        this.orderForm=orderForm;
        this.orderDAO=orderDAO;
        this.orderForm.btnAdd.addActionListener(this);
        this.orderForm.btnRef.addActionListener(this);
        this.orderForm.btnUpd.addActionListener(this);
        this.orderForm.btnDel.addActionListener(this);
    }

    public void ListWharehouse (JTable tabUser){

          String columnas[]={"identifier","TYPE DELIVERY","DATE DELIVERY","DEADLINE","DISTINATION","WAREHOUSE"};
        DefaultTableModel modTab = new DefaultTableModel(columnas,0);
        tabUser.setModel(modTab);
        Object[] columna = new Object[6];
        List<Order> orders = orderDAO.getOrder();
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
        
        if(e.getSource()==orderForm.btnAdd){
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                String date = DATE_FORMAT.format(orderForm.fldDATEDELIVERY.getDate());
                String date2 = DATE_FORMAT.format(orderForm.fldDEADLINE.getDate());
                String typeDelivery = (String) orderForm.fldTYPEDELIVERY.getSelectedItem();
                String distination = orderForm.fldDISTINATION.getText();
                String warehouse =  (String) orderForm.fldIDWAREHOUSE.getSelectedItem();
                String idWarehouse = warehouse.substring(0,warehouse.indexOf("|"));
                Order o = new Order();
                o.setTypeDelivery(typeDelivery);
                o.setDateDelivery(Date.valueOf(date));
                o.setDeadLine(Date.valueOf(date2));
                o.setDistination(distination);
                orderDAO.addOrder(o,Long.valueOf(idWarehouse));
                ListWharehouse(orderForm.tabUser);
            
                    
            
        }
    
else
        if (e.getSource()==orderForm.btnRef){
            ListWharehouse(orderForm.tabUser);
        }else
        if (e.getSource()==orderForm.btnUpd){
               SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                String date = DATE_FORMAT.format(orderForm.fldDATEDELIVERY.getDate());
                String date2 = DATE_FORMAT.format(orderForm.fldDEADLINE.getDate());
                String typeDelivery = (String) orderForm.fldTYPEDELIVERY.getSelectedItem();
                String id = orderForm.idFeild.getText();
                String distination = orderForm.fldDISTINATION.getText();
                String warehouse =  (String) orderForm.fldIDWAREHOUSE.getSelectedItem();
                String idWarehouse = warehouse.substring(0,warehouse.indexOf("|"));
            Order o = new Order();
               o.setTypeDelivery(typeDelivery);
                o.setDateDelivery(Date.valueOf(date));
                o.setDeadLine(Date.valueOf(date2));
                o.setDistination(distination);
                o.setId(Long.valueOf(id));
                orderDAO.updateOrder(o,Long.valueOf(idWarehouse));
            ListWharehouse(orderForm.tabUser);

        }else
        if (e.getSource()==orderForm.btnDel){
         SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                String date = DATE_FORMAT.format(orderForm.fldDATEDELIVERY.getDate());
                String date2 = DATE_FORMAT.format(orderForm.fldDEADLINE.getDate());
                String typeDelivery = (String) orderForm.fldTYPEDELIVERY.getSelectedItem();
                String id = orderForm.idFeild.getText();
                String distination = orderForm.fldDISTINATION.getText();
                String warehouse =  (String) orderForm.fldIDWAREHOUSE.getSelectedItem();
                String idWarehouse = warehouse.substring(0,warehouse.indexOf("|"));
            Order o = new Order();
                o.setId(Long.valueOf(id));
                o.setTypeDelivery(typeDelivery);
                o.setDateDelivery(Date.valueOf(date));
                o.setDeadLine(Date.valueOf(date2));
                o.setDistination(distination);
            orderDAO.deleteOrder(o);
            ListWharehouse(orderForm.tabUser);

        }
            
   }
   

    
}
