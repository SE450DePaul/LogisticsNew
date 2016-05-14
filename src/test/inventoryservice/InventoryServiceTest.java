package test.inventoryservice;

import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.dtos.FacilityWithItemDTO;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by uchennafokoye on 5/13/16.
 */

@RunWith(Parameterized.class)
public class InventoryServiceTest {

    private String itemId;
    private FacilityWithItemDTO expected;

    public InventoryServiceTest(String itemId, FacilityWithItemDTO expected){
        this.itemId = itemId;
        this.expected = expected;
    }


    @Parameters
    public static Collection<Object[]> data()  {
        return Arrays.asList(new Object[][] {
                { null, null},
                {"ABC123", new FacilityWithItemDTO("Denver, CO", "ABC123", 80)},
        });
    }

    static InventoryService instance = null;

    @BeforeClass
    public static void setup() {
        instance = InventoryService.getInstance();
    }

    @Test
    public void testGetFacilitiesWithItem() {
        Collection<FacilityWithItemDTO> actual = instance.getFacilitiesWithItemDTO(itemId);
        if (expected == null){
            assertEquals(expected, actual);
        } else {
            boolean result = actual.contains(expected);
            assertTrue(result);
        }
    }


    @After
    public void teardown() {

    }
}
