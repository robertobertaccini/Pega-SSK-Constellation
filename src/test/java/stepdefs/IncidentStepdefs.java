/*
 * $Id$
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
*/

package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.prpc.workobjects.EditCaseType;
import com.pega.test.pega_sample_testframework.PlatformBrowser;
import com.pega.test.pega_sample_testframework.PlatformObjectsBean;
import com.pega.test.pega_sample_testframework.PlatformTestEnvironment;
import com.pega.util.XPathUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class IncidentStepdefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	private EditCaseType editCaseType;
	private PlatformObjectsBean objBean;
	
	public static final By INCIDENT_TYPE =  byTestID("Incident Type:select:control");
	public static final By INCIDENT_SUBTYPE = byTestID("Incident Subtype:select:control");
	public static final By NEXT =  By.xpath("//button[@name='next']");
	public static final By SEARCH_BY = byTestID("Search by::select:control");
	public static final By COST = byTestID("Cost:currency-input:control");
	public static final By FILL_FORM_WITH_AI =  By.xpath("//span[text()='Fill form with AI']/ancestor::button");
	public static final By RESOLUTION_METHOD = byTestID("What would you like Sweet Life Inc  to do to resolve your issue?:select:control");
	public static final By SUBMIT =  By.xpath("//button[@name='submit']");
	
	public static final By UserConsent =  By.xpath("//label[@data-testid=':checkbox:label' and contains(text(),'I agree to Terms and Conditions')]");
	public static final By PrivacyPolicy =  By.xpath("//label[@data-testid=':checkbox:label' and contains(text(),'I agree with Privacy Policy')]");
	public static final By Manually = By.xpath("//label[text()='Manually']");
	
	public static final By CATEGORY_SEARCH =  byTestID("Category:input:control");
	public static final By PROD_SEARCH =  byTestID("search");
	
	
	private static By byTestID(String TestID) {
		
		return By.xpath("//*[@data-testid=\""+TestID+"\"]");
		
	}
	
	private void GoSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Inject
	public IncidentStepdefs(PlatformTestEnvironment testEnv, PlatformObjectsBean objBean) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		browser = (PlatformBrowser) testEnv.getBrowser();
		
		this.objBean = objBean;
	}
	
	
	@When("I select incident type {string} with subtype {string}")
	public void i_select_incident_type_with_subtype(String string, String string2) {
		
		new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(NEXT));
		pegaDriver.findSelectBox(INCIDENT_TYPE).selectByValue(string);
		GoSleep(2000);
		pegaDriver.findSelectBox(INCIDENT_SUBTYPE).selectByValue(string2);
		pegaDriver.findElement(NEXT).click();

	}
	
	@Then("I search by {string} having category like {string} and cost {int}")
	public void i_search_by_having_category_like_and_cost(String string, String string2, Integer int1) {
		
		new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(NEXT));
		
		pegaDriver.findSelectBox(SEARCH_BY).selectByValue(string);
		
		//new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(CATEGORY_SEARCH));
		//pegaDriver.findElement(CATEGORY_SEARCH).sendKeys(string2);
		
		//pegaDriver.getByTestId("What happened?:text-area:control").fill("Who knows");
		//pegaDriver.getByTestId("Where did this happened?:text-area:control").fill("In my house");

		//pegaDriver.findElement(PROD_SEARCH).click();
		pegaDriver.findElement(COST).sendKeys(int1.toString());
		//pegaDriver.findElement(NEXT).click();

	}
	
	@When("i select the {string} product")
	public void i_select_the_product(String string) {
		
		
		//By SEL_PROD =  By.xpath("//input[@aria-label='"+string+"']/following-sibling::label/div");
		//new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(SEL_PROD));
		
		//pegaDriver.findElement(SEL_PROD,false).click();
		pegaDriver.findElement(NEXT).click();
	}
	
	@When("i provide contact info with manual address")
	public void i_provide_contact_info_with_manual_address() {
		
		new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(NEXT));
		//pegaDriver.findElement(FILL_FORM_WITH_AI).click();
		//GoSleep(5000);
		pegaDriver.findElement(Manually).click();;		
	   	pegaDriver.findElement(NEXT).click();
		
	}
	
	@When("i select {string} for resolution method")
	public void i_select_for_resolution_method(String string) {
		new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(NEXT));
		pegaDriver.findSelectBox(RESOLUTION_METHOD).selectByValue(string);
		pegaDriver.findElement(NEXT).click();
	}
	
	@Then("i review the case and submit")
	public void i_review_the_case_and_submit() {
		new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(SUBMIT));
		pegaDriver.findElement(UserConsent).click();
		pegaDriver.findElement(PrivacyPolicy).click();
		pegaDriver.findElement(SUBMIT).click();
	}
	
	
}
