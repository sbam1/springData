package com.suseelbam.javatutorials.springData.repositories;

import com.suseelbam.javatutorials.springData.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
