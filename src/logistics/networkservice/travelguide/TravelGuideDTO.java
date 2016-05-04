package logistics.networkservice.travelguide;

import java.util.Collection;

/**
 * @author uchenna f. okoye
 */
public class TravelGuideDTO
{

    public Collection<String> path;
    public int distance;
    public Double timeInDays;
    public Double hoursDriving;
    public Double mph;

    public TravelGuideDTO(Collection<String> travelPath, int travelDistance, double travelTime, Double hoursDrivingPerDay, Double milesPerHour)
    {
        path = travelPath;
        distance = travelDistance;
        timeInDays = travelTime;
        mph = milesPerHour;
        hoursDriving = hoursDrivingPerDay;


    }


}
