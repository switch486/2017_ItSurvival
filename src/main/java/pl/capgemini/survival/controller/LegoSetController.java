package pl.capgemini.survival.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.capgemini.survival.common.mapper.LegoSetMapper;
import pl.capgemini.survival.common.to.LegoSetTo;
import pl.capgemini.survival.common.to.SearchCriteriaTo;
import pl.capgemini.survival.common.to.SearchResultTo;
import pl.capgemini.survival.persistence.entity.LegoSet;
import pl.capgemini.survival.service.LegoSetService;

@CrossOrigin
@RestController
@RequestMapping("/survival")
public class LegoSetController {

	@Autowired
	private LegoSetService legoSetService;

	@Autowired
	private LegoSetMapper mapper;

	// TODO TASK 1.0 - Hello World po springowemu - napisac metodę restową
	// zwracającą Hello World

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello World!!1";
	}

	// TODO TASK 1.1 - Napisać metody restowe pod CRUD zgodnie z konwencją
	// opisaną w wykładach

	// TODO TASK 1.2 - Otestować metody CRUD używając Postmana

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/lego-sets", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegoSetTo createLegoSet(@RequestBody LegoSetTo legoSetTo) {

		LegoSet legoSet = mapper.mapToLegoSet(legoSetTo);
		LegoSet createdLegoSet = legoSetService.createLegoSet(legoSet);
		LegoSetTo createdLegoSetTo = mapper.mapToLegoSetTo(createdLegoSet);
		return createdLegoSetTo;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/lego-sets", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LegoSetTo updateLegoSet(@RequestBody @Valid LegoSetTo legoSetTo) {

		LegoSet legoSet = mapper.mapToLegoSet(legoSetTo);
		LegoSet updatedLegoSet = legoSetService.updateLegoSet(legoSet);
		LegoSetTo updatedLegoSetTo = mapper.mapToLegoSetTo(updatedLegoSet);
		return updatedLegoSetTo;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/lego-sets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LegoSetTo> findAll() {

		List<LegoSet> allLegoSets = legoSetService.findAllLegoSets();
		return allLegoSets.stream().map(ls -> mapper.mapToLegoSetTo(ls)).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/lego-sets/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegoSetTo findLegoSet(@PathVariable long id) {

		LegoSet legoSet = legoSetService.findLegoSet(id);
		return mapper.mapToLegoSetTo(legoSet);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/lego-sets/{id}", method = RequestMethod.DELETE)
	public void deleteLegoSet(@PathVariable long id) {
		legoSetService.deleteLegoSet(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/lego-sets/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SearchResultTo search(@RequestBody SearchCriteriaTo searchCriteria) {

		SearchResultTo result = legoSetService.searchLegoSets(searchCriteria);
		return result;
	}

}
