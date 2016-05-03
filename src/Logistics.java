import java.text.DecimalFormat;
import java.util.Formatter;

import com.sun.javafx.binding.StringFormatter;

/**
 * 
 * @author David Olorundare and Uchenna F. Okoye
 *
 */
// This should be the main class of the application

public class Logistics 
{
	// Should initialize all the services: Facility, Item, Inventory, Network, Report
	
	public static void pinch(String name)
	{
		System.out.println(name);
		for (int i = 0; i < name.length(); i++)
		{
			System.out.print("-");
		}
	}
	
	// call the Report service to generate all required output
	public static void main(String[] args)
	{
		pinch("rabbit");
		
		
	}
	
	
}
