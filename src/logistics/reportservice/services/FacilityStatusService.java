package logistics.reportservice.services;

/**
 * This class represents a Facility Status Service Manager that keeps track of
 * the status of all Facilities.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.facilityservice.FacilityService;
import logistics.inventoryservice.InventoryService;
import logistics.networkservice.NetworkService;
import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;

public final class FacilityStatusService {

    private volatile static FacilityStatusService instance;
    NetworkService networkService;
    FacilityService facilityService;
    InventoryService inventoryService;
    ScheduleService scheduleService;

    private FacilityStatusService() {
        networkService = NetworkService.getInstance();
        facilityService = FacilityService.getInstance();
        inventoryService = InventoryService.getInstance();
        scheduleService = ScheduleService.getInstance();
    }

    /*
     * Returns an instance of the Facility Status service.
     */
    public static FacilityStatusService getInstance()
    {
        if (instance == null)
        {
            synchronized (FacilityStatusService.class)
            {
                if (instance == null)
                {
                    instance = new FacilityStatusService();
                }
            }
        }
        return instance;
    }

    /*
     * Given a Facility name return its current status.
     */
    public String getOutput(String facilityName) throws FacilityNotFoundInNetworkException, IllegalParameterException {

        StringBuffer str = new StringBuffer();
        str.append("\n");
        str.append(facilityService.getOutput(facilityName));
        str.append("\n");
        str.append(networkService.getDirectLinksOutput(facilityName));
        str.append("\n");
        str.append(inventoryService.getOutput(facilityName));
        str.append("\n");
        str.append(scheduleService.getOutput(facilityName));
        str.append("\n");
        str.append(generateDashedLine(100));

        return str.toString();
    }
    
    /*
     * Helper method for formatting and displaying the Facility Status 
     * output with dashed lines. 
     */
    private String generateDashedLine(int length) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < length; i++){
            str.append("-");
        }
        return str.toString();
    }
}
