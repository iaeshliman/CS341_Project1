/*
 * Author: Isaac Aeshliman
 * Date: 9/18/2019
 * Description: Manages the multilist by keeping track of the header for each method of sorting
 * the list and adding new items to the list
 */

public class MultiList
{
	private Item headerName;
	private Item headerPrice;
	private Item headerAvailable;
	
	public MultiList()
	{
		
	}
	
	public void addItem(String id, String name, double price, int available)
	{
		Item temp = new Item(id, name, price, available);
		
		addName(temp);
		addPrice(temp);
		addAvailable(temp);
	}
	
	public void addName(Item temp)
	{
		if(headerName==null)
		{
			headerName = temp;
		}
		else
		{
			if(temp.getName().compareTo(headerName.getName())<=0)
			{
				temp.setPointName(headerName);
				headerName = temp;
			}
			else
			{
				Item currentName = headerName;
				Item nextName = headerName.getPointName();
				
				while(nextName!=null)
				{
					if(temp.getName().compareTo(nextName.getName())<=0)
					{
						currentName.setPointName(temp);
						temp.setPointName(nextName);
						break;
					}
					else
					{
						currentName = currentName.getPointName();
						nextName = nextName.getPointName();
					}
				}
				
				if(nextName==null)
				{
					currentName.setPointName(temp);
				}
			}
		}
	}
	
	public void addPrice(Item temp)
	{
		if(headerPrice==null)
		{
			headerPrice = temp;
		}
		else
		{
			if(temp.getPrice()<=headerPrice.getPrice())
			{
				temp.setPointPrice(headerPrice);
				headerPrice = temp;
			}
			else
			{
				Item currentPrice = headerPrice;
				Item nextPrice = headerPrice.getPointPrice();
				
				while(nextPrice!=null)
				{
					if(temp.getPrice()<=nextPrice.getPrice())
					{
						currentPrice.setPointPrice(temp);
						temp.setPointPrice(nextPrice);
						break;
					}
					else
					{
						currentPrice = currentPrice.getPointPrice();
						nextPrice = nextPrice.getPointPrice();
					}
				}
				
				if(nextPrice==null)
				{
					currentPrice.setPointPrice(temp);
				}
			}
		}
	}
	
	public void addAvailable(Item temp)
	{
		if(headerAvailable==null)
		{
			headerAvailable = temp;
		}
		else
		{
			if(temp.getAvailable()<=headerAvailable.getAvailable())
			{
				temp.setPointAvailable(headerAvailable);
				headerAvailable = temp;
			}
			else
			{
				Item currentAvailable = headerAvailable;
				Item nextAvailable = headerAvailable.getPointAvailable();
				
				while(nextAvailable!=null)
				{
					if(temp.getAvailable()<=nextAvailable.getAvailable())
					{
						currentAvailable.setPointAvailable(temp);
						temp.setPointAvailable(nextAvailable);
						break;
					}
					else
					{
						currentAvailable = currentAvailable.getPointAvailable();
						nextAvailable = nextAvailable.getPointAvailable();
					}
				}
				
				if(nextAvailable==null)
				{
					currentAvailable.setPointAvailable(temp);
				}
			}
		}
	}
	
	public String listNames()
	{
		String listNames = "";
		Item temp = headerName;
		
		while(temp!=null)
		{
			listNames += temp;
			temp = temp.getPointName();
		}
		
		return listNames;
	}
	
	public String listPrices()
	{
		String listPrices = "";
		Item temp = headerPrice;
		
		while(temp!=null)
		{
			listPrices += temp;
			temp = temp.getPointPrice();
		}
		
		return listPrices;
	}
	
	public String listAvailables()
	{
		String listAvailable = "";
		Item temp = headerAvailable;
		
		while(temp!=null)
		{
			listAvailable += temp;
			temp = temp.getPointAvailable();
		}
		
		return listAvailable;
	}
	
	
	
}
