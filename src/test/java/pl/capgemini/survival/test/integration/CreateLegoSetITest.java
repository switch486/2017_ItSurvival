package pl.capgemini.survival.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import pl.capgemini.survival.common.to.LegoSetTo;
import pl.capgemini.survival.common.to.ValidationMessageTo;
import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreateLegoSetITest {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String BASE_URL = "/survival/lego-sets";

	// TODO TASK 3.2 - Mockowanie z uzyciem Argument Captors
	// Metoda shouldCreateLegoSet
	// Metoda shouldThrowsValidationExceptionForTooShortName

	@Test
	public void shouldCreateLegoSet() {
		// given
		LegoSetTo request = new LegoSetTo();
		request.setName("star wars");
		request.setExternallId("123");
		request.setStatus(Status.WANTED);
		request.setCondition(Condition.NEW);

		// when
		ResponseEntity<LegoSetTo> result = this.restTemplate.postForEntity(BASE_URL, request, LegoSetTo.class);

		// then
		assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
		assertThat(result.getBody().getId(), equalTo(50L));
	}

	@Test
	public void shouldThrowsValidationExceptionForTooShortName() {
		// given
		LegoSetTo request = new LegoSetTo();
		request.setName("UFO");
		request.setExternallId("123");
		request.setStatus(Status.WANTED);
		request.setCondition(Condition.NEW);

		// when
		ResponseEntity<ValidationMessageTo> result = this.restTemplate.postForEntity(BASE_URL, request,
				ValidationMessageTo.class);

		// then
		assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
		assertThat(result.getBody().getMessages(), hasSize(1));
		assertTrue(result.getBody().getMessages().get(0).contains("UFO"));
	}

}
