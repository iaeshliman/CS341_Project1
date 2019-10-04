/*
 * Author: Isaac Aeshliman and Ryan Haffeman
 * Date: 10/04/2019
 * Description: The GUI for the user to specify the type of sort they want as well as
 * to add new items to the list
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame
{
	// Instance Variables
	Listener listener;
	
	//JLabel label1;
	JTextArea textDisplay;
	
	JButton name;
	JButton price;
	JButton available;
	JButton add;
	
	
	
	// Constructor
	public GUI(int l, int w)
	{
		// Sets the size and visibility of the application window
		this.setPreferredSize(new Dimension(l,w));
		this.setVisible(true);
		
		// Creates the canvas as well as setting the layout type
		Container canvas = this.getContentPane();
		canvas.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Creates a consistent size for all similar components
		Dimension d = new Dimension(150,50);
		
		// Creates and defines the parameters of each component
		name = new JButton("By Name");
		name.setPreferredSize(d);
		
		price = new JButton("By Price");
		price.setPreferredSize(d);
		
		available = new JButton("By Available");
		available.setPreferredSize(d);
		
		add = new JButton("Add Item");
		add.setPreferredSize(d);
		
		textDisplay = new JTextArea();
		textDisplay.setPreferredSize(new Dimension(450,450));
		
		// Adds all the components to the canvas
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		canvas.add(name,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		canvas.add(price,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		canvas.add(available,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		canvas.add(add,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		canvas.add(textDisplay,gbc);
		
		// Finalizes the frame and ensures the program terminates should the window be closed
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	// Setters
	public void setListener(Listener listener)
	{
		this.listener = listener;
		
		name.addActionListener(listener);
		price.addActionListener(listener);
		available.addActionListener(listener);
		add.addActionListener(listener);
	}
	
	
	
	// Getters
	public Listener getListener()
	{
		return this.listener;
	}
	
	public JTextArea getTextArea()
	{
		return this.textDisplay;
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
		return this.available;
	}
	
	public JButton getAddButton()
	{
		return this.add;
	}
}
