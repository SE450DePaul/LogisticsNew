package logistics.orderservice;

import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.facilityrecord.FacilityRecord;
import logistics.orderservice.facilityrecord.FacilityRecordDTO;
import logistics.orderservice.facilityrecord.FacilityRecordFactory;
import logistics.orderservice.orderprocessor.ProcessChain;
import logistics.orderservice.orderprocessor.ProcessChainBuilder;
import logistics.orderservice.ordersolution.OrderSolutionComponent;
import logistics.orderservice.ordersolution.OrderSolutionComposite;
import logistics.orderservice.ordersolution.OrderSolutionLeaf;
import logistics.utilities.exceptions.FacilityNotFoundException;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents the Order Processor Impl manager and provides
 * methods to help process one order at a time.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderProcessor {



    public static OrderSolutionComponent process(Collection<OrderItemRequestDTO> orderItemRequestDTOs) throws IllegalParameterException, FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, FacilityNotFoundException {

        OrderSolutionComposite component = new OrderSolutionComposite();
        for (OrderItemRequestDTO orderItemRequestDTO : orderItemRequestDTOs ){
            component.addSolution(process(orderItemRequestDTO));
        }

        return component;
    }

    private static OrderSolutionLeaf process(OrderItemRequestDTO orderItemRequestDTO) throws IllegalParameterException, FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException, FacilityNotFoundException {
        ProcessChain processChain = ProcessChainBuilder.build(orderItemRequestDTO);
        Collection<FacilityRecordDTO> facilityRecordDTOs = processChain.process();
        Collection<FacilityRecord> facilityRecords = new ArrayList<>();
        for (FacilityRecordDTO facilityRecordDTO : facilityRecordDTOs){
            facilityRecords.add(FacilityRecordFactory.build(facilityRecordDTO));
        }
        OrderSolutionLeaf orderSolutionLeaf = new OrderSolutionLeaf(orderItemRequestDTO, facilityRecords);
        return orderSolutionLeaf;
    }

}
