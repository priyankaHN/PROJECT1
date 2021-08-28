package com.vtiger.skipulogo.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLeadPage
{
	public ConvertLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="firstname")
	private WebElement firstName;
	
	
	@FindBy(id="orgLay")
	private WebElement hidDivPop;
	
	@FindBy(xpath="//b[text()='Organization']/..//input[@id='select_account']")
	private WebElement orgChkBx;
	
	@FindBy(xpath="//b[text()='Opportunity']/..//input[@id='select_potential']")
	private WebElement opportunityChkBx;
	
	@FindBy(xpath="//b[text()='Contact']/..//input[@id='select_contact']")
	private WebElement contactChkBx;
	
	//@FindBy(xpath="//td[@colspan='4']/../../../../../../../..//input[@name='Save']")
	@FindBy(xpath="//input[@name='Save']")
	private WebElement saveBtn;
	
	@FindBy(name="closingdate")
	private WebElement closingDate;
	
	@FindBy(id="jscal_trigger_closedate")
	private WebElement calImg;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succMsg;
	
	
	public WebElement getCalImg() {
		return calImg;
	}

	public WebElement getClosingDate() {
		return closingDate;
	}

	//closingdate
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getContactChkBx() {
		return contactChkBx;
	}

	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getOpportunityChkBx() {
		return opportunityChkBx;
	}

	public WebElement getHidDivPop() {
		return hidDivPop;
	}
	
	public WebElement getOrgChkBx() {
		return orgChkBx;
	}
	
	
}
