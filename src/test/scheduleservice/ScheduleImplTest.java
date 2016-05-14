package test.scheduleservice;

import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.dtos.FacilityWithItemDTO;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by uchennafokoye on 5/13/16.
 */


public class ScheduleImplTest {

    private String itemId;
    private FacilityWithItemDTO expected;
    private Collection<FacilityWithItemDTO> expected_all;

    public ScheduleImplTest(String itemId, FacilityWithItemDTO expected, Collection<FacilityWithItemDTO> expected_all){
        this.itemId = itemId;
        this.expected = expected;
        this.expected_all = expected_all;
    }

    static InventoryService instance = null;

    @BeforeClass
    public static void setup() {
        instance = InventoryService.getInstance();
    }

    @Test
    public void testGetFacilitiesWithItem() {
        Collection<FacilityWithItemDTO> actual = instance.getFacilitiesWithItemDTO(itemId);
        if (itemId == null){
            assertEquals(expected, actual);
        }

        if (expected != null){
            boolean result = actual.contains(expected);
            assertTrue(result);
        }

        if (expected_all != null){
            boolean result = actual.containsAll(expected_all);
            assertTrue(result);
        }
    }


    @After
    public void teardown() {

    }
}
