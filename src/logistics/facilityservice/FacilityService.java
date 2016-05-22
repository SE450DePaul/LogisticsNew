package logistics.facilityservice;

/**
 * This class represents a Facility Manager that keeps track of all Facilities.
 * It provides methods for creating a Facility (using a Facility Factory), returning
 * a Facility's information to a requesting client, as well as display the 
 * list of all available Facilities.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

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
    
    /*
     * Returns an instance of the Facility Service.
     */
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

    /* 
     * Returns a FacilityDTO given the name of the Facility.
     */
    public FacilityDTO getFacility(String name) throws NullParameterException
    {
        if (name.isEmpty())
        	throw new NullParameterException("Facility name cannot be empty string");
    	Facility facility = facilityHashMap.get(name);
        if (facility == null) return null;
        return new FacilityDTO(facility.getName(), facility.getCost(), facility.getRate());
    }

    /*
     * Returns a list of all Facilities
     */
    public Set<String> getFacilityNames(){
        return new TreeSet<String>(facilityHashMap.keySet());
    }
    
    /*
     * Returns information about a Facility given its name.
     */
    public String getOutput(String name) throws NullParameterException
    {
    	if (name.isEmpty())
        	throw new NullParameterException("Facility name cannot be empty string"); 
        Facility facility = facilityHashMap.get(name);
        return facility.toString();
    }
}
