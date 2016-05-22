package logistics.orderservice.chainofresponsibility;

import logistics.facilityservice.FacilityService;
import logistics.inventoryservice.InventoryService;
import logistics.itemservice.ItemCatalogService;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.FacilityNotFoundException;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

import java.util.Collection;

/**
 * Created by uchennafokoye on 5/20/16.
 */
public abstract class ProcessChain {

    private ProcessChain chain;
    protected InventoryService inventoryService = InventoryService.getInstance();
    protected ScheduleService scheduleService = ScheduleService.getInstance();
    protected FacilityService facilityService = FacilityService.getInstance();
    protected ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();

    public void setNextChain(ProcessChain chain) {
        this.chain = chain;
    }

    public void process(Collection<FacilityRecordDTO> facilityRecordDTOs) throws FacilityNotFoundInNetworkException, IllegalParameterException, NeighborNotFoundInNetworkException, FacilityNotFoundException {
        facilityRecordDTOs = getFacilityRecordDTOs(facilityRecordDTOs);
        if (chain != null){
            chain.process(facilityRecordDTOs);
        }
    }

    public abstract Collection<FacilityRecordDTO> getFacilityRecordDTOs(Collection<FacilityRecordDTO> facilityRecordDTOs) throws NeighborNotFoundInNetworkException, IllegalParameterException, FacilityNotFoundInNetworkException, FacilityNotFoundException;

    protected int calculateArrivalDay(int processingEndDay, int travelTime){
        return processingEndDay + travelTime;
    }


}
