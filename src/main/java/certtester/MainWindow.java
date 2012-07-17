package certtester;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import certtester.view.AppMenu;
import certtester.view.CustomImageEditorPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8874886001129847368L;


	public MainWindow(String text) {
			super(text);
		
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       this.setJMenuBar(new AppMenu());
	       
	        //Add content to the window.
	       this.add(new CustomImageEditorPanel());
	        
	        this.addWindowListener(new WindowAdapter() {
			 	
	            @Override
	            public void windowClosing(WindowEvent e) {
	                MainWindow.this.setVisible(false);
	                MainWindow.this.dispose();
	            }
	        });

	        this.pack();
	}

	

}
