package certtester.view;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;


import javax.swing.*;
import javax.swing.filechooser.*;


public class CustomImageEditorPanel extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1883988673580463091L;

	private JButton addImage;
	private JButton removeImage;
	private JTextField imageMessage;
	private JLabel fileLabel;
	private ImageIcon editedImageIcon;
	private String fileName = "Pick file";
	
	private JButton chooseFile;
	
	
	public CustomImageEditorPanel() {
		
		fileLabel = new JLabel(fileName);
		chooseFile = new JButton("Select file");
		
		chooseFile.addActionListener( new ActionListener(){
				
				public void actionPerformed(ActionEvent arg0) {
					
					
					JFileChooser fc = new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Cert file", "cer", "jpeg");
					fc.addChoosableFileFilter(filter);
					
				     // fc.setCurrentDirectory( ) );  
				      int returnVal = fc.showOpenDialog(CustomImageEditorPanel.this);   
				      
				      
				      if ( returnVal == JFileChooser.APPROVE_OPTION )     
				      {    
				        File aFile = fc.getSelectedFile();    
				        fileName = aFile.getName();    
				      }  
				    
				      System.out.println( fileName );  
				
				   }
				}
				
		);
		
		this.setLayout(new BorderLayout());
		
		this.add(fileLabel,BorderLayout.NORTH);
		this.add(chooseFile,BorderLayout.SOUTH);	
	}
}
