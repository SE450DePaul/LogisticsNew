package logistics.orderservice.chainofresponsibility.chains;

import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.chainofresponsibility.ProcessChain;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.utilities.exceptions.*;

import java.util.Collection;

/** Processes Facility Records
 * Created by uchennafokoye on 5/20/16.
 */
public class ProcessFacilityRecordsChain extends ProcessChain {

    private OrderItemRequestDTO orderItemRequestDTO;

    public ProcessFacilityRecordsChain(OrderItemRequestDTO orderItemRequestDTO){
        this.orderItemRequestDTO = orderItemRequestDTO;
    }

    public Collection<FacilityRecordDTO> getFacilityRecordDTOs(Collection<FacilityRecordDTO> facilityRecordDTOs) throws IllegalParameterException, FacilityNotFoundException {
        return processFacilityRecords(facilityRecordDTOs);
    }

    private Collection<FacilityRecordDTO> processFacilityRecords(Collection<FacilityRecordDTO> facilityRecordDTOCollection) throws IllegalParameterException, FacilityNotFoundException {
        int requiredQuantity = orderItemRequestDTO.quantityNeeded;
        for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOCollection){
            if(requiredQuantity <= 0) {
                break;
            }
            int noOfItemsToRetrieve = 0;
            int noOfItemsAtFacility = facilityRecordDTO.noOfItems;
            if (requiredQuantity > noOfItemsAtFacility){
                noOfItemsToRetrieve = noOfItemsAtFacility;
            }
            requiredQuantity -= noOfItemsAtFacility;
            processFromFacility(facilityRecordDTO, noOfItemsToRetrieve);
        }

        return facilityRecordDTOCollection;
    }

    private void processFromFacility(FacilityRecordDTO facilityRecordDTO, int quantity) throws IllegalParameterException, FacilityNotFoundException {
        String facility = facilityRecordDTO.source;
        int startTime = orderItemRequestDTO.startTime;
        int processingEndDay = scheduleService.getProcessDaysNeeded(facility, quantity, startTime);
        inventoryService.reduceFromInventory(facility, orderItemRequestDTO.itemId, quantity);
        scheduleService.bookFacility(facility, quantity, startTime);
        if (processingEndDay != facilityRecordDTO.processingEndDay) {
            int arrivalDay = calculateArrivalDay(processingEndDay, facilityRecordDTO.travelTime);
            facilityRecordDTO.processingEndDay = processingEndDay;
            facilityRecordDTO.arrivalDay = arrivalDay;
        }
    }


}
