package logistics.orderservice;

/**
 * This class represents a Facility Manager that keeps track of all Facilities.
 * It provides methods for creating a Facility (using a Facility Factory), returning
 * a Facility's information to a requesting client, as well as display the 
 * list of all available Facilities.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.orderservice.order.Order;
import logistics.orderservice.ordersolution.OrderSolutionComponent;
import logistics.utilities.exceptions.*;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.HashMap;

public final class OrderService {
    private volatile static OrderService instance;
    private Loader<OrderRequestDTO> loader;
    private Collection<Order> orders;
    private HashMap<String, Order> orderHashMap;
    private HashMap<String, OrderSolutionComponent> orderSolutionComponentHashMap;

    private OrderService() {
        loader = LoaderFactory.build("orders");
        orderSolutionComponentHashMap = new HashMap<>();
        try {
            Collection<OrderRequestDTO> orderRequestDTOs = loader.load();
            for (OrderRequestDTO orderRequestDTO : orderRequestDTOs){

                OrderSolutionComponent orderSolutionComponent = OrderProcessor.process(orderRequestDTO.orderItemRequestDTOs);//getOrderItems());//orderItemRequestDTOs);
//                orderHashMap.put(orderRequestDTO.orderId, OrderFactory.build(orderRequestDTO));
                orderSolutionComponentHashMap.put(orderRequestDTO.getOrderId(), orderSolutionComponent);
            }

        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        } catch (NeighborNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (IllegalParameterException e) {
            e.printStackTrace();
        } catch (FacilityNotFoundException e) {
            e.printStackTrace();
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        }


    }


    public void printOutput(String orderId){
        orderSolutionComponentHashMap.get(orderId).printOutput();
    }


    
    /*
     * Returns an instance of the Facility Service.
     */
    public static OrderService getInstance() {
        if (instance == null)
        {
            synchronized (OrderService.class)
            {
                if (instance == null)
                {
                    instance = new OrderService();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args){

        OrderService orderService = OrderService.getInstance();
        System.out.println("Processing Solution:");
        orderService.printOutput("TO-007");
        orderService.printOutput("TO-006");


    }
}
