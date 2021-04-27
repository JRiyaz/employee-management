package com.employeemanagement.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Name field cannot be null")
    @Length(min = 3, max = 50, message = "Name should be min 3 or max 50 characters long")
    @Column(length = 50)
    private String name;

    @Positive(message = "Age cannot be null")
    @NotNull(message = "Age field cannot be null")
    @Min(value = 18, message = "Age should be min 18")
    @Max(value = 60, message = "Age should be max 60")
    private int age;

    @NotNull(message = "Gender field cannot be null")
    @Column(length = 6)
    private String gender;

    @NotNull(message = "Phone field cannot be null")
    @Length(min = 10, max = 10, message = "Phone should be 10 characters long")
    @Column(length = 10)
    private String phone;

    @NotNull(message = "Email field cannot be null")
    @Email(message = "Invalid Email ID")
    @Length(min = 5, max = 50, message = "Email should be min 10 or max 50 characters long")
    @Column(length = 50)
    private String email;

    @NotNull(message = "Designation field cannot be null")
    @Size(min = 5, max = 50, message = "Designation should be min 10 or max 50 characters long")
    @Column(length = 50)
    private String designation;

    public EmployeeEntity(String name, int age, String gender, String phone, String email, String designation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.designation = designation;
    }
}
