package com.employeemanagement.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ModelData {

    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("Male", "Female");
    }
}
