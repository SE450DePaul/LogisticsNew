package logistics.networkservice.interfaces;

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.SelfLoopNetworkException;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface NetworkGraph {

    void addFacility(String facility) throws NullParameterException;
    void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, NullParameterException, SelfLoopNetworkException;
    Iterator<String> neighbors(String facility) throws FacilityNotFoundInNetworkException;
    int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException;
    boolean contains(String facility);
    Collection<String> vertices();



}
