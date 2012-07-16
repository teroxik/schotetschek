package jschotek;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

public class SimpleTest {
 
	
	@org.junit.Test 
	public void simpleTest() {
		ImageIcon imageIcon = Consts.createImageIcon("");
		assertTrue(imageIcon!=null);
	}
	
	@org.junit.Test(expected = NullPointerException.class) 
	public void exceptionTest() {
		String path = null;
		Consts.createImageIcon(path);		
	}
}
