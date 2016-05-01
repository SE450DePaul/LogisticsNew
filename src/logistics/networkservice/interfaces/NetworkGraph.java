package logistics.networkservice.interfaces;

import logistics.facilityservice.Facility;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.SelfLoopNetworkException;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface NetworkGraph {

    void addFacility(Facility facility) throws IllegalParameterException;
    void addNeighbor(Facility facility, Facility neighbor, int distance) throws FacilityNotFoundInNetworkException, IllegalParameterException, SelfLoopNetworkException;
    Iterator<Facility> neighbors(Facility facility);
    int distanceToNeighbor(Facility facility, Facility neighbor) throws FacilityNotFoundInNetworkException;
    int noOfVertices();


}
