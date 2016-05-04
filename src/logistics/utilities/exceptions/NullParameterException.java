package logistics.utilities.exceptions;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class NullParameterException extends IllegalParameterException {

    public NullParameterException() {super();}
    public NullParameterException(String message){
        super(message);
    }
}
