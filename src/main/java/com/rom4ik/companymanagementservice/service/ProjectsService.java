package com.rom4ik.companymanagementservice.service;

import com.rom4ik.companymanagementservice.model.Manager;
import com.rom4ik.companymanagementservice.model.Programmer;
import com.rom4ik.companymanagementservice.model.Project;
import com.rom4ik.companymanagementservice.repo.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rom4ik
 */
@Service
@Transactional(readOnly = true)
public class ProjectsService {
    private final ProjectsRepository projectsRepository;
    private final EmployeesService employeesService;

    @Autowired
    public ProjectsService(ProjectsRepository projectsRepository, EmployeesService employeesService) {
        this.projectsRepository = projectsRepository;
        this.employeesService = employeesService;
    }

    public List<Project> findAll() {
        return projectsRepository.findAll();
    }

    public Project findById(int id) {
        return projectsRepository.findById(id).get();
    }

    @Transactional
    public void create(Project project) {
        projectsRepository.save(project);
    }

    @Transactional
    public void update(Project project, int id) {
        project.setId(id);
        projectsRepository.save(project);
    }

    @Transactional
    public void delete(int id) {
        projectsRepository.deleteById(id);
    }

    @Transactional
    public void assignManagerToProject(int managerId, int projectId) {
        Project project = projectsRepository.findById(projectId).get();
        Manager manager = employeesService.findManagerById(managerId);
        project.getManagers().add(manager);
    }

    @Transactional
    public void assignProgrammerToProject(int programmerId, int projectId) {
        Project project = projectsRepository.findById(projectId).get();
        Programmer programmer = employeesService.findProgrammerById(programmerId);
        project.getProgrammers().add(programmer);
    }
}

