package logistics.ScheduleService;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import logistics.utilities.loader.interfaces.Loader;

import java.util.HashMap;
import java.util.Set;


/**
 * @author uchenna f. okoye
 */
public final class ScheduleManager
{

    private volatile static ScheduleManager instance;
    private HashMap<String, Facility> facilityHashMap = new HashMap<>();
    private Loader<Facility> loader;
    private FacilityService facilityService;
    private Set<String> facilities;


    private ScheduleManager() {

        facilityService = FacilityService.getInstance();
        facilities = facilityService.getFacilities();

    }


    
    public static ScheduleManager getInstance() {
        if (instance == null)
        {
            synchronized (ScheduleManager.class)
            {
                if (instance == null)
                {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    public void getSchedule(){

    }

    private void generateSchedule(){

    }

    public FacilityDTO getFacility(String name) {
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return null;
        return new FacilityDTO(facility.getName(), facility.getCost(), facility.getRate());
    }

    public String getOutput(String name){
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return "";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(facility.getName());
        stringBuffer.append("\n");
        stringBuffer.append("Rate per Day: " + facility.getRate());
        stringBuffer.append("\n");
        stringBuffer.append("Cost per day: " + facility.getCost());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }




    public static void main(String[] args) {

        ScheduleManager instance = ScheduleManager.getInstance();
//        FacilityDTO facilityDTO = instance.getFacility("San Francisco, CA");
//        System.out.println("Please get Facility");
//        System.out.println(" Facility name " + facilityDTO.name + " Facility cost " + facilityDTO.cost);

        String output = instance.getOutput("San Francisco, CA");
        System.out.println(output);


    }
}
