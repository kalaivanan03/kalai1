package org.flight;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	//Actions actions;
	//Alert alert;
	//TakesScreenshot screenshot;
	//JavascriptExecutor executor;
	//Select select;
//1.	
	
	
	//Usual methods we use to automate a web page
	
	
	public WebDriver driver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;     }
	
	public WebDriver firefoxdriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}
//2.
	public void url(String data) {
		driver.get(data);     }
//3.
	public void type(WebElement element,String data ) {
		element.sendKeys(data);  }
//4.
	public void click(WebElement element) {
		element.click();   }
//5.
	public void maximize() {
		driver.manage().window().maximize(); }
//6.
	public void closeBrowser() {
		driver.quit(); }
//7.
	public void closeCurrentBrowser() {
		driver.close();  }
//8.
	public String printText(WebElement element) {
		String text = element.getText();	
		return text;   }
//9.
	public String printAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;   }
//10.
	public String printTitle() {
		String title = driver.getTitle(); 
		return title;
		}
//11.
	public String printCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
		
	}
//12.
	
	
	
	
	//Navigate
	
	
	
	
	public void navigateTo(String data) {
		driver.navigate().to(data); }
//13.
	public void navigateBack() {
		driver.navigate().back(); }
//14.
	public void navigateForward() {
		driver.navigate().forward(); }
//15.
	public void refresh() {
		driver.navigate().refresh(); }
//16.
	
	
	
	
	
	//Actions
	
	
	
	/*public Actions action() {
		actions = new Actions(driver);
		return actions;   }*/
//17.
	public void mouseOverAction(WebElement element) {
		new Actions(driver).moveToElement(element).perform();  }
//18.
	public void dragAndDrop(WebElement s , WebElement d) {
		new Actions(driver).dragAndDrop(s, d).perform(); }
//19.
	public void rightClick(WebElement element) {
		new Actions(driver).contextClick(element).perform();  }
//20.
	public void doubleClick(WebElement element) {
		new Actions(driver).doubleClick(element).perform();  }
//21.
	
	
	
	
	
	
	//Alert
	
	
	
	
	/*public Alert alertWindow() {
		alert = driver.switchTo().alert();
		return alert; }*/
//22.
	public void accept() {
		driver.switchTo().alert().accept(); }
//23.
	public void dismiss() {
		driver.switchTo().alert().dismiss(); }
//24.
	public String printTextinAlert() {
		String text = driver.switchTo().alert().getText();
		return text;  }
//25.
	public void typeInAlert(String data) {
		driver.switchTo().alert().sendKeys(data); }
//26.
	
	
	
	
	
	
	
	
	/*public TakesScreenshot screenShot() {
		screenshot = (TakesScreenshot)driver;
		return screenshot; }
//27.
	public File saveScreenshotInDefaultLoc() {
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		return s; }*/
//28.
	public File fileCreation(String path) {
		File file = new File(path);
		return file; }
//29.
	//public void saveScreenshotInSpecificLoc(File s , File d) throws IOException {
		//FileUtils.copyFile(s,d);  }
//30.
	/*public JavascriptExecutor javaScript() {
		executor = (JavascriptExecutor) driver;	
		return executor;    }	*/
//31.
	
	
	
	
	//JavaScript
	
	
	
	
	public void enterUsingJavaScript(String data, WebElement element)
	{ 
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value', '"+data+"')",element); 
		}
	public void clickUsingJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",element);
	}
//32.
	public Object getAttributeinJavaScript(String data, WebElement element)
	{ JavascriptExecutor executor = (JavascriptExecutor)driver;
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')",element);
		return executeScript; }
	
//33.
	public void scrollDown( WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);   }
	
	public void scrollUp( WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);   }

	
	
	
	
	
	
	
	   
	
	//Select
	
	//34.
	//public Select select(WebElement element) {
		//select = new Select(element);
		//return select;  }
//35.
	public void selectOptionByIndex(WebElement element, int i) {
	new Select(element).selectByIndex(i); }
//36.
	public void selectOptionByText(WebElement element, String data) {
		new Select(element).selectByVisibleText(data); }
//37.
	public void selectOptionByValue(WebElement element,String data) {
		new Select(element).selectByValue(data);  }
//38.
	public void deselectOptionByIndex(WebElement element,int i) {
		new Select(element).deselectByIndex(i); }
//39.
	public void deselectOptionByText(WebElement element,String data) {
		new Select(element).deselectByVisibleText(data); }
//40.
	public void deselectOptionByValue(WebElement element,String data) {
		new Select(element).deselectByValue(data);  }
//41.
	public List<WebElement> toGetOptionsFromDropDown(WebElement element) {
		List<WebElement> options = new Select(element).getOptions();
		return options;  }
//42.
	public WebElement toGetFirstSelectedOption(WebElement element) {
		WebElement firstSelectedOption = new Select(element).getFirstSelectedOption();
		return firstSelectedOption; }
//43.
	public List<WebElement> toGetAllSelectedOptions(WebElement element) {
		List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
		return allSelectedOptions;  }
//44.	
	public void toDeselectAll(WebElement element) {
		new Select(element).deselectAll();  }

	
	
	
	
	//Frames
	
	
	
//45.
	public void switchToFrameUsingIdAndNAme(String data) {
		driver.switchTo().frame(data); }
//46.
	public void switchToFrameUsingElement(WebElement element) {
		driver.switchTo().frame(element); }
//47.
	public void switchToFrameUsingIndex(int i) {
		driver.switchTo().frame(i); }
//48.
	public void exitFrame() {
		driver.switchTo().defaultContent(); }
//49.
	public void exitChildFrame() {
		driver.switchTo().parentFrame(); }
//50.
	public void switchToWindowUsingUrl(String data) {
		driver.switchTo().window(data); }
//51.
	public void switchToWindowUsingTitle(String data) {
		driver.switchTo().window(data); }
//52.
	public void switchToWindowUsingId(String data) {
		driver.switchTo().window(data); }
//53.
	public String toGetParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;}
//54.
	public Set<String> toGetAllWIndowsId() {
		Set<String> allwindowHandles = driver.getWindowHandles();
		return allwindowHandles; }
//55.
	public void switchToNextWindow() {
		String pWId = driver.getWindowHandle();
		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String eacWindowID : allwindowHandles) {
			if (!pWId.equals(eacWindowID)) {
				driver.switchTo().window(eacWindowID);
			}
			}}
	
	public void switchToMultipleWindow(int index) {
		Set<String> allwindowHandles = driver.getWindowHandles();
		List<String> li = new ArrayList();
		li.addAll(allwindowHandles);
		driver.switchTo().window(li.get(index));
	}
	
	
	
	
	//Wait
	
	
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); }
//56.
	public void webDriverWait(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time); }
//57.
	
	
	
	
	//WebElement methods
	
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;}
//58.
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled; }
//59.
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected; }
//60.
	public void clearText(WebElement element) {
		element.clear(); }


		//Excel

	

	
	
	
	

	
	
	
	
	//Screenshots
	
	
	public void screenshot(String data) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Dell\\eclipse-workspace\\Frames\\ScreenShots\\"+data+".png" );
		FileUtils.copyFile(s, d);
	}



//WebTable
	
	//1.To print data in row exactly:

	public String printDataInRow() {
		String text = null;
		List<WebElement> li = driver.findElements(By.tagName("tr"));
		for (int i = 0; i < li.size(); i++) {
			WebElement element = li.get(i);
			text = element.getText();
			
		}
		return text;
		}
	

//2.To print all data row by row
	 
	public String printDataRowByRow() {
		
		String text = null;
		List<WebElement> li = driver.findElements(By.tagName("tr"));
		for (int i = 0; i < li.size(); i++) {
			
			WebElement element = li.get(i);
			List<WebElement> list = element.findElements(By.tagName("td"));
			for (int j = 0; j < list.size(); j++) {
				WebElement element2 = list.get(j);
				text = element2.getText(); }
				}
		return text;
	}


	
//Robot
	
	public void robotEnter() throws Throwable  {
		new Robot().keyPress(KeyEvent.VK_ENTER);
		new Robot().keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void robotSelectAll() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_A);
		new Robot().keyRelease(KeyEvent.VK_A);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}



	public void robotCut() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_X);
		new Robot().keyRelease(KeyEvent.VK_X);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}

	public void robotCopy() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}

	

	public void robotPaste() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}





	public static String getdata(int rowno,int cellno) throws IOException {
		String data = null;
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Demoblaze\\excel\\flight.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(rowno);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellno);
		int i = cell.getCellType();
		if (i==1) {
			 data = cell.getStringCellValue();
			
		}
		if (i==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yy");
				  data = dFormat.format(date);
				
				
			}else {
				double d = cell.getNumericCellValue();
				long l = (long)d;
				 data = String.valueOf(l);
				
			}
		}
		return data;
		
	  
		 
		
		
		
		
		
		
		













}
}
















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    







