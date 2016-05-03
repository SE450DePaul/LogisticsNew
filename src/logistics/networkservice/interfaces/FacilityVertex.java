package logistics.networkservice.interfaces;

import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface FacilityVertex {

    void addNeighbor(String facility, int distance) throws NullParameterException;

    int distanceTo(String facility) throws NeighborNotFoundInNetworkException;

    Iterator<String> neighbors();

    String getFacilityName();

}
