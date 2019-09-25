/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 9/18/2019
 * Description: A driver class to test the MultiList implementation
 */
import java.io.FileNotFoundException;

public class Driver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		MultiList list = new MultiList();
		DataManager manager = new DataManager(list);
		String fileName = "Data.txt";
		
		manager.addFromFile(fileName);
		
		System.out.print("\n" + manager.getList().listByNames());
		System.out.print("\n" + manager.getList().listByPrices());
		System.out.print("\n" + manager.getList().listByAvailables());
	}
}
