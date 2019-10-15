package com.jbk.springauthor.PublicationManagement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicationManagementApplication implements ApplicationRunner {
	private static  final Logger Log =Logger.getLogger(PublicationManagementApplication.class.getName());	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(PublicationManagementApplication.class, args);
	
	}
	@Override
	public void run(ApplicationArguments applicationArguments)throws Exception{ 
		Log.debug("Debugging log");
		Log.info("Info log");
	}
}
