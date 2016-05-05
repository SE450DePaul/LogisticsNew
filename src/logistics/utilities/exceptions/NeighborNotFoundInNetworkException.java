package logistics.utilities.exceptions;

/**
 * @author Uchenna F. Okoye
 */
public class NeighborNotFoundInNetworkException extends Exception {

    public NeighborNotFoundInNetworkException() {super();}
    public NeighborNotFoundInNetworkException(String message){
        super(message);
    }
}
