package com.vtiger.skipulogo.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage
{
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createLeadImg;
	
	@FindBy(xpath = "//a[@title='Leads']")
	private WebElement lastnameLnk;
	
	public WebElement getLastnameLnk() {
		return lastnameLnk;
	}
	@FindBy(xpath = "//input[@name='selected_id']")
	private WebElement chkBx;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchInDrpDwn;

	@FindBy(name="submit")
	private WebElement searchForBtn;
	
	
	public WebElement getSearchForBtn() {
		return searchForBtn;
	}

	public WebElement getChkBx() {
		return chkBx;
	}

	public WebElement getSearchInDrpDwn() {
		return searchInDrpDwn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}
		
	public WebElement getchkBx() {
		return chkBx;
	}

	public void selectLead(String lastname)
	{
		getLastnameLnk().click();
	}
}
