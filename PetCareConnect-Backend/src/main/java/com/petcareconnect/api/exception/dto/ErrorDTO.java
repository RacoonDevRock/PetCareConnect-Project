package com.petcareconnect.api.exception.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private Date timestamp;

}
