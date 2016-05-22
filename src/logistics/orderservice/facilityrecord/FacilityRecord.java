package logistics.orderservice.facilityrecord;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public interface FacilityRecord {

    public String getSource();
    public int getNoOfItems();
    public int getProcessingEndDay();
    public int getTravelTime();
    public int getArrivalDay();
    public double getTotalCost();

}
