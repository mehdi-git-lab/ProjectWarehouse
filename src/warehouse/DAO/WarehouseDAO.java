/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import warehouse.Modele.IWarehouse;
import warehouse.Modele.SingletonConnection;
import warehouse.Modele.Warehouse;

/**
 *
 * @author PC-MEHDI
 */
public class WarehouseDAO implements IWarehouse{

    @Override
    public void addWarehouse(Warehouse w) {
               Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into WAREHOUSE(LOCALIZATION,VOLUME,CAPACITE,NBEMP,STATUS,AVAILABILITY)"
                    + "values (?,?,?,?,?,?)");
            ps.setString(1, w.getLOCALIZATION());
            ps.setLong(2, w.getVOLUME());
            ps.setLong(3, w.getCAPACITE());
            ps.setLong(4, w.getNBEMP());
            ps.setString(5, w.getSTATUS());
            ps.setString(6, w.getAVAILABILITY());
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWarehouse(Warehouse w) {
              Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("delete WAREHOUSE where id =?  "); 
            ps.setLong(1, w.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}  
    }

    @Override
    public void updateWarehouse(Warehouse w) {
                Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement
        ("update WAREHOUSE set LOCALIZATION =? ,VOLUME = ? ,CAPACITE =? ,  NBEMP=? ,STATUS=?,AVAILABILITY=?  where id =?  "); 
            ps.setString(1, w.getLOCALIZATION());
            ps.setLong(2, w.getVOLUME());
            ps.setLong(3, w.getCAPACITE());
            ps.setLong(4, w.getNBEMP());
            ps.setString(5, w.getSTATUS());
            ps.setString(6, w.getAVAILABILITY());
            ps.setLong(7, w.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();}  
    }

    @Override
    public List<Warehouse> getWarehouse() {

        return listWarehouse();
    }
    public static List<Warehouse> listWarehouse(){
         ArrayList warehouses = new ArrayList();
       Warehouse warehouse;
        try {
         Connection conn = SingletonConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select id,LOCALIZATION,VOLUME,CAPACITE,NBEMP,STATUS,AVAILABILITY from WAREHOUSE");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
             warehouse = new Warehouse();
             warehouse.setId(rs.getLong(1));
             warehouse.setLOCALIZATION(rs.getString(2));
             warehouse.setVOLUME(rs.getLong(3));
             warehouse.setCAPACITE(rs.getLong(4));
             warehouse.setNBEMP(rs.getLong(5));
             warehouse.setSTATUS(rs.getString(6));
             warehouse.setAVAILABILITY(rs.getString(7));
             warehouses.add(warehouse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return warehouses;
    }

    @Override
    public Warehouse getWarehouse(Long id) {
      return gettWarehouse(id);
    }
    
    
    
     public static Warehouse gettWarehouse(Long id) {
          Warehouse warehouse = null;
        try {
         Connection conn = SingletonConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select id,LOCALIZATION,VOLUME,CAPACITE,NBEMP,STATUS,AVAILABILITY from WAREHOUSE where id = ?");
         ps.setLong(1,id);   
         ResultSet rs = ps.executeQuery();
             rs.next();
             warehouse = new Warehouse();
             warehouse.setId(rs.getLong(1));
             warehouse.setLOCALIZATION(rs.getString(2));
             warehouse.setVOLUME(rs.getLong(3));
             warehouse.setCAPACITE(rs.getLong(4));
             warehouse.setNBEMP(rs.getLong(5));
             warehouse.setSTATUS(rs.getString(6));
             warehouse.setAVAILABILITY(rs.getString(7));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return warehouse;    
     }

    
}
