package com.sf.hybridpages;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class DashboardHomePageHybrid extends ProjectSpecMethods {
	
	/*public HomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public DashboardCreatePageHybrid clickNewDashboard()
	{
		explicitWaitStatement("xpath", prop.getProperty("DashboardHomePage.NewDashboardButton.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("DashboardHomePage.NewDashboardButton.xpath")));
		return new DashboardCreatePageHybrid();
	}

}
