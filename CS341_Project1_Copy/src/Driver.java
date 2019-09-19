/*
 * Author: Isaac Aeshliman
 * Date: 9/18/2019
 * Description: A driver class to test the MultiList implementation
 */

public class Driver
{
	public static void main(String[] args)
	{
		// Creates a new MultiList
		MultiList list = new MultiList();
		
		// Adds 4 different items to the list
		list.addItem("item","A",33.5,4);
		list.addItem("item","B",20.55,3);
		list.addItem("item","D",40.50,2);
		list.addItem("item","C",20.55,5);
		
		// Tests the output by getting the two strings of the 3 different lists in the multilist
		System.out.print("\nName Sort:\n" + list.listByNames());
		System.out.print("\nPrice Sort:\n" + list.listByPrices());
		System.out.print("\nAvailable Sort:\n" + list.listByAvailables());
		
		// Adds a empty line between this and the last section
		System.out.print("\n");
		
		// Tests the list methods to get just the individual variable values of all items
		String[] ids = list.listIDs();
		String[] names = list.listNames();
		double[] prices = list.listPrices();
		int[] availables = list.listAvailables();
		
		// The strings to output the variable data
		String idsString = "All IDs:\n";
		String namesString = "All Names:\n";
		String pricesString = "All Prices:\n";
		String availablesString = "All Availables:\n";
		
		for(int i=0; i<list.getSize(); i++)
		{
			idsString += ids[i] + "\n";
			namesString += names[i] + "\n";
			pricesString += prices[i] + "\n";
			availablesString += availables[i] + "\n";
		}
		
		// Concatenates all the strings into one
		String masterString = idsString + "\n" + namesString + "\n" + pricesString + "\n" + availablesString;
		
		// Outputs the master string
		System.out.print(masterString);
	}
}
