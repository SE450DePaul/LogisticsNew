package logistics.reportservice;

/**
 * This class represents a Facility Reporter implementation which
 * prints out information and the status of all Facilities.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.facilityservice.FacilityService;
import logistics.networkservice.NetworkService;
import logistics.reportservice.services.FacilityStatusService;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import java.util.Set;

public final class FacilityStatusReporter implements Reporter {

    private volatile static FacilityStatusReporter instance;
    NetworkService networkService;
    FacilityService facilityService;
    FacilityStatusService facilityStatusService;

    private FacilityStatusReporter() {

        networkService = NetworkService.getInstance();
        facilityService = FacilityService.getInstance();
        facilityStatusService = FacilityStatusService.getInstance();
    }

    /*
     * Returns an instance of the Facility Status Reporter.
     */
    public static FacilityStatusReporter getInstance()
    {
        if (instance == null)
        {
            synchronized (FacilityStatusReporter.class)
            {
                if (instance == null)
                {
                    instance = new FacilityStatusReporter();
                }
            }
        }
        return instance;
    }

    /*
     * Returns the current status of all Facilities.
     */
    public void printOutput() {
        StringBuffer str = new StringBuffer();
        Set<String> facilityNames = facilityService.getFacilityNames();

        for (String facilityName : facilityNames){
            try {
                str.append(facilityStatusService.getOutput(facilityName));
            } catch (FacilityNotFoundInNetworkException e) {
                e.printStackTrace();
            } catch (IllegalParameterException e) {
                e.printStackTrace();
            }
        }

        System.out.println(str);
    }
}
