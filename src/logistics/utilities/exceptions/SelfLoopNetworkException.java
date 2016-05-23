package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * when a Facility (represented as a Vertex) in the Network Graph
 * of Facilities is in a Loop.
 * 
 * @author Uchenna F. Okoye
 */
public class SelfLoopNetworkException extends Exception {

    public SelfLoopNetworkException() {super();}
    public SelfLoopNetworkException(String message){
        super(message);
    }
}
