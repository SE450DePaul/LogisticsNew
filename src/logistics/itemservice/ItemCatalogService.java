package logistics.itemservice;

import logistics.facilityservice.Facility;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.interfaces.Loader;
import logistics.utilities.loader.factory.LoaderFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class ItemCatalogService 
{

    private volatile static ItemCatalogService instance;
    private Loader loader;

    private HashMap<String, Item> itemsHash = new HashMap<>();

    private ItemCatalogService() 
    {
            loader = LoaderFactory.build("item");

            try 
            {
                Collection<Item> items = loader.load();
                for (Item item : items)
                {
                    itemsHash.put(item.getItemId(), item);
                }
            } 
            catch (LoaderFileNotFoundException e) 
            {
                e.printStackTrace();
            }
    }

    public static ItemCatalogService getInstance() 
    {
        if (instance == null)
        {
            synchronized (ItemCatalogService.class)
            {
                if (instance == null)
                {
                    instance = new ItemCatalogService();
                }
            }
        }

        return instance;
    }

    public ItemDTO getItem(String itemId)
    {
        Item item = itemsHash.get(itemId);
        if (item == null) return null;
        return new ItemDTO(item.getItemId(), item.getItemPrice());
    }
/*
    public Set<String> getItems()
    {
        return new TreeSet<String>(itemsHash.keySet());
    }
*/    
    public String getItemOutput(String itemName)
    {
        Item itemId = itemsHash.get(itemName);
        if (itemId == null) return "";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(itemId.getItemId());
        stringBuffer.append("\t");
        stringBuffer.append(":  ");
        stringBuffer.append(itemId.getItemPrice());
        stringBuffer.append("\t\r");
        return stringBuffer.toString();
    }
    
    
    //public ItemDTO getOutput(String itemId)
    //{
    	
    // }
    // Test that the service works
    public static void main(String[] args)
    {
        ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();
        ItemDTO itemDTO = itemCatalogService.getItem("ABC123");
        System.out.println("Please get item:");
        System.out.println(" Item id: " + itemDTO.itemId + " Item price: " + itemDTO.itemPrice);
        System.out.println("Print out all items: ");
        
        
        Set<String> items = itemCatalogService.getItems();
        
        // TO-DO: need to format it to use carriage return \r
        // after each fourth item. Would give four columns of items
        for (String item : items)
        {	
        	System.out.print(itemCatalogService.getItemOutput(item) + "\r");
        	
        	
        }
        
        
    }
}
