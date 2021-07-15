import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {

	static WebDriver driver;
	
	@Test
	public void tc1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Maven\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
	}
	
	@Test(dataProvider="sampledata")
	public void tc2(String email,String pass) {
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);
		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys(pass);
	}
	
	
	@DataProvider(name="sampledata")
	private Object[][] data() {
		return new Object[][] {
			
			{"Welcome.com","test123"},
			{"Welcome2.com","test456"},
			
		};
		
	}
	
	
}
