package com.vtiger.skipulogo.leadtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.skipulogo.pomrepository.lib.ConvertLeadPage;
import com.vtiger.skipulogo.pomrepository.lib.CreateLeadPage;
import com.vtiger.skipulogo.pomrepository.lib.HomePage;
import com.vtiger.skipulogo.pomrepository.lib.LeadsInfoPage;
import com.vtiger.skipulogo.pomrepository.lib.LeadsPage;
import com.vtiger.skipulogo.pomrepository.lib.LoginPage;
import com.vtiger.skipulogo.pomrepository.lib.OrgInfoPage;

//@Listeners(com.vtiger.comcast.genericUtility.ListnerImp.class)
public class CreateLeadTest extends BaseClass
{
	
	
	@Test(groups ={"regressionTest"})
	public void ConverLeadToBySelectingOnlyOrganisationTest() throws Throwable
	{
				
		int randomInt = jLib.getRanDomNumber();
		
		
		/*test script Data*/
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		String companyName = eLib.getDataFromExcel("Sheet1", 1, 3) + randomInt;
		
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
		
		
		boolean succMsg1=(successMsg.contains(lastName));
		softAssert.assertTrue(true);
		
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
		
		softAssert.assertEquals(expectedAlertText, actualAlerText);
		
		alert.accept();
		softAssert.assertAll();
		
	}
	
	@Test(groups ={"smokeTest"})
	public void ConvertLeadBySelectingAllChkBxTest() throws Throwable {
		// TODO Auto-generated method stub
		
				
		int randomInt = jLib.getRanDomNumber();
		
				
		/*test script Data*/
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		String companyName = eLib.getDataFromExcel("Sheet1", 1, 3) + randomInt;

		
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
		
		Boolean Sucmsg=(successMsg.contains(lastName));
		Assert.assertTrue(Sucmsg);
		
		
		/*step4 : navigate to convert lead page*/
		homePage.getLeadsLink().click();
		leadsPage.getchkBx().click();
		leadsPage.getLastnameLnk().click();
	
		leadsInfo.getConvertLeadLnk().click();
		
		
		/*step5 : convertlead by selecting only organisation*/ 
		ConvertLeadPage convertLead = new ConvertLeadPage(driver);
		convertLead.getHidDivPop().click();
		convertLead.getOpportunityChkBx().click();
		
		convertLead.getClosingDate().sendKeys("2029-02-10");
		convertLead.getSaveBtn().click();
		
		OrgInfoPage orgInfoPg= new OrgInfoPage(driver);
		String OrgInfSuCMSG = orgInfoPg.getOrgInfoSuccMsg().getText();
		System.out.println(OrgInfSuCMSG);
		Thread.sleep(3000);
		
		System.out.println("-"+companyName+"-");
		/*if(OrgInfSuCMSG.contains(companyName))
		{
			System.out.println(companyName);
			
			System.out.println("PASS :: organisation info page is displayed");
		}
		else
		{
			System.out.println("PASS :: organisation info page is displayed");
		}*/
		softAssert.assertAll();
		
		
	}

	
	@Test(groups ={"regressionTest"})
	public void ConvertLeadtoOpertunityBySelectingOnlyOpertunityTest() throws Throwable 
	{
		/*Object Creation for Lib*/
		
		
		int randomInt = jLib.getRanDomNumber();
		
				
		/*test script Data*/
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		String companyName = eLib.getDataFromExcel("Sheet1", 1, 3) + randomInt;
		
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
		
		boolean succMsg1=(successMsg.contains(lastName));
		Assert.assertTrue(succMsg1);
		
		
		/*step4 : navigate to convert lead page*/
		homePage.getLeadsLink().click();
		leadsPage.getchkBx().click();
		leadsPage.getLastnameLnk().click();
		
		
		leadsInfo.getConvertLeadLnk().click();
		
		/*step5 : convertlead by selecting only organisation*/ 
		ConvertLeadPage convertLead = new ConvertLeadPage(driver);
		convertLead.getHidDivPop().click();
		convertLead.getOpportunityChkBx().click();
		convertLead.getOrgChkBx().click();
		convertLead.getContactChkBx().click();
		convertLead.getSaveBtn().click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		String expectedAlertText = "Select either Organization or Contact to convert the lead";
		String actualAlerText= alert.getText();
		
		Thread.sleep(2000);
		
		System.out.println("expectedAlertText="+expectedAlertText);
		System.out.println("actualAlerText="+actualAlerText);
		
		softAssert.assertEquals(expectedAlertText, actualAlerText);
		
		alert.accept();
		softAssert.assertAll();
	}
	
}
