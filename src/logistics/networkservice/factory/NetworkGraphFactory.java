package logistics.networkservice.factory;

import logistics.networkservice.implementation.NetworkGraphImpl;
import logistics.networkservice.interfaces.NetworkGraph;

/**
 * Created by uchennafokoye on 4/30/16.
 */
public class NetworkGraphFactory {

    public static NetworkGraph build() {

        return new NetworkGraphImpl();

    }

}
