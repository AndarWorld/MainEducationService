package org.andarworld.maineducationservice.usecases.dto;

public record UniversityResponseDto(
        String title,

        String city,

        String description,

        String periodFrom,

        Boolean governmentStatus
) {
}
