package TestExecution;

import net.thucydides.core.annotations.Steps;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import java.util.Iterator;		
import java.util.Set;

public class GenerateInvoice {
	
	@Steps
	static WebDriver  driver;

	@BeforeClass
	public static void BrowserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
	    driver= new ChromeDriver() ;
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Register_User()
	{
		Actions hover = new Actions(driver);
		Login login = new Login();
		login.login(driver);
		System.out.println("1");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println("2");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
		System.out.println("3");
		driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a/i")).click();
	}		
	
	
}
