package logistics.reportservice;

/**
 * This class represents an Report Factory, which handles object creation 
 * of new Report implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

public class ReporterFactory {

    public static Reporter build(String type){
        type = type.toLowerCase();
        if (type.equals("item")){
            return ItemCatalogReporter.getInstance();
        } else if (type.equals("facility") || type.equals("facility status")){
            return FacilityStatusReporter.getInstance();
        } else if (type.equals("shortest path")){
            return TravelGuideReporter.getInstance();
        } else if (type.equals("everything")) {
            return ReportService.getInstance();
        }
        return null;
    }
}
