package com.suseelbam.javatutorials.springData.services;


import com.suseelbam.javatutorials.springData.entities.Post;
import com.suseelbam.javatutorials.springData.repositories.BookPost;
import com.suseelbam.javatutorials.springData.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public List<BookPost> getSpecialPosts() {
        return postRepository.findAllyByTitleMatchWithBookTitleOpenProjection();
    }
}
