/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 9/18/2019
 * Description: A single item in the multilist and all the data associated with it
 */

public class Item
{
	// Instance Data
	
	// Data about this item
	private String id;
	private String name;
	private double price;
	private int available;
	
	// Pointers for the next item in the list
	private Item pointName;
	private Item pointPrice;
	private Item pointAvailable;
	
	
	
	// Constructors
	public Item(String id, String name, double price, int available)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.available = available;
		
		this.pointName = null;
		this.pointPrice = null;
		this.pointAvailable = null;
	}
	
	
	
	// Setters
	public void setPointName(Item pointName)
	{
		this.pointName = pointName;
	}
	
	public void setPointPrice(Item pointPrice)
	{
		this.pointPrice = pointPrice;
	}
	
	public void setPointAvailable(Item pointAvailable)
	{
		this.pointAvailable = pointAvailable;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setAvailable(int available)
	{
		this.available = available;
	}
	
	
	
	// Getters
	public Item getPointName()
	{
		return this.pointName;
	}
	
	public Item getPointPrice()
	{
		return this.pointPrice;
	}
	
	public Item getPointAvailable()
	{
		return this.pointAvailable;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public int getAvailable()
	{
		return this.available;
	}
	
	
	
	// Miscellaneous
	public String toString()
	{
		String toString = "";
		
		toString += "ID: " + this.id + "\tName: " + this.name + "\tPrice: " + this.price + "\tAvailable: " + this.available + "\n";
		
		return toString;
	}
}
