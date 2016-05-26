package logistics.orderservice.facilityrecord;

/**
 * @author Uchenna F. Okoye
 */

public interface FacilityRecord 
{
    public String getSource();
    public int getNoOfItems();
    public int getProcessingEndDay();
    public int getTravelTime();
    public int getArrivalDay();
    public double getTotalCost();
}
