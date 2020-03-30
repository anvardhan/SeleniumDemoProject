package com.freecrm.testcases;

import org.testng.annotations.Test;

public class RegisterPageTest {
	
	// RegisterPageTest.java file is added by Person A and also registerTest is added by Person A
	
	@Test(enabled=true)
	public void resisterTest1() {
		
		System.out.println("This is register test and this test is added by Person A");
		
	}
	
	@Test(enabled=true)
	public void registerPageTitle() {
		System.out.println("This is register page title test and its added by Person B");
	}
	
	@Test(enabled=true)
	public void registerTest2() {
		System.out.println("This is register test commited from Eclipse");
		System.out.println("This is updated in GithUb directly to demonstrate pull from eclipse");
	}
}
