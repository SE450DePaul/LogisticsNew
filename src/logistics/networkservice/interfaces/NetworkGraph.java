package logistics.networkservice.interfaces;

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.SelfLoopNetworkException;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface NetworkGraph {

    void addFacility(String facility) throws IllegalParameterException;
    void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, IllegalParameterException, SelfLoopNetworkException;
    Iterator<String> neighbors(String facility);
    int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException;
    int noOfVertices();


}
