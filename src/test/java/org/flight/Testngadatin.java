package org.flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testngadatin {
	WebDriver driver;

	@BeforeClass
	private void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	}

	@Parameters({ "username" })
	@Test(priority = 0)
	private void username(String s) {
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys(s);

	}

	@Parameters({ "password" })
	@Test(priority = 1)
	private void password(String s) {
		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys(s);
	}

	@Test(priority = 2)
	private void login() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Test(priority = 3)
	private void location() {
		WebElement location = driver.findElement(By.id("location"));
		Select select = new Select(location);
		select.selectByIndex(2);

	}

	@Test(priority = 4)
	private void hotels() {
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select select1 = new Select(hotels);
		select1.selectByIndex(2);

	}

	@Test(priority = 5)
	private void roomtype() {
		WebElement roomtype = driver.findElement(By.id("room_type"));
		Select select2 = new Select(roomtype);
		select2.selectByIndex(2);

	}

	@Test(priority = 6)
	private void noofroom() {
		WebElement noofroom = driver.findElement(By.id("room_nos"));
		Select select3 = new Select(noofroom);
		select3.selectByIndex(2);

	}

	@Parameters({ "datepick_in" })
	@Test(priority = 7)
	private void checkindate(String s) {

		WebElement checkin = driver.findElement(By.id("datepick_in"));
		checkin.sendKeys(s);

	}

	@Parameters({ "datepick_out" })
	@Test(priority = 8)
	private void checkoutdate(String s) {
		WebElement checkout = driver.findElement(By.id("datepick_out"));
		checkout.sendKeys(s);

	}

	@Test(priority = 9)
	private void adultsperroom() {
		WebElement adultroom = driver.findElement(By.id("adult_room"));
		Select select4 = new Select(adultroom);
		select4.selectByIndex(2);

	}

	@Test(priority = 10)

	private void chidperroom() {
		WebElement childroom = driver.findElement(By.id("child_room"));
		Select select5 = new Select(childroom);
		select5.selectByIndex(1);

	}

	@Test(priority = 11)
	private void search() {
		WebElement search = driver.findElement(By.id("Submit"));
		search.click();

	}

	@Test(priority = 12)
	private void continues() {
		WebElement radiobtn = driver.findElement(By.id("radiobutton_0"));
		radiobtn.click();
	}

	@Test(priority = 13)
	private void continuebtn() {
		WebElement continuebtn = driver.findElement(By.id("continue"));
		continuebtn.click();
	}

	@Parameters({ "first_name" })
	@Test(priority = 14)
	private void firstname(String s) {
		WebElement firstname = driver.findElement(By.id("first_name"));
		firstname.sendKeys(s);

	}

	@Parameters({ "last_name" })
	@Test(priority = 15)
	private void lastname(String s) {
		WebElement lastname = driver.findElement(By.id("last_name"));
		lastname.sendKeys(s);

	}

	@Parameters({ "address" })
	@Test(priority = 16)
	private void address(String s) {
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys(s);

	}

	@Parameters({ "cc_num" })
	@Test(priority = 17)
	private void creditcardno(String s) {
		WebElement ccnum = driver.findElement(By.id("cc_num"));
		ccnum.sendKeys(s);
	}

	@Test(priority = 18)
	private void creditcardtype() {
		WebElement cctype = driver.findElement(By.id("cc_type"));
		Select select6 = new Select(cctype);
		select6.selectByIndex(1);

	}

	@Test(priority = 19)
	private void expiredate() {
		WebElement ccexpmonth = driver.findElement(By.id("cc_exp_month"));
		Select select7 = new Select(ccexpmonth);
		select7.selectByIndex(12);
	}

	@Test(priority = 20)
	private void cctypeyear() {
		WebElement ccexpyear = driver.findElement(By.id("cc_exp_year"));
		Select select8 = new Select(ccexpyear);
		select8.selectByIndex(12);

	}

	@Parameters({ "cc_cvv" })
	@Test(priority = 21)

	private void cvvno(String s) {
		WebElement cvvno = driver.findElement(By.id("cc_cvv"));
		cvvno.sendKeys(s);
	}

	@Test(priority = 22)
	private void booknow() {
		WebElement booknow = driver.findElement(By.id("book_now"));
		booknow.click();
	}

}
