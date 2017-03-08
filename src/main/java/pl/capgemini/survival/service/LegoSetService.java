package pl.capgemini.survival.service;

import java.util.List;

import pl.capgemini.survival.common.to.SearchCriteriaTo;
import pl.capgemini.survival.common.to.SearchResultTo;
import pl.capgemini.survival.persistence.entity.LegoSet;

public interface LegoSetService {

	LegoSet createLegoSet(LegoSet legoSet);

	LegoSet findLegoSet(long legoSetId);

	LegoSet updateLegoSet(LegoSet legoSet);

	void deleteLegoSet(long id);

	List<LegoSet> findAllLegoSets();

	SearchResultTo searchLegoSets(SearchCriteriaTo searchCriteria);

}
