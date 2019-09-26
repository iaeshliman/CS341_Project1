import java.io.IOException;

import javax.swing.JOptionPane;

public class Listener {
	
	GUI userInput;
	DataManager giveDataHere;
	
	public void setWindow(GUI guiWindow) {
		userInput=guiWindow;
	}
	
	public void addItem() throws IOException {		//get user input using JOptionPane and pass that to DataHandler
		String userInput="";
		
		userInput=JOptionPane.showInputDialog("What is the name of the item you are trying to add?");
		
	//	double price=Double.parseDouble(JOptionPane.showInputDialog("What is the price of the item?"));			\\will work on later, error handling
		
		userInput+=","+JOptionPane.showInputDialog("What is the price of the item you are trying to add?");
		userInput+=","+JOptionPane.showInputDialog("How many of that item do we have in stock?");
		
		giveDataHere.newItem(userInput, "Data.txt");
	}
	
	public String getNameList()
	{
		MultiList list = giveDataHere.getList();
		
		String nameList = list.listByNames();
		
		return nameList;
	}
	
	public String getPriceList()
	{
		MultiList list = giveDataHere.getList();
		
		String priceList = list.listByPrices();
		
		return priceList;
	}
	
	public String getAvailableList()
	{
		MultiList list = giveDataHere.getList();
		
		String availableList = list.listByAvailables();
		
		return availableList;
	}
}
