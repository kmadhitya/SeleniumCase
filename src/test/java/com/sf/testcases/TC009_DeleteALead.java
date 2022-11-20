package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC009_DeleteALead extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteLead";
	}
	@Test(dataProvider = "excelData")//, dependsOnMethods = "com.sf.testcases.TC008_EditALead.editLeadTC008")
	public void deleteLeadTC09(String searchText, String expectedText) throws InterruptedException {
		new HomePage(driver).clickAppLauncher().clickSales().clickLeadLabel().searchLead(searchText).openLead().deleteLead()
		.confirmDelete().clearSearchText().searchLead(searchText).verifyNoItemsToDisplay(expectedText);
	}

}
