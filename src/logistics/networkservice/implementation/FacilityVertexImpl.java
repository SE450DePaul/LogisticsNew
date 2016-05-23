package logistics.networkservice.implementation;

/**
 * This class represents the implementation of a Facility Vertex,
 * which serves as a vertex on the Network Graph of all Facilities and 
 * their corresponding neighbors.
 * 
 * It provides methods for adding a new neighbor, to a given Facility,
 * determining the distance between a Facility and its neighbor, as well as
 * returning a list of all neighbors of a given Facility.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class FacilityVertexImpl implements FacilityVertex {

    private String facility;
    private HashMap<String, Integer> weights;

    public FacilityVertexImpl(String fac) throws NullParameterException {
        setFacility(fac);
        weights = new HashMap<>();
    }

    /*
     * Adds a new neighbor to this Facility given another Facility's name and
     * corresponding distance from this Facility. 
     */
    public void addNeighbor(String facility, int distance) throws NullParameterException, NegativeOrZeroParameterException {
        validateFacility(facility);
        validateDistance(distance);
        weights.put(facility, distance);
    }

    /*
     * Returns the distance between this Facility and another Facility given its name.
     */
    public int distanceTo(String facility) throws NeighborNotFoundInNetworkException {
        Integer distance = weights.get(facility);
        if (distance == null){
            throw new NeighborNotFoundInNetworkException("No distance found for neighbor");
        }
        return distance;
    }

    /*
     * Returns a list of Facilities that are neighbors to this Facility.  
     */
    public Iterator<String> neighbors() {
        return new TreeSet<String>(weights.keySet()).iterator();
    }

    /*
     * Returns the name of this Facility.
     */
    public String getFacilityName() {
        return facility;
    }


    /*
     * Helper method that sets the name of this Facility to a given name. 
     */
    private void setFacility(String fac) throws NullParameterException {
        validateFacility(fac);
        facility = fac;
    }

    /*
     * Helper method that validates that a given Facility name is not null.
     */
    private void validateFacility(String fac) throws NullParameterException {
        if (fac == null){
            throw new NullParameterException("Facility cannot be null");
        }
    }
    
    /*
     * Helper method that validates that a given distance to a Facility is not a negative value.
     */
    private void validateDistance(int distance) throws NegativeOrZeroParameterException {
        if (distance < 0){
            throw new NegativeOrZeroParameterException("Distance cannot be negative");
        }
    }
}
