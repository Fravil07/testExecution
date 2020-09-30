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

public class AddProduct {
	
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
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement frameID = driver.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div/div/div/div/iframe"));
		driver.switchTo().frame(frameID);
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
	}		
	
	
}
