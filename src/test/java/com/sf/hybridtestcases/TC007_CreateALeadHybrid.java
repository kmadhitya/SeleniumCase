package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC007_CreateALeadHybrid extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateLead";
	}
	@Test(dataProvider = "excelData")
	public void createLeadTC007Hybrid(String lastName, String company, String expected) throws InterruptedException {
		
		new HomePageHybrid().clickAppLauncher().clickSales().clickLeadLabel().clickNewButton().selectSalutationAsMr()
		.enterLastName(lastName).enterCompanyName(company).clickSaveButton().verifyLeadName(expected);
	}
}
