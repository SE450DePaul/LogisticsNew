package logistics.networkservice.shortestpath;

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public class ShortestPathFactory {

    public static ShortestPathStrategy build(NetworkGraph graph, String start) throws NullParameterException, FacilityNotFoundInNetworkException {
        return new DijkstraImpl(graph, start);
    }
}
