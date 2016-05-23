package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which the value of a parameter is either Null or Negative.
 * 
 * @author Uchenna F. Okoye
 */
public class NegativeOrZeroParameterException extends IllegalParameterException {

    public NegativeOrZeroParameterException() {super();}
    public NegativeOrZeroParameterException(String message){
        super(message);
    }
}
