package com.employeemanagement.controller;

import com.employeemanagement.entity.EmployeeEntity;
import com.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("all")
    public String findAll(final Model model) {
        model.addAttribute("employees", service.findAll());
        return "employees";
    }

    @GetMapping("{email}")
    public String findByEmail(final @PathVariable String email, final Model model) {
        model.addAttribute("employee", service.findByEmail(email));
        return "employee";
    }

    @GetMapping("add")
    public String add(final Model model) {
        model.addAttribute("employeeEntity", new EmployeeEntity());
        return "add-employee";
    }

    @PostMapping("add")
    public String save(final @Valid @ModelAttribute EmployeeEntity employeeEntity, final BindingResult result) {

        if (result.hasErrors())
            return "add-employee";

        service.save(employeeEntity);
        return "redirect:/employee/all?employee-added=true";
    }

    @GetMapping("update/{id}")
    public String update(final @PathVariable int id, final Model model) {
        model.addAttribute("employeeEntity", service.findById(id).get());
        return "update-employee";
    }

    @PostMapping("update/{id}")
    public String update(final @PathVariable int id, final @Valid EmployeeEntity employeeEntity, final BindingResult result) {

        if (result.hasErrors())
            return "update-employee";
        final EmployeeEntity employee = service.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No value present"));

        employee.setName(employeeEntity.getName());
        employee.setAge(employeeEntity.getAge());
        employee.setEmail(employeeEntity.getEmail());
        employee.setGender(employeeEntity.getGender());
        employee.setPhone(employeeEntity.getPhone());
        employee.setDesignation(employeeEntity.getDesignation());

        service.save(employee);
        return "redirect:/employee/all?employee-updated=true";
    }

    @GetMapping("delete/{id}")
    public String deleteById(final @PathVariable int id) {
        service.deleteById(id);
        return "redirect:/employee/all?employee-deleted=true";
    }
}
