/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author oracle
 */
@ApplicationException(rollback = true)
public class MyException extends Exception {

    private String errormsg;
    
    public MyException() {
    }

    public MyException(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
    
}
