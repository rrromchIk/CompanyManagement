package com.rom4ik.companymanagementservice.controller;

import com.rom4ik.companymanagementservice.dto.ManagerDTO;
import com.rom4ik.companymanagementservice.dto.ProgrammerDTO;
import com.rom4ik.companymanagementservice.exception.EmployeeValidationException;
import com.rom4ik.companymanagementservice.model.Manager;
import com.rom4ik.companymanagementservice.model.Programmer;
import com.rom4ik.companymanagementservice.response.EmployeeErrorResponse;
import com.rom4ik.companymanagementservice.service.EmployeesService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rom4ik
 */
@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeesController(EmployeesService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getAllManagers() {
        return employeeService.findAllManagers();
    }

    @GetMapping("/programmers")
    @ResponseStatus(HttpStatus.OK)
    public List<Programmer> getAllProgrammers() {
        return employeeService.findAllProgrammers();
    }

    @GetMapping("/managers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Manager getManager(@PathVariable int id) {
        return employeeService.findManagerById(id);
    }

    @GetMapping("/programmers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Programmer getProgrammer(@PathVariable int id) {
        return employeeService.findProgrammerById(id);
    }

    @PostMapping("/programmers")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProgrammer(@RequestBody @Valid ProgrammerDTO programmerDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new EmployeeValidationException(getErrorMessages(bindingResult));
        }

        employeeService.createProgrammer(convertProgrammerDTOtoEntity(programmerDTO));
    }

    @PostMapping("/managers")
    @ResponseStatus(HttpStatus.CREATED)
    public void createManager(@RequestBody @Valid ManagerDTO managerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EmployeeValidationException(getErrorMessages(bindingResult));
        }

        employeeService.createManager(convertManagerDTOtoEntity(managerDTO));
    }

    @PatchMapping("/programmers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProgrammer(@RequestBody @Valid ProgrammerDTO programmerDTO, BindingResult bindingResult) {
        //TODO
    }

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleEmployeeValidationException(EmployeeValidationException exc) {
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(exc.getMessage());
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private Programmer convertProgrammerDTOtoEntity(ProgrammerDTO programmerDTO) {
        return modelMapper.map(programmerDTO, Programmer.class);
    }

    private Manager convertManagerDTOtoEntity(ManagerDTO managerDTO) {
        return modelMapper.map(managerDTO, Manager.class);
    }

    private String getErrorMessages(BindingResult bindingResult) {
        StringBuilder errMsg = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for(FieldError fieldError : errors) {
            errMsg.append(fieldError.getField())
                    .append(" - ").append(fieldError.getDefaultMessage()).append(";");
        }
        return errMsg.toString();
    }
}
