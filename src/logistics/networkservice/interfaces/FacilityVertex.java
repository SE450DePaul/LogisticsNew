package logistics.networkservice.interfaces;

import logistics.facilityservice.Facility;
import logistics.utilities.exceptions.IllegalParameterException;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public interface FacilityVertex {

    void addNeighbor(Facility facility, int distance) throws IllegalParameterException;

    int distanceTo(Facility facility);

    boolean isANeighbor(Facility facility);

    Iterator<Facility> neighbor();

}
