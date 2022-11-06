package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.pages.HomePage;
import com.sf.projectspecmethod.ProjectSpecMethods;

public class TC008_EditALead extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditLead";
	}
	@Test(dataProvider = "excelData")
	public void editLeadTC008(String lastName, String expected) throws InterruptedException {
		
		new HomePage(driver).clickAppLauncher().clickSales().clickLeadLabel().openLead().editLead().enterLastName(lastName)
		.selectLeadStatusAsWorkingContacted().clickSaveButton().selectDetailsTab().verifyLeadStatus(expected);
		
		
	}

}
