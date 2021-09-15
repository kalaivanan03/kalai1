package org.flight;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demoflight {
	public static void main(String[] args) throws IOException {
		Baseclass a =new Baseclass();
		WebDriver driver = a.driver();
		a.url("https://blazedemo.com/");
		
		Po1 b =new Po1();
		
	 WebElement depaturecity = b.getDepaturecity();
	
	// String s1 = a.getdata(1, 0);
	 a.type(depaturecity, a.getdata(1, 0));
	 a.type(b.getDestinationcity(), a.getdata(1,1));
	 WebElement find = b.getFind();
	 a.click(find);
	 Po2 c = new Po2();
	 WebElement chooseflight = c.getChooseflight();
	 a.click(chooseflight);
	 Po3 d = new Po3();
	 a.type(d.getFirstname(), a.getdata(1, 2));
	 a.type(d.getAddress(),a.getdata(1, 3));
	 a.type(d.getCity(), a.getdata(1, 4));
	 a.type(d.getState(), a.getdata(1, 5));
	 a.type(d.getZipcode(), a.getdata(1, 6));
	 a.type(d.getCardtype(), a.getdata(1, 7));
	 a.type(d.getCreditcardno(), a.getdata(1, 8));
	 a.type(d.getMonth(), a.getdata(1, 9));
	 a.type(d.getYear(), a.getdata(1, 10));
	 a.type(d.getNameoncard(), a.getdata(1, 11));
	 WebElement submit = d.getSubmit();
	 a.click(submit);
	 
	 
	 WebElement table = driver.findElement(By.xpath("//table//tr[1]//td//[2]"));
	 String attribute = table.getText();
	 System.out.println(attribute);
	 
	 
	 
	 
	 
	 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}


