package logistics.orderservice;

/**
 * This class represents a Facility Manager that keeps track of all Facilities.
 * It provides methods for creating a Facility (using a Facility Factory), returning
 * a Facility's information to a requesting client, as well as display the 
 * list of all available Facilities.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.facilityservice.Facility;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

public final class OrderService
{
    private volatile static OrderService instance;
    private Loader<Facility> loader;

    private OrderService() {
        loader = LoaderFactory.build("orders");
        try {
            loader.load();
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }


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
    public String getOutput(String name) throws NullParameterException
    {
    	return "";
    }



    public static void main(String[] args){

        OrderService orderService = OrderService.getInstance();


    }
}
