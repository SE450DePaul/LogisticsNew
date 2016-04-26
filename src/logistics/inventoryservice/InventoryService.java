package logistics.inventoryservice;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public final class InventoryService
{

    private volatile static InventoryService instance;
    
    private ArrayList<Inventory> items = new ArrayList<Inventory>();

    private InventoryService()
    {
          /*  loader = new XmlLoaderFactoryImpl();
    		
            
            try 
            {
                items = loader.load();
            } 
            catch (LoaderFileNotFoundException e) 
            {
                e.printStackTrace();
            }*/
    }

   /* public XmlLoadable xmlload(String filetype, String filepath) 
    {
    	
    }*/
    
    public static InventoryService getInstance()
    {
        if (instance == null)
        {
            synchronized (InventoryService.class)
            {
                if (instance == null)
                {
                    instance = new InventoryService();
                }
            }
        }
        return instance;
    }



}
