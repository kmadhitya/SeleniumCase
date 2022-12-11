package com.sf.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class AssessmentTC_FileUploadDownload extends ProjectSpecMethods {
	
	@Test()
	public void fileUploadDownload() throws AWTException
	{
		new HomePage(driver).clickAppLauncher().clickServiceConsole().clickServiceControlDropdown().clickFiles().clickShowMoreActionDropdown()
		.clickPublicLink().verifyLinkTextFieldIsDisabled().closePublicLinkWindow().clickShowMoreActionDropdown().clickDownload()
		.clickShowMoreActionDropdown().clickShare().clickSearchPeople().selectDerrick().verifyCantShareWithOwnerMessage()
		.closePublicLinkWindow().clickUploadFiles();//uploadFiles();
	}

}
