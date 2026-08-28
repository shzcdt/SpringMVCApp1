package org.idubinov.example.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Book {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Author must be indicated")
    private String author;

    @Range(min = 0, max = 2026, message = "Please write wrong year of manufacture")
    private int postYear;


    public Book() {
    }

    public Book(int id, String name, String author, int postYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.postYear = postYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostYear() {
        return postYear;
    }

    public void setPostYear(int postYear) {
        this.postYear = postYear;
    }
}
