package com.rom4ik.companymanagementservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "manager")
public class Manager extends Employee {
    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @ManyToMany(mappedBy = "managers", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Project> projects;
}
