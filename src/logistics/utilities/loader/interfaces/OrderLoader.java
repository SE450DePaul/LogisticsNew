package logistics.utilities.loader.interfaces;

import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.utilities.exceptions.LoaderFileNotFoundException;

import java.util.Collection;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface OrderLoader extends Loader<OrderRequestDTO>
{
    Collection<OrderRequestDTO> load() throws LoaderFileNotFoundException;
}
