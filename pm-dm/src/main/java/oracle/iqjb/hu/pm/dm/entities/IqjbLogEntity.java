/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "LogEntity")
public class IqjbLogEntity extends IqjbEntity {

    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String content;
    
    public IqjbLogEntity() {
    }

    public IqjbLogEntity(String content, Date date) {
        this.date = date;
        this.content = content;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
