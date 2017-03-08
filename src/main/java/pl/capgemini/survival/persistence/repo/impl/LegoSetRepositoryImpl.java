package pl.capgemini.survival.persistence.repo.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.QueryResults;

import pl.capgemini.survival.common.to.SearchCriteriaTo;
import pl.capgemini.survival.persistence.entity.LegoSet;
import pl.capgemini.survival.persistence.repo.LegoSetRepositoryCustom;

@Repository
public class LegoSetRepositoryImpl implements LegoSetRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	// TODO TASK 2.2 - Query DSL - Wyszukiwanie zestawow lego po kryteriach
	// Metoda searchLegoSets

	@Override
	public QueryResults<LegoSet> searchLegoSets(SearchCriteriaTo searchCriteria) {

		return null;
	}

}
