package pl.capgemini.survival.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.capgemini.survival.common.exception.ValidationException;
import pl.capgemini.survival.common.mapper.LegoSetMapper;
import pl.capgemini.survival.common.mapper.SearchResultMapper;
import pl.capgemini.survival.common.to.SearchCriteriaTo;
import pl.capgemini.survival.common.to.SearchResultTo;
import pl.capgemini.survival.persistence.entity.LegoSet;
import pl.capgemini.survival.persistence.repo.LegoSetRepository;
import pl.capgemini.survival.service.LegoSetService;

@Service
public class LegoSetServiceImpl implements LegoSetService {

	@Autowired
	private LegoSetRepository repo;

	@Autowired
	private SearchResultMapper searchResultMapper;

	@Autowired
	private LegoSetMapper legoSetMapper;

	@Autowired
	private Validator validator;

	@Override
	public LegoSet createLegoSet(LegoSet legoSet) {
		validate(legoSet);

		LegoSet savedLegoSet = repo.save(legoSet);
		return savedLegoSet;
	}

	private void validate(LegoSet legoSet) {
		List<String> validationMessages = Lists.newArrayList();
		validationMessages.addAll(validateStandard(legoSet));
		validationMessages.addAll(validateCustom(legoSet));

		if (!validationMessages.isEmpty()) {
			throw new ValidationException(validationMessages);
		}
	}

	private List<String> validateStandard(LegoSet legoSet) {
		return validator.validate(legoSet).stream().map(v -> "'" + v.getInvalidValue() + "' - " + v.getMessage())
				.collect(Collectors.toList());
	}

	private List<String> validateCustom(LegoSet legoSet) {
		// custom validation
		return Lists.newArrayList();
	}

	@Override
	public LegoSet updateLegoSet(LegoSet legoSet) {
		LegoSet updatedLegoSet = repo.save(legoSet);
		return updatedLegoSet;
	}

	@Override
	public LegoSet findLegoSet(long legoSetId) {
		LegoSet legoSet = repo.findOne(legoSetId);
		return legoSet;
	}

	@Override
	public List<LegoSet> findAllLegoSets() {
		Iterable<LegoSet> allLegoSets = repo.findAll();
		return Lists.newArrayList(allLegoSets);
	}

	@Override
	public void deleteLegoSet(long id) {
		repo.delete(id);
	}

	@Override
	public SearchResultTo searchLegoSets(SearchCriteriaTo searchCriteria) {
		List<LegoSet> result = repo.findByLegoNameStartsWith(searchCriteria.getName());

		SearchResultTo searchResultTo = new SearchResultTo();
		searchResultTo.setLegoSets(result.stream().map(legoSetMapper::mapToLegoSetTo).collect(Collectors.toList()));

		return searchResultTo;
	}

}
