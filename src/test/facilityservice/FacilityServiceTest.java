package test.facilityservice;


import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by uchennafokoye on 4/28/16.
 */

public class FacilityServiceTest 
{

    FacilityService instance = null;

    @Before
    public void setUp()  
    {
         instance = FacilityService.getInstance();
    }

    @Test
    public void getInstance() 
    {
        assertNotNull(FacilityService.getInstance());
    }

    @Test
    public void getFacilityName() 
    {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = instance.getFacility("San Francisco, CA");
        assertEquals("San Francisco, CA", facility.name);
    }

    @Test
    public void getFacilityCost() 
    {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = instance.getFacility("San Francisco, CA");
        assertEquals(facility.cost, 300, 0.002);
    }

    @Test
    public void getFacilityNull() 
    {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = instance.getFacility(null);
        assertNull(facility);
    }
}