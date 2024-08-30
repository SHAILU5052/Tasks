package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QA_Demo {
	WebDriver driver;
	Actions actions;
	@Test(dataProvider="Data")
	public void Form(String NM,String LT,String EL,String PN,String DT,String G) throws Exception {
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		WebElement name=driver.findElement(By.xpath("//input[@id='firstName']"));
		name.clear();
		name.sendKeys(NM);
		Thread.sleep(2000);
		
		WebElement last=driver.findElement(By.xpath("//input[@id='lastName']"));
		last.clear();
		last.sendKeys(LT);
		Thread.sleep(2000);
		
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		email.clear();
		email.sendKeys(EL);
		Thread.sleep(2000);
		
		
		WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		WebElement femaleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		WebElement otherRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		
		String Gender = G; // Replace with the desired gender (male, female, or other)

		if (Gender.equals("male")) {
		    maleRadioButton.click();
		} else if (Gender.equals("female")) {
		    femaleRadioButton.click();
		} else if (Gender.equals("other")) {
		    otherRadioButton.click();
		} else {
		    // Handle invalid gender input
		    System.out.println("Invalid gender input: " + Gender);
		}
		
		
		
		
		WebElement mn=driver.findElement(By.xpath("//input[@id='userNumber']"));
		mn.clear();
		mn.sendKeys(PN);
		Thread.sleep(2000);
	//=====================================================	
		WebElement date=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		date.click();
		String month=DT.split(" ")[1]; //9    //---> 2023 9 13
		
		System.out.println(Integer.valueOf(month));

		WebElement dd_month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Thread.sleep(2000);
		
		Select select=new Select(dd_month);
		select.selectByIndex(Integer.valueOf(month));
		Thread.sleep(2000);
		
		String year=DT.split(" ")[0];
		System.out.println((year));
		
		WebElement dd_year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Thread.sleep(2000);
		
		Select select1=new Select(dd_year);
		select1.selectByVisibleText(year);
		Thread.sleep(2000);
	
		String day=DT.split(" ")[2]; //13SUBJECT
		WebElement dt=driver.findElement(By.xpath("(//div[@class='react-datepicker__week'])[5]"));
		dt.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		

		
	
		
		
	}
	@DataProvider
	public String[][] Data(){
		String[][] arr= {{"Shailaja","Arige","s123@gmail.com","167036095916","2002 5 25","female"},
		{"mounika"," ","m123@gmail.com","1670360","2002 7 25","female"},
		{"manohar","Arige"," ","1670360959","2002 5 25","male"},
		{" ","Arige","s123@gmail.com","7036095916","2002 5 25"," "}};
		return arr;
	}
	@BeforeTest
	public void Url() {
		driver=new ChromeDriver();
		actions=new Actions(driver);
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@AfterTest
	public void close() {
		//driver.close();
	}
	

}
