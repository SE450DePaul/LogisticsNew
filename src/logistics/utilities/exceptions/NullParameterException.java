package logistics.utilities.exceptions;

/**
 * @author Uchenna F. Okoye
 */
public class NullParameterException extends IllegalParameterException {

    public NullParameterException() {super();}
    public NullParameterException(String message){
        super(message);
    }
}
