package org.andarworld.maineducationservice.api.exception;

public record ErrorResponse(
        String message,
        Integer statusCode,
        String date
) {
}
