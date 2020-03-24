package com.project.utilities;

import com.project.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT=10;
	
	
	//SwitchToFrame
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

}
