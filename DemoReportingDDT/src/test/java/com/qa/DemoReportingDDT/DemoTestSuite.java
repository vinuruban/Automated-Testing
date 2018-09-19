package com.qa.DemoReportingDDT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Suite.class)

@Suite.SuiteClasses({ DemoExcelTesting.class, DemoAddAndLoginTesting.class, DemoAddAndInvalidLoginTesting.class})

public class DemoTestSuite {
	public static ExtentReports report= new ExtentReports(Constants.reportLocation, true); //ITS HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
