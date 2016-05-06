package test.facilityservice;


import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import logistics.utilities.exceptions.NullParameterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by uchennafokoye on 4/28/16.
 */

public class FacilityServiceTest {

    FacilityService instance = null;

    @Before
    public void setUp()  {
         instance = FacilityService.getInstance();
    }

    @Test
    public void getInstance() {
        assertNotNull(FacilityService.getInstance());
    }

    @Test
    public void getFacilityName() {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = null;
        try {
            facility = instance.getFacility("San Francisco, CA");
        } catch (NullParameterException e) {
            e.printStackTrace();
        }
        assertEquals("San Francisco, CA", facility.name);
    }

    @Test
    public void getFacilityCost() {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = null;
        try {
            facility = instance.getFacility("San Francisco, CA");
        } catch (NullParameterException e) {
            e.printStackTrace();
        }
        assertEquals(facility.cost, 300, 0.002);
    }

    @Test
    public void getFacilityNull() {
        assertNotNull(FacilityService.getInstance());
        FacilityDTO facility = null;
        try {
            facility = instance.getFacility(null);
        } catch (NullParameterException e) {
            e.printStackTrace();
        }
        assertNull(facility);
    }



}