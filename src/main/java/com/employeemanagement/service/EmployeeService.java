package com.employeemanagement.service;

import com.employeemanagement.entity.EmployeeEntity;
import com.employeemanagement.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Optional<EmployeeEntity> findById(final int id) {
        return repository.findById(id);
    }

    public Optional<EmployeeEntity> findByEmail(final String email) {
        return repository.findByEmail(email);
    }

    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }

    public EmployeeEntity save(final EmployeeEntity employee) {
        return repository.save(employee);
    }

    public void deleteById(final int id) {
        repository.deleteById(id);
    }
}
