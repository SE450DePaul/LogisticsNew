package logistics.networkservice.interfaces;

import logistics.utilities.exceptions.*;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface NetworkGraph {

    void addFacility(String facility) throws NullParameterException;
    void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, NullParameterException, SelfLoopNetworkException, NegativeOrZeroParameterException;
    Iterator<String> neighbors(String facility) throws FacilityNotFoundInNetworkException;
    int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException;
    boolean contains(String facility);
    Collection<String> vertices();



}
