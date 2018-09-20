package com.qa.BingCucumber;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)

public class BingRunner {
	public static ExtentReports report = new ExtentReports(Constants.reportLocation, true);
}
