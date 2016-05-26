package logistics.orderservice.facilityrecord;

import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * This class represents an Item Data Transfer Object,
 * which is used by the Item Service manager when communicating
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */
public class FacilityRecordDTO 
{
    public String source;
    public int noOfItems;
    public double itemPrice;
    public int processingEndDay;
    public int travelTime;
    public int arrivalDay;
    public double costPerDay;
    public int rate;
    public double totalCost;

    /*
     * Constructor that creates a new FacilityRecordDTO given the source, number of items, item price, facility rate, travel time, arrival day, and processing end day.
     */
    public FacilityRecordDTO(String source, int noOfItems, double itemPrice, int processingEndDay, int travelTime, int arrivalDay, double facilityCostPerDay, int facilityRate) throws NullParameterException, NegativeOrZeroParameterException
    {
        setSource(source);
        setNoOfItems(noOfItems);
        setItemPrice(itemPrice);
        setProcessingEndDay(processingEndDay);
        setTravelTime(travelTime);
        setArrivalDay(arrivalDay);
        setCost(facilityCostPerDay);
        setRate(facilityRate);	
    }
    
    /*
     * Helper method that sets the Facility Record's source.
     */
 	public void setSource(String recordSource) throws NullParameterException
 	{
 		validateSource(recordSource);
 		recordSource = source;
 	}

 	/*
 	 * Helper method that sets the Facility Record's Number of Items.
 	 */
 	public void setNoOfItems(int recordNoOfItems) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateNoOfItems(recordNoOfItems);
 		recordNoOfItems = noOfItems;
 	}

 	/*
 	 * Helper method that sets the Facility Record's Travel Time.
 	 */
 	public void setTravelTime(int recordTravelTime) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateTravelTime(recordTravelTime);
 		recordTravelTime = travelTime;
 	}

 	/*
 	 * Helper method that sets the Facility Record's Arrival Day.
 	 */
 	public void setArrivalDay(int recordArrivalDay) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateArrivalDay(recordArrivalDay);
 		recordArrivalDay = arrivalDay;
 	}
 	
 	/*
 	 *  Helper method that sets the Facility Record's Processing End Day.
 	 */
 	public void setProcessingEndDay(int recordProcessingED) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateProcessingEndDay(recordProcessingED);
 		recordProcessingED = processingEndDay;
 	}
 	
 	/*
 	 * Helper method that sets the Facility Record's Cost per Day.
 	 */
 	public void setCost(Double recordCost) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateCost(recordCost);
 		recordCost = costPerDay;
 	}
 	
 	/*
 	 * Helper method that sets the Facility Record's Rate.
 	 */
 	public void setRate(int recordRate) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateRate(recordRate);
 		recordRate = rate;
 	}
 	
 	/*
 	 * Helper method that sets the Facility Record's Item Price.
 	 */
 	public void setItemPrice(Double recordItemPrice) throws NullParameterException, NegativeOrZeroParameterException
 	{
 		validateItemPrice(recordItemPrice);
 		recordItemPrice = itemPrice;
 	}

 	/*
 	 * Returns the Facility Record's source.
 	 */
 	public String getSource()
 	{
 		return source;
 	}
 	
 	/*
 	 * Returns the Facility Record's Number of Items.
 	 */
 	public int getNoOfItems() 
 	{
 		return noOfItems;
 	}

 	/*
 	 * Returns the Facility Record's Item Price.
 	 */
 	public Double getItemPrice() 
 	{
 		return itemPrice;
 	}
 	
 	/*
 	 * Returns the Facility Record's Processing End Day.
 	 */
 	public int getProcessingEndDay() 
 	{
 		return processingEndDay;
 	}
 	
 	/*
 	 * Returns the Facility Record's Travel Time.
 	 */
 	public int getTravelTime() 
 	{
 		return travelTime;
 	}
 	
 	/*
 	 * Returns the Facility Record's Arrival Day.
 	 */
 	public int getArrivalDay() 
 	{
 		return arrivalDay;
 	}
 	
 	/*
 	 * Returns the Facility Record's Cost Per Day.
 	 */
 	public Double getCost() 
 	{
 		return costPerDay;
 	}
 	
 	/*
 	 * Returns the Facility Record's Facility Rate.
 	 */
 	public int getRate() 
 	{
 		return rate;
 	}
 	
   /*
    * Helper method that validates that the Facility Record's Source is not Null or Empty.
    */
    private void validateSource(String recordSource) throws NullParameterException 
    {
 	   if (recordSource == null || recordSource.isEmpty())
 			throw new NullParameterException("The Facility Record's Source cannot be Null or Empty");
    }
 		
    /*
     * Helper method that validates that the Facility Record's Number of Items is not zero or negative.
     */		
   private void validateNoOfItems(int recordItemNum) throws NullParameterException, NegativeOrZeroParameterException
   {
	   if (recordItemNum == 0)
			throw new NullParameterException("The Facility Record's Number of Items cannot be Zero");
	  if (recordItemNum < 0)
			throw new NegativeOrZeroParameterException("The Facility Record's Number of Items cannot be a Negative value");
   }
   
   /*
    * Helper method that validates that the Facility Record's Item Price is not zero or negative.
    */		
  private void validateItemPrice(Double recordItemPrice) throws NullParameterException, NegativeOrZeroParameterException
  {
	  if (recordItemPrice == 0.0)
			throw new NullParameterException("The Facility Record's Item Price cannot be Zero");
	  if (recordItemPrice < 0.0)
			throw new NegativeOrZeroParameterException("The Facility Record's Item Price cannot be a Negative value");
  }
  
  /*
   * Helper method that validates that the Facility Record's Processing End Day is not zero or negative.
   */		
  private void validateProcessingEndDay(int recordProcessingED) throws NullParameterException, NegativeOrZeroParameterException
  {
	 if (recordProcessingED == 0)
			throw new NullParameterException("The Facility Record's Processing End Day cannot be Zero");
	 if (recordProcessingED < 0)
			throw new NegativeOrZeroParameterException("The Facility Record's Processing Day cannot be a Negative value");
  }
 
  /*
   * Helper method that validates that the Facility Record's Travel Time is not zero or negative.
   */		
 private void validateTravelTime(int recordTravelTime) throws NullParameterException, NegativeOrZeroParameterException 
 {
	if (recordTravelTime == 0)
		throw new NullParameterException("The Facility Record's Travel Time cannot be Zero");
    if (recordTravelTime < 0)
		throw new NegativeOrZeroParameterException("The Facility Record's Travel Time cannot be a Negative value");
 }

 /*
  * Helper method that validates that Facility Record's Arrival Day is not zero or negative. 
  */		
 private void validateArrivalDay(int recordArrivalDay) throws NullParameterException, NegativeOrZeroParameterException 
 {
	if (recordArrivalDay == 0)
		throw new NullParameterException("The Facility Record's Arrival day cannot be Zero");
	if (recordArrivalDay < 0)
		throw new NegativeOrZeroParameterException("The Facility Record's Arrival day cannot be a Negative value");
 }

 /*
  * Helper method that validates that Facility Record's Cost per day is not zero or negative.
  */		
 private void validateCost(Double recordCost) throws NullParameterException, NegativeOrZeroParameterException 
 {
	if (recordCost == 0.0)
		throw new NullParameterException("The Facility Record's Cost per day cannot be Zero");
    if (recordCost < 0.0)
		throw new NegativeOrZeroParameterException("The Facility Record's Cost per day cannot be a Negative value");
 }

 /*
  * Helper method that validates that Facility Record's Rate is not zero or negative.
  */		
 private void validateRate(int recordRate) throws NullParameterException, NegativeOrZeroParameterException 
 {
	if (recordRate == 0)
		throw new NullParameterException("The Facility Record's Rate cannot be Zero");
    if (recordRate < 0)
		throw new NegativeOrZeroParameterException("The Facility Record's Rate cannot be a Negative value");
 }  
}
