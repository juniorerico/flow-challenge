package challenges.flow;

import flow.IAction;
import flow.IAgent;

import java.util.LinkedList;
import java.util.List;

public class UserAgent implements IAgent {
	private String[] values;

	public UserAgent(String... values) {
		this.values = values;
	}

	public List<IAction> act() {
		List<IAction> flow = new LinkedList<IAction>();
		for (String value : values) {
			flow.add(new EmailAction(value));
		}
		return flow;
	}
}
