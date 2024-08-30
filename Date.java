package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Date {
	
	@Test
	public void DOB() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
	  
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement date=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		Thread.sleep(2000);
		date.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement dd_month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		
		Select select=new Select(dd_month);
		
		select.selectByIndex(5);
		
		//String year=DT.split(" ")[0];
		//System.out.println(Integer.valueOf(year));
		
		WebElement dd_year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Thread.sleep(2000);
		
		Select select1=new Select(dd_year);
		select1.selectByValue("2002");
		Thread.sleep(2000);
	}

}
