/**
 * 
 */
package com.my.quickstart.exception;

/**
 * 
 * @author mingxing.fmx
 * 
 */
public class DefaultException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -3337769128623895934L;

    public DefaultException() {
        super();
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }
}
