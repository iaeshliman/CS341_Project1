/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 9/23/2019
 * Description: Handles reading and writing from and to any files as well as communicating with
 * the multilist and listener to add items to the list
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DataManager
{
	// Instance Variables
	private MultiList list;
	private String fileName;
	
	// Constructors
	public DataManager()
	{
		
	}
	
	public DataManager(MultiList list)
	{
		this.list = list;
	}
	
	public DataManager(String fileName)
	{
		this.fileName = fileName;
	}
	
	public DataManager(MultiList list, String fileName)
	{
		this.list = list;
		this.fileName = fileName;
	}
	
	
	
	// Setters
	public void setList(MultiList list)
	{
		this.list = list;
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	
	
	// Getters
	public MultiList getList()
	{
		return list;
	}
	
	public String getFileName()
	{
		return this.fileName;
	}
	
	
	
	// Miscellaneous
	// Adds each line of the given file to the multilist
	public void addFromFile()
	{
		boolean fileFound = true;
		Scanner scanFile = null;
		
		// try catch for an invalid file name
		try
		{
			// Creates an scanner object that reads from the given file
			scanFile = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			fileFound = false;
			System.out.print("Could not read from file " + fileName);;
		}
		
		// Iterates through the entire file
		while((fileFound)&&(scanFile.hasNext()))
		{
			// Creates a string for each line in the file
			String line = scanFile.nextLine();
			// Splits the line by the , delimiter and adds each part to a string array
			String[] lineSplit = line.split(",");
			// Uses each part of the array to add a new item and parse the strings as needed
			list.addItem(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Integer.parseInt(lineSplit[3]));
		}
		
		if(fileFound)
		{
			scanFile.close();
		}
	}
	
	// Adds the given item to the given file when the item is given as a single string
	public void newItem(String input)
	{
		// Creates a unique id by randomly generating a 6 digit number
		Random ran = new Random();
		Boolean unique = false;
		String uniqueID = "";
		
		// Ensures the random id is unique by comparing it to all other ids
		do
		{
			uniqueID = (ran.nextInt(900000) + 100000) + "";
			
			String[] ids = list.listIDs();
			
			for(int i=0; i<ids.length; i++)
			{
				if(ids[i].compareToIgnoreCase(uniqueID)==0)
				{
					unique = false;
					break;
				}
				else
				{
					unique = true;
				}
			}
		}
		while(!unique);
		
		// Splits the input into a string array delimited by ,
		String[] inputSplit = input.split(",");
		
		// try catch for an error while writing to file
		try
		{
			// Writes the input to the given file with the unique id appended to the beginning
			FileWriter writeFile = new FileWriter(fileName, true);
			writeFile.write("\n" + uniqueID + "," + input);
			writeFile.close();
		}
		catch(IOException e)
		{
			System.out.print("Could not write to file " + fileName);
		}
		
		// Add the item to the multilist
		list.addItem(uniqueID, inputSplit[0], Double.parseDouble(inputSplit[1]), Integer.parseInt(inputSplit[2]));
	}
	
	// Adds the given item to the given file when the item is given as each part of the item
	public void newItem(String name, double price, int available)
	{
		// Creates a unique id by randomly generating a 6 digit number
		Random ran = new Random();
		Boolean unique = false;
		String uniqueID = "";
		
		// Ensures the random id is unique by comparing it to all other ids
		do
		{
			uniqueID = (ran.nextInt(900000) + 100000) + "";
			
			String[] ids = list.listIDs();
			
			for(int i=0; i<ids.length; i++)
			{
				if(ids[i].compareToIgnoreCase(uniqueID)==0)
				{
					unique = false;
					break;
				}
				else
				{
					unique = true;
				}
			}
		}
		while(!unique);
		
		// try catch for an error while writing to file
		try
		{
			// Writes the input to the given file with the unique id appended to the beginning
			FileWriter writeFile = new FileWriter(fileName, true);
			writeFile.write("\n" + uniqueID + "," + name + "," + price + "," + available);
			writeFile.close();
		}
		catch(IOException e)
		{
			System.out.print("Could not write to file " + fileName);
		}
			
		// Add the item to the multilist
		list.addItem(uniqueID, name, price, available);
	}
}
