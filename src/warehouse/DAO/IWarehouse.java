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
public interface IWarehouse {
    public void addWarehouse(Warehouse w);
    public void deleteWarehouse(Warehouse w);
    public void updateWarehouse(Warehouse w);
    public  List<Warehouse> getWarehouse();  
    public Warehouse getWarehouse(Long id);  
    
}
