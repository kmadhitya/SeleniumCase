package com.sf.hybridpages;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AppLauncherPageHybrid extends ProjectSpecMethods {
	
	/*public HomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public DashboardHomePageHybrid clickDashboard()
	{
		explicitWaitStatement("xpath", prop.getProperty("AppLauncherPage.Dashboard.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AppLauncherPage.Dashboard.xpath")));
		return new DashboardHomePageHybrid();
	}

}
