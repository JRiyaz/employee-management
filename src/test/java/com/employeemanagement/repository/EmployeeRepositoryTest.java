package com.employeemanagement.repository;

import com.employeemanagement.entity.EmployeeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("It should get the Employee by email ID")
    void itShouldGetTheEmployeeByEmailId() {

//        Given
        final String email = "j.riyaz@gmail.com";

        final EmployeeEntity actual = new EmployeeEntity(
                1, "Riyaz J", 26, "Male", "8099531318",
                email, "Full Stack Java Developer");

//        When
        repository.save(actual);

//        Then
        final EmployeeEntity expected = repository.findByEmail(email).get();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("It should throw NoSuchElementException")
    void itShouldThrowNoSuchElementExceptionForEmailField() {
        //        Given
        final String email = "emailId";

//        When
//        Then
        Assertions.assertThatThrownBy(() -> repository.findByEmail(email).get())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }
}