package logistics.orderservice.facilityrecord;

/**
 * This class represents an Item Data Transfer Object,
 * which is used by the Item Service manager when communicating
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */
public class FacilityRecordDTO {

    public String source;
    public int noOfItems;
    public double itemPrice;
    public int processingEndDay;
    public int travelTime;
    public int arrivalDay;
    public double costPerDay;
    public double rate;
    public double totalCost;

    /*
     * Constructor that creates a new ItemDTO given
     * an item's ID and price.
     */
    public FacilityRecordDTO(String source, int noOfItems, double itemPrice, int processingEndDay, int travelTime, int arrivalDay, double facilityCostPerDay, int facilityRate) {
        this.source = source;
        this.noOfItems = noOfItems;
        this.itemPrice = itemPrice;
        this.processingEndDay = processingEndDay;
        this.travelTime = travelTime;
        this.arrivalDay = arrivalDay;
        this.costPerDay = facilityCostPerDay;
        this.rate = facilityRate;
    }
}
