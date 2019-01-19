package com.suseelbam.javatutorials.springData;

import com.suseelbam.javatutorials.springData.DataUtils.MockDataSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private MockDataSetup mockDataSetup;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mockDataSetup.setup();
	}


}

