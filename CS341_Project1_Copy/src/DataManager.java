import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataManager {
	File file=new File("Data.txt");
	
	MultiList mList;
	Random rng=new Random();
	String id;
	
	public void addItem(String name, double price, int availability) throws IOException{
		id=""+rng.nextInt(999999);
		String fileInputString="\n"+id+"\t \t"+name+"\t \t"+price+"\t \t"+availability;
		FileWriter write=new FileWriter("Data.txt");
		write.write(fileInputString);
		
		mList.addItem(id, name, price, availability);
		
	}
}

