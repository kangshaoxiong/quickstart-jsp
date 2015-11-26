/**
 * 
 */
package com.my.quickstart.exception;

/**
 * 
 * @author mingxing.fmx
 *
 */
public class UtilException extends DefaultException {


    /**
     * 
     */
    private static final long serialVersionUID = 2905377174945017545L;

    public UtilException(String msg){
        super(msg);
    }
    
    public UtilException(String msg, Throwable t){
        super(msg, t);
    }
}
