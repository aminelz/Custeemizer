package com.lzi.Custeemizer;

import static org.assertj.core.api.Assertions.assertThat;

import com.lzi.Custeemizer.Common.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CusteemizerApplicationTests {

	@Autowired
	private CustomerController customercontrol;

	@Test
	public void contextLoads() {
		assertThat(customercontrol).isNotNull();
	}

}
