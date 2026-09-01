package org.idubinov.example.dao;

import org.idubinov.example.models.Book;
import org.idubinov.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {


    public List<Book> index() {
        return null;
    }

    public Book show(int id) {
        return null;
    }

    public void save(Book book){
    }

    public void update(int id, Book updatedBook){
    }

    public void delete(int id){
    }

    public void assign(int bookId, Person selectedPerson) {
    }

    public void release(int id) {
    }

    public Optional<Person> getBookOwner(int id) {
        return null;
    }
}
