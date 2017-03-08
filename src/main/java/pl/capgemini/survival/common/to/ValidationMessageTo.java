package pl.capgemini.survival.common.to;

import java.util.List;

public class ValidationMessageTo {

	private List<String> messages;

	public ValidationMessageTo() {
	}

	public ValidationMessageTo(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
