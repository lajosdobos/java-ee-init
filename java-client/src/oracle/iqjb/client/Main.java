/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.client;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.intf.EchoInterface;
/**
 *
 * @author oracle
 */
public class Main {
    
    public static void main(String[] args) {
     try {
         Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
         env.put(Context.PROVIDER_URL, "t3://localhost:7001");
           Context ctx = new InitialContext(env);
//         EchoInterface echoInterface =
//         (EchoInterface) ctx.lookup("java:global/pm-server-ear/pm-server-ejb/EchoService");
         
         EchoInterface echoInterface =
         (EchoInterface) ctx.lookup("java:global.pm-server-ear-1.0-SNAPSHOT.pm-server-ejb-1.0-SNAPSHOT.MyEchoService!oracle.iqjb.hu.pm.intf.EchoInterface") ;
         
         System.out.println(echoInterface.echo("ejb"));

     } catch (NamingException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
     }

 }
    
//    public static void main(String[] args) {
//
//        String jndiPath = "departmentSessionService#oracle.iqjb.hu.pm.service.department.DepartmentSessionServiceRemote";
//
//        try  {    
//            final  Context  cxt  =  getInitialContext();  
//            System.out.println("standaloneapp.main: looking  up  bean  at: "  +  jndiPath);  
//            DepartmentInterface departmentBean = (DepartmentInterface) cxt.lookup(jndiPath);
//
//            DepartmentRequest request = new DepartmentRequest();
//            request.setFrom("interceptor teszt");
//            request.setName("interceptor teszt");
//            request.setDepartmentName("log teszt");
//            
//            DepartmentResponse resp = departmentBean.addDepartment(request);
//            System.out.println("Response from: " + resp.getFrom() + ", name" + resp.getName() + ", departmentName: " + resp.getDepartmentName());                  
//            
//            
//        } catch (Exception  e)  {  
//            System.err.println("Could not  find  departmentBean");  
//            e.printStackTrace(); 
//        }  
//    } 
//       
//    private static InitialContext  getInitialContext()  throws NamingException  { 
//        Hashtable env = new Hashtable();  
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 
//        env.put(Context.PROVIDER_URL, "t3://localhost:7001");  
//        return  new  InitialContext(env);  
//    }
    
}

