package logistics.itemservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemImpl implements Item
{
    private String id;
    private Double price;

    public ItemImpl(String id, Double price) throws IllegalParameterException 
    {
        setId(id);
        setPrice(price);
    }

    public String getId() 
    {
        return id;
    }

    public Double getPrice() 
    {
        return price;
    }

    private void setId(String itemId) throws IllegalParameterException
    {
        validateId(itemId);
        id = itemId;
    }

    private void setPrice(Double itemPrice) throws IllegalParameterException
    {
        validatePrice(itemPrice);
        price = itemPrice;
    }

    private void validateId(String id) throws IllegalParameterException 
    {
        if (id == null){
            throw new IllegalParameterException();
        }
    }

    private void validatePrice(Double price) throws IllegalParameterException 
    {
        if (price == null){
            throw new IllegalParameterException("Price cannot be null");
        }
    }
}
