package org.andarworld.maineducationservice.usecases.mapper;

import org.andarworld.maineducationservice.persistence.model.University;
import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Value;


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UniversityMapper {

    @Mapping(target = "periodFrom", expression = "java(university.getPeriodFrom().toString())")
    @Mapping(target = "fromWho", source = "serverPort")
    UniversityResponseDto fromEntityToDto(University university, String serverPort);
}
