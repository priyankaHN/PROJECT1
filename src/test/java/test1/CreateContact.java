package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {

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
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("win5");
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//input[@name='account_name']/..//img[@title='Select']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement mh = driver.findElement(By.className("small"));
		Actions actions =new Actions(driver);
		actions.moveToElement(mh).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//try
		//{
		//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//}
		////catch(Exception e)
		//{
			
		//}
		//driver.quit();
	}

}
