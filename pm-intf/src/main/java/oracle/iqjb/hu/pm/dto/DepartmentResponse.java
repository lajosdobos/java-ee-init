/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dto;

/**
 *
 * @author oracle
 */
public class DepartmentResponse extends BaseRequest {
    
    private String departmentName;

    public DepartmentResponse() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentResponse{" + "departmentName=" + departmentName + '}';
    }
    
    

}
