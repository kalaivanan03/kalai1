package org.my.base;

public class BaseClass {

}
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class BaseClass {

	public static WebDriver driver;
	public static Actions actions;
	public static Alert alert;
	public static TakesScreenshot tk;
	public static JavascriptExecutor js;
	public static Select select;
	public static WebElement element;
	
	public String getdatafromcell( int rownum, int cellnum) throws Throwable {
		String data = null;
		File file = new File("C:\\Users\\Study's\\eclipse-workspace\\Practice01Maven\\ExcelSheets\\workbook1forloginreg.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Data");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		int cellType = cell.getCellType();
		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				data = new SimpleDateFormat("dd/MMM/yy").format(cell.getDateCellValue());
			} else {
				data = String.valueOf((long) cell.getNumericCellValue());
			}
		}
		return data;

	}

	public WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("fire fox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}// 1

	public void loadUrl(String url) {
		driver.get(url);
	}// 2

	public void maximize() {
		driver.manage().window().maximize();
	}// 3

	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}// 4

	public void click(WebElement element) {
		element.click();
	}// 5

	public String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}// 6

	public String getText(WebElement element) {
		return element.getText();
	}// 7

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}// 8

	public String getTitle() {
		return driver.getTitle();
	}// 9

	public void quit() {
		driver.quit();
	}// 10

	public void close() {
		driver.close();
	}// 11

	public void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}// 12

	public void dragAndDrop(WebElement element) {
		actions = new Actions(driver);
		actions.dragAndDrop(element, element).perform();
	}// 13

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}// 14

	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}// 15

	public void keyBoardActions(String data) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
	}// 16

	public void CapitalType(WebElement element, String data) {
		actions = new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys(element, data).keyUp(element, Keys.SHIFT);
	}// 17

	public void typeAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}// 18

	public void simpleAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}// 19

	public void confrimAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}// 20

	public void promptAlert(String data) {
		alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();
	}// 21

	public String getTextfromAlert() {
		alert = driver.switchTo().alert();
		return alert.getText();
	}// 22

	public void navigateToNewurl(String data) {
		driver.navigate().to(data);
	}// 23

	public void navigateBack() {
		driver.navigate().back();
	}// 24

	public void navigateForward() {
		driver.navigate().forward();
	}// 25

	public void refreshWindow() {
		driver.navigate().refresh();
	}// 26

	public String windowHandle() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}// 27

	public Set<String> windowHandles() {
		Set<String> allwindowId = driver.getWindowHandles();
		return allwindowId;
	}// 28

	public void switchWindowid(String id) {
		driver.switchTo().window(id);
	}// 29

	public void switchwindowtitle(String title) {
		driver.switchTo().window(title);
	}// 30

	public void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}// 31

	public void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}// 32

	public void getScreenShot(String path) throws IOException {
		tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File des = new File(path);
		FileUtils.copyFile(source, des);
	}// 33

	public void switchFrameid(String locator, String idname) {
		if (locator.equalsIgnoreCase("id")) {
			driver.switchTo().frame(idname);
		} else if (locator.equalsIgnoreCase("name")) {
			driver.switchTo().frame(idname);
		}
	}// 34

	public void switchFrameindex(int index) {
		driver.switchTo().frame(index);
	}// 35

	public void switchFrameelement(WebElement element) {
		driver.switchTo().frame(element);
	}// 36

	public void defaultContent() {
		driver.switchTo().defaultContent();
	}// 37

	public void parentFrame() {
		driver.switchTo().parentFrame();
	}// 38

	public void SelectBy(WebElement element, String type, String value) {
		select = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		} else if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		}
	}// 39

	public void deSelectBy(WebElement element, String type, String value) {
		select = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			select.deselectByIndex(Integer.parseInt(value));
		} else if (type.equalsIgnoreCase("value")) {
			select.deselectByValue(value);
		} else if (type.equalsIgnoreCase("text")) {
			select.deselectByVisibleText(value);
		}
	}// 40

	public void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}// 41

	public WebElement getFirstSelect(WebElement element) {
		select = new Select(element);
		WebElement selectedOption = select.getFirstSelectedOption();

		return selectedOption;
	}

	// 42
	public List<WebElement> getAllSelected(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		return allSelectedOptions;

	}

	// 43
	public List<String> getoptions(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> allOptionsText = new ArrayList<String>();
		for (WebElement eachElement : options) {
			String data = eachElement.getText();
			allOptionsText.add(data);
		}
		return allOptionsText;
	}// 44

	public List<String> getoption(WebElement element) {
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		List<String> eachtext = new ArrayList<String>();
		for (WebElement alloptions : list) {
			String string = alloptions.getText();
			eachtext.add(string);
		}
		return eachtext;

	}

	public boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}// 45

	public WebElement locaters(String locater, String value) {

		if (locater.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(value));
		} else if (locater.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(value));
		} else if (locater.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(value));
		} else if (locater.equalsIgnoreCase("tagname")) {
			element = driver.findElement(By.tagName(value));
		}
		return element;
	}// 46

	public void jsSendkeys(WebElement element, String data) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}// 47

	public void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}// 48

	public void jsgetAttribute(WebElement element) {
		js = (JavascriptExecutor) driver;
		String executeScript = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(executeScript);

	}

	public void insertCellvalue(int rownum, int cellnum, String Data) throws Throwable {
		File file = new File("C:\\Users\\Study's\\eclipse-workspace\\Practice01Maven\\ExcelSheets\\workbook1forloginreg.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.getSheet("Data");
		Row createRow = createSheet.getRow(rownum);
		Cell createCell = createRow.getCell(cellnum);
		createCell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class Demoflight {

	public static WebDriver driver;
	public static Actions actions;
	public static Alert alert;
	public static TakesScreenshot tk;
	public static JavascriptExecutor js;
	public static Select select;
	public static WebElement element;
	
	public String getdatafromcell( int rownum, int cellnum) throws Throwable {
		String data = null;
		File file = new File("C:\\Users\\Study's\\eclipse-workspace\\Practice01Maven\\ExcelSheets\\workbook1forloginreg.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Data");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		int cellType = cell.getCellType();
		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				data = new SimpleDateFormat("dd/MMM/yy").format(cell.getDateCellValue());
			} else {
				data = String.valueOf((long) cell.getNumericCellValue());
			}
		}
		return data;

	}

	public WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("fire fox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}// 1

	public void loadUrl(String url) {
		driver.get(url);
	}// 2

	public void maximize() {
		driver.manage().window().maximize();
	}// 3

	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}// 4

	public void click(WebElement element) {
		element.click();
	}// 5

	public String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}// 6

	public String getText(WebElement element) {
		return element.getText();
	}// 7

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}// 8

	public String getTitle() {
		return driver.getTitle();
	}// 9

	public void quit() {
		driver.quit();
	}// 10

	public void close() {
		driver.close();
	}// 11

	public void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}// 12

	public void dragAndDrop(WebElement element) {
		actions = new Actions(driver);
		actions.dragAndDrop(element, element).perform();
	}// 13

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}// 14

	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}// 15

	public void keyBoardActions(String data) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
	}// 16

	public void CapitalType(WebElement element, String data) {
		actions = new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys(element, data).keyUp(element, Keys.SHIFT);
	}// 17

	public void typeAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}// 18

	public void simpleAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}// 19

	public void confrimAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}// 20

	public void promptAlert(String data) {
		alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();
	}// 21

	public String getTextfromAlert() {
		alert = driver.switchTo().alert();
		return alert.getText();
	}// 22

	public void navigateToNewurl(String data) {
		driver.navigate().to(data);
	}// 23

	public void navigateBack() {
		driver.navigate().back();
	}// 24

	public void navigateForward() {
		driver.navigate().forward();
	}// 25

	public void refreshWindow() {
		driver.navigate().refresh();
	}// 26

	public String windowHandle() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}// 27

	public Set<String> windowHandles() {
		Set<String> allwindowId = driver.getWindowHandles();
		return allwindowId;
	}// 28

	public void switchWindowid(String id) {
		driver.switchTo().window(id);
	}// 29

	public void switchwindowtitle(String title) {
		driver.switchTo().window(title);
	}// 30

	public void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}// 31

	public void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}// 32

	public void getScreenShot(String path) throws IOException {
		tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File des = new File(path);
		FileUtils.copyFile(source, des);
	}// 33

	public void switchFrameid(String locator, String idname) {
		if (locator.equalsIgnoreCase("id")) {
			driver.switchTo().frame(idname);
		} else if (locator.equalsIgnoreCase("name")) {
			driver.switchTo().frame(idname);
		}
	}// 34

	public void switchFrameindex(int index) {
		driver.switchTo().frame(index);
	}// 35

	public void switchFrameelement(WebElement element) {
		driver.switchTo().frame(element);
	}// 36

	public void defaultContent() {
		driver.switchTo().defaultContent();
	}// 37

	public void parentFrame() {
		driver.switchTo().parentFrame();
	}// 38

	public void SelectBy(WebElement element, String type, String value) {
		select = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		} else if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		}
	}// 39

	public void deSelectBy(WebElement element, String type, String value) {
		select = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			select.deselectByIndex(Integer.parseInt(value));
		} else if (type.equalsIgnoreCase("value")) {
			select.deselectByValue(value);
		} else if (type.equalsIgnoreCase("text")) {
			select.deselectByVisibleText(value);
		}
	}// 40

	public void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}// 41

	public WebElement getFirstSelect(WebElement element) {
		select = new Select(element);
		WebElement selectedOption = select.getFirstSelectedOption();

		return selectedOption;
	}

	// 42
	public List<WebElement> getAllSelected(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		return allSelectedOptions;

	}

	// 43
	public List<String> getoptions(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> allOptionsText = new ArrayList<String>();
		for (WebElement eachElement : options) {
			String data = eachElement.getText();
			allOptionsText.add(data);
		}
		return allOptionsText;
	}// 44

	public List<String> getoption(WebElement element) {
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		List<String> eachtext = new ArrayList<String>();
		for (WebElement alloptions : list) {
			String string = alloptions.getText();
			eachtext.add(string);
		}
		return eachtext;

	}

	public boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}// 45

	public WebElement locaters(String locater, String value) {

		if (locater.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(value));
		} else if (locater.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(value));
		} else if (locater.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(value));
		} else if (locater.equalsIgnoreCase("tagname")) {
			element = driver.findElement(By.tagName(value));
		}
		return element;
	}// 46

	public void jsSendkeys(WebElement element, String data) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}// 47

	public void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}// 48

	public void jsgetAttribute(WebElement element) {
		js = (JavascriptExecutor) driver;
		String executeScript = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(executeScript);

	}

	public void insertCellvalue(int rownum, int cellnum, String Data) throws Throwable {
		File file = new File("C:\\Users\\Study's\\eclipse-workspace\\Practice01Maven\\ExcelSheets\\workbook1forloginreg.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.getSheet("Data");
		Row createRow = createSheet.getRow(rownum);
		Cell createCell = createRow.getCell(cellnum);
		createCell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	


	
}
    
	
	
	
	
	
	
	
	
}

	
	
	


	
}