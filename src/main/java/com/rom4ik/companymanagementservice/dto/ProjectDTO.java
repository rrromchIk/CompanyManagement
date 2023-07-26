package com.rom4ik.companymanagementservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rom4ik
 */
@Data
@NoArgsConstructor
public class ProjectDTO {
    @NotNull @NotEmpty @Size(max = 50)
    private String name;

    @NotNull @NotEmpty @Size(max = 500)
    private String description;
}
