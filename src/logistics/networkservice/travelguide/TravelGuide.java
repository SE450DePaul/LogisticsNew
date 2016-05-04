package logistics.networkservice.travelguide;

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public interface TravelGuide {

//    Collection<String> shortestPath(String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException;
//    int distance(String facility, String destination) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, NullParameterException;
//    Double travelTime(int distance, double drivingHours, double mph) throws NegativeOrZeroParameterException;
//    String printTravelItinerary(String facility, String destination, double drivingHours, double mph) throws FacilityNotFoundInNetworkException, NegativeOrZeroParameterException, NeighborNotFoundInNetworkException;
    TravelGuideDTO getTravelGuideDTO(String facility, String destination) throws NullParameterException, FacilityNotFoundInNetworkException;
}
