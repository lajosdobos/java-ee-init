/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf;

import oracle.iqjb.hu.pm.dto.DepartmentRequest;
import oracle.iqjb.hu.pm.dto.DepartmentResponse;
import oracle.iqjb.hu.pm.exception.MyException;

public interface DepartmentInterface {
 
    DepartmentResponse addDepartment(DepartmentRequest departmentRequest) throws MyException;
    
}
