package logistics.reportservice;

/**
 * This class represents a Travel Guide Reporter implementation which
 * prints out information about all Shortest Path Tests.
 * 
 * @author Uchenna F. Okoye
 */
import logistics.Main;
import logistics.reportservice.services.TravelGuideService;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

public class TravelGuideReporter implements Reporter {

    private volatile static TravelGuideReporter instance;
    TravelGuideService service;
    
    private TravelGuideReporter() {
    	
    }

    /*
     * Returns an instance of the Travel Guide Reporter.
     */
    public static TravelGuideReporter getInstance()
    {
        if (instance == null)
        {
            synchronized (TravelGuideReporter.class)
            {
                if (instance == null)
                {
                    instance = new TravelGuideReporter();
                }
            }
        }
        
        return instance;
    }

    /*
     * Returns the output of all Shortest Path Tests.
     */
    public void printOutput() {
        String[][] shortestPathTests =  Main.SHORTEST_PATH_TEST;

        System.out.println("Shortest Path Tests: ");
        System.out.print("\n");
        char alph = 'a';
        for (int i = 0; i < shortestPathTests.length; i++){
            String origin = shortestPathTests[i][0];
            String destination = shortestPathTests[i][1];
            try {
                System.out.println(alph + ") " + origin + " to " + destination + ":");
                System.out.println(TravelGuideService.printItinerary(origin, destination));
                System.out.print("\n");
            } catch (FacilityNotFoundInNetworkException e) {
                e.printStackTrace();
            } catch (IllegalParameterException e) {
                e.printStackTrace();
            } catch (NeighborNotFoundInNetworkException e) {
                e.printStackTrace();
            }
            alph++;
        }

    }
}
