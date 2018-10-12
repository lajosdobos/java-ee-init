/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.client;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.dto.DepartmentRequest;
import oracle.iqjb.hu.pm.dto.DepartmentResponse;
import oracle.iqjb.hu.pm.intf.DepartmentInterface;

/**
 *
 * @author oracle
 */
public class Main {
    
    
    public static void main(String[] args) {

         String jndiPath = "departmentSessionService#oracle.iqjb.hu.pm.service.DepartmentSessionServiceRemote";

        try  {    
            final  Context  cxt  =  getInitialContext();  
            System.out.println("standaloneapp.main: looking  up  bean  at: "  +  jndiPath);  
            DepartmentInterface departmentBean = (DepartmentInterface) cxt.lookup(jndiPath);

            DepartmentRequest request = new DepartmentRequest();
            request.setFrom("java-client");
            request.setName("main");
            request.setDepartmentName("iqjb newnewnewnew");
            
            DepartmentResponse resp = departmentBean.addDepartment(request);
            System.out.println("Response from: " + resp.getFrom() + ", name" + resp.getName() + ", departmentName: " + resp.getDepartmentName());                  
            
            
        } catch (Exception  e)  {  
            System.err.println("Could not  find  departmentBean");  
            e.printStackTrace(); 
        }  
    } 
       
    private static InitialContext  getInitialContext()  throws NamingException  { 
        Hashtable env = new Hashtable();  
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");  
        return  new  InitialContext(env);  
    }
    
}

