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

public class SelfServicePortal extends PortalImpl{
		
		public SelfServicePortal(TestEnvironment testEnv) {
		super(testEnv);
	}
		
		public Incident createIncident() {

			System.out.println("looking for incident");
			
			By QUICK_LINK = By.xpath("//button[contains(.,'Incident')]");
			findElement(QUICK_LINK).click();
			return new Incident(getActiveFrameId(true), testEnv);
			
			
			//new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Incident')]")));
		 	
			//pegaDriver.findElement(By.xpath("//button[contains(.,'Incident')]")).click(); 
			
			//	pegaDriver.findElement(incident).click(); 	 	 
			}
		
	
	public Incident createCase(String caseName) {

		System.out.println("looking for incident");
		
		By QUICK_LINK = By.xpath("//button[contains(.,'"+caseName+"')]");
		findElement(QUICK_LINK).click();
		return new Incident(getActiveFrameId(true), testEnv);
		
		
		//new WebDriverWait(pegaDriver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Incident')]")));
	 	
		//pegaDriver.findElement(By.xpath("//button[contains(.,'Incident')]")).click(); 
		
		//	pegaDriver.findElement(incident).click(); 	 	 
		}
	}
	
