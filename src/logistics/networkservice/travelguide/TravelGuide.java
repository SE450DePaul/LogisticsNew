package logistics.networkservice.travelguide;

/**
 * This is a Travel Guide Interface which provides common behaviors 
 * every Travel Guide implementation should be able to perform.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

public interface TravelGuide {
    TravelGuideDTO getTravelGuideDTO(String facility, String destination) throws NullParameterException, FacilityNotFoundInNetworkException;
}
