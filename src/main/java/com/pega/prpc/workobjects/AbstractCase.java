package com.pega.prpc.workobjects;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.elmt.FrameImpl;
import com.pega.util.XPathUtil;

import io.cucumber.java.en.*;


public abstract class AbstractCase extends FrameImpl {
	public AbstractCase(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
	
	public static final By SAVE =  By.xpath(XPathUtil.getDataTestIDXpath("2014092311173805466485"));
	
	public void save()
	{
		findElement(SAVE).click();
	}
	
	

	

	
}