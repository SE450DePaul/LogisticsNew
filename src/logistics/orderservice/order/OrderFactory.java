package logistics.orderservice.order;

/**
 * This class represents a Facility Factory, which handles object creation 
 * of new Facility Implementation classes.
 * 
 * @author Uchenna F.okoye
 */

import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

public class OrderFactory {
    public static Order build(OrderRequestDTO orderRequestDTO) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException {
        return new OrderImpl(orderRequestDTO);
    }
}
