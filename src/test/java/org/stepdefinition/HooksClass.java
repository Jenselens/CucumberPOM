package org.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.resources.Library;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class HooksClass extends Library {

	@After
	public void afterscenario(Scenario sc) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screen = ts.getScreenshotAs(OutputType.BYTES);
		sc.embed(screen, sc.getName() + ".png");

	}
}
