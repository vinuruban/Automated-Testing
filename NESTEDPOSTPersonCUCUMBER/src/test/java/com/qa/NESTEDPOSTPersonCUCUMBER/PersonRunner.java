package com.qa.NESTEDPOSTPersonCUCUMBER;

import org.junit.runner.RunWith;

import com.qa.NESTEDPOSTPersonCUCUMBER.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileLocation)
public class PersonRunner {

}
