package com.suseelbam.javatutorials.springData.repositories;

import com.suseelbam.javatutorials.springData.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);

    @Query(value = "select p.title as title, p.description as descp, p.likes as likes, b.publication as pub, b.pages from post p INNER JOIN book b ON p.title = b.title", nativeQuery = true)
    List<BookPost> findAllyByTitleMatchWithBookTitleOpenProjection();

//    @Query(nativeQuery = true)
//    List<BookPostClass> usingNamedQueryMatchWithBookTitleDynamicProjection();
}
