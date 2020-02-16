package challenges.step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import challenges.flow.EmailAdapter;
import challenges.flow.EmailApp;
import challenges.flow.UserAgent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flow.Engine;
import flow.IAdapter;
import flow.IAgent;

public class FlowChallenge1Steps {
	private Engine engine;
	private IAgent agent;

	@Given("^A User sends an \"([^\"]*)\" message$")
	public void a_user_sends_an_message(String message) throws Throwable {
		agent = new UserAgent(message);
	}

	@When("^The message is converted by the Adapter$")
	public void the_message_is_converted_by_the_adapter() throws Throwable {
		Map<String, IAdapter> adapters = new HashMap();
		adapters.put("EMAIL", new EmailAdapter());
		engine = new Engine(agent, adapters, new EmailApp());
		engine.run();
	}

	@Then("^The Message server should contain the \"([^\"]*)\" message in the queue$")
	public void the_message_server_should_contain_the_message_in_the_queue(String message) throws Throwable {
		EmailApp emailApp = (EmailApp) engine.getApp();
		assertTrue(emailApp.getMessages().contains(message));
	}

}
