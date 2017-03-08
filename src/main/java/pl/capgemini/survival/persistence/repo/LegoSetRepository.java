package pl.capgemini.survival.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;
import pl.capgemini.survival.persistence.entity.LegoSet;

public interface LegoSetRepository extends CrudRepository<LegoSet, Long>, LegoSetRepositoryCustom {

	// TODO TASK 2.0 - JPA Query Methods - Wyszukiwanie zestawow lego zgodnie z
	// konwencją nazewniczą
	// Metoda z atrybutami Status status, Condition condition

	List<LegoSet> findByLegoStatusAndLegoCondition(Status status, Condition condition);

	// TODO TASK 2.1 - @Query adnotacja - wyszukiwanie zestawow lego po początku
	// nazwy zestawu
	// Metoda findByLegoNameStartsWith

	@Query("select ls from LegoSet ls where ls.legoName like ?1%")
	List<LegoSet> findByLegoNameStartsWith(String legoName);
}
