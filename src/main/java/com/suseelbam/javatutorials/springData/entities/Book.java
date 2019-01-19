package com.suseelbam.javatutorials.springData.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOK")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private int pages;
    private String publication;

    @ManyToMany
    @JoinColumn(name = "USERS_ID")
    private List<Users> writers;


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

    public List<Users> getWriters() {
        return writers;
    }

    public void setWriters(List<Users> writers) {
        this.writers = writers;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}
