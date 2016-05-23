package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which a Facility is not found in the Network Graph of Facilities.
 * 
 * @author Uchenna F. Okoye
 */
public class FacilityNotFoundInNetworkException extends Exception {

    public FacilityNotFoundInNetworkException() {super();}
    public FacilityNotFoundInNetworkException(String message){
        super(message);
    }
}
