/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.service;

import javax.ejb.Remote;
import oracle.iqjb.hu.pm.dto.DepartmentRequest;
import oracle.iqjb.hu.pm.dto.DepartmentResponse;

/**
 *
 * @author oracle
 */
@Remote
public interface DepartmentSessionServiceRemote {
 
    DepartmentResponse addDepartment(DepartmentRequest request);
    
}
