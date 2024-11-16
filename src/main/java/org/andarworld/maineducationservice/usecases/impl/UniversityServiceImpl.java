package org.andarworld.maineducationservice.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.andarworld.maineducationservice.persistence.model.University;
import org.andarworld.maineducationservice.persistence.repository.UniversityRepository;
import org.andarworld.maineducationservice.usecases.UniversityService;
import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;
import org.andarworld.maineducationservice.usecases.mapper.UniversityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Override
    public UniversityResponseDto getUniversityByUuid(String uuid) {
        University university = universityRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException());
        return universityMapper.fromEntityToDto(university);
    }

    @Override
    public List<UniversityResponseDto> getAllUniversities() {
        List<University> universities = universityRepository.findAll();
        List<UniversityResponseDto> universityResponseDtos = universities.stream()
                .map((university) -> universityMapper.fromEntityToDto(university))
                .toList();
        return universityResponseDtos;
    }
}
