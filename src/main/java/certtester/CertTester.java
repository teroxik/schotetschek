package certtester;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CertTester {

		/**
		 * @param args
		 */
		public static void main(String[] args) throws Exception {
			
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	               UIManager.put("swing.boldMetal", Boolean.FALSE); 
	    
	               MainWindow mW = new MainWindow("test app");
	               mW.setVisible(true);
	              
	            }
	        });
		}

}
