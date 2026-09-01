package org.idubinov.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.Collections;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Author must be indicated")
    @Column(name = "author")
    private String author;

    @Range(min = 0, max = 2026, message = "Please write wrong year of manufacture")
    @Column(name = "post_year")
    private int postYear;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Book() {
    }

    public Book(String name, String author, int postYear) {
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        if (this.owner == owner) return;

        Person oldOwner = this.owner;
        this.owner = owner;

        if (oldOwner != null && oldOwner.getBooks() != null){
            oldOwner.getBooks().remove(this);
        }

        if (owner != null && !owner.getBooks().contains(this)) {
            if (owner.getBooks() != null) {
                owner.getBooks().add(this);
            } else {
                owner.setBooks(new ArrayList<>(Collections.
                        singletonList(this)));
            }
        }
    }
}
