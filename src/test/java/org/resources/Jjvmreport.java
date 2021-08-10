package org.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Jjvmreport {
	public static void generateJvmreport(String jsonfile) {
		String path = System.getProperty("user.dir");
		File reportDirectory = new File(path + "\\src\\test\\resources\\ReportPath");
		Configuration config = new Configuration(reportDirectory, "Adactin Hotel");
		config.addClassifications("OS", "Window 10");
		config.addClassifications("Browser", "chrome");
		config.addClassifications("Version", "89");
		config.addClassifications("Sprint", "34");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);

		ReportBuilder report = new ReportBuilder(jsonFiles, config);
		report.generateReports();
	

	}
}
