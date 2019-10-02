import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Listener implements ActionListener{
	
	GUI userInput;
	DataManager giveDataHere;
	
	public void setWindow(GUI guiWindow) {
		userInput=guiWindow;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==userInput.getNameButton())
		{
			userInput.getTextArea().setText(getNameList());
		}
		
		if(e.getSource()==userInput.getPriceButton())
		{
			userInput.getTextArea().setText(getPriceList());
		}
		
		if(e.getSource()==userInput.getAvailableButton())
		{
			userInput.getTextArea().setText(getAvailableList());
		}
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
	
	public DataManager getManager()
	{
		return this.giveDataHere;
	}
	
	public void setManager(DataManager giveDataHere)
	{
		this.giveDataHere = giveDataHere;
	}
	
}
