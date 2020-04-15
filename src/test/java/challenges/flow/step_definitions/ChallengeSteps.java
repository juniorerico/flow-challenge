package challenges.flow.step_definitions;

import org.junit.Assert;

import challenges.flow.EmailAction;
import challenges.flow.EmailAdapter;
import challenges.flow.EmailApp;
import challenges.flow.EmailEvent;
import challenges.flow.UserAgent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChallengeSteps {
	private EmailAction action = null;
	private EmailEvent event = null;
	private EmailApp app = null;

	@Given("^A User sends an \"([^\"]*)\" message$")
	public void a_user_sends_an_message(String message) throws Throwable {
		UserAgent agent = new UserAgent(message);
		action = (EmailAction) agent.act().get(0);
	}

	@When("^The message is converted by the Adapter$")
	public void the_message_is_converted_by_the_adapter() throws Throwable {
		EmailAdapter adapter = new EmailAdapter();
		event = (EmailEvent) adapter.adapt(action);
	}

	@Then("^The Message server should contain the \"([^\"]*)\" message in the queue$")
	public void the_message_server_should_contain_the_message_in_the_queue(String message) throws Throwable {
		app = new EmailApp();
		app.in(event);

		Assert.assertEquals(message, app.popMessage());
	}

}
