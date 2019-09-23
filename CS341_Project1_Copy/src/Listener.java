
public class Listener {
	
	GUI userInput;
	DataManager giveDataHere;
	
	public void setWindow(GUI guiWindow) {
		userInput=guiWindow;
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
