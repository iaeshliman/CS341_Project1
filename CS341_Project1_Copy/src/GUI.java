import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	public GUI(int l, int w) {		//init gui
		this.setPreferredSize(new Dimension(l, w));
		this.setVisible(true);			//sets a size above, then makes the window visible

		
		Dimension d=new Dimension(150,40);		//sets a common size for future components
		Container canvas=this.getContentPane();		//makes a "canvas" that we add/change things on instead of the window itself
		canvas.setLayout(new FlowLayout());			//flowlayout dynamically adjusts, worked better than borderlayout

		
		JLabel labelLeft=new JLabel("How to sort...?");
		labelLeft.setPreferredSize(d);
		canvas.add(labelLeft);				//the basic process, make a components with a name, set size, add to canvas
		
		JButton name=new JButton("by name");
		name.setPreferredSize(d);
		canvas.add(name);
		
		JButton price=new JButton("by price");
		price.setPreferredSize(d);
		canvas.add(price);
		
		JButton availability=new JButton("by availabiltiy");
		availability.setPreferredSize(d);
		canvas.add(availability);
		
		JLabel empty=new JLabel(" ");
		empty.setPreferredSize(d);
		canvas.add(empty);
		
		JLabel func=new JLabel("Functions");
		func.setPreferredSize(d);
		canvas.add(func);
		
		JButton add=new JButton("add item");
		add.setPreferredSize(d);
		canvas.add(add);
		
		JLabel list=new JLabel("Your sorted list");
		list.setPreferredSize(d);
		canvas.add(list);
		
		JTextArea output=new JTextArea();
		output.setPreferredSize(new Dimension(400,500));		//makes a new dimension instead of a preset one
		canvas.add(output);
		

		
		
		this.pack();			//adds all components to window, in this case, the canvas.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//closes the program when the window is closed
	}
	
	
	public void actionPerformed(ActionEvent e) {		//listener
		if(e.getSource()==button) {				//if the source of the action is a button...
			String input=button.getName();		//grab the name of the button...
			//call datahandler, passing input;
		}
	}
	
}
