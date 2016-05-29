package logistics.orderservice.orderprocessor.chains;

import java.util.Collection;

import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.orderservice.orderprocessor.ProcessChain;
import logistics.utilities.exceptions.FacilityNotFoundException;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

public class CalculateOrderStatisticsChain extends ProcessChain
{
	private OrderItemRequestDTO orderItemRq;
	private String itemId;
	private int itemQty;
	private int startDay;
	private int totalOrderCost = 0;
	private double percentUsed;
	private double cummulativePercentUsed;
	
	public CalculateOrderStatisticsChain(OrderItemRequestDTO orderItemRequest) throws NullParameterException
	{
		//validateOrderItemRequest(orderItemRequest);
		orderItemRq = orderItemRequest;
		itemId = orderItemRq.getItemId();
		itemQty = orderItemRq.getQuantityNeeded();
		startDay = orderItemRq.getStartTime();
	}
	
	protected Collection<FacilityRecordDTO> buildFacilityRecordDTOs() throws NeighborNotFoundInNetworkException, IllegalParameterException, FacilityNotFoundInNetworkException, FacilityNotFoundException 
	{
		for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOs)
		{
			totalOrderCost += facilityRecordDTO.totalCost;
		}
		System.out.printf("\nItem ID: %s, Quantity: %d, Total Cost: $%,d ", itemId, itemQty, totalOrderCost);
		
		System.out.println("\n\nItem Arrivals: ");
		
		for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOs)
		{
			percentUsed = ((facilityRecordDTO.getNoOfItems() / orderItemRq.getQuantityNeeded()) * 100);
			cummulativePercentUsed += percentUsed;
			if (cummulativePercentUsed == 99.9) cummulativePercentUsed = 100;
				
			System.out.printf("  Day %d: %d (%.2f%%, %.2f%% of total)", facilityRecordDTO.arrivalDay, facilityRecordDTO.noOfItems, percentUsed, cummulativePercentUsed);
		}
		
		System.out.println("\n\nLogisitcs Details: ");
		
		int i = 1;
		for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOs)
		{
			System.out.printf("  %d)\tName: %s (%d of %d)\n\tCost: $%,f\n\t Processing Start:\tDay %d\n\t Processing End:\tDay %d", i, facilityRecordDTO.getSource(), facilityRecordDTO.getNoOfItems(), itemQty, facilityRecordDTO.totalCost, startDay, facilityRecordDTO.getProcessingEndDay());
			System.out.printf("\n\t Travel Start:\t\tDay %d\n\t Travel End:\t\tDay %d", facilityRecordDTO.getProcessingEndDay() + 1, facilityRecordDTO.getArrivalDay());
			i++;
		}
		
		return facilityRecordDTOs;
	}
	
	
	private void validateOrderItemRequest(OrderItemRequestDTO orderItmRq) throws NullParameterException
	{
		if (orderItmRq == null)
			throw new NullParameterException("OrderItemRequest cannot be null");
	}
}
