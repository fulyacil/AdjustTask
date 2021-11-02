package com.project.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;

@CucumberOptions(
              
              features = "src/test/features",
       glue= {"com.project.stepdefs"},
       plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html",
       "json:target/cucumber.json"}
              )
        
public class TestRunner {
    
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
    	System.out.println("Before class of Runner Class");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	System.out.println("Test class of Runner Class");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
    	System.out.println("Data provider of Runner Class");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	System.out.println("After class of Runner Class");
        testNGCucumberRunner.finish();
    }
}
