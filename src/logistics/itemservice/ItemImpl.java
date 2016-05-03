package logistics.itemservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemImpl implements Item
{
    private String itemId;
    private Double itemPrice;

    public ItemImpl(String id, Double price) throws NullParameterException 
    {
        setItemId(id);
        setItemPrice(price);
    }

    public String getItemId() 
    {
        return itemId;
    }

    public Double getItemPrice() 
    {
        return itemPrice;
    }

    private void setItemId(String id) throws NullParameterException 
    {
        validateItemId(id);
        itemId = id;
    }

    private void setItemPrice(Double price) throws NullParameterException 
    {
        validateItemPrice(price);
        itemPrice = price;
    }

    private void validateItemId(String id) throws NullParameterException 
    {
        if (id == null)
        {
            throw new NullParameterException("Item ID cannot be null");
        }
    }

    private void validateItemPrice(Double price) throws NullParameterException 
    {
        if (price == null)
        {
            throw new NullParameterException("Item Price cannot be null");
        }
    }
}
