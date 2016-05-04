package logistics.itemservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemImpl implements Item
{
    private String id;
    private Double price;

    public ItemImpl(String id, Double price) throws NullParameterException {
        setId(id);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(id);
        stringBuffer.append(" : ");
        stringBuffer.append("$" + price);
        return stringBuffer.toString();
    }

    private void setId(String itemId) throws NullParameterException {
        validateId(itemId);
        id = itemId;
    }

    private void setPrice(Double itemPrice) throws NullParameterException {
        validatePrice(itemPrice);
        price = itemPrice;
    }

    private void validateId(String id) throws NullParameterException {
        if (id == null){
            throw new NullParameterException();
        }
    }

    private void validatePrice(Double price) throws NullParameterException {
        if (price == null){
            throw new NullParameterException("Price cannot be null");
        }
    }


}
