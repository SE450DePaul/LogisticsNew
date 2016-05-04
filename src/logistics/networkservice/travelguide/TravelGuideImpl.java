package logistics.networkservice.travelguide;

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.networkservice.travelguide.algorithm.ShortestPathAlgorithm;
import logistics.networkservice.travelguide.algorithm.ShortestPathAlgorithmFactory;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class TravelGuideImpl implements TravelGuide {

    private HashMap<String, ShortestPathAlgorithm> shortestPathHash;
    private NetworkGraph networkGraph;
    private Double DEFAULT_DRIVING_HOURS_PER_DAY = 8.0;
    private Double DEFAULT_DRIVING_MILES_PER_HOUR = 50.0;

    public TravelGuideImpl(NetworkGraph graph) throws NullParameterException {
            validateGraph(graph);
            networkGraph = graph;
            shortestPathHash = new HashMap<>();
    }

//    public int distance (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
//        if (shortestPathHash.get(facility) == null) {
//            ShortestPathAlgorithm shortestPaths = ShortestPathAlgorithmFactory.build(networkGraph, facility);
//            shortestPathHash.put(facility, shortestPaths);
//        }
//        return shortestPathHash.get(facility).distanceTo(destination);
//    }
//
//    public Collection<String> shortestPath (String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException {
//        if (shortestPathHash.get(facility) == null) {
//            ShortestPathAlgorithm shortestPaths = ShortestPathAlgorithmFactory.build(networkGraph, facility);
//            shortestPathHash.put(facility, shortestPaths);
//        }
//
//        return shortestPathHash.get(facility).shortestPathTo(destination);
//    }


    public TravelGuideDTO getTravelGuideDTO(String facility, String destination) throws NullParameterException, FacilityNotFoundInNetworkException {

        if (shortestPathHash.get(facility) == null) {
            ShortestPathAlgorithm shortestPaths = ShortestPathAlgorithmFactory.build(networkGraph, facility);
            shortestPathHash.put(facility, shortestPaths);
        }
        int distance = shortestPathHash.get(facility).distanceTo(destination);
        Collection<String> path = shortestPathHash.get(facility).shortestPathTo(destination);
        Double travelTime = travelTime(distance, DEFAULT_DRIVING_HOURS_PER_DAY, DEFAULT_DRIVING_MILES_PER_HOUR);

        return new TravelGuideDTO(path, distance, travelTime, DEFAULT_DRIVING_HOURS_PER_DAY, DEFAULT_DRIVING_MILES_PER_HOUR);

    }
    private void validateGraph(NetworkGraph networkGraph) throws NullParameterException {
        if (networkGraph == null){
            throw new NullParameterException();
        }
    }

//    public String printTravelItinerary(String facility, String destination, double drivingHours, double mph) throws FacilityNotFoundInNetworkException, NullParameterException, NeighborNotFoundInNetworkException, NegativeOrZeroParameterException {
//
//        Collection<String> path = shortestPath(facility, destination);
//        int distance = distance(facility, destination);
//        Double days = travelTime(distance, drivingHours, mph);
//
//
//        StringBuffer str = new StringBuffer();
//        int i = 0;
//        int size = path.size() - 1;
//        for (String link : path) {
//            if (size == 0){
//                str.append("\t");
//                str.append("-");
//            }
//            str.append(link);
//            if (i < size){
//                str.append("->");
//            }
//
//            i++;
//        }
//
//        String distanceInString = distance + "mi";
//        String daysInString = days + " days";
//
//        str.append(" = ");
//        str.append(distanceInString);
//
//        str.append("\n");
//        str.append("\t");
//        str.append(distanceInString + "/ (" + drivingHours + "hours per day * " + mph  + "mph");
//        str.append(" = ");
//        str.append(daysInString);
//
//
//
//        return str.toString();
//
//    }



    private Double travelTime(int distance, double drivingHours, double mph){
        Double time = distance / drivingHours / mph;
        return time;
    }





}
