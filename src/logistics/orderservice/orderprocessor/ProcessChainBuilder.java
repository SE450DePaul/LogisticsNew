package logistics.orderservice.orderprocessor;

/**
 * This class represents a Facility Factory, which handles object creation 
 * of new Facility Implementation classes.
 * 
 * @author David Olorundare and Uchenna F.okoye
 */

import logistics.orderservice.orderprocessor.chains.CalculateTotalCostChain;
import logistics.orderservice.orderprocessor.chains.GetFacilitiesWithItemChain;
import logistics.orderservice.orderprocessor.chains.ProcessFacilityRecordsChain;
import logistics.orderservice.orderprocessor.chains.SortByArrivalDayChain;
import logistics.orderservice.dtos.OrderItemRequestDTO;

public class ProcessChainBuilder {
    public static ProcessChain build(OrderItemRequestDTO orderItemRequestDTO) {
        ProcessChain firstStep = new GetFacilitiesWithItemChain(orderItemRequestDTO);
        ProcessChain secondStep = new SortByArrivalDayChain();
        ProcessChain thirdStep = new ProcessFacilityRecordsChain(orderItemRequestDTO);
        ProcessChain fourthStep = new CalculateTotalCostChain(orderItemRequestDTO);
        firstStep.setNextChain(secondStep);
        secondStep.setNextChain(thirdStep);
        thirdStep.setNextChain(fourthStep);
        return firstStep;
    }
}
