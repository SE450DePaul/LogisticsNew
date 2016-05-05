package logistics.scheduleservice;

/**
 * This class represents a Schedule Manager that keeps track of the schedules
 * of all the Facilities.
 * It provides methods for creating a Schedule (given a Facility), updating a
 * Facility's Schedule, as well as display the list of all available Facility Schedules.
 *  
 * @author David Olorundare
 *
 */

import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import java.util.Set;


public final class ScheduleService
{
    private volatile static ScheduleService instance;
    FacilityService facilityService;

    private ScheduleService()
    {
        facilityService = FacilityService.getInstance();


    }

    // return static instance of the service
    public static ScheduleService getInstance()
    {
        if (instance == null)
        {
            synchronized (ScheduleService.class)
            {
                if (instance == null)
                {
                    instance = new ScheduleService();
                }
            }
        }
        return instance;
    }

    // return string output of a schedule of a given facility name
    public String getOutput(String facilityName)
    {
        return getSchedule(facilityService.getFacility(facilityName));
    }

    // given a facility return its schedule
    public String getSchedule(FacilityDTO facility)
    {
        Schedule schedule = ScheduleFactory.build(facility);;
        return schedule.getScheduleOutput();
    }

    // create a schedule given a facilityDTO
    public Schedule createSchedule(FacilityDTO facility)
    {
        return ScheduleFactory.build(facility);
    }

    // create a schedule for a specific number of days, given a facility
    public Schedule createSchedule(FacilityDTO facility, int runDays)
    {
        return ScheduleFactory.build(facility, runDays);
    }

    // return a list of all facilities and their schedules
    public void getFacilitySchedules()
    {
        Set<String> facilities = facilityService.getFacilityNames();
        for (String facility : facilities)
        {
            System.out.println(" " + facility);
            getOutput(facility);
        }
    }



    // update the schedule of a facility given a number of items to process
    public Schedule updateSchedule(FacilityDTO facility, int itemNums)
    {
        Schedule updatedSchedule = ScheduleFactory.build(facility);
        updatedSchedule.computeChangedSchedule(itemNums);
        return updatedSchedule;
    }


    // Test that the service works
    public static void main(String[] args)
    {
	    FacilityService instance = FacilityService.getInstance();

		Schedule schedule = ScheduleFactory.build(instance.getFacility("Chicago, IL"));
		System.out.println("-------------------------Initial Schedule-----------------------------------------------\n");
		System.out.println(schedule.getScheduleOutput());
		System.out.println("--------------------New Schedule when 26 items processed--------------------------------\n");
		schedule.computeChangedSchedule(26);
		System.out.println(schedule.getScheduleOutput());
		System.out.println("--------------------New Schedule when another 33 items are processed--------------------\n");
		schedule.computeChangedSchedule(33);
		System.out.println(schedule.getScheduleOutput());
		System.out.println("--------------------New Schedule when 7 more items processed----------------------------\n");
		schedule.computeChangedSchedule(7);
		System.out.println(schedule.getScheduleOutput());

        // Get all the current schedules in the facility
        ScheduleService test = new ScheduleService();
        test.getFacilitySchedules();

    }
}
