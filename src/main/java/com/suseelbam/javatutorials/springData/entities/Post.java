package com.suseelbam.javatutorials.springData.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.suseelbam.javatutorials.springData.repositories.BookPostClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@SqlResultSetMapping(name="postBooks-mapping",
        classes={
                @ConstructorResult(targetClass= BookPostClass.class, columns={
                        @ColumnResult(name="title", type=String.class),
                        @ColumnResult(name="desc", type=String.class),
                        @ColumnResult(name="likes", type=Integer.class),
                        @ColumnResult(name="pages", type=Integer.class),
                        @ColumnResult(name="pub", type=String.class)
                })
        }
)
//@NamedNativeQuery(
//        name="Post.usingNamedQueryMatchWithBookTitleDynamicProjection",
//        query="select p.title as title, p.description as desc, p.likes as likes, b.pages as pages, b.publication as pub from POST p INNER JOIN BOOK b ON p.title = b.title",
//        resultSetMapping="postBooks-mapping"
//)
@Entity
@Table(name = "POST")
public class Post extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "POST_ID")
    private long id;
    private String title;
    private String description;
    private Date postedDate;
    private long likes;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", fetch = EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
        this.postedDate = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
