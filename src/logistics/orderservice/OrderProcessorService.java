package logistics.orderservice;

import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.dtos.FacilityWithItemDTO;
import logistics.networkservice.NetworkService;
import logistics.networkservice.travelguide.TravelGuideDTO;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents the Order Processor Service manager and provides
 * methods to help process one order at a time.
 * 
 * @author Uchenna F. Okoye
 */
public final class OrderProcessorService {

    private volatile static OrderProcessorService instance;

    private OrderProcessorService() {

    }

    public static OrderProcessorService getInstance() {
        if (instance == null){
            synchronized (OrderProcessorService.class){
                if (instance == null){
                    instance = new OrderProcessorService();
                }
            }
        }

        return instance;
    }


    public void processOrder(String itemId, String destination){

    }


    /*
     * Returns a Collection of FacilitiesWithItemDTO without the destination included
     * which provides a list of all the facilities with an item and the quantity
     */
    private Collection<FacilityWithItemDTO> getFacilitiesWithItem(String itemId, String destination){

        Collection<FacilityWithItemDTO> facilityWithItemDTOs = InventoryService.getInstance().getFacilitiesWithItemDTO(itemId);

        for (FacilityWithItemDTO facilityWithItemDTO : facilityWithItemDTOs){
            if (facilityWithItemDTO.facility == destination){
                facilityWithItemDTOs.remove(facilityWithItemDTO);
            }
        }

        return facilityWithItemDTOs;
    }

    /*
     * Returns a Collection of TravelGuideDTOs from the Network Service
     * which provides a list of all the facilities with an item and the quantity
     */
    private Collection<TravelGuideDTO> getTravelGuideDTOs(Collection<String> origins, String destination) {
        ArrayList<TravelGuideDTO> travelGuideDTOs = new ArrayList<>();

        NetworkService networkService = NetworkService.getInstance();
        for (String origin : origins) {
            try {
                travelGuideDTOs.add(networkService.getTravelGuideDTO(origin, destination));
            } catch (NullParameterException e) {
                e.printStackTrace();
            } catch (FacilityNotFoundInNetworkException e) {
                e.printStackTrace();
            } catch (NeighborNotFoundInNetworkException e) {
                e.printStackTrace();
            }
        }

        return travelGuideDTOs;
    }









}
