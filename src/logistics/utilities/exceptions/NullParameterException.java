package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which the value of a parameter is Null.
 * 
 * @author Uchenna F. Okoye
 */
public class NullParameterException extends IllegalParameterException {

    public NullParameterException() {super();}
    public NullParameterException(String message){
        super(message);
    }
}
