package com.suseelbam.javatutorials.springData.controllers;

import com.suseelbam.javatutorials.springData.entities.Post;
import com.suseelbam.javatutorials.springData.repositories.BookPost;
import com.suseelbam.javatutorials.springData.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    @ResponseBody
    public List<Post> getPosts() {
        return postService.getAllPost();
    }

    @RequestMapping("/special-posts")
    @ResponseBody
    public List<BookPost> getSpecialPosts() {
        return postService.getSpecialPosts();
    }

    @RequestMapping("/")
    @ResponseBody
    public String homePage() {
        return "wel come to home";
    }
}
