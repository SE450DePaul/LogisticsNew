package logistics.networkservice.implementation;

import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.IllegalParameterException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public class FacilityVertexImpl implements FacilityVertex {

    private String facility;
    private HashMap<String, Integer> weights;
    private HashSet<String> neighbors;

    public FacilityVertexImpl(String fac) throws IllegalParameterException {
        setFacility(fac);
        weights = new HashMap<>();
        neighbors = new HashSet<>();
    }

    @Override
    public void addNeighbor(String facility, int distance) throws IllegalParameterException {
        validateFacility(facility);
        validateDistance(distance);
        weights.put(facility, distance);
        neighbors.add(facility);
    }

    @Override
    public int distanceTo(String facility) {
        Integer distance = weights.get(facility);
        if (distance == null){
            return -1;
        }
        return distance;
    }

    @Override
    public boolean isANeighbor(String facility) {
        return neighbors.contains(facility);
    }

    @Override
    public Iterator<String> neighbor() {
        return neighbors.iterator();
    }

    @Override
    public String getFacilityName() {
        return facility;
    }


    private void setFacility(String fac) throws IllegalParameterException {
        validateFacility(fac);
        facility = fac;
    }


    private void validateFacility(String fac) throws IllegalParameterException {
        if (fac == null){
            throw new IllegalParameterException("Facility cannot be null");
        }
    }

    private void validateDistance(int distance) throws IllegalParameterException {
        if (distance < 0){
            throw new IllegalParameterException("Distance cannot be null");
        }
    }
}
