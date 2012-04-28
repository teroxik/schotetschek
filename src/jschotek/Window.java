package jschotek;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import java.io.*;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.event.*;



public class Window extends JPanel implements ActionListener
{
	
	
	

	static private final String SCHOTEK_PATH = "schotek.gif";
	static private final String RES_PATH = "Res";
	
	
	
	static private final String newline = "\n";
	
	
	private Map<Integer, String> messages;
	private ResourceBundle res = ResourceBundle.getBundle("jschotek/"+RES_PATH);
	
	private JLabel imageLabel;
	private JButton changeSchotek;
	private JLabel randomText;
   
    ImageIcon ota;
    ImageIcon schotek; 
    Boolean switchSchotek = true;

    Integer order = 1;
    public Window()
    {
      
    	super(new BorderLayout());

        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    void jbInit()
        throws Exception
    {
    	Boolean run = true;
    	Integer i = 1;
    	messages = new HashMap<Integer,String>();
    	while(run) {
    		
    		try{
    	 	messages.put(i,res.getString(i.toString()));
    	 	i++;}
    		catch(Exception e){
    			e.printStackTrace();
    		    run = false;
    		}
    	}
    	
    	
    	
    	
    	
    	ota = createImageIcon("oto"+order+".jpg");
    	schotek = createImageIcon(SCHOTEK_PATH);
    	imageLabel = new JLabel(ota);
 
         changeSchotek = new JButton("Do it like ota!!");
         changeSchotek.addActionListener(this);
         
         randomText = new JLabel();
         randomText.setHorizontalAlignment(SwingConstants.CENTER);
         randomText.setText("Test - text");
         
         //For layout purposes, put the buttons in a separate panel
         JPanel buttonPanel = new JPanel(); //use FlowLayout
         buttonPanel.add(changeSchotek);
        
       //Add the buttons and the log to this panel.
         add(buttonPanel, BorderLayout.PAGE_START);
         add(imageLabel, BorderLayout.CENTER);
         add(randomText, BorderLayout.PAGE_END);
    }


        public void actionPerformed(ActionEvent e) {
        	order++;
        	if(order>4)
        		order = 1;
            //Handle open button action.
            if (e.getSource() == changeSchotek) {
               
            	if(switchSchotek) {
            		//imageLabel.setIcon(schotek);
            		changeSchotek.setText("Do it like schotetschek!!");
            	}
            	else {
            		
            		changeSchotek.setText("Do it like ota!!");
            	
            	}
            	imageLabel.setIcon( createImageIcon("oto"+order+".jpg"));
            	switchSchotek = !switchSchotek;
            	imageLabel.repaint();
            	changeSchotek.repaint();
            	randomText.setText(randomMessage());
            
            
            }	
            
            
            this.repaint();
               
        }

        /** Returns an ImageIcon, or null if the path was invalid. */
        protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = Window.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }

        /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event dispatch thread.
         */
        public static void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("JSchotetschek v0.1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Add content to the window.
            frame.add(new Window());
            
            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }

       private String randomMessage() {
    	   
    	   return messages.get(new Long((Math.round(Math.random()*messages.size()))).intValue());
       }
    }



