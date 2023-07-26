package com.rom4ik.companymanagementservice.exception;

import lombok.NoArgsConstructor;

/**
 * @author rom4ik
 */

@NoArgsConstructor
public class EmployeeValidationException extends RuntimeException {
    public EmployeeValidationException(String message) {
        super(message);
    }
}
