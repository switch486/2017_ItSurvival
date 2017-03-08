package pl.capgemini.survival.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.capgemini.survival.common.exception.ValidationException;
import pl.capgemini.survival.persistence.entity.LegoSet;
import pl.capgemini.survival.persistence.repo.LegoSetRepository;
import pl.capgemini.survival.service.LegoSetService;
import pl.capgemini.survival.test.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class LegoSetServiceTest {

	@Autowired
	private LegoSetService legoSetService;

	@Autowired
	private LegoSetRepository legoSetRepository;

	// TODO TASK 3.0 - Testowanie serwisow
	// Metoda shouldCreateLegoSet

	@Test
	public void shouldCreateLegoSet() {
		throw new RuntimeException("Not Implemented");
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowsValidationException() {
		// given
		LegoSet legoSet = new LegoSet();

		// when
		legoSetService.createLegoSet(legoSet);
	}
}
