package oracle.iqjb.hu.repository;

import java.util.List;
import javax.persistence.EntityManager;
import oracle.iqjb.hu.pm.dm.entities.Department;


public abstract class DepartmentRepository  {

    protected abstract EntityManager getEntityManager();
  
    public Department add(Department department){
        getEntityManager().persist(department);
        return department;
    }
    
    public List<Department> findAll() {
        return getEntityManager().createQuery("select d from Department d", Department.class).getResultList();
    }
    
}
