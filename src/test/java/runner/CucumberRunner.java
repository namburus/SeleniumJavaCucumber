package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, monochrome = true, features = "src/test/resources/Features", glue ={"Stepdefinitions"}, publish=true)
 

public class CucumberRunner {

}