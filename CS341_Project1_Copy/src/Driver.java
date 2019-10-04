/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 9/18/2019
 * Description: A driver class to test the MultiList implementation
 */
public class Driver
{
	public static void main(String[] args)
	{
		// Values for the size of the window
		int width = 800;
		int height = 700;
		
		// Name of the file to be read into the system
		String fileName = "Data.txt";
		
		// Initializes all of the classes
		MultiList list = new MultiList();
		DataManager manager = new DataManager();
		GUI window = new GUI(width,height);
		Listener listener = new Listener();
		
		// Links all the classes together so they can operate (could be done using their constructors as well)
		manager.setList(list);
		manager.setFileName(fileName);
		window.setListener(listener);
		listener.setWindow(window);
		
		listener.setDataManager(manager);
		
		// Reads from the file and starts the multilist
		manager.addFromFile();
	}
}
