package pl.capgemini.survival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.capgemini.survival.common.mapper.LegoSetMapper;
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

	// TODO TASK 1.1 - Napisać metody restowe pod CRUD zgodnie z konwencją
	// opisaną w wykładach

	// TODO TASK 1.2 - Otestować metody CRUD używając Postmana

}
