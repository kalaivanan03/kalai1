package org.flight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Po3 extends Baseclass {
	public Po3() {
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(xpath="//input[@id ='inputName']")
		private WebElement firstname;
		@FindBy(id="address")
		private WebElement address;
		@FindBy(id="city")
		private WebElement city;

		@FindBy(id="state")
		private WebElement state;
		public WebElement getFirstname() {
			return firstname;
		}
		public WebElement getAddress() {
			return address;
		}
		public WebElement getCity() {
			return city;
		}
		public WebElement getState() {
			return state;
		}
		public WebElement getZipcode() {
			return zipcode;
		}
		public WebElement getCardtype() {
			return cardtype;
		}
		public WebElement getCreditcardno() {
			return creditcardno;
		}
		public WebElement getMonth() {
			return month;
		}
		public WebElement getYear() {
			return year;
		}
		public WebElement getNameoncard() {
			return nameoncard;
		}
		public WebElement getSubmit() {
			return submit;
		}
		@FindBy(id="zipCode")
		private WebElement zipcode;
		@FindBy(id="cardType")
		private WebElement cardtype;
		@FindBy(id="creditCardNumber")
		private WebElement creditcardno;
		@FindBy(id="creditCardMonth")
		private WebElement month;
		@FindBy(id="creditCardYear")
		private WebElement year;
		@FindBy(id="nameOnCard")
		private WebElement nameoncard;
		@FindBy(xpath="(//input[@type='submit'])")
		private WebElement submit;













}
