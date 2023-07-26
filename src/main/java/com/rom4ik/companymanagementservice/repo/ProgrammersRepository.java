package com.rom4ik.companymanagementservice.repo;

import com.rom4ik.companymanagementservice.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammersRepository extends JpaRepository<Programmer, Integer> {
}
