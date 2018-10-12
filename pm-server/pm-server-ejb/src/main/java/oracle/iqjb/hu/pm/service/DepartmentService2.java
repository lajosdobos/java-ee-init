/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.pm.dm.entities.Department;
import oracle.iqjb.hu.pm.interceptor.LoggerInterceptor;
import oracle.iqjb.hu.repository.DepartmentRepository2;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class DepartmentService2 {

    @EJB
    private DepartmentRepository2 departmentRepository2;
    
    @Interceptors(LoggerInterceptor.class)
    public Department add(Department department) {
        return departmentRepository2.add(department);
    }

}
