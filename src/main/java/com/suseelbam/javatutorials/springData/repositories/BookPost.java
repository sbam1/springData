package com.suseelbam.javatutorials.springData.repositories;

import org.springframework.beans.factory.annotation.Value;

public interface BookPost {

    @Value("#{target.title}")
    String getTitle();

    @Value("#{target.descp}")
    String getDesc();

    @Value("#{target.likes}")
    int getLikes();

    @Value("#{target.pages}")
    int getPages();

    @Value("#{target.pub}")
    String getPub();
}
