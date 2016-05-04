package logistics.networkservice.travelguide.algorithm;

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public class ShortestPathAlgorithmFactory {

    public static ShortestPathAlgorithm build(NetworkGraph graph, String start) throws NullParameterException, FacilityNotFoundInNetworkException {
        return new DijkstraImpl(graph, start);
    }
}
