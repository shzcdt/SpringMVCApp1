package org.idubinov.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.idubinov.example.models.Book;
import org.idubinov.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BookDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Book p", Book.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.find(Book.class, id);
    }

    @Transactional
    public void save(Book book){
        Session session = sessionFactory.getCurrentSession();

        session.persist(book);
    }

    @Transactional
    public void update(int id, Book updatedBook){
        Session session = sessionFactory.getCurrentSession();

        Book book = session.find(Book.class, id);
        book.setOwner(updatedBook.getOwner());
        book.setAuthor(updatedBook.getAuthor());
        book.setName(updatedBook.getName());
        book.setPostYear(updatedBook.getPostYear());
    }

    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        Book removeBook = session.find(Book.class, id);

        session.remove(removeBook);
    }

    @Transactional
    public void assign(int bookId, int selectedPersonId) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.find(Book.class, bookId);
        Person person = session.find(Person.class, selectedPersonId);

        if (person.getBooks() != null){
            person.getBooks().add(book);
            book.setOwner(person);
        } else {
            person.setBooks(new ArrayList<>(Collections.singletonList(book)));
        }
    }

    @Transactional
    public void release(int bookId) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.find(Book.class, bookId);
        book.setOwner(null);
    }

    @Transactional
    public Person getBookOwner(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.find(Book.class, id).getOwner();
    }
}
