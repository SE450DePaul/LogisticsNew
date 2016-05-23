package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which an incorrect value is entered in as a parameter.
 * 
 * @author Uchenna F. Okoye
 */
public class IllegalParameterException extends Exception {

    public IllegalParameterException() {super();}
    public IllegalParameterException(String message){
        super(message);
    }
}
