package jschotek.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import jschotek.Window;

public class CustomImageEditorPanel extends JPanel implements ActionListener {

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
		chooseFile.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		
		this.add(fileLabel,BorderLayout.NORTH);
		this.add(chooseFile,BorderLayout.SOUTH);
	}
	

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == chooseFile) {
			
			JFileChooser fc = new JFileChooser();  
		     // fc.setCurrentDirectory( ) );  
		      int returnVal = fc.showOpenDialog( this );   
		      
		      
		      if ( returnVal == JFileChooser.APPROVE_OPTION )     
		      {    
		        File aFile = fc.getSelectedFile();    
		        fileName = aFile.getName();    
		      }  
		    
		      System.out.println( fileName );  
		
		}
		
	}
	
	  /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("JSchotetschek v0.2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new CustomImageEditorPanel());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
