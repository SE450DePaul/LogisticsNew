package logistics.utilities.exceptions;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class NeighborNotFoundInNetworkException extends Exception 
{
    public NeighborNotFoundInNetworkException() {super();}
    public NeighborNotFoundInNetworkException(String message){
        super(message);
    }
}
