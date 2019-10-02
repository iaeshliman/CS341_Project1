import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener{

	JLabel label;
	JButton button;
	JTextArea output;
	
	JButton name;
	JButton price;
	JButton availability;
	
	JButton add;
	
	Listener listener;
	
	public GUI(int l, int w) {		//init gui
		this.setPreferredSize(new Dimension(l, w));
		this.setVisible(true);			//sets a size above, then makes the window visible

		
		Dimension d=new Dimension(150,40);		//sets a common size for future components
		Container canvas=this.getContentPane();		//makes a "canvas" that we add/change things on instead of the window itself
		canvas.setLayout(new FlowLayout());			//flowlayout dynamically adjusts, worked better than borderlayout

		
		JLabel labelLeft=new JLabel("How to sort...?");
		labelLeft.setPreferredSize(d);
		canvas.add(labelLeft);				//the basic process, make a components with a name, set size, add to canvas
		
		name=new JButton("by name");
		name.setPreferredSize(d);
		canvas.add(name);
		
		price=new JButton("by price");
		price.setPreferredSize(d);
		canvas.add(price);
		
		availability=new JButton("by availabiltiy");
		availability.setPreferredSize(d);
		canvas.add(availability);
		
		JLabel empty=new JLabel(" ");
		empty.setPreferredSize(d);
		canvas.add(empty);
		
		JLabel func=new JLabel("Functions");
		func.setPreferredSize(d);
		canvas.add(func);
		
		add = new JButton("add");
		add.setText("add item");
		add.setPreferredSize(d);
		canvas.add(add);
	
		JLabel list=new JLabel("Your sorted list");
		list.setPreferredSize(d);
		canvas.add(list);
		
		output=new JTextArea();
		output.setPreferredSize(new Dimension(400,500));		//makes a new dimension instead of a preset one
		canvas.add(output);
		

		
		
		this.pack();			//adds all components to window, in this case, the canvas.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//closes the program when the window is closed
	}
	
	public void setListener(Listener l)
	{
		this.listener = l;
		
		name.addActionListener(listener);
		price.addActionListener(listener);
		availability.addActionListener(listener);
		add.addActionListener(listener);
	}
	
	public JTextArea getTextArea()
	{
		return this.output;
	}
	
	public JButton getNameButton()
	{
		return this.name;
	}
	
	public JButton getPriceButton()
	{
		return this.price;
	}
	
	public JButton getAvailableButton()
	{
		return this.availability;
	}
	/*
	Listener listen;
	
	public void actionPerformed(ActionEvent e) {		//listener
		System.out.println("actionPerformed was called.");
		if(e.getSource()==add) {
			System.out.println("working");
		}
		
		
		if(e.getSource()==button) {				//if the source of the action is a button...
			System.out.println("A button was pressed in the gui");
			String input=button.getText();		//grab the name of the button...
			//call datahandler, passing input;
			if(input.equals("availability")) {
				listen.getAvailableList();
			}else if(input.equals("price")) {
				listen.getPriceList();
			}else if(input.equals("name")) {
				listen.getNameList();
			}else if(input.equals("add")) {
				System.out.println("Listen in gui");
				try {
					listen.addItem();
				} catch (IOException e1) {
					System.out.println("Something about the file and/or its location is incorrect.");
					e1.printStackTrace();
				}
			}
			
		}
	
	}
	*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
