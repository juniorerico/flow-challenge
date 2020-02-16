package challenges.flow;

import flow.IAction;

public class EmailAction implements IAction<String> {
  private String value;

  public EmailAction(String value) {
    this.value = value;
  }

  public String execute() {
    return value;
  }

  public String getType() {
    return "EMAIL";
  }
}
