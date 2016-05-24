package logistics.orderservice.orderprocessor;

import logistics.facilityservice.FacilityService;
import logistics.inventoryservice.InventoryService;
import logistics.itemservice.ItemCatalogService;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.*;

import java.util.Collection;

/**
 * Created by uchennafokoye on 5/20/16.
 */
public abstract class ProcessChain {

    private ProcessChain chain;
    protected Collection<FacilityRecordDTO> facilityRecordDTOs;
    protected InventoryService inventoryService = InventoryService.getInstance();
    protected ScheduleService scheduleService = ScheduleService.getInstance();
    protected FacilityService facilityService = FacilityService.getInstance();
    protected ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();

    protected void setNextChain(ProcessChain chain) {
        this.chain = chain;
    }

    public Collection<FacilityRecordDTO> process() throws FacilityNotFoundInNetworkException, IllegalParameterException, NeighborNotFoundInNetworkException, FacilityNotFoundException {
        facilityRecordDTOs = buildFacilityRecordDTOs();
        if (chain != null){
            chain.setFacilityRecordDTOs(facilityRecordDTOs);
            facilityRecordDTOs = chain.process();
        }
        return facilityRecordDTOs;
    }

    protected void setFacilityRecordDTOs(Collection<FacilityRecordDTO> facilityRecordDTOs) throws NullParameterException {
        validateFacilityRecordDTOs(facilityRecordDTOs);
        this.facilityRecordDTOs = facilityRecordDTOs;
    };

    protected void validateFacilityRecordDTOs(Collection<FacilityRecordDTO> facilityRecordDTOs) throws NullParameterException {
        if (facilityRecordDTOs == null){
            throw new NullParameterException("Facility Record DTO cannot be null unless overridden");
        }
    }

    protected abstract Collection<FacilityRecordDTO> buildFacilityRecordDTOs() throws NeighborNotFoundInNetworkException, IllegalParameterException, FacilityNotFoundInNetworkException, FacilityNotFoundException;

    protected int calculateArrivalDay(int processingEndDay, int travelTime){
        return processingEndDay + travelTime;
    }


}
