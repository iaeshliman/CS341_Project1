
public class Driver
{
	public static void main(String[] args)
	{
		
		MultiList list = new MultiList();
		
		list.addItem("item","A",33.5,4);
		list.addItem("item","B",20.55,3);
		list.addItem("item","D",40.50,2);
		list.addItem("item","C",20.55,5);
		
		System.out.print("\nName Sort:\n" + list.listNames());
		System.out.print("\nPrice Sort:\n" + list.listPrices());
		System.out.print("\nAvailable Sort:\n" + list.listAvailables());
		
	}
}
