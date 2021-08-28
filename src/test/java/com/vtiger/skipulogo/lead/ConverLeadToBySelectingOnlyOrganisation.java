package com.vtiger.skipulogo.lead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
//import com.vtiger.comcast.genreriUtility.WebDriverUtility;
import com.vtiger.skipulogo.pomrepository.lib.ConvertLeadPage;
import com.vtiger.skipulogo.pomrepository.lib.CreateLeadPage;
import com.vtiger.skipulogo.pomrepository.lib.HomePage;
import com.vtiger.skipulogo.pomrepository.lib.LeadsInfoPage;
import com.vtiger.skipulogo.pomrepository.lib.LeadsPage;
import com.vtiger.skipulogo.pomrepository.lib.LoginPage;

public class ConverLeadToBySelectingOnlyOrganisation {
	
	@Test
	public static void ConverLeadToBySelectingOnlyOrganisation() throws Throwable
	{
		/*Object Creation for Lib*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		
		int randomInt = jLib.getRanDomNumber();
		
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*test script Data*/
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		String companyName = eLib.getDataFromExcel("Sheet1", 1, 3) + randomInt;
		
		
		/* Navigate to app*/
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wLib.waitUntilPageLoad(driver);
        driver.get(URL);
        
        /* step 1 : login */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp(USERNAME, PASSWORD);

        /*step 2 : navigate to leads*/
        HomePage homePage = new HomePage(driver);
        homePage.getLeadsLink().click();

        /*step 3 : navigate to "create new lead"page by click on "+" image */
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();
		
        /*step 4 : create lead*/
		CreateLeadPage createLeadsPage = new CreateLeadPage(driver);
		createLeadsPage.createLead(lastName,companyName);
		
		/*step 5: to verify successfull message in leads info page after creating new lead*/
		LeadsInfoPage leadsInfo= new LeadsInfoPage(driver);
		String successMsg = leadsInfo.getSuccessMsg().getText();
		
		if(successMsg.contains(lastName))
		{
			System.out.println("PASS :: lead is created successfully");
		}
		else
		{
			System.out.println("FAIL :: lead is not created successfully");
		}
		
		/*step4 : navigate to convert lead page*/
		homePage.getLeadsLink().click();
		leadsPage.getchkBx().click();
		leadsPage.getLastnameLnk().click();
		
		
		leadsInfo.getConvertLeadLnk().click();
		
		/*step5 : convertlead by selecting only organisation*/ 
		ConvertLeadPage convertLead = new ConvertLeadPage(driver);
		convertLead.getHidDivPop().click();
		convertLead.getContactChkBx().click();
		convertLead.getSaveBtn().click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		String expectedAlertText = "Contact should be selected to transfer related records ";
		String actualAlerText= alert.getText();
		
		Thread.sleep(2000);
		
		System.out.println("expectedAlertText="+expectedAlertText);
		System.out.println("actualAlerText="+actualAlerText);
		
		if(actualAlerText.equals(expectedAlertText))
		{
			System.out.println("PASS :: alert text is correct");
			
		}
		else
		{
			System.out.println("FAIL :: alert text is not correct");
		}
		alert.accept();
		homePage.logout();
		
	}

}
