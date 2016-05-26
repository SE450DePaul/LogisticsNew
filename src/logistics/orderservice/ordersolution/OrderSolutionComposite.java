package logistics.orderservice.ordersolution;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderSolutionComposite implements OrderSolutionComponent{


    private Collection<OrderSolutionLeaf> orderSolutions;

    public OrderSolutionComposite(){
        orderSolutions = new ArrayList<>();
    }

    public void addSolution(OrderSolutionLeaf orderSolution){
        orderSolutions.add(orderSolution);
    }


    @Override
    public int getTotalCost() {
        int totalCost = 0;
        for (OrderSolutionLeaf orderSolution : orderSolutions) {
            totalCost += orderSolution.getTotalCost();
        }
        return totalCost;
    }

    @Override
    public int getFirstDeliveryDay() {
        int firstDeliveryDay = Integer.MAX_VALUE;
        for (OrderSolutionLeaf orderSolution : orderSolutions){
            if (firstDeliveryDay > orderSolution.getFirstDeliveryDay()){
                firstDeliveryDay = orderSolution.getFirstDeliveryDay();
            }
        }
        return firstDeliveryDay;
    }

    @Override
    public int getLastDeliveryDay() {
        int lastDeliveryDay = Integer.MIN_VALUE;
        for (OrderSolutionLeaf orderSolution : orderSolutions){
            if (lastDeliveryDay < orderSolution.getFirstDeliveryDay()){
                lastDeliveryDay = orderSolution.getFirstDeliveryDay();
            }
        }
        return lastDeliveryDay;
    }

    @Override
    public int getNoOfSourcesUsed() {
        int noOfSourcesUsed = 0;
        for (OrderSolutionLeaf orderSolution : orderSolutions) {
            noOfSourcesUsed += orderSolution.getNoOfSourcesUsed();
        }
        return noOfSourcesUsed;
    }

    @Override
    public void printOutput() {
        System.out.println("  Total Cost: \t" + getTotalCost());
        System.out.println("  1st Delivery Day: \t" + getFirstDeliveryDay());
        System.out.println("  Last Delivery Day: \t" + getLastDeliveryDay());
        System.out.println("  Order Items: \n");
        System.out.println("  Item ID  Quantity  Cost	# Sources Used  First Day  Last Day ");
        for (OrderSolutionLeaf orderSolution : orderSolutions){
            orderSolution.printOutput();
        }
    }




}
