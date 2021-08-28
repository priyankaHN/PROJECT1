package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_organisation 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("1234");
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("or2");
		
		 WebElement industry_dd = driver.findElement(By.name("industry"));
		 Select select = new Select(industry_dd);
		 select.selectByVisibleText("Banking");
		 
		 WebElement type_dd = driver.findElement(By.name("accounttype"));
		 Select select1 = new Select(type_dd);
		 select1.selectByValue("Customer");
		 
		 WebElement rating_dd=driver.findElement(By.name("rating"));
		 Select select2 = new Select(rating_dd);
		 select2.selectByIndex(2);
		 
		 Thread.sleep(4000);
		 
		 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		 
		 WebElement administrator =driver.findElement(By.className("small"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(administrator).perform();
		 
		 try
		 {
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 }
		 catch(Exception e)
		 {
			 
		 }
	}

}

