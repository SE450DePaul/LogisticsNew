package logistics.networkservice.travelguide;

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public interface TravelGuide {
    TravelGuideDTO getTravelGuideDTO(String facility, String destination) throws NullParameterException, FacilityNotFoundInNetworkException;
}
