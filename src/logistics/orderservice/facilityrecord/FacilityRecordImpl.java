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


    private void setSource(String recordSource) throws IllegalParameterException {
        if (recordSource == null){
            throw new NullParameterException("Source cannot be null");
        }
        if (recordSource.isEmpty()){
            throw new IllegalParameterException("Source cannot be blank");
        }
        recordSource = source;
    }

    private void setNoOfItems(int recordNoOfItems) throws NegativeOrZeroParameterException {
        if (recordNoOfItems < 0){
            throw new NegativeOrZeroParameterException("Number of Items cannot be negative");
        }
        recordNoOfItems = noOfItems;
    }

    private void setProcessingEndDay(int recordProcessingEndDay) throws NegativeOrZeroParameterException {
        if (recordProcessingEndDay < 0){
            throw new NegativeOrZeroParameterException("Processing End Day cannot be negative");
        }
        recordProcessingEndDay = processingEndDay;
    }

    private void setTravelTime(int recordTravelTime) throws NegativeOrZeroParameterException {
        if (processingEndDay < 0){
            throw new NegativeOrZeroParameterException("Processing End Day cannot be negative");
        }
        recordTravelTime = travelTime;
    }

    private void setArrivalDay(int recordArrivalDay) throws NegativeOrZeroParameterException {
        if (recordArrivalDay < 0){
            throw new NegativeOrZeroParameterException("Arrival Day cannot be negative");
        }
        recordArrivalDay = arrivalDay;
    }

    private void setTotalCost(double recordTotalCost) throws NegativeOrZeroParameterException {
        if (recordTotalCost < 0){
            throw new NegativeOrZeroParameterException("Total coast cannot be negative");
        }

        recordTotalCost = totalCost;

    }
}
