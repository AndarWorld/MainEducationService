package org.andarworld.maineducationservice.api.controllers;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.andarworld.maineducationservice.usecases.UniversityService;
import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UniversityApiController {

    private final UniversityService universityService;

    @GetMapping("/{uuid}")
    public ResponseEntity<UniversityResponseDto> getUniversity
            (@PathVariable("uuid") @Size(max = 36, min = 36) String uuid) {
        log.debug("Getting all universities");
        UniversityResponseDto university = universityService.getUniversityByUuid(uuid);
        return ResponseEntity.ok(university);
    }
}
