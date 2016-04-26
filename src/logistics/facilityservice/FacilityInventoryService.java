package logistics.facilityservice;

import logistics.facilityservice.inventory.InventoryDTO;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Olorundare and uchenna f. okoye
 */
public final class FacilityInventoryService
{

    private volatile static FacilityInventoryService instance;
    private ArrayList<Facility> facilities = new ArrayList<Facility>();
    private HashMap<String, Facility> facilityHashMap = new HashMap<>();
    private Loader<Facility> loader;


    private FacilityInventoryService() {
        LoaderFactory loaderFactory = LoaderFactory.getLoaderFactory("facility");
        loader = loaderFactory.createLoader("xml", "data/facilities_and_inventory.xml");

        try {
            facilities = loader.load();
            for (Facility facility : facilities){
                facilityHashMap.put(facility.getName(), facility);
            }
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public static FacilityInventoryService getInstance() {
        if (instance == null)
        {
            synchronized (FacilityInventoryService.class)
            {
                if (instance == null)
                {
                    instance = new FacilityInventoryService();
                }
            }
        }
        return instance;
    }


    public FacilityDTO getFacility(String name) {
            Facility facility = facilityHashMap.get(name);
            if (facility == null) return null;
            return new FacilityDTO(facility.getName(), facility.getCost());
    }


    public FacilityDTO getFacilityWithInventory(String name) {
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return null;
        return new FacilityDTO(facility.getName(), facility.getCost());
    }



    public static void main(String[] args) {

        FacilityInventoryService instance = FacilityInventoryService.getInstance();
        FacilityDTO facilityDTO = instance.getFacility("San Francisco, CA");
        System.out.println("Please get Facility");
        System.out.println(" Facility name " + facilityDTO.name + " Facility cost " + facilityDTO.cost);


    }
}
