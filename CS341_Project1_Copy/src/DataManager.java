import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {
	File file=new File("Data.txt");
	
	public void addItem(String id, String name, double price, int availability) throws IOException{
		String fileInputString="\n"+id+"\t \t"+name+"\t \t"+price+"\t \t"+availability;
		FileWriter write=new FileWriter("Data.txt");
		write.write(fileInputString);
		
	}
}

