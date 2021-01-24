/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.Modele;

import java.sql.Date;


/**
 *
 * @author PC-MEHDI
 */
public class Order {
         private Long        id;
         private String      typeDelivery;
         private Date        dateDelivery;
         private Date        deadLine;
         private String      Distination;
         private Warehouse   idWareHouse;

    public Long getId() {
        return id;
    }

    public String getTypeDelivery() {
        return typeDelivery;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public String getDistination() {
        return Distination;
    }

    public Warehouse getIdWareHouse() {
        return idWareHouse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeDelivery(String typeDelivery) {
        this.typeDelivery = typeDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public void setDistination(String Distination) {
        this.Distination = Distination;
    }

    public void setIdWareHouse(Warehouse idWareHouse) {
        this.idWareHouse = idWareHouse;
    }

    public Order(Long id, String typeDelivery, Date dateDelivery, Date deadLine, String Distination, Warehouse idWareHouse) {
        this.id = id;
        this.typeDelivery = typeDelivery;
        this.dateDelivery = dateDelivery;
        this.deadLine = deadLine;
        this.Distination = Distination;
        this.idWareHouse = idWareHouse;
    }

    public Order() {
    }

    public Order(String typeDelivery, Date dateDelivery, Date deadLine, String Distination, Warehouse idWareHouse) {
        this.typeDelivery = typeDelivery;
        this.dateDelivery = dateDelivery;
        this.deadLine = deadLine;
        this.Distination = Distination;
        this.idWareHouse = idWareHouse;
    }

    public Order(String typeDelivery, Date dateDelivery, Date deadLine, String Distination) {
        this.typeDelivery = typeDelivery;
        this.dateDelivery = dateDelivery;
        this.deadLine = deadLine;
        this.Distination = Distination;
    }
         
         
}
