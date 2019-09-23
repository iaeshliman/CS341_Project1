import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;

/*
 * Author:
 */


public class DataManager
{
	// Instance Variables
	private MultiList list;
	
	// Constructors
	public DataManager()
	{
		
	}
	
	public DataManager(MultiList list)
	{
		this.list = list;
	}
	
	
	
	// Setters
	public void setList(MultiList list)
	{
		this.list = list;
	}
	
	
	
	// Getters
	public MultiList getList()
	{
		return list;
	}
	
	
	
	// Miscellaneous
	public void addFromFile(String fileName) throws FileNotFoundException
	{
		// Creates an scanner object that reads from the given file
		Scanner scanFile = new Scanner(new File(fileName));
		
		// Iterates through the entire file
		while(scanFile.hasNext())
		{
			// Creates a string for each line in the file
			String line = scanFile.nextLine();
			// Splits the line by the , delimiter and adds each part to a string array
			String[] lineSplit = line.split(",");
			// Uses each part of the array to add a new item and parse the strings as needed
			list.addItem(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Integer.parseInt(lineSplit[3]));
		}
		
		scanFile.close();
	}
	
	public void newItem(String input, String fileName) throws IOException
	{
		// Creates a unique id by randomly generating a 6 digit number
		Random ran = new Random();
		String uniqueID = (ran.nextInt(900000) + 100000) + "";
		
		// Splits the input into a string array delimited by ,
		String[] inputSplit = input.split(",");
		
		// Writes the input to the given file with the unique id appended to the beginning
		Writer writeFile = new FileWriter(fileName);
		writeFile.write("\n" + uniqueID + "," + input);
		writeFile.close();
		
		// Add the item to the multilist
		list.addItem(uniqueID, inputSplit[0], Double.parseDouble(inputSplit[1]), Integer.parseInt(inputSplit[2]));
	}	
}
