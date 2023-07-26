package com.rom4ik.companymanagementservice.repo;

import com.rom4ik.companymanagementservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rom4ik
 */
@Repository
public interface ProjectsRepository extends JpaRepository<Project, Integer> {
}
