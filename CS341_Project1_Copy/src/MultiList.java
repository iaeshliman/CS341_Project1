/*
 * Author: Isaac Aeshliman
 * Date: 9/18/2019
 * Complexity: O(n)
 * Description: Manages the multilist by keeping track of the header for each method of sorting
 * the list and adding new items to the list
 */

public class MultiList
{
	// Instance data
	private Item headerName;
	private Item headerPrice;
	private Item headerAvailable;
	private int count;
	
	
	
	// Constructors
	public MultiList()
	{
		count = 0;
	}
	
	
	
	// Miscellaneous
	
	// Adds an item to the list in the correct order
	public void addItem(String id, String name, double price, int available)
	{
		// Creates the new instance of the class Item to add to the list
		Item temp = new Item(id, name, price, available);
		
		// Calls the methods that insert the new item into the correct point in the list
		addName(temp);
		addPrice(temp);
		addAvailable(temp);
		count++;
	}
	
	// Inserts the item into the correct spot in the name list
	public void addName(Item temp)
	{
		// If the list is empty then make this the first item in the list
		if(headerName==null)
		{
			headerName = temp;
		}
		else
		{
			// If this should be the first item in the list then make it so
			if(temp.getName().compareTo(headerName.getName())<=0)
			{
				temp.setPointName(headerName);
				headerName = temp;
			}
			else
			{
				// Creates variables to be references to the current and next item in the list
				Item currentName = headerName;
				Item nextName = headerName.getPointName();
				
				// Iterates through the entire list but prevents out of bounds errors
				while(nextName!=null)
				{
					// If this item belongs before the next item set current to point to this item
					// and set this item to point to next item then break
					if(temp.getName().compareTo(nextName.getName())<=0)
					{
						currentName.setPointName(temp);
						temp.setPointName(nextName);
						break;
					}
					// Otherwise make current and next a reference to the items they point to
					else
					{
						currentName = currentName.getPointName();
						nextName = nextName.getPointName();
					}
				}
				
				// If the iteration reached the end and never got placed then add the item to the end
				if(nextName==null)
				{
					currentName.setPointName(temp);
				}
			}
		}
	}
	
	// Inserts the item into the correct spot in the price list
	public void addPrice(Item temp)
	{
		// If the list is empty then make this the first item in the list
		if(headerPrice==null)
		{
			headerPrice = temp;
		}
		else
		{
			// If this should be the first item in the list then make it so
			if(temp.getPrice()<=headerPrice.getPrice())
			{
				temp.setPointPrice(headerPrice);
				headerPrice = temp;
			}
			else
			{
				// Creates variables to be references to the current and next item in the list
				Item currentPrice = headerPrice;
				Item nextPrice = headerPrice.getPointPrice();
				
				// Iterates through the entire list but prevents out of bounds errors
				while(nextPrice!=null)
				{
					// If this item belongs before the next item set current to point to this item
					// and set this item to point to next item then break
					if(temp.getPrice()<=nextPrice.getPrice())
					{
						currentPrice.setPointPrice(temp);
						temp.setPointPrice(nextPrice);
						break;
					}
					// Otherwise make current and next a reference to the items they point to
					else
					{
						currentPrice = currentPrice.getPointPrice();
						nextPrice = nextPrice.getPointPrice();
					}
				}
				
				// If the iteration reached the end and never got placed then add the item to the end
				if(nextPrice==null)
				{
					currentPrice.setPointPrice(temp);
				}
			}
		}
	}
	
	// Inserts the item into the correct spot in the available list
	public void addAvailable(Item temp)
	{
		// If the list is empty then make this the first item in the list
		if(headerAvailable==null)
		{
			headerAvailable = temp;
		}
		else
		{
			// If this should be the first item in the list then make it so
			if(temp.getAvailable()<=headerAvailable.getAvailable())
			{
				temp.setPointAvailable(headerAvailable);
				headerAvailable = temp;
			}
			else
			{
				// Creates variables to be references to the current and next item in the list
				Item currentAvailable = headerAvailable;
				Item nextAvailable = headerAvailable.getPointAvailable();
				
				// Iterates through the entire list but prevents out of bounds errors
				while(nextAvailable!=null)
				{
					// If this item belongs before the next item set current to point to this item
					// and set this item to point to next item then break
					if(temp.getAvailable()<=nextAvailable.getAvailable())
					{
						currentAvailable.setPointAvailable(temp);
						temp.setPointAvailable(nextAvailable);
						break;
					}
					else
					// Otherwise make current and next a reference to the items they point to
					{
						currentAvailable = currentAvailable.getPointAvailable();
						nextAvailable = nextAvailable.getPointAvailable();
					}
				}
				
				// If the iteration reached the end and never got placed then add the item to the end
				if(nextAvailable==null)
				{
					currentAvailable.setPointAvailable(temp);
				}
			}
		}
	}
	
	// Returns a string of the entire name list
	public String listByNames()
	{
		String listNames = "";
		Item temp = headerName;
		
		// Iterates through the entire list
		while(temp!=null)
		{
			// Appends the current items toString then updates the reference to the next item
			listNames += temp;
			temp = temp.getPointName();
		}
		
		return listNames;
	}

	// Returns a string of the entire price list
	public String listByPrices()
	{
		String listPrices = "";
		Item temp = headerPrice;
		
		// Iterates through the entire list
		while(temp!=null)
		{
			// Appends the current items toString then updates the reference to the next item
			listPrices += temp;
			temp = temp.getPointPrice();
		}
		
		return listPrices;
	}
	
	// Returns a string of the entire available list
	public String listByAvailables()
	{
		String listAvailable = "";
		Item temp = headerAvailable;
		
		// Iterates through the entire list
		while(temp!=null)
		{
			// Appends the current items toString then updates the reference to the next item
			listAvailable += temp;
			temp = temp.getPointAvailable();
		}
		
		return listAvailable;
	}
	
	// Returns an array of all the ids for all items
	public String[] listIDs()
	{
		String[] ids = new String[count];
		Item temp = headerName;
		
		// Iterates through the entire list
		for(int i=0; i<count; i++)
		{
			// Sets each index of the array equal to the current items id then updates the reference to the next item
			ids[i] = temp.getID();
			temp = temp.getPointName();
		}
		
		return ids;
	}
	
	// Returns an array of all the names for all items
	public String[] listNames()
	{
		String[] names = new String[count];
		Item temp = headerName;
		
		// Iterates through the entire list
		for(int i=0; i<count; i++)
		{
			// Sets each index of the array equal to the current items name then updates the reference to the next item
			names[i] = temp.getName();
			temp = temp.getPointName();
		}
		
		return names;
	}
	
	// Returns an array of all the prices for all items
	public double[] listPrices()
	{
		double[] prices = new double[count];
		Item temp = headerPrice;
		
		// Iterates through the entire list
		for(int i=0; i<count; i++)
		{
			// Sets each index of the array equal to the current items price then updates the reference to the next item
			prices[i] = temp.getPrice();
			temp = temp.getPointPrice();
		}
		
		return prices;
	}
	
	// Returns an array of all the availables for all items
	public int[] listAvailables()
	{
		int[] availables = new int[count];
		Item temp = headerAvailable;
		
		// Iterates through the entire list
		for(int i=0; i<count; i++)
		{
			// Sets each index of the array equal to the current items available then updates the reference to the next item
			availables[i] = temp.getAvailable();
			temp = temp.getPointAvailable();
		}
		
		return availables;
	}
	
	// Returns the current size of the list
	public int getSize()
	{
		return this.count;
	}
}
