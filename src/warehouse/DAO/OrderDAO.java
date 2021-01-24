/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import warehouse.Modele.IOrder;
import warehouse.Modele.Order;
import warehouse.Modele.SingletonConnection;

/**
 *
 * @author PC-MEHDI
 */
public class OrderDAO  implements IOrder {
     WarehouseDAO  warehouseDAO = null ;
    @Override
    public void addOrder(Order o, Long idWhareHouse) {
                      Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into ORDERS(TYPEDELIVERY,DATEDELIVERY,DEADLINE,DISTINATION,IDWAREHOUSE)"
                    + "values (?,?,?,?,?)");
            ps.setString(1,o.getTypeDelivery());
            ps.setDate(2,  o.getDateDelivery());
            ps.setDate(3, o.getDeadLine());
            ps.setString(4,o.getDistination());
            ps.setLong(5,idWhareHouse);
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(Order o) {
               Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("delete ORDERS where id =?  "); 
            ps.setLong(1, o.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}  
    }

    @Override
    public void updateOrder(Order o, Long idWhareHouse) {
                       Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement
        ("update ORDERS set TYPEDELIVERY =? ,DATEDELIVERY = ? ,DEADLINE =? ,  DISTINATION=? ,IDWAREHOUSE=?  where id =?  "); 
            ps.setString(1,o.getTypeDelivery());
            ps.setDate(2,  o.getDateDelivery());
            ps.setDate(3, o.getDeadLine());
            ps.setString(4,o.getDistination());
            ps.setLong(5,idWhareHouse);
            ps.setLong(6,o.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}  
    }

    @Override
    public List<Order> getOrder() {
               ArrayList orders = new ArrayList();
       Order order;
        try {
         Connection conn = SingletonConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select   id,TYPEDELIVERY ,DATEDELIVERY  ,DEADLINE,  DISTINATION ,IDWAREHOUSE  from ORDERS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
             order = new Order();
             order.setId(rs.getLong(1));
             order.setTypeDelivery(rs.getString(2));
             order.setDateDelivery(rs.getDate(3));
             order.setDeadLine(rs.getDate(4));
             order.setDistination(rs.getString(5));          
             order.setIdWareHouse(warehouseDAO.gettWarehouse(rs.getLong(6)));                       
             orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getOrder(Long id) {
       ArrayList orders = new ArrayList();
       Order order;
        try {
         Connection conn = SingletonConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select   id,TYPEDELIVERY ,DATEDELIVERY  ,DEADLINE,  DISTINATION ,IDWAREHOUSE  from ORDERS where IDWAREHOUSE = ?");
         ps.setLong(1,id);  
         ResultSet rs = ps.executeQuery();
            while (rs.next()){
             order = new Order();
             order.setId(rs.getLong(1));
             order.setTypeDelivery(rs.getString(2));
             order.setDateDelivery(rs.getDate(3));
             order.setDeadLine(rs.getDate(4));
             order.setDistination(rs.getString(5));          
             order.setIdWareHouse(warehouseDAO.gettWarehouse(rs.getLong(6)));                       
             orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    }

  

    

