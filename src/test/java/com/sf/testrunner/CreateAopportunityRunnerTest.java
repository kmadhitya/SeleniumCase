package com.sf.testrunner;

import com.sf.stepdefs.BasicSteps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features = {"src/test/java/com/sf/features/Opportunity.feature",
"src/test/java/com/sf/features/Account.feature"},
glue = "com/sf/stepdefs",
monochrome = true)

public class CreateAopportunityRunnerTest extends BasicSteps{

}
