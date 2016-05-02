package logistics.networkservice.factory;

import logistics.networkservice.implementation.FacilityVertexImpl;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.IllegalParameterException;

/**
 * Created by uchennafokoye on 4/30/16.
 */
public class FacilityVertexFactory 
{

    public static FacilityVertex build(String facilityName) throws IllegalParameterException 
    {

        return new FacilityVertexImpl(facilityName);

    }

}
