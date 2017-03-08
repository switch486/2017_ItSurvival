package pl.capgemini.survival.test.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import pl.capgemini.survival.persistence.repo.LegoSetRepository;

@Configuration
@ComponentScan(basePackages = { "pl.capgemini.survival.service", "pl.capgemini.survival.common" })
public class TestConfig {

	@Bean
	@Primary
	public LegoSetRepository legoSetRepository() {
		return Mockito.mock(LegoSetRepository.class);
	}

}
