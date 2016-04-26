package logistics.facilityservice;

import logistics.facilityservice.inventory.InventoryDTO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Olorundare
 */
public class FacilityDTO
{

    public String name;
    public Double cost;
    public HashMap<String, InventoryDTO> inventoryHashMap = new HashMap<>();

    public FacilityDTO(String name, Double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public FacilityDTO(String name, Double cost, HashMap<String, InventoryDTO> inventoryDTOHashMap){

        this.name = name;
        this.cost = cost;
        this.inventoryHashMap = inventoryDTOHashMap;

    }
}
