package pl.capgemini.survival.test.config;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.capgemini.survival.controller.LegoSetController;
import pl.capgemini.survival.persistence.entity.LegoSet;
import pl.capgemini.survival.service.LegoSetService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class LegoServiceControllerTest {

	@MockBean
	private LegoSetService legoSetService;

	@Autowired
	private LegoSetController controller;

	@Captor
	private ArgumentCaptor<LegoSet> legoSetCaptor;

	// TODO TASK 3.2 - Mockowanie z uzyciem Argument Captors
	// Metoda shouldInvokeServiceWithProperParameters

	@Test
	@Ignore("not implemented yet")
	public void shouldInvokeServiceWithProperParameters() {

	}

}