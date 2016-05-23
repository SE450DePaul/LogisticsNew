package logistics.utilities.exceptions;

/**
 * This class represents the exception error handler for instances 
 * in which a File, to be loaded into the Logistics application, cannot be found
 * or does not exist.
 * 
 * @author Uchenna F. Okoye
 */
public class LoaderFileNotFoundException extends Exception {
    public LoaderFileNotFoundException() {super();}
    public LoaderFileNotFoundException(String message){
        super(message);
    }
}
