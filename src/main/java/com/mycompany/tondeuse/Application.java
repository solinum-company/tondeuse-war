package com.mycompany.tondeuse;

/*************************************************************************************************************
*
* @author khalil
* 
* 
**************************************************************************************************************/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public void run() {
	}
        
  
}
