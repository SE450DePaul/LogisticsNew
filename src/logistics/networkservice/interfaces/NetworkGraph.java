package logistics.networkservice.interfaces;

/**
 * This class represents a Network Graph Factory, which handles object creation 
 * of new Network Graph implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.*;
import java.util.Collection;
import java.util.Iterator;

public interface NetworkGraph {

    void addFacility(String facility) throws NullParameterException;
    void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, NullParameterException, SelfLoopNetworkException, NegativeOrZeroParameterException;
    Iterator<String> neighbors(String facility) throws FacilityNotFoundInNetworkException;
    int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException;
    boolean contains(String facility);
    Collection<String> vertices();
}
