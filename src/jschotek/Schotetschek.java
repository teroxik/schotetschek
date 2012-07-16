package jschotek;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Schotetschek {

	//static BasicService basicService = null;

		/**
		 * @param args
		 */
		public static void main(String[] args) throws Exception {
		
			
		
			  
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	                UIManager.put("swing.boldMetal", Boolean.FALSE); 
	                Window.createAndShowGUI();
	            }
	        });
		}

}
