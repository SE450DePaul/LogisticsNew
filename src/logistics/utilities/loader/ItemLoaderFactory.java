package logistics.utilities.loader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemLoaderFactory extends LoaderFactory {

    public ItemLoader createLoader(String type, String filepath) {
        if (type.equals("xml")){
            return new ItemXMLLoaderImpl(filepath);
        } else if (type.equals("json")){
            return null;
        }

        return null;
    }
}
