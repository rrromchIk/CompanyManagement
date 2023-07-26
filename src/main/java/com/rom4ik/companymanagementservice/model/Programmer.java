package com.rom4ik.companymanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author rom4ik
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "programmer")
public class Programmer extends Employee {
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private ProgrammerLevel level;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ProgrammerRole role;

    @ManyToMany(mappedBy = "programmers", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Project> projects;

    public Programmer(String name, int age, ProgrammerLevel level, ProgrammerRole role) {
        this.name = name;
        this.age = age;
        this.level = level;
        this.role = role;
    }
}
