package com.rom4ik.companymanagementservice.controller;

import com.rom4ik.companymanagementservice.dto.ProjectDTO;
import com.rom4ik.companymanagementservice.model.Project;
import com.rom4ik.companymanagementservice.service.ProjectsService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rom4ik
 */
@RestController
@RequestMapping("/projects")
public class ProjectsController {
    private final ProjectsService projectsService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectsController(ProjectsService projectsService, ModelMapper modelMapper) {
        this.projectsService = projectsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAll() {
        return projectsService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getById(@PathVariable int id) {
        return projectsService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid ProjectDTO projectDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {

        }

        projectsService.create(convertDtoToEntity(projectDTO));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid ProjectDTO projectDTO, BindingResult bindingResult, @PathVariable int id) {
        if(bindingResult.hasErrors()) {

        }

        projectsService.update(convertDtoToEntity(projectDTO), id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        projectsService.delete(id);
    }

    @PatchMapping("/{projectId}/assign-manager/{managerId}")
    public void assignManagerToProject(@PathVariable int projectId, @PathVariable int managerId) {
        projectsService.assignManagerToProject(managerId, projectId);
    }

    @PatchMapping("/{projectId}/assign-programmer/{programmerId}")
    public void assignProgrammerToProject(@PathVariable int projectId, @PathVariable int programmerId) {
        projectsService.assignProgrammerToProject(programmerId, projectId);
    }

    private Project convertDtoToEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }
}
