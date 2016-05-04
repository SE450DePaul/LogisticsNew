package logistics.networkservice;

import logistics.networkservice.factory.NetworkGraphFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.networkservice.travelguide.TravelGuide;
import logistics.networkservice.travelguide.TravelGuideDTO;
import logistics.networkservice.travelguide.TravelGuideFactory;
import logistics.utilities.exceptions.*;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class NetworkService {

    private volatile static NetworkService instance;
    private HashSet<String> facilities;
    private Loader loader;
    private TravelGuide travelGuide;


    private NetworkGraph networkGraph;

    private NetworkService() {
            loader = LoaderFactory.build("network");
            facilities = new HashSet<>();
            networkGraph = NetworkGraphFactory.build();
            buildGraph();
            buildTravelGuide();
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

//    public int distance (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
//        return travelGuide.distance(facility, destination);
//    }
//
//
//    public Collection<String> shortestPath (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
//        return travelGuide.shortestPath(facility, destination);
//    }

    public String getDirectLinksOutput(String facility) throws FacilityNotFoundInNetworkException{
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = networkGraph.neighbors(facility);
        stringBuffer.append("\n");
        stringBuffer.append("Direct links: ");
        stringBuffer.append("\n");
        while (iterator.hasNext()) {

            String neighbor = iterator.next();
            stringBuffer.append(neighbor);

            try {
                TravelGuideDTO travelItinerary = getTravelGuideDTO(facility, neighbor);
                stringBuffer.append(" (" + String.format("%1.1f", travelItinerary.timeInDays ) + "d)");
                stringBuffer.append("; ");
            } catch (NullParameterException e) {
                e.printStackTrace();
            } catch (NeighborNotFoundInNetworkException e) {
                e.printStackTrace();
            }

        }

        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public TravelGuideDTO getTravelGuideDTO(String facility, String destination) throws NullParameterException, FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException {

        return travelGuide.getTravelGuideDTO(facility, destination);

    }

//    public String printTravelItinerary(String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException{
//        try {
//            return travelGuide.printTravelItinerary(facility, destination, DEFAULT_DRIVING_HOURS_PER_DAY, DEFAULT_DRIVING_MILES_PER_HOUR);
//        } catch (NegativeOrZeroParameterException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String printTravelItinerary(String facility, String destination, Double drivingHours, Double mph) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NegativeOrZeroParameterException {
//        return travelGuide.printTravelItinerary(facility, destination, drivingHours, mph);
//    }



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
        } catch (NegativeOrZeroParameterException e) {
            e.printStackTrace();
        }
    }


    private void buildTravelGuide() {
        try {
            travelGuide = TravelGuideFactory.build(networkGraph);
        } catch (NullParameterException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

//        NetworkService networkService = NetworkService.getInstance();
//        try {
//            System.out.println(networkService.getDirectLinksOutput("Chicago, IL"));
//        } catch (FacilityNotFoundInNetworkException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            System.out.println("Distance from Chicago to Denver, CO: ");
//            System.out.println(networkService.distance("Chicago, IL", "Denver, CO"));
//        } catch (FacilityNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NeighborNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NullParameterException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Collection<String> shortestPath = networkService.shortestPath("Chicago, IL", "Denver, CO");
//
//            System.out.println("Shortest path from Chicago to Denver");
//
//            int i = 0;
//            int size = shortestPath.size() - 1;
//            for (String link : shortestPath){
//                System.out.print(link);
//                if (i < size){
//                    System.out.print(" -> ");
//                }
//                i++;
//            }
//
//            System.out.println("");
//
//        } catch (FacilityNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NeighborNotFoundInNetworkException e) {
//            e.printStackTrace();
//        } catch (NullParameterException e) {
//            e.printStackTrace();
//        }



    }

}
