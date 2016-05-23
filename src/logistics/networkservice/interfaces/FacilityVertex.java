package logistics.networkservice.interfaces;

/**
 * This class represents a Facility Vertex Factory, which handles object creation 
 * of new FacilityVertex implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import java.util.Iterator;

public interface FacilityVertex {

    void addNeighbor(String facility, int distance) throws NullParameterException, NegativeOrZeroParameterException;

    int distanceTo(String facility) throws NeighborNotFoundInNetworkException;

    Iterator<String> neighbors();

    String getFacilityName();
}
