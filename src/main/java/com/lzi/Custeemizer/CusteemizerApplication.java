package com.lzi.Custeemizer;

import com.lzi.Custeemizer.model.EndUser;
import com.lzi.Custeemizer.model.UserCustomer;
import com.lzi.Custeemizer.repository.CustomerRepository;
import com.lzi.Custeemizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CusteemizerApplication {

	//private static final Logger logger = LoggerFactory.getLogger(CusteemizerApplication.class);
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CustomerRepository customerrepo;

	public static void main(String[] args) {

		SpringApplication.run(CusteemizerApplication.class, args);
		//logger.info(("Testing the logger function"));
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			//Creating two user entities
			EndUser user1 = new EndUser("amine.laazizi@gmail.com", "admin",
					"Mohamed Amine", "Laazizi", Boolean.TRUE);
			EndUser user2 = new EndUser("client@gmail.com", "123456",
					"Client", "Uno", Boolean.FALSE);
			EndUser user3 = new EndUser("testing", "testing",
					"testing", "testing", Boolean.FALSE);

			//creating instance of the Customer table
			UserCustomer customer1 = new UserCustomer("08/08/1997",
					"0650286171", user2);
			UserCustomer customer2 = new UserCustomer("testing", "testing", user3);

			//Saving all instances to the database using the repos
			userrepo.save(user1);
			userrepo.save(user2);
			userrepo.save(user3);
			customerrepo.save(customer1);
			customerrepo.save(customer2);

//			customerrepo.delete(customer2);
//			userrepo.delete(user3);


		};
	}

}
