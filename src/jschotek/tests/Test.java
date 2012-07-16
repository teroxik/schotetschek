package jschotek.tests;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import jschotek.Constants;


public class Test {

	
	@org.junit.Test 
	public void simpleTest() {
		ImageIcon imageIcon = Constants.createImageIcon("");
		assertTrue(imageIcon!=null);
	}
	
	@org.junit.Test(expected = NullPointerException.class) 
	public void exceptionTest() {
		String path = null;
		Constants.createImageIcon(path);		
	}
}
