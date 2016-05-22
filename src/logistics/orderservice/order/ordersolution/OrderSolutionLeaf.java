package logistics.orderservice.order.ordersolution;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderSolutionLeaf implements OrderSolutionComponent{


    private int totalCost;
    private int noOfSourcesUsed;


    @Override
    public int getTotalCost() {
        return 0;
    }

    @Override
    public int getFirstDeliveryDay() {
        return 0;
    }

    @Override
    public int getLastDeliveryDay() {
        return 0;
    }

    @Override
    public int getNoOfSourcesUsed() {
        return 0;
    }

    @Override
    public void printOutput() {
        System.out.println(toString());
    }
}
