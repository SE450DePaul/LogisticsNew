package logistics.networkservice.factory;

import logistics.facilityservice.Facility;
import logistics.networkservice.implementation.FacilityVertexImpl;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.IllegalParameterException;

/**
 * Created by uchennafokoye on 4/30/16.
 */
public class FacilityVertexFactory {

    public static FacilityVertex build(Facility facility) throws IllegalParameterException {

        return new FacilityVertexImpl(facility);

    }

}
