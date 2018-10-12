package oracle.iqjb.hu.pm.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import oracle.iqjb.hu.DepartmentRepository;
import oracle.iqjb.hu.pm.dto.DepartmentRequest;
import oracle.iqjb.hu.pm.dto.DepartmentResponse;

/**
 *
 * @author oracle
 */
@Stateless(mappedName="departmentSessionService")
public class DepartmentSessionService implements DepartmentSessionServiceRemote {

    @EJB
    DepartmentRepository departmentRepository;
    
    @Override
    public DepartmentResponse addDepartment(DepartmentRequest request) {
        DepartmentResponse resp = new DepartmentResponse();
        return resp;
    }
    
}
