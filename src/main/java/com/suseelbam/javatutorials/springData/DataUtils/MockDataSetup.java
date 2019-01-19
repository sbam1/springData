package com.suseelbam.javatutorials.springData.DataUtils;

import com.suseelbam.javatutorials.springData.entities.Address;
import com.suseelbam.javatutorials.springData.entities.Comment;
import com.suseelbam.javatutorials.springData.entities.Post;
import com.suseelbam.javatutorials.springData.entities.Users;
import com.suseelbam.javatutorials.springData.repositories.AddressRepository;
import com.suseelbam.javatutorials.springData.repositories.CommentRepository;
import com.suseelbam.javatutorials.springData.repositories.PostRepository;
import com.suseelbam.javatutorials.springData.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MockDataSetup {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

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


    public void setup() {
        usersRepository.deleteAll();
        addressRepository.deleteAll();
        postRepository.deleteAll();
        address1 = new Address("4120 Appian Way Ct", "Columbus", "HO", 43230, "USA");
        address2 = new Address("4121 Appian Way Ct", "Gahanna", "HO", 43231, "USA");
        address3 = new Address("4122 Appian Way Ct", "Worthington", "HO", 43232, "USA");
        address4 = new Address("4123 Appian Way Ct", "grove port", "HO", 43233, "USA");
        addressRepository.saveAll(Arrays.asList(address1, address2, address3, address4));

        userA = new Users("bamsuseel", "bamsuseel@email.com",address1);
        userB = new Users("anil123", "anil123@email.com", address3);
        userC = new Users("shyam", "shyam@email.com", address2);
        userD = new Users("susmapun", "susmapun@email.com",  address4);

        userA.setCreatedBy("me");

        usersRepository.saveAll(Arrays.asList(userA, userB, userC, userD));

        postA = new Post("spring data Jpa", "this is about spring data Jpa");
        postA.setLikes(1000);
        postA.setCreatedBy("suseel bam");
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

        postRepository.saveAll(Arrays.asList(postA, postB));
        commentRepository.saveAll(Arrays.asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA,
                commentOneForPostB, commentTwoForPostB));

        postB.setComments(Arrays.asList(commentOneForPostB, commentTwoForPostB));
        postA.setComments(Arrays.asList(commentOneForPostA, commentTwoForPostA, commentThreeForPostA));

    }
}
