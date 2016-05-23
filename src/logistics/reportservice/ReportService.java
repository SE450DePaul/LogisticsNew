package logistics.reportservice;

/**
 * This class represents a Report Service Manager that keeps
 * track of the reports of all services in the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */

public final class ReportService implements Reporter {

    private volatile static ReportService instance;
    private Reporter reporter;

    private ReportService() {

    }

    /*
     * Returns an instance of the Report Service.
     */
    public static ReportService getInstance()
    {
        if (instance == null)
        {
            synchronized (ReportService.class)
            {
                if (instance == null)
                {
                    instance = new ReportService();
                }
            }
        }
        return instance;
    }

    /*
     * Helper method that sets the type of report to be returned by the service.
     */
    private void setReportType(String type){
       reporter = ReporterFactory.build(type);
    }

    /*
     * Returns the reports of all services. 
     * 
     */
    public void printOutput() {
        setReportType("facility");
        reporter.printOutput();
        setReportType("item");
        reporter.printOutput();
        setReportType("shortest path");
        reporter.printOutput();
    }
}
