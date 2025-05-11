package com.pega.prpc.portal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.page.PortalImpl;
import com.pega.prpc.workobjects.Incident;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AbstractPortal extends PortalImpl{
		
		public AbstractPortal(TestEnvironment testEnv) {
		super(testEnv);
	}
		
	public Incident createCase(String caseName) {

		By QUICK_LINK = By.xpath("//button[contains(.,'"+caseName+"')]");
		findElement(QUICK_LINK).click();
		return new Incident(getActiveFrameId(true), testEnv);

	}
	}
	
