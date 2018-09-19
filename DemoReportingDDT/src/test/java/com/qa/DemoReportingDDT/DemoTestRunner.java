package com.qa.DemoReportingDDT;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class DemoTestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(DemoTestSuite.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}  	