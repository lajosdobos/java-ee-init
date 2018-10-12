package oracle.iqjb.hu.repository;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class IqjbLogRepository1 extends IqjbLogRepository {

    @PersistenceContext(unitName = "iqjbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
