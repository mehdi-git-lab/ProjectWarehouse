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
public interface IOrder {
    public void addOrder(Order o,Long idWhareHouse);
    public void deleteOrder(Order o);
    public void updateOrder(Order o ,Long idWhareHouse);
    public List<Order> getOrder(); 
    public List<Order> getOrder(Long id);
    
}
