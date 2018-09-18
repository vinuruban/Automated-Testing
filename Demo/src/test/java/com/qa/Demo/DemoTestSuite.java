package com.qa.Demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ DemoAddAndLoginTesting.class, DemoAddAndInvalidLoginTesting.class})

public class DemoTestSuite {
}
