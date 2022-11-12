package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC008_EditALeadHybrid extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditLead";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.hybridtestcases.TC007_CreateALeadHybrid.createLeadTC007Hybrid")
	public void editLeadTC008Hybrid(String lastName, String expected) throws InterruptedException {
		
		new HomePageHybrid().clickAppLauncher().clickSales().clickLeadLabel().openLead().editLead().enterLastName(lastName)
		.selectLeadStatusAsWorkingContacted().clickSaveButton().selectDetailsTab().verifyLeadStatus(expected);
	}

}
