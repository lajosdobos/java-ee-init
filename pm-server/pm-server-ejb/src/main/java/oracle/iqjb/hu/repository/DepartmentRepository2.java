package oracle.iqjb.hu.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="departmentRepository2")
@LocalBean
public class DepartmentRepository2 extends DepartmentRepository {
    
    @PersistenceContext(unitName = "iqjbPU2")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
    
}
