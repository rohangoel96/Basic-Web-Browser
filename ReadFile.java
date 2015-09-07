package website;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class ReadFile extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane editorPane;
	
	public ReadFile(){
		
		super("rohangoel's broswer");	//sets the title of the browser window
		
		addressBar = new JTextField("Enter your URL here");	//address bar for entering the URL
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
		add(addressBar,BorderLayout.NORTH);
	}

}
