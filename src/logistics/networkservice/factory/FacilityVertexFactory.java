package logistics.networkservice.factory;

import logistics.networkservice.implementation.FacilityVertexImpl;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 4/30/16.
 */
public class FacilityVertexFactory {

    public static FacilityVertex build(String facilityName) throws NullParameterException {

        return new FacilityVertexImpl(facilityName);

    }

}
