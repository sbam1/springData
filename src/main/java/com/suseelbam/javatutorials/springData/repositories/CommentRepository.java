package com.suseelbam.javatutorials.springData.repositories;

import com.suseelbam.javatutorials.springData.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
