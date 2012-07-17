package certtester.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AppMenu extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7263555938377914644L;

	public AppMenu(){
		
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("Reading of certificates.");
	
		menuItem = new JMenuItem("Open File");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "Open cert file");
		menuItem.addActionListener( new ActionListener(){
			String fileName;
			public void actionPerformed(ActionEvent arg0) {
				
				
				JFileChooser fc = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("X.509 certificate files", "der", "pem","p7b","p7c","pfx","p12","cer","crt");
				fc.addChoosableFileFilter(filter);
				
			     // fc.setCurrentDirectory( ) );  
			    int returnVal = fc.showOpenDialog(AppMenu.this);   
			      
			      
			    if ( returnVal == JFileChooser.APPROVE_OPTION )     
			      {    
			        File aFile = fc.getSelectedFile();    
			        fileName = aFile.getName();    
			      }  
			    
			      System.out.println( fileName );  
			
			   }
			}	);
		menu.add(menuItem);

		
		this.add(menu);
		
		menu = new JMenu("Settings");
		menu.setMnemonic(KeyEvent.VK_S);
		menu.getAccessibleContext().setAccessibleDescription("Application settings");
		
		this.add(menu);
		
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription("Help");
	
		this.add(menu);
	}


}
