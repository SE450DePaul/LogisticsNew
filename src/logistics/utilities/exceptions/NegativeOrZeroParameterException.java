package logistics.utilities.exceptions;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class NegativeOrZeroParameterException extends IllegalParameterException {

    public NegativeOrZeroParameterException() {super();}
    public NegativeOrZeroParameterException(String message){
        super(message);
    }
}
