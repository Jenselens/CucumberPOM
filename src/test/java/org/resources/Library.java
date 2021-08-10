package org.resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	JavascriptExecutor executor;
	public static WebDriver driver;
	Actions actions;
	Robot robot;

	public String excelRead(int rowNo, int cellNo) throws Throwable {
		String name = null;
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\Frame2\\Excel\\File2.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Test");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		if (type == 1) {
			name = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			name = dateFormat.format(date);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			name = String.valueOf(l);
		}

		return name;
	}

	public static void excelWrite(String name) throws Exception {
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\Frame2\\Excel\\File2.xlsx");
		FileInputStream ip = new FileInputStream(file);
		Workbook w1 = new XSSFWorkbook(ip);
		Sheet sh = w1.getSheet("Test");
		Row rw = sh.getRow(1);
		Cell ce = rw.createCell(14);
		String cellValue = ce.getStringCellValue();
		if (cellValue.equals("")) {
			ce.setCellValue(name);
		}
		FileOutputStream out = new FileOutputStream(file);
		w1.write(out);
	}

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void loadurl(String url) {
		driver.get(url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void type(WebElement element, String name) {
		element.sendKeys(name);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void closeAllWindows() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void geturl() {
		System.out.println(driver.getCurrentUrl());
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void dragAndDrop(WebElement src, WebElement dest) {
		actions = new Actions(driver);
		actions.dragAndDrop(src, dest).perform();
	}

	public void mouseOver(WebElement position) {
		actions.moveToElement(position);
	}

	public String getAttr(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public String getAttr(WebElement element, String data) {
		String attr2 = element.getAttribute(data);
		return attr2;
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	public Navigation navi() {
		Navigation navigate = driver.navigate();
		return navigate;
	}

	public void navigateTo(String url) {
		navi().to(url);
	}

	public void navigateBack() {
		navi().back();
	}

	public void navigateForward() {
		navi().forward();
	}

	public void navigateRefresh() {
		navi().refresh();
	}

	public boolean display(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean select(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public boolean enable(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean ismultiplevalueinSelect(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public void enter() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void selectcut() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
	}

	public void selectcopy() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	}

	public void overallselect() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}

	public Alert alrt() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public void alrtAccept() {
		alrt().accept();
	}

	public void alrtDismiss() {
		alrt().dismiss();
	}

	public void alrtConfirmAlert(String txt) {
		alrt().sendKeys(txt);
		alrt().accept();
	}

	public void sByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public String gtOptns(WebElement element) {

		String text = null;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			text = getElementText(webElement);
		}
		return text;

	}

	public void takesscreen(String location, String filename) throws Throwable {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File ss = sc.getScreenshotAs(OutputType.FILE);
		File dd = new File(location + "\\" + filename);
		FileUtils.copyFile(ss, dd);

	}

	public void jsClick(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void jsscrolldown(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("aruguments[0].scrollIntoView(true)", element);
	}

	public void jsscrollUp(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("aruguments[0].scrollIntoView(false)", element);
	}

	public void jsinsert(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("aruguments[0].scrollIntoView(true)", element);
	}

	public void jsinsert(String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("aruguments[0].setAttribute('value',' " + data + " ')");
	}

	public void alldeselect(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public String indexdeselect(WebElement element, int index) {
		String text = null;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			text = getElementText(webElement);
		}
		select.deselectByIndex(index);
		return text;
	}

	public String valuedeselect(WebElement element, String value) {
		String text = null;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			text = getElementText(webElement);
		}
		select.deselectByValue(value);
		return text;
	}

	public String visibletextdeselect(WebElement element, String vtext) {
		String text = null;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			text = getElementText(webElement);
		}
		select.deselectByVisibleText(vtext);
		return text;
	}

	public void switchbyIndexframe(int index) {
		driver.switchTo().frame(index);
	}

	public void switchbyStringframe(String framename) {
		driver.switchTo().frame(framename);
	}

	public void switchbyElementFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchtodefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void selectbyvisi(WebElement element, String txt) {
		Select s = new Select(element);
		s.selectByVisibleText(txt);
	}
}
