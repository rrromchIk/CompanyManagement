package com.rom4ik.companymanagementservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rom4ik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    @NotNull
    @Min(16) @Max(60)
    private int age;
    @NotNull @NotEmpty @Max(40)
    private String name;
}
