import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener{

	JLabel label;
	JButton button;
	JTextArea textOutput;
	
	public GUI(int l, int w) {
		this.setPreferredSize(new Dimension(l, w));
		this.setVisible(true);
		
		setLayout(new BorderLayout());
		
		
		//west-side
		add(new JLabel("How to sort...?"),BorderLayout.WEST);
		label=new JLabel("How to sort...");
		button=new JButton("by name?");
		button=new JButton("by price?");
		button=new JButton("by availability?");
		
		label=new JLabel("");
		label=new JLabel("Functions");
		button=new JButton("add item");
		
		//east
		label=new JLabel("Your sorted list");
		textOutput=new JTextArea();	//add dimensions
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
//			String input=button.getLabel();
			//call datahandler, passing input;
		}
	}
	
}
