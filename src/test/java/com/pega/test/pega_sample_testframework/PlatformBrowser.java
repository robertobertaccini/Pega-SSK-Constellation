package com.pega.test.pega_sample_testframework;

import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.BrowserImpl;
import com.pega.Configuration;
import com.pega.page.Portal;
import com.pega.prpc.portal.CaseManagerPortal;
import com.pega.prpc.portal.DesignerStudioPortal;
import com.pega.prpc.portal.SelfServicePortal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class PlatformBrowser extends BrowserImpl {

	private Configuration configuration;
	private PlatformTestEnvironment myAppTestEnv;

	private static final By OPERATOR_MENU = By.xpath(
			"//img[@alt='Show User Profile']|//i[@data-test-id='px-opr-image-ctrl']|//i[contains(@class, 'icons avatar name')]");
	private static final By OPERATOR_AVATAR = By.xpath("//div[@data-testid=':avatar:']");
	private static final By LOG_OFF_BUTTON = By.xpath("//*[text()='Log off']");

	@Inject
	public PlatformBrowser(PlatformTestEnvironment testEnv) {
		super(testEnv);
		this.myAppTestEnv = testEnv;
		configuration = testEnv.getConfiguration();
	}

	public <T extends Portal> T getPortal(Class<T> type) {
		T portal = null;
		String className = type.getName();
		if (className.contains("DesignerStudio")) {
			portal = type.cast(new DesignerStudioPortal(myAppTestEnv));
		}
		if(className.equals("CaseManager"))
		{
			portal = type.cast(new CaseManagerPortal(myAppTestEnv));
		}
		if(className.contains("SelfService"))
		{
			portal = type.cast(new SelfServicePortal(myAppTestEnv));
		}		
		return portal;
	}

	/*
	public void logout() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(OPERATOR_AVATAR).click();
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(LOG_OFF_BUTTON).click();
	}
	*/

	@Given("^A User logs in with \"(.*?)\" and \"(.*?)\"$")
	public void login(String username, String password) {
		open();
		super.login(username, password);
	}
	
	@When("^User logs off from portal$")
	public void user_logs_off_from_portal() {
		super.logout();
	}

	@Given("^A User logs in with Administrator credentials$")
	public void a_User_logs_in_with_Administrator_credentials() {
		open();
		super.login(configuration.getCredential("ADMIN_USER_ID"), configuration.getCredential("ADMIN_PASSWORD"));
	}
	
	@Given("^A User logs in as admin for testapp$")
	public void a_User_logs_in_as_bwatcher() throws Throwable {
		open();
		super.login(configuration.getCredential("TESTAPP_ADMIN_ID"), configuration.getCredential("TESTAPP_ADMIN_PASSWORD"));
	}
	
	@Given("^A User logs in as customer$")
	public void a_User_logs_in_with_Customer_credentials() {
		open();
		super.login(configuration.getCredential("TESTAPP_CUSTOMER_USER_ID"), configuration.getCredential("TESTAPP_CUSTOMER_PASSWORD"));
	}

}