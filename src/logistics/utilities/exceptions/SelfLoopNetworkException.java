package logistics.utilities.exceptions;

/**
 * @author Uchenna F. Okoye
 */
public class SelfLoopNetworkException extends Exception {

    public SelfLoopNetworkException() {super();}
    public SelfLoopNetworkException(String message){
        super(message);
    }
}
