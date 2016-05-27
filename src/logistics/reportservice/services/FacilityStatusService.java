package logistics.reportservice.services;

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


    public String getOutput(String facilityName) throws FacilityNotFoundInNetworkException, IllegalParameterException {

        StringBuffer str = new StringBuffer();
        System.out.print("\n\n");
        //str.append("\n");
        System.out.print(facilityService.getOutput(facilityName));
        //str.append(facilityService.getOutput(facilityName));
        System.out.print("\n");
        //str.append("\n");
        //str.append(networkService.getDirectLinksOutput(facilityName));
        System.out.print(networkService.getDirectLinksOutput(facilityName));
        System.out.print("\n");
        //str.append("\n");
        //str.append(inventoryService.getOutput(facilityName));
        System.out.print(inventoryService.getOutput(facilityName));
        //str.append("\n");
        //System.out.print("\n");
        //str.append(scheduleService.getOutput(facilityName));
        System.out.print(scheduleService.getOutput(facilityName));

        //str.append("\n"); 
        System.out.print("\n");
        //str.append(generateDashedLine(100));
        System.out.print(generateDashedLine(100));

        return str.toString();

    }

    private String generateDashedLine(int length) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < length; i++){
            str.append("-");
        }
        return str.toString();
    }


}
