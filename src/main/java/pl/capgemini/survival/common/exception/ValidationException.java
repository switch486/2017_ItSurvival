package pl.capgemini.survival.common.exception;

import java.util.List;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1450862787404857954L;

	List<String> validationMessages;

	public ValidationException(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public List<String> getValidationMessages() {
		return validationMessages;
	}

}
