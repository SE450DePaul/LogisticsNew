package logistics.itemservice;

import logistics.utilities.exceptions.IllegalParameterException;


/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface Item
{

    void setId(String id) throws IllegalParameterException;
    String getId();
    void setPrice(Double price) throws IllegalParameterException;
    Double getPrice();

}
