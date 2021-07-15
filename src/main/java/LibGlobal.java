import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {

static WebDriver driver;
	
	public static void browserConfig() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\BaseClass\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	public static void openUrl(String url) {
		driver.get(url);	
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public static void type(WebElement element,String data) {
		element.sendKeys(data);
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void dropDown1(WebElement element,String data) {
		Select s=new Select(element);
		s.selectByValue(data);
	}
	public static void dropDown2(WebElement element, String data) {
		Select s=new Select(element);
		s.selectByVisibleText(data);
	}
	public static void dropDown3(WebElement element, String data) {
		Select s=new Select(element);
		s.selectByIndex(0);
	}
	public static void keyBoard1(WebElement element,int keyEvent) throws AWTException {
		Robot r=new Robot();
		r.keyPress(keyEvent);
	}
	public static void keyBoard2(WebElement element,int keyEvent) throws AWTException {
		Robot r=new Robot();
		r.keyRelease(keyEvent);	
	}
	public static void scrollDown(JavascriptExecutor arg, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;	
	}
	
	
	
	public static String excelRead(String location,String sheet1,int row1,int cell1) throws Exception {
		File f=new File(location);
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet(sheet1);
		Row row = sheet.getRow(row1);
		Cell cell = row.getCell(cell1);
		String value="";
		int cellType = cell.getCellType();
		if (cellType==1) {
			
			cell.getStringCellValue();			
		}
		else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("MM/dd/yyyy");
				value =sim.format(dateCellValue);
				
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long) numericCellValue;
				value = String.valueOf(l);		
			}
		}
		return value;	
	}
	public void excelWrite(String location,String sheet,int row,int cell,String name) throws Exception {
		File f=new File(location);
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet createSheet = w.createSheet(sheet);
		Row createRow = createSheet.createRow(row);
		Cell createCell = createRow.createCell(cell);
		createCell.setCellValue(name);
		
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		
		
		
		
	}
}









