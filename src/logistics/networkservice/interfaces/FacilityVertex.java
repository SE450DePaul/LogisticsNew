package logistics.networkservice.interfaces;

import logistics.utilities.exceptions.IllegalParameterException;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface FacilityVertex {

    void addNeighbor(String facility, int distance) throws IllegalParameterException;

    int distanceTo(String facility);

    boolean isANeighbor(String facility);

    Iterator<String> neighbor();

    String getFacilityName();

}
