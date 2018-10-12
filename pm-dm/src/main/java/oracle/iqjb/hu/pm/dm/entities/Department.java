/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Department")
public class Department extends IqjbEntity {
    
    private String name;
    
    private Department(){}

    public Department(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
