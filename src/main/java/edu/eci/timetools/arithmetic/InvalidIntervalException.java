package edu.eci.timetools.arithmetic;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */
public class InvalidIntervalException extends RuntimeException {

    public InvalidIntervalException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public InvalidIntervalException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public InvalidIntervalException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InvalidIntervalException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
