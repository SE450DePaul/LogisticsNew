package logistics.reportservice;


/**
 * 
 * @author David Olorundare
 *
 */

//Strategy: First hardcode this, test it works, and then work 
// backwards till it works un-hardcoded/dynamically and is properly structured.


public class ReportService 
{
	// Initialize and setup a bunch of stuff
	
	private volatile static ReportService instance;
	
	
	String facilityName = "Chicago";
	
	int ratePerDay = 10;
	float costPerDay = 300;
	
	
	
	
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

	
	
	
	
	
	
	
	// will probably make this its own class.
	// iterate and output facility and inventory details for EACH facility
	public static void facilityOutput()
	{
		// Facility output should use an iterator of some sort,
		// make use of the Facility and Inventory Service APIs
				System.out.println("--------------------------------------------------------------------------");
				
				// get facility name
				System.out.println("Chicago, IL" );
				System.out.println("------------");
				
				// get rate and cost output from each facility name
				System.out.println("Rate per Day: %d");//, ratePerDay);
				System.out.println("Cost per Day: %d");//, costPerDay);
				
				System.out.println("\nDirect Links:");
				
				// Iterator for facilityName links
				System.out.println("Detroit, MI (0.7d); Fargo, ND (1.6d); New York City, NY (2.0d); St.Louis, MO (0.7d);");
				
				System.out.println("\nActive Inventory:\n Item ID\tQuantity ");
				
				// Iterator for facility's inventory item id and inventory quantity
				System.out.println(" ABC123\t\t60\n CT1928\t\t20\n E241i\t\t64\n RTF110\t\t110\n XTP202\t\t20\n");
				
				// get number of used-up inventory in facility
				System.out.println("Depleted (Used-Up) Inventory: s% if 'None' OR %d if remaining");
				
				// generate SCHEDULE for facility using Schedule Manager API
				System.out.println("\nSchedule: ");
				// generate SCHEDULE day using API
				System.out.println("Day: \t\t1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
				// generate SCHEDULE availability using API
				System.out.println("Available: \t10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10");
				// facility output ends here
				System.out.print("------------------------------------------------------------------------------");
	}
	
	// will probably make this its own class.
	// iterate and output item catalog details for EACH facility
	public static void itemCatalogOutput()
	{
		// don't forget to make the formatting dynamic
		
		System.out.println("\n\nItem Catalog: ");
		// use an iterator structure to generate item details using ItemCatalog Service APIs
		System.out.println("ABC123\t: $550\t\tCR2032\t: $240\t\tCT1928\t: $910\t\tE241i\t: $10,400");
		System.out.println("JBL3100\t: $180\t\tMM35P\t: $1,950\tPL132-C\t: $440\t\tPU238\t: $2,200");
		System.out.println("JBL3100\t: $180\t\tMM35P\t: $1,950\tPL132-C\t: $440\t\tPU238\t: $2,200");
		System.out.println("RL123A\t: $360\t\tRTF110\t: $715\t\tRX100-3\t: $642\t\tSN-241-L: $620");
		System.out.println("SR71-D\t: $1,600\tXLK200B\t: $820\t\tXTP202\t: $345\t\tZTF109\t: $1,100");	
		// end output of item catalog for facility
	}
	
	// will probably make this its own class. MAYBE.
	// iterate and output shortest path result details
	// for a given FACILITY -to- another FACILITY
	public static void shortestPathOutput() 
	{
		// needs to output 10 pairs of facility, but ideally should
		// be able to output any number of pairs, given two facilities.
		System.out.println("\nShortest Path Tests:\n");

		// these are the only four lines you need, an iterator
		// should cycle through the variable parts in these lines
		// and dynamically fill them in using the Network Service APIs
		
		// facilityNameA -to- facilityNameB
		System.out.println("a) Santa Fe, NM to Chicago, IL:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Santa Fe, NM->St.Louis, MO->Chicago, IL = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();
		
		
		
		// The rest below are just exemplary to show
		// the kind of output formatting.
		
		// facilityNameA -to- facilityNameB
		System.out.println("b) Atlanta, GA to Louis, MO:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Atlanta, GA->New Orleans, LA->Nashville, TN->St. Louis, MO = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();
		
		// facilityNameA -to- facilityNameB
		System.out.println("c) Seattle, WA to Nashville, TN:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Seattle, WA->Fargo, ND->Chicago, IL->St. Louis, MO->Nashville, TN = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();
		
		// facilityNameA -to- facilityNameB
		System.out.println("d) New York City, NY to Phoenix, AZ:");
		// facilityLinks and total distance between A and B
		System.out.println("    - New York, NY->Chicago, Il->St. Louis, MO->Santa Fe, NM->Phoenix, AZ = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();	
		
		// facilityNameA -to- facilityNameB
		System.out.println("e) Fargo, ND to Austin, TX:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Fargo, ND->Chicago, IL->St. Louis, MO->Austin, TX = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();
		
		// facilityNameA -to- facilityNameB
		System.out.println("f) Denver, CO to Miami, FL:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Denver, CO->Santa, Fe, NM->Austin, TX->New Orleans, LA->Miami, FL = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();			
		
		// facilityNameA -to- facilityNameB
		System.out.println("g) Austin, TX to Norfolk, VA:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Austin, TX->New Orleans, LA->Atlanta, GA->Norfolk, VA = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();			
		
		// facilityNameA -to- facilityNameB
		System.out.println("h) Miami, FL to Seattle, WA:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Miami, FL->New Orleans, LA->Nashville, TN->St.Louis, MO->Chicago, IL->Fargo, ND->Seattle, WA = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();	

		// facilityNameA -to- facilityNameB
		System.out.println("i) Los Angeles, CA to Chicago, IL:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Los Angeles, CA->Phoenix, AZ->Santa Fe, NM->St. Louis, MO->Chicago, IL = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();			
		
		// facilityNameA -to- facilityNameB
		System.out.println("j) Detroit, MI to Nashville, TN:");
		// facilityLinks and total distance between A and B
		System.out.println("    - Detroit, MI->Chicago, IL->St. Louis, MO->Nashville, TN = %d mi");
		// total distance between A and B, (in hours per day), in days
		System.out.println("    - %d mi / (%d hours per day * %d mph) = %d days");
		System.out.println();			
		
	}
	
	public static void main(String[] args)
	{
		//TO-DO: Need to create a dedicated display 
		// method for each of the three parts of the output
		
		// needs to be able to iterate for each facility, dynamically
		facilityOutput();
		
		// needs to be able to iterate for each facility's item catalog, dynamically
		itemCatalogOutput();
		
		// this output is separate from the first two, given that
		// it is not outputed per facility, but rather shows the 
		// works for (10) different facility-to-facility inputs.
		shortestPathOutput();
	}
}
