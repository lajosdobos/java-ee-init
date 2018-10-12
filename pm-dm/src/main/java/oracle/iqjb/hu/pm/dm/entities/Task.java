/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Task")
public class Task extends IqjbEntity {  
    
    private String name;
    
    @ManyToOne //egy taskhoz tobb ember is tartozhat
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    private Employee owner;

    public Task() {
    }

    public Task(String name, Employee owner) {
        this.name = name;
        this.owner = owner;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
    
}
