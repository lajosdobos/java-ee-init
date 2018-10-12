/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oracle.iqjb.hu.pm.dm.Department;

/**
 *
 git hub
 * login
 * create new repo
 * 
 * from project root
 * 
 * git init
 * git add .
 * git commit -m "commit"
 * git remote add origin https://github.com/lajosdobos/java-ee-ejb.git ie
 * git push -u origin master
* 
* 
* 
 */
public class WebClient {
    
    public static void main(String[] args) {
        //getById
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:7001/pm-server-web/webresources/departmentservices/get/1");
        Invocation invocation = target.request().buildGet();
        Department department = invocation.invoke(Department.class);
        System.out.println(department.toString());      
        
        //delete
        target = client.target("http://localhost:7001/pm-server-web/webresources/departmentservices/delete/6");
        invocation = target.request().buildDelete();
//        invocation.invoke();
//        System.out.println("deleted");
        
        //post
        target = client.target("http://localhost:7001/pm-server-web/webresources/departmentservices/add");
        Department d = new Department("oracle-rest");
        invocation = target.request(MediaType.APPLICATION_JSON).buildPost(Entity.entity(d, MediaType.APPLICATION_JSON));
        Response resp = invocation.invoke();
        System.out.println(resp);
        
        //put
        target = client.target("http://localhost:7001/pm-server-web/webresources/departmentservices/update/8");
        d = new Department("oracle-rest-update");
        invocation = target.request(MediaType.APPLICATION_JSON).buildPut(Entity.entity(d, MediaType.APPLICATION_JSON));
        resp = invocation.invoke();
        System.out.println(resp);
                
                
    }
}
