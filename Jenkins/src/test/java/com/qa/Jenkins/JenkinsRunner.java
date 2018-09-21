package com.qa.Jenkins;

import org.junit.runner.RunWith;

import com.qa.Jenkins.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)

public class JenkinsRunner {
	public static ExtentReports report = new ExtentReports(Constants.reportLocation, true);
}
