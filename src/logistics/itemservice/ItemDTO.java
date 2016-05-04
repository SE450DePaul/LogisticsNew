package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemDTO {

    public String id;
    public Double price;

    public ItemDTO(String itemId, Double itemPrice){
        id = itemId;
        price = itemPrice;
    }
}
