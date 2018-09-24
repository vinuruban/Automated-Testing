package com.qa.RESTAssuredCucumber;

import org.junit.runner.RunWith;

import com.qa.RESTAssuredCucumber.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)

public class RESTRunner {
//	public static ExtentReports report = new ExtentReports(Constants.reportLocation, true);
}
