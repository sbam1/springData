package com.suseelbam.javatutorials.springData.repositories;

import com.suseelbam.javatutorials.springData.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostRepositoryCompTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BookRepository bookRepository;

    private Address address1;
    private Address address2;
    private Address address3;
    private Address address4;
    private Users userA;
    private Users userB;
    private Users userC;
    private Users userD;
    private Post postA;
    private Post postB;
    private Comment commentOneForPostA;
    private Comment commentTwoForPostA;
    private Comment commentThreeForPostA;
    private Comment commentOneForPostB;
    private Comment commentTwoForPostB;

    @Before
    @Transactional
    public void setup() {
        usersRepository.deleteAll();
        addressRepository.deleteAll();
        postRepository.deleteAll();
        address1 = new Address("4120 Appian Way Ct", "Columbus", "HO", 43230, "USA");
        address2 = new Address("4121 Appian Way Ct", "Gahanna", "HO", 43231, "USA");
        address3 = new Address("4122 Appian Way Ct", "Worthington", "HO", 43232, "USA");
        address4 = new Address("4123 Appian Way Ct", "grove port", "HO", 43233, "USA");
        addressRepository.saveAll(asList(address1, address2, address3, address4));

        userA = new Users("bamsuseel", "bamsuseel@email.com",address1);
        userB = new Users("anil123", "anil123@email.com", address3);
        userC = new Users("shyam", "shyam@email.com", address2);
        userD = new Users("susmapun", "susmapun@email.com",  address4);

        userA.setCreatedBy("me");

        usersRepository.saveAll(asList(userA, userB, userC, userD));

        postA = new Post("spring data Jpa", "this is about spring data Jpa");
        postA.setLikes(1000);
        //postA.setComments(Arrays.asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA));
        postB = new Post("wornderfull napal", "this post is about visit nepal 2020");
        postB.setLikes(34);
        //postB.setComments(Arrays.asList(commentOneForPostB, commentTwoForPostB));

        commentOneForPostA = new Comment("very nice I like it");
        commentOneForPostA.setCommenter(userA);
        commentOneForPostA.setPost(postA);


        commentTwoForPostA = new Comment("its good but little small");
        commentTwoForPostA.setPost(postA);
        commentTwoForPostA.setCommenter(userB);
        commentThreeForPostA = new Comment("thank you, its very helpful");
        commentThreeForPostA.setCommenter(userC);
        commentThreeForPostA.setPost(postA);

        commentOneForPostB = new Comment("nice country, I am going to visit");
        commentOneForPostB.setPost(postB);
        commentOneForPostB.setCommenter(userD);
        commentTwoForPostB = new Comment("its wonderful");
        commentTwoForPostB.setCommenter(userA);
        commentTwoForPostB.setPost(postB);

        postRepository.saveAll(asList(postA, postB));
        commentRepository.saveAll(asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA,
                commentOneForPostB, commentTwoForPostB));

        postB.setComments(asList(commentOneForPostB, commentTwoForPostB));
        postA.setComments(asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA));

        Book bookA = new Book();
        bookA.setTitle("spring data Jpa");
        bookA.setWriters(asList(userA, userB));
        bookA.setPages(230);
        bookA.setPublication("fake publication");
        Book bookB =   new Book();
        bookB.setTitle("Spring DATA Jpa");
        bookB.setWriters(singletonList(userC));

        Book bookC = new Book();
        bookC.setTitle("Spring MVC 4");
        bookC.setWriters(singletonList(userD));

        bookRepository.saveAll(Arrays.asList(bookA, bookB, bookC));

    }


    @Test
    public void findAll_should_return_all_posts() {
        List<Post> searchResults = postRepository.findAll();
        assert searchResults.size() == 2;
    }

    @Test
    @Transactional
    public void findByTitle_should_return_post_by_given_title() {

        Post post = postRepository.findByTitle("spring data Jpa");
        //assert post.getComments().size() == 3;
        assert post.getLikes() == 1000;
        //assert post.getComments().containsAll(Arrays.asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA));
    }

    @Test
    @Transactional
    public void findAllyByTitleMatchsWithBookTitle_should_return_post_maching_with_book_titleOpenProjection() {
        List<BookPost> posts = postRepository.findAllyByTitleMatchWithBookTitleOpenProjection();
        assert posts.size() == 1;
    }

    @Test
    @Transactional
    public void findAllyByTitleMatchsWithBookTitle_should_return_post_maching_with_book_titleDynamicProjection() {

        List<BookPostClass> posts = postRepository.usingNamedQueryMatchWithBookTitleDynamicProjection();
        assert posts.size() == 1;
    }



}
