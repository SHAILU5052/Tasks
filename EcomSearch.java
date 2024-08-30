package Basic;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EcomSearch {
	WebDriver driver;
	Actions actions;
	@Test
	public void ReadData() throws InterruptedException, Exception {
		
		driver = new ChromeDriver();
		actions=new Actions(driver);
		driver.get("https://demo.nopcommerce.com/electronics");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		File src=new File("C:\\Users\\SAILAJA\\OneDrive\\Desktop\\xssf.xlsx");
		  Thread.sleep(2000);

		  
		  FileInputStream fis=new FileInputStream(src);
		 
		  XSSFWorkbook xsf = new XSSFWorkbook(fis);
		  
			XSSFSheet sheet = xsf.getSheet("Search");
			
			int rowcount = sheet.getLastRowNum();
			for(int i=0; i<rowcount; i++) {

				Row row = sheet.getRow(i+1);

				String Search = row.getCell(0).getStringCellValue();
				
				WebElement sh = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
				
				sh.clear();
				sh.sendKeys(Search);
				Thread.sleep(5000);
				
			driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				
				
				//assertion once u click on the serarch button , 
				
			}
		driver.close();
	}

}
