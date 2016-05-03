package logistics.networkservice;

import logistics.networkservice.factory.NetworkGraphFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.networkservice.shortestpath.ShortestPathFactory;
import logistics.networkservice.shortestpath.ShortestPathStrategy;
import logistics.utilities.exceptions.*;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class NetworkService {

    private volatile static NetworkService instance;
    private HashSet<String> facilities;
    private Loader loader;
    private Double DEFAULT_DRIVING_HOURS_PER_DAY = 8.0;
    private Double DEFAULT_DRIVING_MILES_PER_HOUR = 50.0;
    private HashMap<String, ShortestPathStrategy> shortestPathHash;


    private NetworkGraph networkGraph;

    private NetworkService() {
            loader = LoaderFactory.build("network");
            facilities = new HashSet<>();
            networkGraph = NetworkGraphFactory.build();
            shortestPathHash = new HashMap<>();
            buildGraph();
    }

    public static NetworkService getInstance() {
        if (instance == null){
            synchronized (NetworkService.class){
                if (instance == null){
                    instance = new NetworkService();
                }
            }
        }

        return instance;
    }

    public int distance (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
        if (shortestPathHash.get(facility) == null) {
            ShortestPathStrategy shortestPaths = ShortestPathFactory.build(networkGraph, facility);
            shortestPathHash.put(facility, shortestPaths);
        }
        return shortestPathHash.get(facility).distanceTo(destination);
    }


    public Collection<String> shortestPath (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
        if (shortestPathHash.get(facility) == null) {
            ShortestPathStrategy shortestPaths = ShortestPathFactory.build(networkGraph, facility);
            shortestPathHash.put(facility, shortestPaths);
        }

        return shortestPathHash.get(facility).shortestPathTo(destination);
    }

    public String getOutput(String facility) throws FacilityNotFoundInNetworkException {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = networkGraph.neighbors(facility);
        stringBuffer.append("\n");
        stringBuffer.append("Direct links: ");
        stringBuffer.append("\n");
        while (iterator.hasNext()) {
            String neighbor = iterator.next();
            stringBuffer.append(neighbor);

            int distance = 0;
            try {
                distance = networkGraph.distanceToNeighbor(facility, neighbor);
            } catch (NeighborNotFoundInNetworkException e) {
                e.printStackTrace();
            }
            Double travelTime = travelTime(distance, DEFAULT_DRIVING_HOURS_PER_DAY, DEFAULT_DRIVING_MILES_PER_HOUR);

            stringBuffer.append(" (" + String.format("%1.1f", travelTime) + "d)");
            stringBuffer.append("; ");

        }

        stringBuffer.append("\n");
        return stringBuffer.toString();
    }


    private Double travelTime(int distance, double drivingHours, double mph){
        Double time = distance / drivingHours / mph;
        return time;
    }


    private void buildGraph() {
        try {
            Collection<FacilityVertex> facilityVertices = loader.load();
            for (FacilityVertex facilityVertex : facilityVertices){
                String facilityName = facilityVertex.getFacilityName();
                networkGraph.addFacility(facilityName);
                facilities.add(facilityName);

                Iterator<String> iterator = facilityVertex.neighbors();
                while (iterator.hasNext()){
                    String neighbor = iterator.next();
                    int distance = facilityVertex.distanceTo(neighbor);
                    networkGraph.addNeighbor(facilityName, neighbor, distance);
                }

            }
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (SelfLoopNetworkException e) {
            e.printStackTrace();
        } catch (NeighborNotFoundInNetworkException e) {
            e.printStackTrace();
        }
    }






    public static void main(String[] args){

        NetworkService networkService = NetworkService.getInstance();
//        try {
//            System.out.println("Distance from Seattle to Fargo: " + networkService.distance("Seattle, WA", "Fargo, ND"));
//        } catch (FacilityNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NeighborNotFoundInNetworkException e) {
//            e.printStackTrace();
//        }

        try {
            System.out.println(networkService.getOutput("Chicago, IL"));
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("Distance from Chicago to Denver, CO: ");
            System.out.println(networkService.distance("Chicago, IL", "Denver, CO"));
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (NeighborNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (NullParameterException e) {
            e.printStackTrace();
        }

        try {
            Collection<String> shortestPath = networkService.shortestPath("Chicago, IL", "Denver, CO");

            System.out.println("Shortest path from Chicago to Denver");

            int i = 0;
            int size = shortestPath.size() - 1;
            for (String link : shortestPath){
                System.out.print(link);
                if (i < size){
                    System.out.print(" -> ");
                }
                i++;
            }

            System.out.println("");

        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (NeighborNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (NullParameterException e) {
            e.printStackTrace();
        }



    }

}
