package org.idubinov.example.models;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+", message = "Your full name should be in this format: Ivan Dubinov")
    private String fullName;

    @Range(min = 1900, max = 2023, message = "Write the correct year of your Birthday")
    private int BirthYear;


    // Cтрана, Город, Индекс (6 цифр)
    // @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, Postal code (6 digits )")
    public Person() { }

    public Person(int id, String name, int birthYear) {
        this.id = id;
        this.fullName = name;
        this.BirthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }
}
