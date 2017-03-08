package pl.capgemini.survival.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import pl.capgemini.survival.common.to.LegoSetTo;
import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:sql/legoSets.sql")
@Sql(scripts = "classpath:sql/clearDB.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class FindLegoSetITest {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String BASE_URL = "/survival/lego-sets";

	// TODO TASK 3.1 - Testowanie koncowek restowych
	// Metoda shouldFindLegoSet

	@Test
	public void shouldFindLegoSet() {

		// when
		ResponseEntity<LegoSetTo> result = this.restTemplate.getForEntity(BASE_URL + "/1", LegoSetTo.class);

		// then
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody().getId(), equalTo(1L));
		assertThat(result.getBody().getComment(), nullValue());
		assertThat(result.getBody().getCondition(), equalTo(Condition.NEW));
		assertThat(result.getBody().getExternallId(), equalTo("123"));
		assertThat(result.getBody().getName(), equalTo("Star Wars"));
		assertThat(result.getBody().getStatus(), equalTo(Status.WANTED));
		assertThat(result.getBody().getVersion(), equalTo(0L));
	}

	@Test
	public void shouldNotFoundLegoSet() {

		// when
		ResponseEntity<LegoSetTo> result = this.restTemplate.getForEntity(BASE_URL + "/2", LegoSetTo.class);

		// then
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

}
