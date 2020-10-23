package be.nd2k.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AuthModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthModuleApplication.class, args);
	}

}
