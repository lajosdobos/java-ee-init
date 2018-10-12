/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.repository;

import java.util.List;
import javax.persistence.EntityManager;
import oracle.iqjb.hu.pm.dm.entities.IqjbLogEntity;

/**
 *
 * @author oracle
 */
public abstract class IqjbLogRepository {

   protected abstract EntityManager getEntityManager();
  
    public IqjbLogEntity add(IqjbLogEntity entity){
        getEntityManager().persist(entity);
        return entity;
    }
    
    public List<IqjbLogEntity> findAll() {
        return getEntityManager().createQuery("select d from IqjbLog d", IqjbLogEntity.class).getResultList();
    }
    
}
