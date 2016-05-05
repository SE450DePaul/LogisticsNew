package logistics.utilities.exceptions;

/**
 * @author Uchenna F. Okoye
 */
public class NegativeOrZeroParameterException extends IllegalParameterException {

    public NegativeOrZeroParameterException() {super();}
    public NegativeOrZeroParameterException(String message){
        super(message);
    }
}
