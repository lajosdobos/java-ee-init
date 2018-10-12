package oracle.iqjb.hu.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(mappedName="departmentRepository1")
@LocalBean
public class DepartmentRepository1 extends DepartmentRepository {
    
    @PersistenceContext(unitName = "iqjbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
    
}
