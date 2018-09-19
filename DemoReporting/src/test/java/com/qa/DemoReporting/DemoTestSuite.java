package com.qa.DemoReporting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Suite.class)

@Suite.SuiteClasses({ DemoAddAndLoginTesting.class, DemoAddAndInvalidLoginTesting.class})

public class DemoTestSuite {
	public static ExtentReports report= new ExtentReports("C:\\Users\\Admin\\Desktop\\sh\\Demo.html", true); //ITS HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
