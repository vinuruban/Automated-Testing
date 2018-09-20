package com.qa.PassionateTea;

import org.junit.runner.RunWith;

import com.qa.PassionateTea.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)

public class TeaRunner {
	//public static ExtentReports report= new ExtentReports(Constants.reportLocation, true);
}

