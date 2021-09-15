package org.flight;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Testng {
	@org.testng.annotations.BeforeClass
	private void beforeclass() {
		System.out.println("Before class");

	}
	@BeforeMethod
	private void beforemethod() {
		System.out.println("Before method");

	}
	@AfterMethod
     private void aftermethod() {
		System.out.println("After method");
		

	}
@org.testng.annotations.AfterClass
     private void afterclass() {
		System.out.println("After class");
		

	}
     
     @org.testng.annotations.Test
     private void tc0() {
		System.out.println("Method 1");
		

	}
     @org.testng.annotations.Test
    private void tc1() {
		System.out.println("Method2");

	} 
}
