package com.jbk.springauthor.PublicationManagement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicationManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PublicationManagementApplication.class, args);
	}

}
