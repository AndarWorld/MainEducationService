package org.andarworld.maineducationservice.usecases;

import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;

import java.util.List;

public interface UniversityService {
    UniversityResponseDto getUniversityByUuid(String uuid);
    List<UniversityResponseDto> getAllUniversities();
}
