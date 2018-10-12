/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.interceptor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.intf.LoggerServiceRemote;


/**
 *
 * @author oracle
 */
public class LoggerInterceptor {

    
    @EJB(lookup = "java:global/oracle.iqjb.hu_pm-logger-ear_ear_1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote")
    private LoggerServiceRemote loggerServiceRemote;

      @Resource
    private SessionContext context;
      
      
    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        
        LoggerServiceRemote remote = lookupIqjbLogServiceRemote() ;
        remote.create(
                LocalDateTime.now().toString() + " - " +
                ctx.getMethod().getDeclaringClass().getCanonicalName()
                + "::" + ctx.getMethod().getName() + " is called by " + context.getCallerPrincipal().getName());
        loggerServiceRemote.create(ctx.getMethod().getDeclaringClass().getCanonicalName()
                + "::" + ctx.getMethod().getName() + " is called by " + context.getCallerPrincipal().getName());
        LocalTime start = LocalTime.now();
        Object ret = ctx.proceed();
        LocalTime end = LocalTime.now();
        loggerServiceRemote.create(
                LocalDateTime.now().toString() + " - " +
                ctx.getMethod().getDeclaringClass().getCanonicalName()
                + "::" + ctx.getMethod().getName() + " is called by " + context.getCallerPrincipal().getName() +
                " - Time: " + (end.getNano() - start.getNano()) + " ns");
       
        return ret;
    }

    private LoggerServiceRemote lookupIqjbLogServiceRemote() {
        try {
            Context c = new InitialContext();
            return (LoggerServiceRemote) c.lookup("java:global/oracle.iqjb.hu_pm-logger-ear_ear_1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
