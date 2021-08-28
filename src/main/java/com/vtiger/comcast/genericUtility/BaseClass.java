//package com.vtiger.comcast.genericUtility;

/*public class BaseClass
{

}*/
package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.vtiger.skipulogo.pomrepository.lib.HomePage;
import com.vtiger.skipulogo.pomrepository.lib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	  /*Object Creation for Lib*/
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public SoftAssert softAssert=new SoftAssert();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
	System.out.println("========================connect to DB========================");
	}
		
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() {
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		sDriver=driver;
	}
	
	/*@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(String BROWSER) {
		System.out.println("=============Launch the Browser=======");
		if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			 driver = new ChromeDriver();
		}

		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}*/
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		/*common Data*/
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		//String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		   driver.get(URL);
	        /* step 1 : login */
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
	      /*step 6 : logout*/
		HomePage homePage = new HomePage(driver);
        homePage.logout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}

