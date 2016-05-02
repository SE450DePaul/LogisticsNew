package logistics.networkservice;

import logistics.networkservice.factory.NetworkGraphFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.exceptions.SelfLoopNetworkException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class NetworkService 
{

    private volatile static NetworkService instance;
    private Loader loader;


    private NetworkGraph networkGraph;

    private NetworkService() 
    {
            loader = LoaderFactory.build("network");
            networkGraph = NetworkGraphFactory.build();
            buildGraph();
    }

    public static NetworkService getInstance() 
    {
        if (instance == null)
        {
            synchronized (NetworkService.class)
            {
                if (instance == null){
                    instance = new NetworkService();
                }
            }
        }

        return instance;
    }

    public int distance (String facility, String neighbor) throws FacilityNotFoundInNetworkException 
    {
        return networkGraph.distanceToNeighbor(facility, neighbor);
    }


    private void buildGraph() 
    {
        try 
        {
            Collection<FacilityVertex> facilityVertices = loader.load();
            for (FacilityVertex facilityVertex : facilityVertices)
            {
                String facilityName = facilityVertex.getFacilityName();
                networkGraph.addFacility(facilityName);

                Iterator<String> iterator = facilityVertex.neighbor();
                while (iterator.hasNext()){
                    String neighbor = iterator.next();
                    int distance = facilityVertex.distanceTo(neighbor);
                    networkGraph.addNeighbor(facilityName, neighbor, distance);
                }

            }
        } 
        catch (LoaderFileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IllegalParameterException e) 
        {
            e.printStackTrace();
        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (SelfLoopNetworkException e) 
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {

        NetworkService networkService = NetworkService.getInstance();
        try 
        {
            System.out.println("Distance from Seattle to Fargo: " + networkService.distance("Seattle, WA", "Fargo, ND"));
        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        }


    }

}
