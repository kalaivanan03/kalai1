package org.flight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Po2  extends Baseclass{
 public Po2() {
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath ="//input[@type='submit']")
 private WebElement chooseflight;

public WebElement getChooseflight() {
	return chooseflight;
}
 
 
 
}
