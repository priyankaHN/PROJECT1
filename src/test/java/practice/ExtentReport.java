package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport
{
	WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void setUp() 
	{
		System.out.println("========================connect to DB========================");
		reporter=new ExtentHtmlReporter("./vtiger/extentReports/SDET20.html");
		reporter.config().setDocumentTitle("vtiger");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	
	@BeforeClass
	public void configBC() 
	{
		System.out.println("=============Launch the Browser1=======");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void configBM()
	{
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("1234");
				
		driver.findElement(By.id("submitButton")).click();
	}
	@Test
	public void extentReportHomePage() 
	{
		 test = reports.createTest("extentReportHomePage");
		 String expectedHmPgTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualHmPgTitle=driver.getTitle();
		System.out.println(actualHmPgTitle);
		Assert.assertEquals(actualHmPgTitle, expectedHmPgTitle);
		
	}
	
	@Test
	public void extentReportOrgPg()
	{
		 test = reports.createTest("extentReportOrgPg");
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//System.out.println(actualOrgPgTitle);
		String expectedOrgPgTitle="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String actualOrgPgTitle= driver.getTitle();
		
		Assert.assertEquals(actualOrgPgTitle, expectedOrgPgTitle);
		
	}
	
	@AfterMethod
	public void configAM()
	{
		WebElement administratorImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(administratorImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("========================close DB========================");
		reports.flush();
	}
	

}
