package com.suseelbam.javatutorials.springData.repositories;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class BookPostClass implements Serializable {
    private String title;
    private String desc;
    private int likes;
    private int pages;
    private String pub = "";

    public BookPostClass() {
    }

    public BookPostClass(String title, String desc, int likes, int pages, String pub) {
        this.title = title;
        this.desc = desc;
        this.likes = likes;
        this.pages = pages;
        this.pub = pub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }
}
