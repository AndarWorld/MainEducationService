package org.andarworld.maineducationservice.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.andarworld.maineducationservice.api.exception.UniversityNotFoundException;
import org.andarworld.maineducationservice.persistence.model.University;
import org.andarworld.maineducationservice.persistence.repository.UniversityRepository;
import org.andarworld.maineducationservice.usecases.UniversityService;
import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;
import org.andarworld.maineducationservice.usecases.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Value("${server.port}")
    private String serverPort; // Это нужно, чтобы с репликами поэксперементировать

    @Override
    public UniversityResponseDto getUniversityByUuid(String uuid) {
        University university = universityRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new UniversityNotFoundException("University not found!"));
        return universityMapper.fromEntityToDto(university, serverPort);
    }

    @Override
    public List<UniversityResponseDto> getAllUniversities() {
        List<University> universities = universityRepository.findAll();
        return universities.stream()
                .map((University university) ->
                        universityMapper.fromEntityToDto(university, serverPort))
                .toList();
    }
}
