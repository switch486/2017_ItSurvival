package pl.capgemini.survival.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.collect.Lists;

import pl.capgemini.survival.common.exception.ValidationException;
import pl.capgemini.survival.common.to.ValidationMessageTo;

// Target all Controllers within specific packages
//@RestControllerAdvice("pl.capgemini.survival.controller")

// Target all Controllers annotated with @RestController
//@RestControllerAdvice(annotations = RestController.class)

// Target all Controllers assignable to specific classes
//@RestControllerAdvice(assignableTypes = { LegoSetController.class })

// Target all Controllers
@RestControllerAdvice
public class LegoSetControllerAdvice {

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ValidationMessageTo validationException(MethodArgumentNotValidException ex) {
		ValidationMessageTo message = new ValidationMessageTo();
		message.setMessages(Lists.newArrayList(ex.getLocalizedMessage()));
		return message;
	}

	@ExceptionHandler({ ValidationException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ValidationMessageTo customValidationException(ValidationException ex) {
		return new ValidationMessageTo(ex.getValidationMessages());
	}
}
