package webTestCases;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.ReUseableLib;

public class Module2_Login extends ReUseableLib {

	@Test
	public void tc004_VerifyLoginWithValidCredentials() throws InterruptedException
	{
		test=extent.createTest(Reporter.getCurrentTestResult().getName());
		Map<String, String> mapData = util.readFromGoogleSheetForUniqueDataInSingleRowTable("Login", "tc004");
		util.generateReport(test);
		util.setDelayBtwnSteps(1);
		
		navigateToLoginPage("Chrome");
		util.EnterInto(lp.emailTF(), mapData.get("Email"));
		util.EnterInto(lp.pwdTF(), mapData.get("Password"));
		util.clickOn(lp.logInBtn());
		util.verifyIfDisplayed(hp.logoutLink());
	}
	
	@Test
	public void tc005_VerifyLoginWithInValidCredentials() throws InterruptedException
	{
		test=extent.createTest(Reporter.getCurrentTestResult().getName());
		Map<String, String> mapData = util.readFromGoogleSheetForUniqueDataInSingleRowTable("Login", "tc005");
		util.generateReport(test);
		util.setDelayBtwnSteps(1);
		
		navigateToLoginPage("FireFox");
		util.EnterInto(lp.emailTF(), mapData.get("Email"));
		util.EnterInto(lp.pwdTF(), mapData.get("InvalidPwd"));
		util.clickOn(lp.logInBtn());
		util.verifyIfDisplayed(lp.IncorrectCredMsg());
	}
	
	@Test
	public void tc006_VerifyLoginWithNoCredentials() throws InterruptedException
	{
		test=extent.createTest(Reporter.getCurrentTestResult().getName());
		util.generateReport(test);
		util.setDelayBtwnSteps(1);
		
		navigateToLoginPage("Edge");
		util.clickOn(lp.logInBtn());
		util.verifyIfDisplayed(lp.noAccountFoundMsg());
	}
	
}
