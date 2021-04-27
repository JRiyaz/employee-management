package com.employeemanagement.repository;

import com.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("FROM EmployeeEntity e WHERE e.email = ?1")
    public Optional<EmployeeEntity> findByEmail(final String email);
}
