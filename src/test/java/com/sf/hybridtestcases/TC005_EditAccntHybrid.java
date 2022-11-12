package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC005_EditAccntHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditAccount";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.hybridtestcases.TC004_CreateAccntHybrid.createAccountTC04Hybrid")
	public void editAccountTC05Hybrid(String phone, String billingAddress, String shippingAddress, String typeValue)
	{
		new HomePageHybrid().clickAppLauncher().clickSales().clickAccountLabel().openFirstAccount().editAccount()
		.enterPhone(phone).selectTypeAsTechnologyPartner().selectIndustryAsHealthCare().enterBillingAddress(billingAddress)
		.enterShippingAddress(shippingAddress).selectCustomerPriorityAsLow().selectslaAsSilver().selectActiveAsNo()
		.selectUpsellOptyAsNo().clickSaveButton().selectDetailsTab().verifyType(typeValue);
	}

}
