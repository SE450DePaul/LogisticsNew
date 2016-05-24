package logistics.orderservice.ordersolution;

import logistics.orderservice.facilityrecord.FacilityRecord;

import java.util.Collection;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderSolutionLeaf implements OrderSolutionComponent{


    private int totalCost = 0;
    private int noOfSourcesUsed = 0;
    private int firstDeliveryDay = -1;
    private int lastDeliveryDay = -1;
    private Collection<FacilityRecord> facilityRecords;

    public OrderSolutionLeaf(Collection<FacilityRecord> facilityRecords){
        //validate facility records
        this.facilityRecords = facilityRecords;

        for (FacilityRecord facilityRecord : facilityRecords){
            totalCost += facilityRecord.getTotalCost();
            noOfSourcesUsed++;
            int arrivalDay = facilityRecord.getArrivalDay();
            if (firstDeliveryDay == -1){
                firstDeliveryDay =  arrivalDay;
                lastDeliveryDay = arrivalDay;
            } else {
                if (firstDeliveryDay > arrivalDay){
                    firstDeliveryDay = arrivalDay;
                }
                if (lastDeliveryDay < arrivalDay){
                    lastDeliveryDay = arrivalDay;
                }
            }

        }

    }


    @Override
    public int getTotalCost(){
        return totalCost;
    }

    @Override
    public int getFirstDeliveryDay() {
        return firstDeliveryDay;
    }

    @Override
    public int getLastDeliveryDay() {
        return lastDeliveryDay;
    }

    @Override
    public int getNoOfSourcesUsed() {
        return noOfSourcesUsed;
    }

    @Override
    public void printOutput() {
        System.out.println("Total cost " + totalCost);
        System.out.println("First Delivery Day " + firstDeliveryDay);
        System.out.println("Last delivery day " + lastDeliveryDay);
        System.out.println("No of sources used: " + noOfSourcesUsed);
    }
}
