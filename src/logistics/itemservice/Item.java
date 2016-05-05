package logistics.itemservice;

/**
 * This is a Item Interface which provides common behaviors 
 * every Item object should be able to perform.
 * 
 * @author Uchenna F. Okoye
 */
public interface Item
{
    String getId();
    Double getPrice();
    String toString();
}
