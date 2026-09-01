package org.idubinov.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.idubinov.example.models.Book;
import org.idubinov.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {

    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return null;
    }

    public List<Book> getBooksByPersonId(int id) {
        return null;
    }
}
