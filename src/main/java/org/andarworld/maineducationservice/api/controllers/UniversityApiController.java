package org.andarworld.maineducationservice.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.andarworld.maineducationservice.usecases.UniversityService;
import org.andarworld.maineducationservice.usecases.dto.UniversityResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
@RequiredArgsConstructor
@Slf4j
public class UniversityApiController {

    private final UniversityService universityService;

    @GetMapping("/{uuid}")
    public ResponseEntity<UniversityResponseDto> getAllCourses(@PathVariable("uuid") String uuid) {
        log.debug("Getting all universities");
        UniversityResponseDto university = universityService.getUniversityByUuid(uuid);
        return ResponseEntity.ok(university);
    }
}
