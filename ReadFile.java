package website;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class ReadFile extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane display;
	
	public ReadFile(){
		
		super("rohangoel's broswer");	//sets the title of the browser window
		
		addressBar = new JTextField("http://");	//address bar for entering the URL
		addressBar.addActionListener(
				
				/**
				 *  Action Listener to check when enter is pressed
				 */
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						loadWebsite(e.getActionCommand());	//getActionCommand() returns the string inside the address bar associated with the hit enter event
						
					}
					
				}	
				
				);
		add(addressBar,BorderLayout.NORTH);	//add the address bar and place it on the top of the screen
		
		display = new JEditorPane();
		display.setEditable(false); 	//can't edit website
		
		display.addHyperlinkListener(
				
				/**
				 * Handles when click on a hyperlink
				 */
				
				new HyperlinkListener() {
					
					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) // if click on the link
							loadWebsite(e.getURL().toString());	//convert the URL object to string (method loadWebsite takes string as an attribute)
											
					}
					
				}
				
				);
		
		add (new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);	//size of the browser window
		setVisible(true);
			
			}
	
	/**
	 * load the website
	 */
	
	private void loadWebsite(String website){
		
		try {
			
			display.setPage(website); //setPage() inbuilt JAVA method which takes website as a string and put in the display window
			addressBar.setText(website);
		} 
		
		catch (Exception e) {
			System.out.println("Error while loading website");
		}
		
	}

}
