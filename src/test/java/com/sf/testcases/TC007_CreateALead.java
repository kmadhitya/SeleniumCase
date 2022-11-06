package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.pages.HomePage;
import com.sf.projectspecmethod.ProjectSpecMethods;

public class TC007_CreateALead extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateLead";
	}
	@Test(dataProvider = "excelData")
	public void createLeadTC007(String lastName, String company, String expected) throws InterruptedException {
		
		new HomePage(driver).clickAppLauncher().clickSales().clickLeadLabel().clickNewButton().selectSalutationAsMr()
		.enterLastName(lastName).enterCompanyName(company).clickSaveButton().verifyLeadName(expected);
		
	}

}
