package pl.capgemini.survival.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import pl.capgemini.survival.common.to.LegoSetTo;
import pl.capgemini.survival.persistence.entity.LegoSet;

@Mapper(componentModel = "spring")
public interface LegoSetMapper {

	@Mapping(source = "legoVersion", target = "version")
	@Mapping(source = "legoName", target = "name")
	@Mapping(source = "legoStatus", target = "status")
	@Mapping(source = "legoComment", target = "comment")
	@Mapping(source = "legoCondition", target = "condition")
	LegoSetTo mapToLegoSetTo(LegoSet legoSet);

	@Mapping(source = "version", target = "legoVersion")
	@Mapping(source = "name", target = "legoName")
	@Mapping(source = "status", target = "legoStatus")
	@Mapping(source = "comment", target = "legoComment")
	@Mapping(source = "condition", target = "legoCondition")
	LegoSet mapToLegoSet(LegoSetTo legoSetTo);

}
