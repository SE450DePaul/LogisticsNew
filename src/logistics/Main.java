package logistics;

import logistics.reportservice.Reporter;
import logistics.reportservice.ReporterFactory;

/**
 * Created by uchennafokoye on 5/3/16.
 */
public class Main {

    public static String[][] SHORTEST_PATH_TEST = {{"Santa Fe, NM", "Chicago, IL"},
        {"Atlanta, GA", "St. Louis, MO"},
            {"Seattle, WA", "Nashville, TN"},
                {"New York City, NY", "Phoenix, AZ"},
                    {"Fargo, ND", "Austin, TX"},
                        {"Denver, CO", "Miami, FL"},
                            {"Austin, TX", "Norfolk, VA"},
                                {"Miami, FL", "Seattle, WA"},
                                    {"Los Angeles, CA", "Chicago, IL"},
                                        {"Detroit, MI", "Nashville, TN"}};


    public static void main(String args[]){
        Reporter reporter = ReporterFactory.build("everything");
        reporter.printOutput();
    }
}
