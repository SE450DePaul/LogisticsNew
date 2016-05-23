package logistics.networkservice.travelguide.algorithm;

/**
 * This class represents a Shortest Path Factory, which handles object creation 
 * of new implementation classes of the Shortest Path algorithm.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

public class ShortestPathAlgorithmFactory {

    public static ShortestPathAlgorithm build(NetworkGraph graph, String start) throws NullParameterException, FacilityNotFoundInNetworkException {
        return new DijkstraImpl(graph, start);
    }
}
