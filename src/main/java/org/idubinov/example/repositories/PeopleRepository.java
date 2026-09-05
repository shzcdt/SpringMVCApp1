package org.idubinov.example.repositories;

import org.idubinov.example.models.Book;
import org.idubinov.example.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    List<Book> findBooksByPersonId();
}
