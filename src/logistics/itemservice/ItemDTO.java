package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemDTO 
{
    public String itemId;
    public Double itemPrice;

    public ItemDTO(String id, Double price)
    {
        itemId = id;
        itemPrice = price;
    }
}
