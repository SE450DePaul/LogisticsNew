package logistics.networkservice.factory;

/**
 * This class represents a Network Graph Factory, which handles object creation 
 * of new Network Graph implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.implementation.NetworkGraphImpl;
import logistics.networkservice.interfaces.NetworkGraph;

public class NetworkGraphFactory {

    public static NetworkGraph build() {

        return new NetworkGraphImpl();

    }

}
