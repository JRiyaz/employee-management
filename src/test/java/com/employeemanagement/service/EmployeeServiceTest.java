package com.employeemanagement.service;

import com.employeemanagement.entity.EmployeeEntity;
import com.employeemanagement.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@ContextConfiguration(classes = EmployeeService.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    @DisplayName("It should get the employee by email Id")
    void itShouldGetTheEmployeeByEmailId() {

//        Given
        final String email = "j.riyaz@gmail.com";

        final EmployeeEntity actual = new EmployeeEntity(
                1, "Riyaz J", 26, "Male", "8099531318",
                email, "Full Stack Java Developer");

//        BDDMockito.given(repository.findByEmail(ArgumentMatchers.anyString()))
//                .willReturn(Optional.of(actual));

//        When
        Mockito.when(repository.findByEmail(Mockito.anyString()))
                .thenReturn(Optional.of(actual));

        final EmployeeEntity expected = service.findByEmail(email).get();

//        Then
        Assertions.assertThat(actual).isEqualTo(expected);

//        Check if findByEmail() method is getting called in the EmployeeRepository interface
//        Mockito.verify(repository, Mockito.never()).findByEmail(Mockito.anyString());
    }

    @Test
    @DisplayName("It should get the employee with id")
    void itShouldGetTheEmployeeWithId() {

//        Given
        final int id = 1;

        final EmployeeEntity actual = new EmployeeEntity(
                id, "Riyaz J", 26, "Male", "8099531318",
                "j.riyaz@gmail.com", "Full Stack Java Developer");

//        When
        Mockito.when(repository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(actual));

        final EmployeeEntity expected = service.findById(id).get();

//        Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("It should get a list of employees")
    void itShouldGetAListOfEmployees() {

//        Given
        final List<EmployeeEntity> actual = Arrays.asList(
                new EmployeeEntity(
                        1, "Riyaz J", 26, "Male", "8099531318",
                        "j.riyaz@gmail.com", "Full Stack Java Developer"),
                new EmployeeEntity(
                        2, "Fayaz J", 23, "Male", "9019168638",
                        "j.fayaz@gmail.com", "Medical Coder"),
                new EmployeeEntity(
                        3, "Inthiyaz J", 19, "Male", "8985462507",
                        "j.inthiyaz@gmail.com", "CA")
        );

//        When
        Mockito.when(repository.findAll())
                .thenReturn(actual);

        final List<EmployeeEntity> expected = service.findAll();

//        Then
        Assertions.assertThat(expected)
                .isEqualTo(actual)
                .hasSize(3);
    }

    @Test
    @DisplayName("It should save the employee object")
    void itShouldSaveTheEmployeeObject() {

//        Given
        final EmployeeEntity actual = new EmployeeEntity(
                1, "Riyaz J", 26, "Male", "8099531318",
                "j.riyaz@gmail.com", "Full Stack Java Developer");

//        When
        Mockito.when(repository.save(Mockito.any(EmployeeEntity.class)))
                .thenReturn(actual);

        final EmployeeEntity expected = service.save(actual);

//        Then
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("It should delete the employee by id")
    void itShouldDeleteTheEmployeeById() {

//        Given
        final int id = 1;

//        When
        service.deleteById(id);

//        Then
        Mockito.verify(repository, Mockito.times(1)).deleteById(Mockito.anyInt());
    }

}