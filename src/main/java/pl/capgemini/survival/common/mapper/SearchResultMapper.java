package pl.capgemini.survival.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.querydsl.core.QueryResults;

import pl.capgemini.survival.common.to.SearchResultTo;
import pl.capgemini.survival.persistence.entity.LegoSet;

@Mapper(componentModel = "spring", uses = { LegoSetMapper.class })
public interface SearchResultMapper {

	@Mapping(source = "results", target = "legoSets")
	SearchResultTo mapToSearchResult(QueryResults<LegoSet> queryResults);

}
