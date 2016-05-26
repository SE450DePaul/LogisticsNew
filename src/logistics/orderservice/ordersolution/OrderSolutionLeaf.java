package logistics.orderservice.ordersolution;

import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.facilityrecord.FacilityRecord;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.Collection;

/**
 * @author Uchenna F. Okoye
 */
public class OrderSolutionLeaf implements OrderSolutionComponent
{

    private int totalCost = 0;
    private int noOfSourcesUsed = 0;
    private int firstDeliveryDay = -1;
    private int lastDeliveryDay = -1;
    private Collection<FacilityRecord> facilityRecords;
    private OrderItemRequestDTO orderItemRequestDTO;

    public OrderSolutionLeaf(OrderItemRequestDTO orderItemRequestDTO, Collection<FacilityRecord> facRecords) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
    {
        //validate facility records
        // validate order item
    	
    	setFacilityRecord(facRecords);
    	setOrderItemRequest(orderItemRequestDTO);

        for (FacilityRecord facilityRecord : facilityRecords)
        {
            totalCost += facilityRecord.getTotalCost();
            noOfSourcesUsed++;
            int arrivalDay = facilityRecord.getArrivalDay();
            if (firstDeliveryDay == -1)
            {
                firstDeliveryDay =  arrivalDay;
                lastDeliveryDay = arrivalDay;
            } else {
                if (firstDeliveryDay > arrivalDay)
                {
                    firstDeliveryDay = arrivalDay;
                }
                if (lastDeliveryDay < arrivalDay)
                {
                    lastDeliveryDay = arrivalDay;
                }
            }

        }

    }
    
    /*
     * Helper method that sets the Facility Record given a set of records.
     */
    public void setFacilityRecord(Collection<FacilityRecord> fRecord)throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
    {
    	validateFacilityRecord(fRecord);
    	facilityRecords = fRecord;
    }
    
    /*
     * Helper method that sets the order item request.
     */
    public void setOrderItemRequest(OrderItemRequestDTO orderItemRDTO) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
    {
    	validateOrderItemRequest(orderItemRDTO);
    	orderItemRequestDTO = orderItemRDTO;
    }
    
    /*
     * Returns the Total Cost.
     */
    public int getTotalCost()
    {
        return totalCost;
    }

    /*
     * Returns the First Delivery Day.
     */
    public int getFirstDeliveryDay() 
    {
        return firstDeliveryDay;
    }

    /*
     * Returns the Last Delivery Day.
     */
    public int getLastDeliveryDay() 
    {
        return lastDeliveryDay;
    }

    /*
     * Returns the Number of Sources used.
     */
    public int getNoOfSourcesUsed() 
    {
        return noOfSourcesUsed;
    }

    /*
     * Helper method that outputs the orderItemRequestDTO's details.
     */
    public void printOutput() 
    {
        System.out.println("  " + orderItemRequestDTO.itemId + "\t" + orderItemRequestDTO.quantityNeeded + "\t" + getTotalCost() + "\t" + getNoOfSourcesUsed() + "\t" + getFirstDeliveryDay() + "\t" + getLastDeliveryDay());
    }
    
    /*
     * Helper method that validates that a Facility Record's parameters are not null, negative, or empty.
     */
     private void validateFacilityRecord(Collection<FacilityRecord> fRecord) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
     {
    	 for (FacilityRecord record : fRecord)
    	 {
    		 if (record == null)
           	  throw new NullParameterException("Facility Record cannot be Null");
             
             if (record.getSource() == null)
           	  throw new NullParameterException("The Facility Record's source cannot be Null");
             if (record.getSource().isEmpty())
           	  throw new IllegalParameterException("The Facility Record's source cannot be Empty");
             
             if (record.getNoOfItems() == 0)
              throw new NullParameterException("The Facility Record's Item Number cannot be zero");
             if (record.getNoOfItems() < 0)
              throw new NegativeOrZeroParameterException("The Facility Record's Item Number cannot be Negative");
             
             if (record.getProcessingEndDay() == 0)
              throw new NullParameterException("The Facility Record's Processing End Day cannot be zero");
             if (record.getProcessingEndDay() < 0)
              throw new NegativeOrZeroParameterException("The Facility Record's Processing End Day cannot be Negative");
             
             if (record.getTravelTime() == 0)
              throw new NullParameterException("The Facility Record's Travel Time cannot be zero");
             if (record.getTravelTime() < 0)
              throw new NegativeOrZeroParameterException("The Facility Record's Travel Time cannot be Negative");
             
             if (record.getArrivalDay() == 0)
              throw new NullParameterException("The Facility Record's Arrival Day cannot be zero");
             if (record.getArrivalDay() < 0)
              throw new NegativeOrZeroParameterException("The Facility Record's Arrival Day cannot be Negative");
         }
     }
     
     /*
      * Helper method that validates that an order item DTO's parameters are not null, zero, empty, or negative.
      */
      private void validateOrderItemRequest(OrderItemRequestDTO itemRequest) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException 
      {
              if (itemRequest == null)
            	  throw new NullParameterException("Order Item Request cannot be Null");
              
              if (itemRequest.getDestination() == null)
            	  throw new NullParameterException("The OrderItemRequestDTO's Destination cannot be Null");
              if (itemRequest.getDestination().isEmpty())
            	  throw new IllegalParameterException("The OrderItemRequestDTO's Destination cannot be Empty");
              
              if (itemRequest.getItemId() == null)
            	  throw new NullParameterException("The OrderItemRequestDTO's Item ID cannot be Null");
              if (itemRequest.getItemId().isEmpty())
            	  throw new IllegalParameterException("The OrderItemRequestDTO's Item ID cannot be Empty");
              
              if (itemRequest.getStartTime() == 0)
            	  throw new NullParameterException("The OrderItemRequestDTO's Starting time cannot be zero");
              if (itemRequest.getStartTime() < 0)
            	  throw new NegativeOrZeroParameterException("The OrderItemRequestDTO's Starting time cannot be Negative");
              
              if (itemRequest.getQuantityNeeded() == 0)
            	  throw new NullParameterException("The OrderItemRequestDTO's Item quantity cannot be zero");
              if (itemRequest.getQuantityNeeded() < 0)
            	  throw new NegativeOrZeroParameterException("The OrderItemRequestDTO's Item quantity cannot be Negative");
      }
}
