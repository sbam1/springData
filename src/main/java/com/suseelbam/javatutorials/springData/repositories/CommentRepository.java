package com.suseelbam.javatutorials.springData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CommentRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
