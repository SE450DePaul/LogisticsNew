package logistics.reportservice.services;

/**
 * This class represents a Travel Guide Service Manager that keeps track of
 * all Traveling information needed by each Facility.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.NetworkService;
import logistics.networkservice.travelguide.TravelGuideDTO;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import java.text.DecimalFormat;
import java.util.Collection;

public final class TravelGuideService {

    private volatile static TravelGuideService instance;
    NetworkService networkService;

    private TravelGuideService() {

        networkService = NetworkService.getInstance();
    }

    /*
     * Returns an instance of the Travel Guide service.
     */
    private static TravelGuideService getInstance()
    {
        if (instance == null)
        {
            synchronized (TravelGuideService.class)
            {
                if (instance == null)
                {
                    instance = new TravelGuideService();
                }
            }
        }
        return instance;
    }
    
    /*
     * Given a source Facility and its destination return a Travel Itinerary.
     */
    public static String printItinerary(String origin, String destination) throws FacilityNotFoundInNetworkException, IllegalParameterException, NeighborNotFoundInNetworkException {
        TravelGuideService reporter = getInstance();
        NetworkService netService = reporter.networkService;
        TravelGuideDTO travelItinerary = netService.getTravelGuideDTO(origin, destination);
        return printTravelItinerary(travelItinerary);
    }
    
    /*
     * Given a Travel Guide DTO return its Travel Itinerary.
     */
    private static String printTravelItinerary(TravelGuideDTO travelGuideDTO) {

        Collection<String> path = travelGuideDTO.path;
        int distance = travelGuideDTO.distance;
        Double days = travelGuideDTO.timeInDays;
        Double drivingHours = travelGuideDTO.hoursDriving;
        Double mph = travelGuideDTO.mph;

        StringBuffer str = new StringBuffer();
        int i = 0;
        int size = path.size() - 1;
        for (String link : path) {
            if (i == 0){
                str.append("\t");
                str.append("- ");
            }
            str.append(link);
            if (i < size){
                str.append("->");
            }

            i++;
        }

        DecimalFormat commaFormat = new DecimalFormat("#,###");
        DecimalFormat inputFormat = new DecimalFormat(".##");
        DecimalFormat nonDecimalFormat = new DecimalFormat("#");

        String distanceInString = commaFormat.format(distance) + " mi";
        String daysInString = inputFormat.format(days) + " days";

        str.append(" = ");
        str.append(distanceInString);

        str.append("\n");
        str.append("\t");
        str.append("- " + distanceInString + " / (" + nonDecimalFormat.format(drivingHours) + " hours per day * " + nonDecimalFormat.format(mph)  + " mph");
        str.append(" = ");
        str.append(daysInString);

        return str.toString();
    }
}
