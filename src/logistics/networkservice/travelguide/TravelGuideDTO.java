package logistics.networkservice.travelguide;

import java.util.Collection;

/**
 * This class represents a Travel Guide Data Transfer Object,
 * which is used by the Travel Guide Service manager when communicating
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */

public class TravelGuideDTO
{
    public Collection<String> path;
    public int distance;
    public Double timeInDays;
    public Double hoursDriving;
    public Double mph;

    /*
     * Creates a new TravelGuideDTO given a travel path, travel distance, travel time, number of driving hours and travel speed.
     */
    public TravelGuideDTO(Collection<String> travelPath, int travelDistance, double travelTime, Double hoursDrivingPerDay, Double milesPerHour)
    {
        path = travelPath;
        distance = travelDistance;
        timeInDays = travelTime;
        mph = milesPerHour;
        hoursDriving = hoursDrivingPerDay;
    }
}