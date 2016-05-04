package logistics.networkservice.travelguide;

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public class TravelGuideFactory {

    public static TravelGuide build(NetworkGraph graph) throws NullParameterException{
        return new TravelGuideImpl(graph);
    }
}
