package challenges.flow;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty", 
		features = "src/test/resources/features", 
		glue = "challenges/step_definitions", 
		tags = {"@LoginProfile" }
)
public class FlowChallenge1Test {

}
