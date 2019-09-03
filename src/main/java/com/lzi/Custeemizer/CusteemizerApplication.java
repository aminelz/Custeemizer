package com.lzi.Custeemizer;

import com.lzi.Custeemizer.model.*;
import com.lzi.Custeemizer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class CusteemizerApplication {

	//private static final Logger logger = LoggerFactory.getLogger(CusteemizerApplication.class);
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CustomerRepository customerrepo;
	@Autowired
	private CartRepository cartrepo;
	@Autowired
	private PaymentRepository paymentrepo;
	@Autowired
	private CartItemRepository itemrepo;
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private ShippingRepository shippingrepo;
	@Autowired
	private TshirtRepository tshirtrepo;


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
			EndUser user3 = new EndUser("client2@gmail.com", "123456",
					"Client", "Dos", Boolean.FALSE);

			//creating instance of the Customer table
			UserCustomer customer1 = new UserCustomer("08/08/1997",
					"0650286171", user2);
			UserCustomer customer2 = new UserCustomer("03/03/1989", "0537710200", user3);

			//creating instance of shipping and payment entities
			ShippingInfo shippinguser2 = new ShippingInfo("Sect 21 Avenue Annakhil n10", "10100",
					"Rabat", "Maroc", customer1);
			PaymentInfo paymentuser2 = new PaymentInfo("12345678901234", "Client",
					"Uno","Visa", "Sect 21 Avenue annakhil n10", customer1);

			ShippingInfo shippinguser3 = new ShippingInfo("Sect 3 Bloc H n3", "10100",
					"Rabat", "Maroc", customer2);
			PaymentInfo paymentuser3 = new PaymentInfo("43159712553701", "Client",
					"Dos","MasterCard", "Sect 3 Bloc H n3", customer2);

			//creating instance of Tshirts
			Tshirt tshirt1 = new Tshirt("Col V Classique","Homme", "Small", "Blanc",
					"T-shirt simple de couleur blanche avec un col V", "https://asda.scene7.com/is/image/Asda/5057983738821?hei=1800&wid=1354&qlt=85&fmt=pjpg&resmode=sharp&op_usm=1.1,0.5,0,0&defaultimage=default_details_George_rd",
					99, Boolean.FALSE);
			Tshirt tshirt2 = new Tshirt("Col V Classique","Homme", "Small", "Noir",
					"T-shirt simple de couleur noire avec un col V", "https://asda.scene7.com/is/image/Asda/5054924026733?hei=1800&wid=1354&qlt=85&fmt=pjpg&resmode=sharp&op_usm=1.1,0.5,0,0&defaultimage=default_details_George_rd",
					99, Boolean.FALSE);

			//Creating instance of Cart and cart item
			Cart cart1 = new Cart(LocalDateTime.now(), 0);
			CartItem cartItem1 = new CartItem(2, tshirt1, cart1);
			CartItem cartItem2 = new CartItem(3, tshirt2, cart1);
			cart1.setTotal(cartItem1.getQuantity()*cartItem1.getTshirt().getPrice());
			cart1.setTotal(cart1.getTotal()+cartItem2.getQuantity()*cartItem2.getTshirt().getPrice());

			//Creating instance of Order
			Order order1 = new Order("Pending_Confirmation", cart1.getTotal(), customer1,cart1);



			//Saving all instances to the database using the repos
			userrepo.save(user1);
			userrepo.save(user2);
			userrepo.save(user3);
			customerrepo.save(customer1);
			customerrepo.save(customer2);
			shippingrepo.save(shippinguser2);
			shippingrepo.save(shippinguser3);
			paymentrepo.save(paymentuser2);
			paymentrepo.save(paymentuser3);
			tshirtrepo.save(tshirt1);
			tshirtrepo.save(tshirt2);
			cartrepo.save(cart1);
			itemrepo.save(cartItem1);
			itemrepo.save(cartItem2);
			orderrepo.save(order1);
			customer1.setPayment(paymentuser2);
			customer1.setShipping(shippinguser2);
			customer2.setShipping(shippinguser3);
			customer2.setPayment(paymentuser3);
			customerrepo.save(customer1);
			customerrepo.save(customer2);


//			customerrepo.delete(customer2);
//			userrepo.delete(user3);


		};
	}

}
