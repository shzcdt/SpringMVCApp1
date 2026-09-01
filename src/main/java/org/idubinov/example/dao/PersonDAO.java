package org.idubinov.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.idubinov.example.models.Book;
import org.idubinov.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        return session.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.find(Person.class, id);

        person.setBirthYear(updatedPerson.getBirthYear());
        person.setFullName(updatedPerson.getFullName());
        person.setBooks(updatedPerson.getBooks());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person removePerson = session.find(Person.class, id);

        session.remove(removePerson);
    }

    @Transactional
    public Person getPersonByFullName(String fullName) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("FROM Person p WHERE p.full_name = :nameParam", Person.class)
                .setParameter("nameParam", fullName)
                .uniqueResult();
    }

    @Transactional
    public List<Book> getBooksByPersonId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.find(Person.class, id);

        return person.getBooks();
    }
}
