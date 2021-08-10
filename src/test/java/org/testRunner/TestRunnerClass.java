package org.testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.resources.Jjvmreport;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue =  "org.stepdefinition" , monochrome = true, plugin = {
		"pretty", "json:src\\test\\resources\\ReportPath\\adactin.json" })
public class TestRunnerClass {

	@AfterClass
	public static void afterclass() {
		Jjvmreport.generateJvmreport(System.getProperty("user.dir")+"\\src\\test\\resources\\ReportPath\\adactin.json");
	}
}
