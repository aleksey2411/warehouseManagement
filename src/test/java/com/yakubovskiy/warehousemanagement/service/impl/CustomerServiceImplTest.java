package com.yakubovskiy.warehousemanagement.service.impl;

import com.yakubovskiy.warehousemanagement.entity.Customer;
import com.yakubovskiy.warehousemanagement.repository.CustomerRepository;
import com.yakubovskiy.warehousemanagement.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CustomerServiceImpl.class})
public class CustomerServiceImplTest {
	@Autowired
	private CustomerService customerService;
	@MockBean
	private CustomerRepository customerRepository;
	private final int id = 10;
	private final String name = "alex2411";
	private final List<Customer> list;
	private Customer inputCustomer;
	private Customer outputCustomer;

	public CustomerServiceImplTest() {
		inputCustomer = Customer.builder()
				.id(id)
				.name(name)
				.build();
		outputCustomer = Customer.builder()
				.id(id)
				.name(name)
				.build();
		list = Arrays.asList(outputCustomer);
	}

	@Test
	public void findAllCustomers_success() {
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list, customerService.findAllCustomers());
	}

	@Test
	public void findCustomerById_success() {
		when(customerRepository.findById(id)).thenReturn(Optional.of(outputCustomer));
		assertEquals(outputCustomer,customerService.findById(id));
	}

	@Test
	public void removeCustomer_success() {
		when(customerRepository.findById(id)).thenReturn(Optional.of(inputCustomer));
		doNothing().when(customerRepository).delete(inputCustomer);
		customerService.removeCustomer(id);
		verify(customerRepository).delete(inputCustomer);
	}

	@Test
	public void findCustomerById_invalidIndex() {
		when(customerRepository.findById(id)).thenReturn(null);
		assertThrows(NullPointerException.class, ()->customerService.findById(id));
	}

}