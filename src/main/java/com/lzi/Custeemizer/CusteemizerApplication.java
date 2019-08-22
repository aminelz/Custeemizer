package com.lzi.Custeemizer;

import com.lzi.Custeemizer.model.User;
import com.lzi.Custeemizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CusteemizerApplication {

	//private static final Logger logger = LoggerFactory.getLogger(CusteemizerApplication.class);
	@Autowired
	private UserRepository userrepo;
	public static void main(String[] args) {

		SpringApplication.run(CusteemizerApplication.class, args);
		//logger.info(("Testing the logger function"));
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			userrepo.save(new User("amine.laazizi@gmail.com", "admin",
					"Mohamed Amine", "Laazizi", Boolean.TRUE));
			userrepo.save(new User("client@gmail.com", "123456",
					"Client", "Uno", Boolean.FALSE));

		};
	}

}
