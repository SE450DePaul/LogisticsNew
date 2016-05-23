package logistics.networkservice.travelguide.algorithm;

/**
 * This is a Shortest Path Interface which provides common behaviors 
 * every Shortest Path algorithm implementation should be able to perform.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import java.util.Collection;

public interface ShortestPathAlgorithm {

    Collection<String> shortestPathTo(String destination) throws FacilityNotFoundInNetworkException;
    int distanceTo(String destination) throws FacilityNotFoundInNetworkException;
}
