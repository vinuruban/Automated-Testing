package com.qa.Jenkins;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Jenkins.JenkinsRunner;
import com.qa.Jenkins.UserScreen;
import com.qa.Jenkins.Constants;
import com.qa.Jenkins.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class JenkinsSteps {
	
	WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test; 
	
	@Before 
	public void setup() {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);
		System.setProperty(Constants.driverType, Constants.driverLocation);
		report = JenkinsRunner.report;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Constants.count++;
		test = report.startTest("Scenario" + Constants.count);
		driver.get(Constants.loginURL);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterU("Admin");
		Thread.sleep(1000);
		login.enterP("bac9db78399644198694a664ecbb5f19");
		login.submitSignIn();
		test.log(LogStatus.INFO, "Logged in"); 
		
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "UserScreen Loaded"); 
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		UserScreen userScreen = PageFactory.initElements(driver, UserScreen.class);
		userScreen.clickCreateUser();
		test.log(LogStatus.INFO, "CreateUserScreen Loaded");
		
		CreateUserScreen cuScreen = PageFactory.initElements(driver, CreateUserScreen.class);
		cuScreen.enterUS("abcabc");
		cuScreen.enterPass("abcabc");
		cuScreen.enterCPass("abcabc");
		cuScreen.enterName("Abc Abc");
		cuScreen.enterEmail("abc@abc.com");
		test.log(LogStatus.INFO, "Details entered");
		Thread.sleep(2000);
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions
		CreateUserScreen cuScreen = PageFactory.initElements(driver, CreateUserScreen.class);
		cuScreen.submitUser();
		test.log(LogStatus.INFO, "User sumbitted");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		UserScreen userScreen = PageFactory.initElements(driver, UserScreen.class);
		
		String seeUser = userScreen.checkUser().getText();
		String un = "abcabc";
		if(seeUser.equals(un)) { //new
			test.log(LogStatus.PASS, "The username is visible on the UserScreen"); 
			ExcelUtils.setCellData("Pass", 1, Constants.count);
			ExcelUtils.setCellData("abcabc", 2, Constants.count);
			ExcelUtils.setCellData("The username is visible on the UserScreen", 3, Constants.count);
			
		}
		else { 
			test.log(LogStatus.FAIL, "The username isn't visible on the UserScreen"); 
			ExcelUtils.setCellData("Fail", 1, Constants.count);
			ExcelUtils.setCellData("abcabc", 2, Constants.count);
			ExcelUtils.setCellData("The username is visible on the UserScreen", 3, Constants.count);
			
		}
		assertEquals(un, seeUser);
		Thread.sleep(1000);
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserScreen userScreen = PageFactory.initElements(driver, UserScreen.class);
		userScreen.clickCreateUser();
		test.log(LogStatus.INFO, "CreateUserScreen Loaded");
		
		CreateUserScreen cuScreen = PageFactory.initElements(driver, CreateUserScreen.class);
		cuScreen.enterUS(arg1);
		cuScreen.enterPass(arg2);
		cuScreen.enterCPass(arg3);
		cuScreen.enterName(arg4);
		cuScreen.enterEmail(arg5);
		test.log(LogStatus.INFO, "Details entered");
		
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		UserScreen userScreen = PageFactory.initElements(driver, UserScreen.class);
		
		//driver.findElement(By.linkText(arg1)).click();
		
		int index = 0;
		WebElement baseTable = driver.findElement(By.id("people"));
		List<WebElement> tableRows = baseTable.findElements(By.linkText(arg1));
		String nme = tableRows.get(index).getText();
		
		// I'm not sure on how to avoid iterating through the "name" column of that table"
		
		//String nme = driver.findElement(By.linkText(arg1)).getText();
		
		if(nme.equals(arg1)) { //new
			test.log(LogStatus.PASS, "The username is visible on the UserScreen"); 
			ExcelUtils.setCellData("Pass", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("The username is visible on the UserScreen", 3, Constants.count);
		}
		else { 
			test.log(LogStatus.FAIL, "The username isn't visible on the UserScreen"); 
			ExcelUtils.setCellData("Fail", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("The username isn't visible on the UserScreen", 3, Constants.count);
		}
		assertEquals(arg1, nme);
		Thread.sleep(1000);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Constants.count++;
		test = report.startTest("Scenario" + Constants.count);
		driver.get(Constants.loginURL);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterU("Admin");
		Thread.sleep(1000);
		login.enterP("bac9db78399644198694a664ecbb5f19");
		login.submitSignIn();
		test.log(LogStatus.INFO, "Logged in"); 
		
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "UserScreen Loaded"); 
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText(arg1)).click();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		
//MATT LOCATED ELSEWHERE		
		
		String seePro = proPage.getHeading().getText();
		if(seePro.equals("Jenkins User Id: " + arg1)) { //new
			test.log(LogStatus.PASS, "User Profile displays the username on the ProfileScreen"); 
			ExcelUtils.setCellData("Pass", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("User Profile displays the username on the ProfileScreen", 3, Constants.count);
		}
		else { 
			test.log(LogStatus.FAIL, "User Profile doesn't display the username on the ProfileScreen"); 
			ExcelUtils.setCellData("Fail", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("User Profile doesn't display the username on the ProfileScreen", 3, Constants.count);
		}
		assertEquals("Jenkins User Id: " + arg1, seePro);
		Thread.sleep(1000);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Constants.count++;
		test = report.startTest("Scenario" + Constants.count);
		driver.get(Constants.loginURL);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterU("Admin");
		Thread.sleep(1000);
		login.enterP("bac9db78399644198694a664ecbb5f19");
		login.submitSignIn();
		test.log(LogStatus.INFO, "Logged in"); 
		
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "UserScreen Loaded"); 
		
		driver.findElement(By.linkText(arg1)).click();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() {
	    // Write code here that turns the phrase above into concrete actions
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		proPage.clickConfig();
		test.log(LogStatus.INFO, "Configation page opened");
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ConfigPage cfgPage = PageFactory.initElements(driver, ConfigPage.class);
		cfgPage.updateEmail(arg1);
		test.log(LogStatus.INFO, "Email Updated");
		Thread.sleep(1000);
		
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ConfigPage cfgPage = PageFactory.initElements(driver, ConfigPage.class);
		cfgPage.submitSave();
		test.log(LogStatus.INFO, "Changes have been saved");
		Thread.sleep(1000);
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		proPage.clickConfig();
		Thread.sleep(1000);
		ConfigPage cfgPage = PageFactory.initElements(driver, ConfigPage.class);
		
		String email = cfgPage.checkEmail().getAttribute("value");
//		String email = driver.findElement(By.linkText("UPDATED" + arg1)).getText();
		if(email.equals(arg1)) { //new
			test.log(LogStatus.PASS, "Configuration page shows the new email"); 
			ExcelUtils.setCellData("Pass", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("Configuration page shows the new email", 3, Constants.count);
		}
		else { 
			test.log(LogStatus.FAIL, "Configuration page doesn't show the new email"); 
			ExcelUtils.setCellData("Fail", 1, Constants.count);
			ExcelUtils.setCellData(arg1, 2, Constants.count);
			ExcelUtils.setCellData("Configuration page doesn't show the new email", 3, Constants.count);
			
		}
		assertEquals(arg1, email);
		Thread.sleep(1000);
		
		

	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		driver.quit();
		report.flush();
	}

}
