package logistics.reportservice;

// First hardcode this, test it works, and then work backwards till it works un-hardcoded.

public class ReportService 
{
	// Initialize and setup a bunch of stuff
	
	String facilityName = "Chicago";
	
	float costPerDay = 300;
	
	public static void main(String[] args)
	{
		int ratePerDay = 10;	
		
		// Facility output should use an iterator of some sort
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Chicago, IL" );
		System.out.println("------------");
		System.out.println("Rate per Day: %d", ratePerDay);
		
	}
}
