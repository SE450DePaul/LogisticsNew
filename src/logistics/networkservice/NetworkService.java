package logistics.networkservice;

import logistics.networkservice.factory.NetworkGraphFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.networkservice.shortestpath.ShortestPathFactory;
import logistics.networkservice.shortestpath.ShortestPathStrategy;
import logistics.utilities.exceptions.*;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class NetworkService 
{
    private volatile static NetworkService instance;
    private HashSet<String> facilities;
    private Loader loader;
    private Double DEFAULT_DRIVING_HOURS_PER_DAY = 8.0;
    private Double DEFAULT_DRIVING_MILES_PER_HOUR = 50.0;
    private HashMap<String, ShortestPathStrategy> shortestPathHash;

    private NetworkGraph networkGraph;

    private NetworkService() 
    {
            loader = LoaderFactory.build("network");
            facilities = new HashSet<>();
            networkGraph = NetworkGraphFactory.build();
            shortestPathHash = new HashMap<>();
            buildGraph();
    }

    public static NetworkService getInstance() 
    {
        if (instance == null){
            synchronized (NetworkService.class)
            {
                if (instance == null)
                {
                    instance = new NetworkService();
                }
            }
        }

        return instance;
    }

    public int distance (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException 
    {
        if (shortestPathHash.get(facility) == null) 
        {
            ShortestPathStrategy shortestPaths = ShortestPathFactory.build(networkGraph, facility);
            shortestPathHash.put(facility, shortestPaths);
        }
        return shortestPathHash.get(facility).distanceTo(destination);
    }

    public double getDistanceDays(int distance) throws NullParameterException
    {
    	DecimalFormat inputFormat = new DecimalFormat(".##"); 
    	if (distance == 0)
    		throw new NullParameterException("Distance cannot be Zero");
    	
    	double distanceDays = travelTime(distance, 8, 50);	
        return Double.valueOf(inputFormat.format(distanceDays));	
    }

    public Collection<String> shortestPath (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException 
    {
        if (shortestPathHash.get(facility) == null) 
        {
            ShortestPathStrategy shortestPaths = ShortestPathFactory.build(networkGraph, facility);
            shortestPathHash.put(facility, shortestPaths);
        }
        return shortestPathHash.get(facility).shortestPathTo(destination);
    }

    public String getOutput(String facility) throws FacilityNotFoundInNetworkException 
    {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = networkGraph.neighbors(facility);
        while (iterator.hasNext()) 
        {
            String neighbor = iterator.next();
            stringBuffer.append(neighbor);

            int distance = 0;
            try 
            {
                distance = networkGraph.distanceToNeighbor(facility, neighbor);
            } 
            catch (NeighborNotFoundInNetworkException e) 
            {
                e.printStackTrace();
            }
            Double travelTime = travelTime(distance, DEFAULT_DRIVING_HOURS_PER_DAY, DEFAULT_DRIVING_MILES_PER_HOUR);

            stringBuffer.append(" (" + String.format("%1.1f", travelTime) + "d)");
            stringBuffer.append("; ");
        }
        return stringBuffer.toString();
    }

    private Double travelTime(int distance, double drivingHours, double mph) 
    {
    	
    	Double time = distance / drivingHours / mph;
        return time;
    }

    
    public void displayFacilityPathInfo(String facility, String destination)
    {
    	NetworkService networkService = NetworkService.getInstance();
    	
    	// display facilityNameA -to- facilityNameB information
    	
    	System.out.print("    - ");
    	networkService.getLink(facility, destination);
    	System.out.print("    - ");
    	try 
    	{
    		System.out.print(networkService.distance(facility, destination));
    	} 
    	catch (FacilityNotFoundInNetworkException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    	catch (NeighborNotFoundInNetworkException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    	catch (NullParameterException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	try 
    	{
    		System.out.print(" / 8 hours per day * 50mph = " + networkService.getDistanceDays(networkService.distance(facility, destination)) + " days\n\n");
    	} 
    	catch (NullParameterException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    	catch (FacilityNotFoundInNetworkException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    	catch (NeighborNotFoundInNetworkException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    public void getLink(String firstFacility, String secondFacility )
    {
    	NetworkService networkService = NetworkService.getInstance();
    	
    	try 
        {
            Collection<String> shortestPath = networkService.shortestPath(firstFacility, secondFacility);

            
            for (String link : shortestPath)
            {
                System.out.print(link + "->");
            }

            System.out.println("");

        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NullParameterException e) 
        {
            e.printStackTrace();
        }
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
                facilities.add(facilityName);

                Iterator<String> iterator = facilityVertex.neighbors();
                while (iterator.hasNext())
                {
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
        catch (NullParameterException e) 
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
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {

        NetworkService networkService = NetworkService.getInstance();
//        try 
          {
//            System.out.println("Distance from Seattle to Fargo: " + networkService.distance("Seattle, WA", "Fargo, ND"));
//        } 
        //catch (FacilityNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NeighborNotFoundInNetworkException e) {
//            e.printStackTrace();
//        }

        try 
        {
            System.out.println(networkService.getOutput("Chicago, IL"));
        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        }


        try 
        {
            System.out.println("Distance from Chicago to Denver, CO: ");
            System.out.println(networkService.distance("Chicago, IL", "Denver, CO"));
        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NullParameterException e) 
        {
            e.printStackTrace();
        }

        try 
        {
            Collection<String> shortestPath = networkService.shortestPath("Chicago, IL", "Denver, CO");

            System.out.println("Shortest path from Chicago to Denver");
            for (String link : shortestPath)
            {
                System.out.print(link + "->");
            }

            System.out.println("\n");

        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NullParameterException e) 
        {
            e.printStackTrace();
        }
        
       /* try 
        {
            Collection<String> shortestPath = networkService.shortestPath("Chicago, IL", "Denver, CO");
            System.out.println("Shortest path from Chicago to Denver");
            for (String link : shortestPath)
            {
                System.out.print(link + "-> ");
            }

            System.out.println("");

        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NullParameterException e) 
        {
            e.printStackTrace();
        }*/
      }
   }
}