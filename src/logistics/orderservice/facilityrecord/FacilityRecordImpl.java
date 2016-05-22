package logistics.orderservice.facilityrecord;

import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class FacilityRecordImpl implements FacilityRecord{


    private String source;
    private int noOfItems;
    private int processingEndDay;
    private int travelTime;
    private int arrivalDay;
    private double totalCost;

    public FacilityRecordImpl(FacilityRecordDTO facilityRecordDTO) throws IllegalParameterException {
        setSource(facilityRecordDTO.source);
        setArrivalDay(facilityRecordDTO.arrivalDay);
        setNoOfItems(facilityRecordDTO.noOfItems);
        setProcessingEndDay(facilityRecordDTO.processingEndDay);
        setTravelTime(facilityRecordDTO.travelTime);
        setTotalCost(facilityRecordDTO.totalCost);
    }

    public String getSource() {
        return source;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public int getProcessingEndDay() {
        return processingEndDay;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public double getTotalCost() {
        return totalCost;
    }


    private void setSource(String source) throws IllegalParameterException {
        if (source == null){
            throw new NullParameterException("Source cannot be null");
        }
        if (source.isEmpty()){
            throw new IllegalParameterException("Source cannot be blank");
        }
        this.source = source;
    }

    private void setNoOfItems(int noOfItems) throws NegativeOrZeroParameterException {
        if (noOfItems < 0){
            throw new NegativeOrZeroParameterException("no Of Items cannot be negative");
        }
        this.noOfItems = noOfItems;
    }

    private void setProcessingEndDay(int processingEndDay) throws NegativeOrZeroParameterException {
        if (processingEndDay < 0){
            throw new NegativeOrZeroParameterException("Processing End Day cannot be negative");
        }
        this.processingEndDay = processingEndDay;
    }

    private void setTravelTime(int travelTime) throws NegativeOrZeroParameterException {
        if (processingEndDay < 0){
            throw new NegativeOrZeroParameterException("Processing End Day cannot be negative");
        }
        this.travelTime = travelTime;
    }

    private void setArrivalDay(int arrivalDay) throws NegativeOrZeroParameterException {
        if (arrivalDay < 0){
            throw new NegativeOrZeroParameterException("Arrival Day cannot be negative");
        }
        this.arrivalDay = arrivalDay;
    }

    private void setTotalCost(double totalCost) throws NegativeOrZeroParameterException {
        if (totalCost < 0){
            throw new NegativeOrZeroParameterException("Total coast cannot be negative");
        }

        this.totalCost = totalCost;

    }
}
