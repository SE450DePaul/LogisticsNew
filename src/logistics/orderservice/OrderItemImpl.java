package logistics.orderservice;

import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.dtos.FacilityWithItemDTO;
import logistics.networkservice.NetworkService;
import logistics.networkservice.travelguide.TravelGuideDTO;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.Collection;
import java.util.HashMap;

/**
 * This class represents the Order Processor Impl manager and provides
 * methods to help process one order at a time.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderItemImpl implements OrderItemProcess {

    private String destination;
    private HashMap<String, TravelGuideDTO> travelGuideDTOHashMap;
    private HashMap<String, FacilityWithItemDTO> facilityWithItemDTOHashMap;

    public OrderItemImpl(String itemId, String orderDestination) throws NeighborNotFoundInNetworkException {
        destination = orderDestination;
        travelGuideDTOHashMap = new HashMap<>();
        facilityWithItemDTOHashMap = new HashMap<>();
        buildFacilityWithItemsDTO(itemId);
        buildAllFacilityRecords();
    }

    /*
     * Returns a Collection of FacilitiesWithItemDTO without the destination included
     * which provides a list of all the facilities with an item and the quantity
     */
    private void buildFacilityWithItemsDTO(String itemId){

        Collection<FacilityWithItemDTO> facilityWithItemDTOs = InventoryService.getInstance().getFacilitiesWithItemDTO(itemId);

        for (FacilityWithItemDTO facilityWithItemDTO : facilityWithItemDTOs){
            String name = facilityWithItemDTO.name;
            if (name != destination){
                facilityWithItemDTOHashMap.put(name, facilityWithItemDTO);
            }
        }

    }

    private void buildAllFacilityRecords() throws NeighborNotFoundInNetworkException {
        Collection<FacilityWithItemDTO> facilities = facilityWithItemDTOHashMap.values();
        for (FacilityWithItemDTO facility : facilities){
            buildFacilityRecord(facility);
        }
    }

    private FacilityRecordDTO buildFacilityRecord(FacilityWithItemDTO facility) throws NeighborNotFoundInNetworkException {
        FacilityRecordDTO facilityRecordDTO = null;
        try {
            String source = facility.name;
            int noOfItems = facility.quantity;
            TravelGuideDTO travelGuideDTO = NetworkService.getInstance().getTravelGuideDTO(source, destination);
            int travelTime = travelGuideDTO.timeInDays.intValue();
            int processingEndDay= ScheduleService.getInstance().getProcessDaysNeeded(source, noOfItems, 1);
            int arrivalDay = processingEndDay + travelTime;
            facilityRecordDTO = new FacilityRecordDTO(source, noOfItems, processingEndDay, travelTime, arrivalDay);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (IllegalParameterException e) {
            e.printStackTrace();
        }

        return facilityRecordDTO;
    }


    /*
     * Returns a Collection of TravelGuideDTOs from the Network Service
     * which provides a list of all the facilities with an item and the quantity
     */
    private void buildTravelGuidesDTO(Collection<String> origins, String destination) {

        NetworkService networkService = NetworkService.getInstance();
        for (String origin : origins) {
            try {
                travelGuideDTOHashMap.put(origin, networkService.getTravelGuideDTO(origin, destination));
            } catch (NullParameterException e) {
                e.printStackTrace();
            } catch (FacilityNotFoundInNetworkException e) {
                e.printStackTrace();
            } catch (NeighborNotFoundInNetworkException e) {
                e.printStackTrace();
            }
        }

    }

    private double getArrivalDay(TravelGuideDTO travelGuideDTO) {
        double travelTime = travelGuideDTO.timeInDays;
        return travelTime;
    }

    private Integer daysNeededPerFacility(String facility, int noOfItemsToProcess, int startDay) throws IllegalParameterException {
        return ScheduleService.getInstance().getProcessDaysNeeded(facility, noOfItemsToProcess, startDay);
    }









}
