package com.rom4ik.companymanagementservice.service;

import com.rom4ik.companymanagementservice.model.Manager;
import com.rom4ik.companymanagementservice.model.Programmer;
import com.rom4ik.companymanagementservice.repo.ManagersRepository;
import com.rom4ik.companymanagementservice.repo.ProgrammersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rom4ik
 */
@Service
@Transactional(readOnly = true)
public class EmployeesService {
    private final ManagersRepository managersRepository;
    private final ProgrammersRepository programmersRepository;

    @Autowired
    public EmployeesService(ManagersRepository managersRepository, ProgrammersRepository programmersRepository) {
        this.managersRepository = managersRepository;
        this.programmersRepository = programmersRepository;
    }

    public List<Manager> findAllManagers() {
        return managersRepository.findAll();
    }

    public List<Programmer> findAllProgrammers() {
        return programmersRepository.findAll();
    }

    public Manager findManagerById(int id) {
        return managersRepository.findById(id).get();
    }

    public Programmer findProgrammerById(int id) {
        return programmersRepository.findById(id).get();
    }

    @Transactional
    public void createProgrammer(Programmer programmer) {
        programmersRepository.save(programmer);
    }

    @Transactional
    public void createManager(Manager manager) {
        managersRepository.save(manager);
    }
}
