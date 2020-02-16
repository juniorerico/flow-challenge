package challenges.flow;

import flow.IEvent;

public class EmailEvent implements IEvent<String> {
  private String value;

  public EmailEvent(String value) {
    this.value = value;
  }

  public String trigger() {
    return "MSG:" + value;
  }
}
