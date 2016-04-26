package logistics.facilityservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare
 */
public interface Facility
{

    void setName(String name) throws IllegalParameterException;
    String getName();
    void setRate(Double rate) throws IllegalParameterException;
    Double getRate();
    void setCost(Double cost) throws IllegalParameterException;
    Double getCost();
    int getQuantity(String itemId);

}
