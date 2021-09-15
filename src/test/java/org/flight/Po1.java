package org.flight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Po1 extends Baseclass {
	public Po1() {
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath= "//select[@name='fromPort']")
    private WebElement depaturecity;
   
    @FindBy(xpath="//select[@name='toPort']")
    private WebElement destinationcity;
    public WebElement getDepaturecity() {
		return depaturecity;
	}
	public WebElement getDestinationcity() {
		return destinationcity;
	}
	@FindBy(xpath="//input[@type = 'submit']")
	private WebElement find;
	
	public WebElement getFind() {
		return find;
	}
	
	
	
	
	
	
}
