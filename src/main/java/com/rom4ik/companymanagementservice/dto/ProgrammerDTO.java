package com.rom4ik.companymanagementservice.dto;

import com.rom4ik.companymanagementservice.model.ProgrammerLevel;
import com.rom4ik.companymanagementservice.model.ProgrammerRole;
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
public class ProgrammerDTO {
    @NotNull @Min(16) @Max(60)
    private int age;
    @NotNull @NotEmpty @Max(40)
    private String name;
    @NotNull
    private ProgrammerLevel level;
    @NotNull
    private ProgrammerRole role;
}
