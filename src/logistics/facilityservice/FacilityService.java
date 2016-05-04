package logistics.facilityservice;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author uchenna f. okoye
 */
public final class FacilityService
{

    private volatile static FacilityService instance;
    private HashMap<String, Facility> facilityHashMap = new HashMap<>();
    private Loader<Facility> loader;


    private FacilityService() {
        loader = LoaderFactory.build("facility");

        try {
            Collection<Facility> facilities = loader.load();
            for (Facility facility : facilities){
                facilityHashMap.put(facility.getName(), facility);
            }
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public static FacilityService getInstance() {
        if (instance == null)
        {
            synchronized (FacilityService.class)
            {
                if (instance == null)
                {
                    instance = new FacilityService();
                }
            }
        }
        return instance;
    }

    public FacilityDTO getFacility(String name) {
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return null;
        return new FacilityDTO(facility.getName(), facility.getCost(), facility.getRate());
    }

    public Set<String> getFacilityNames(){
        return new TreeSet<String>(facilityHashMap.keySet());
    }


    public String getOutput(String name){
        Facility facility = facilityHashMap.get(name);
        return facility.toString();
    }


    public static void main(String[] args) {

        FacilityService instance = FacilityService.getInstance();
//        FacilityDTO facilityDTO = instance.getFacility("San Francisco, CA");
//        System.out.println("Please get Facility");
//        System.out.println(" Facility name " + facilityDTO.name + " Facility cost " + facilityDTO.cost);

        String output = instance.getOutput("San Francisco, CA");
        System.out.println(output);

        System.out.println("Facilities: ");
        Set<String> facilities = instance.getFacilityNames();
        for (String facility : facilities){
            System.out.println(facility);
        }


    }
}
