package test1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		String parentWid = driver.getWindowHandle();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("1234");
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("win8");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@name='account_name']/..//img[@title='Select']")).click();
		
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Set<String> allwid = driver.getWindowHandles();
		String childUrl= "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";		
		for(String wid:allwid)
		{
			driver.switchTo().window(wid);
			Thread.sleep(4000);
			System.out.println(driver.getCurrentUrl());
			
			
			if(driver.getCurrentUrl().equals(childUrl))
			{
				break;
			}
			
		}
		WebElement click = driver.findElement(By.id("2"));
		Actions actions = new Actions(driver);
		actions.doubleClick(click).perform();
		
		driver.switchTo().window(parentWid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
	
	}

}
