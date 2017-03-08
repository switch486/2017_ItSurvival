package pl.capgemini.survival.test.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.capgemini.survival.common.exception.ValidationException;
import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;
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
		// given
		LegoSet legoSet = new LegoSet();
		legoSet.setExternallId("123");
		legoSet.setLegoComment("comment");
		legoSet.setLegoCondition(Condition.NEW);
		legoSet.setLegoName("StarTrek");
		legoSet.setLegoStatus(Status.OWNED);
		legoSet.setLegoVersion(0);

		LegoSet newLegoSet = new LegoSet();
		newLegoSet.setId(5L);

		when(legoSetRepository.save(legoSet)).thenReturn(newLegoSet);

		// when
		LegoSet createdLegoSet = legoSetService.createLegoSet(legoSet);

		// then
		assertThat(createdLegoSet, notNullValue());
		assertThat(createdLegoSet.getId(), equalTo(5L));
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowsValidationException() {
		// given
		LegoSet legoSet = new LegoSet();

		// when
		legoSetService.createLegoSet(legoSet);
	}
}
