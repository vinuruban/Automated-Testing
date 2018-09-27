package com.qa.PetClinic;

import org.junit.runner.RunWith;

import com.qa.PetClinic.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)
public class VetRunner {
	public static ExtentReports report = new ExtentReports(Constants.reportLocation, true);
}
