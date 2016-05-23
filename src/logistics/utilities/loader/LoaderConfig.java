package logistics.utilities.loader;

/**
 * This class represents a configuration file containing all the
 * filesystem paths to the various XML data that will be loaded into
 * the Logistic application.
 * 
 * @author Uchenna F. Okoye
 */
public class LoaderConfig {

    public static final class FilePath {

        public static final String FILE_TYPE = "xml";
        public static final String FACILITY = "data/facilities.xml";
        public static final String ITEM = "data/item_catalog.xml";
        public static final String NETWORK = "data/facility_network.xml";
        public static final String ORDERS = "data/orders.xml";
        public static final String INVENTORY = "data/facility_inventory.xml";
    }
}
