package logistics.networkservice.travelguide;

/**
 * This class represents a Travel Guide Factory, which handles object creation 
 * of new Travel Guide implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.NullParameterException;

public class TravelGuideFactory {

	/*
	 * Returns a newly created Travel Guide object given
	 * a NetworkGraph object. 
	 */
    public static TravelGuide build(NetworkGraph graph) throws NullParameterException{
        return new TravelGuideImpl(graph);
    }
}
