package test.scheduleservice;

import logistics.scheduleservice.ScheduleService;
import logistics.utilities.exceptions.IllegalParameterException;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by uchennafokoye on 5/13/16.
 */


public class ScheduleServiceTest {

    static ScheduleService instance = null;

    @BeforeClass
    public static void setup() {
        instance = ScheduleService.getInstance();
    }

    @Test
    public void testFacilityProcessDaysNeeded() {
        int actual = 0;
        try {
            actual = instance.getProcessDaysNeeded("San Francisco, CA", 40, 1);
        } catch (IllegalParameterException e) {
           fail();
        }
        int expected = 4;
        assertEquals(expected, actual);
    }


    @After
    public void teardown() {

    }
}
