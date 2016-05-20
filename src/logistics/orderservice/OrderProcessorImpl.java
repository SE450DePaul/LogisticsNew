package logistics.orderservice;

import logistics.facilityservice.FacilityService;
import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.dtos.FacilityWithItemDTO;
import logistics.itemservice.ItemCatalogService;
import logistics.networkservice.NetworkService;
import logistics.networkservice.travelguide.TravelGuideDTO;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * This class represents the Order Processor Impl manager and provides
 * methods to help process one order at a time.
 *
 * @author Uchenna F. Okoye
 */
public class OrderProcessorImpl implements OrderProcessor {

    private String destination;
    private String itemId;
    private int startTime;
    private int quantityNeeded;
    private FacilityService facilityService;
    private NetworkService networkService;
    private InventoryService inventoryService;
    private ItemCatalogService itemCatalogService;
    private ScheduleService scheduleService;


    public OrderProcessorImpl(String itemId, int quantityNeeded, String destination, int startTime) throws NeighborNotFoundInNetworkException {
        this.destination = destination;
        this.itemId = itemId;
        this.startTime = startTime;
        this.quantityNeeded = quantityNeeded;
        facilityService = FacilityService.getInstance();
        networkService = NetworkService.getInstance();
        inventoryService = InventoryService.getInstance();
        itemCatalogService = ItemCatalogService.getInstance();
        scheduleService = scheduleService.getInstance();
    }

    public void process() throws NeighborNotFoundInNetworkException {
        processItems();
    }

    private void processItems() throws NeighborNotFoundInNetworkException {
        TreeSet<FacilityRecordDTO> facilityRecordDTOTreeSet = buildFacilityRecordCollection();
        processFacilityRecords(facilityRecordDTOTreeSet);
    }

    private TreeSet<FacilityRecordDTO> buildFacilityRecordCollection() throws NeighborNotFoundInNetworkException {
        Collection<FacilityWithItemDTO> facilities = getFacilitiesWithItem(itemId);
        TreeSet<FacilityRecordDTO> facilityRecordDTOs = new TreeSet<>(new Comparator<FacilityRecordDTO>() {
            @Override
            public int compare(FacilityRecordDTO o1, FacilityRecordDTO o2) {
                if (o1.arrivalDay > o2.arrivalDay) {
                    return 1;
                } else if (o1.arrivalDay < o2.arrivalDay) {
                    return -1;
                }
                return 0;
            }
        });

        for (FacilityWithItemDTO facility : facilities) {
            facilityRecordDTOs.add(buildFacilityRecord(facility));
        }

        return facilityRecordDTOs;
    }


    private FacilityRecordDTO buildFacilityRecord(FacilityWithItemDTO facility) throws NeighborNotFoundInNetworkException {
        FacilityRecordDTO facilityRecordDTO = null;
        try {
            String source = facility.name;
            int noOfItems = facility.quantity;
            int travelTime = getTravelTime(source, destination);
            int processingEndDay = scheduleService.getProcessDaysNeeded(source, noOfItems, startTime);
            int arrivalDay = calculateArrivalDay(processingEndDay, travelTime);
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

    private void processFacilityRecords(TreeSet<FacilityRecordDTO> facilityRecordDTOTreeSet){
        int requiredQuantity = quantityNeeded;
        for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOTreeSet){
            if(requiredQuantity <= 0) {
                break;
            }
            int noOfItemsToRetrieve = 0;
            int noOfItemsAtFacility = facilityRecordDTO.noOfItems;
            if (requiredQuantity > noOfItemsAtFacility){
                noOfItemsToRetrieve = noOfItemsAtFacility;
            }
            requiredQuantity -= noOfItemsAtFacility;
            try {
                processFromFacility(facilityRecordDTO, noOfItemsToRetrieve);
            } catch (QuantityExceedsAvailabilityException e) {
                e.printStackTrace();
            } catch (NullParameterException e) {
                e.printStackTrace();
            } catch (ItemNotFoundInActiveInventoryException e) {
                e.printStackTrace();
            } catch (NegativeOrZeroParameterException e) {
                e.printStackTrace();
            } catch (FacilityNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalParameterException e) {
                e.printStackTrace();
            }
        }
    }

    private void processFromFacility(FacilityRecordDTO facilityRecordDTO, int quantity) throws IllegalParameterException, FacilityNotFoundException {
        String facility = facilityRecordDTO.source;
        int processingEndDay = scheduleService.getProcessDaysNeeded(facility, quantity, startTime);
        inventoryService.reduceFromInventory(facility, itemId, quantity);
        scheduleService.bookFacility(facility, quantity, startTime);
        if (processingEndDay != facilityRecordDTO.processingEndDay) {
            int arrivalDay = calculateArrivalDay(processingEndDay, facilityRecordDTO.travelTime);
            facilityRecordDTO.processingEndDay = processingEndDay;
            facilityRecordDTO.arrivalDay = arrivalDay;
        }
    }

    private Collection<FacilityWithItemDTO> getFacilitiesWithItem(String itemId) {
        Collection<FacilityWithItemDTO> facilityWithItemDTOs = inventoryService.getFacilitiesWithItemDTO(itemId);
        for (FacilityWithItemDTO facilityWithItemDTO : facilityWithItemDTOs) {
            if (facilityWithItemDTO.name == destination) {
                facilityWithItemDTOs.remove(facilityWithItemDTO);
            }
        }

        return facilityWithItemDTOs;
    }

    private int calculateArrivalDay(int processingEndDay, int travelTime){
        return processingEndDay + travelTime;
    }

    private int getTravelTime(String source, String destination) throws FacilityNotFoundInNetworkException, NullParameterException, NeighborNotFoundInNetworkException {
        TravelGuideDTO travelGuideDTO = NetworkService.getInstance().getTravelGuideDTO(source, destination);
        int travelTime = travelGuideDTO.timeInDays.intValue();
        return travelTime;
    }



}
