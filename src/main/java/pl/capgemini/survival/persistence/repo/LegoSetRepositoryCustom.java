package pl.capgemini.survival.persistence.repo;

import com.querydsl.core.QueryResults;

import pl.capgemini.survival.common.to.SearchCriteriaTo;
import pl.capgemini.survival.persistence.entity.LegoSet;

public interface LegoSetRepositoryCustom {

	public QueryResults<LegoSet> searchLegoSets(SearchCriteriaTo searchCriteria);
}
