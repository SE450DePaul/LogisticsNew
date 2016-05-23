package logistics.itemservice;

/**
 * This is an Item Interface which provides common behaviors 
 * every Item implementation should be able to perform.
 * 
 * @author Uchenna F. Okoye
 */
public interface Item
{
    String getId();
    Double getPrice();
    String toString();
}
