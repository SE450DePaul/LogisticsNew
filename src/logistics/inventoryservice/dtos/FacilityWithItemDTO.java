package logistics.inventoryservice.dtos;

/**
 * This class represents a Facility With Item Data Transfer Object,
 * which is used by the Inventory Service manager when communicating
 * with other subsystems of the Logistics application.
 *
 * Created by uchennafokoye on 5/13/16.
 */

public class FacilityWithItemDTO {

    public String facility;
    public String itemId;
    public int quantity;

    public FacilityWithItemDTO(String facilityName, String itemNoId, int itemQuantity){
        facility = facilityName;
        itemId = itemNoId;
        quantity = itemQuantity;
    }

    public String toString() {
        return facility + " " + itemId + " " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof FacilityWithItemDTO)) return false;

        FacilityWithItemDTO facilityWithItemDTO = (FacilityWithItemDTO) o;

        if (!facility.equals(facilityWithItemDTO.facility)) return false;
        if (!itemId.equals(facilityWithItemDTO.itemId)) return false;
        if (! (quantity == facilityWithItemDTO.quantity) ) return false;

        return true;
    }

}
