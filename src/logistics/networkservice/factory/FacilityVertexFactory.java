package logistics.networkservice.factory;

/**
 * This class represents an Facility Vertex Factory, which handles object creation 
 * of new Facility Vertex implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.implementation.FacilityVertexImpl;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.NullParameterException;

public class FacilityVertexFactory {

    public static FacilityVertex build(String facilityName) throws NullParameterException {

        return new FacilityVertexImpl(facilityName);

    }

}
