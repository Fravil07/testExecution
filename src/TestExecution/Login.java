package TestExecution;

import net.thucydides.core.annotations.Steps;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	@Steps
	static WebDriver  driver;

	@BeforeClass
	public static void BrowserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
	    driver= new ChromeDriver() ;
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void login(WebDriver wdriver) {
		wdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wdriver.get("http://automationpractice.com/index.php");
		wdriver.manage().window().maximize();
		wdriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		wdriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("fravil07@gmail.com");
		wdriver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("01071995243");
		wdriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
	}
	
	@Test
	public void Login_User()
	{
		login(driver);
		String url= driver.getCurrentUrl();
	    assert url!="http://automationpractice.com/index.php?controller=my-account": String.format("Login fallido");
	}		
	
	@AfterClass
	public static void BrowserClose()
	{
		driver.quit();
	}
	
	public Login() {
		
	}
}
