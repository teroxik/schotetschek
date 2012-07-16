package jschotek;

import javax.swing.ImageIcon;

public class Consts {

	private Consts(){};
	
	public static final String SCHOTEK_PATH = "schotek.gif";
	public static final String RES_PATH = "Res";
	public static final String newline = "\n";
	
	
	   /** Returns an ImageIcon, or null if the path was invalid. */
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Window.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
