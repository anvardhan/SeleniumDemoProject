package com.freecrm.testcases;

import org.testng.annotations.Test;

public class NewClassTest {
	
	@Test(enabled=true)
	public void newTest1() {
		
		//This class and code is Added by Person B on develop branch
		System.out.println("This test is added through develop branch and yet to be tested");
	}
	
	@Test(enabled=true)
	public void newTest2() {
		
		//This class and code is Added by Person A on develop branch
		System.out.println("This test is added through develop branch and yet to be tested by A");
	}

}
