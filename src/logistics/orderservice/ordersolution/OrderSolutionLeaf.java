package logistics.orderservice.ordersolution;

import logistics.orderservice.facilityrecord.FacilityRecord;

import java.util.Collection;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderSolutionLeaf implements OrderSolutionComponent{


    private int totalCost;
    private int noOfSourcesUsed;
    private int firstDeliveryDay;
    private Collection<FacilityRecord> facilityRecords;

    public OrderSolutionLeaf(Collection<FacilityRecord> facilityRecords){
        //validate facility records
        this.facilityRecords = facilityRecords;

    }


    @Override
    public int getTotalCost() {
        return 0;
    }

    @Override
    public int getFirstDeliveryDay() {
        return 0;
    }

    @Override
    public int getLastDeliveryDay() {
        return 0;
    }

    @Override
    public int getNoOfSourcesUsed() {
        return 0;
    }

    @Override
    public void printOutput() {
        System.out.println(toString());
    }
}
