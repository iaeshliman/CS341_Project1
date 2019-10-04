/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 10/3/2019
 * Description: Listens to any GUI events and utilizes the DataManger to perform the needed
 * functions
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Listener implements ActionListener{
	// Instance variables
	private GUI window;
	private DataManager dataManager;
	
	
	
	// Constructors
	public Listener()
	{
		
	}
	
	public Listener(GUI window)
	{
		this.window = window;
	}
	
	public Listener(DataManager dataManager)
	{
		this.dataManager = dataManager;
	}
	
	public Listener(GUI window, DataManager dataManager)
	{
		this.window = window;
		this.dataManager = dataManager;
	}
	
	
	
	// Getters
	public GUI getWindow()
	{
		return this.window;
	}
	
	public DataManager getDataManager()
	{
		return this.dataManager;
	}
	
	
	
	// Setters
	public void setWindow(GUI window)
	{
		this.window = window;
	}
	
	public void setDataManager(DataManager dataManager)
	{
		this.dataManager = dataManager;
	}
	
	
	
	// Miscellaneous
	// Gets the item information from the user and then adds the item using the DataManager
	public void addItem()
	{
		boolean cancel = false;
		boolean valid = true;
		String input = null;
		String name = null;
		double price = -1;
		int available = -1;
		
		// Iterates until the user inputs a valid value
		do
		{
			if(cancel)
			{
				break;
			}
			
			try
			{
				name = JOptionPane.showInputDialog("Please enter the name of the item");
				valid = true;
				
				if(name.compareTo("")==0)
				{
					valid = false;
				}
			}
			catch(NullPointerException e)
			{
				valid = false;
				cancel = true;
			}
		}
		while(!valid);
		
		// Iterates until the user inputs a valid value
		do
		{
			if(cancel)
			{
				break;
			}
			
			
			try
			{
				// Gives a default message which changes to a clarifying statement on the requirements if the user inputs an invalid value
				if(valid)
				{
					input = JOptionPane.showInputDialog("Please enter the price of the item");
				}
				else
				{
					input = JOptionPane.showInputDialog("Please enter numeric values only\nPlease enter the price of the item");
				}
				
				price = Double.parseDouble(input);
				valid = true;
			}
			catch(NullPointerException e)
			{
				valid = false;
				cancel = true;
			}
			catch(NumberFormatException e)
			{
				valid = false;
			}
		}
		while(!valid);
		
		// Iterates until the user inputs a valid value
		do
		{
			if(cancel)
			{
				break;
			}
			
			try
			{
				// Gives a default message which changes to a clarifying statement on the requirements if the user inputs an invalid value
				if(valid)
				{
					input = JOptionPane.showInputDialog("Please enter the quantity available of the item");
				}
				else
				{
					input = JOptionPane.showInputDialog("Please enter numeric values only\nPlease enter the quantity available of the item");
				}
				
				if(input==null)
				{
					cancel = true;
				}
				
				available = Integer.parseInt(input);
				valid = true;
			}
			catch(NumberFormatException e)
			{
				valid = false;
			}
		}
		while(!valid);
		
		// Calls the DataManagers newItem method to add the item to the multilist unless any stage of the user input was cancelled
		if(!cancel)
		{
			this.dataManager.newItem(name, price, available);
		}
	}
	
	// Action Event
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==window.getNameButton())
		{
			window.getTextArea().setText(dataManager.getList().listByNames());
		}
		if(e.getSource()==window.getPriceButton())
		{
			window.getTextArea().setText(dataManager.getList().listByPrices());
		}
		if(e.getSource()==window.getAvailableButton())
		{
			window.getTextArea().setText(dataManager.getList().listByAvailables());
		}
		if(e.getSource()==window.getAddButton())
		{
			addItem();
		}
	}
}
