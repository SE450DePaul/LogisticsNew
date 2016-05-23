package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which the Neighbor of a Facility, in the Network Graph of Facilities,
 * does not exist.
 * 
 * @author Uchenna F. Okoye
 */
public class NeighborNotFoundInNetworkException extends Exception {

    public NeighborNotFoundInNetworkException() {super();}
    public NeighborNotFoundInNetworkException(String message){
        super(message);
    }
}
