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
		
		
		GUI userInterface=new GUI(800,800);
		Listener listen=new Listener();
		listen.setWindow(userInterface);
		userInterface.setListener(listen);
		listen.setManager(manager);
		
		manager.addFromFile(fileName);
		
		
		System.out.print(listen.getManager().getList().listByNames());
		
		/*
		System.out.print("\n" + manager.getList().listByNames());
		System.out.print("\n" + manager.getList().listByPrices());
		System.out.print("\n" + manager.getList().listByAvailables());
		*/
	}
}
