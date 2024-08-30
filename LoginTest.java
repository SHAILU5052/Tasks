package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@Test(dataProvider="MyData")
	public void  login(String s1,String s2) throws InterruptedException 
	{
		WebElement log=driver.findElement(By.xpath("//input[@id='user-name']"));
		
		log.clear();
		log.sendKeys(s1);
		Thread.sleep(2000);
		
		WebElement in=driver.findElement(By.xpath("//input[@id='password']"));
		
		in.clear();
		in.sendKeys(s2);
		Thread.sleep(2000);
		
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
		
		loginButton.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		
		WebElement out=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		out.click();
		Thread.sleep(2000);
		
		
	}
	@DataProvider
	public String[][] MyData() 
	{
		String[][] arr= {{"standard_user","secret_sauce"},
						 {"locked_out_user","secret_sauce"},
						 {"problem_user","secret_sauce"},
						 {"performance_glitch_user","secret_sauce"},
						 {"error_user","secret_sauce"},
						 {"visual_user","secret_sauce"}
						 };
		return arr;
		
	}
	
	
	@BeforeTest
	public void Url() {
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
