package com.rom4ik.companymanagementservice.repo;

import com.rom4ik.companymanagementservice.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagersRepository extends JpaRepository<Manager, Integer> {
}
