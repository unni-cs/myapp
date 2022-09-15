package com.agile.customerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.agile.customerapp.models.Customer;
import com.agile.customerapp.repo.ICustomerRepo;
import com.agile.customerapp.services.CreditService;

@Configuration
@ComponentScan({"com.agile.customerapp.services","com.agile.customerapp.repo"})
public class CustomerAppConfiguration {
	private ICustomerRepo customerRepo;
	private CreditService creditService;
	
	@Autowired
	public CustomerAppConfiguration(ICustomerRepo customerRepo,CreditService creditService) {
		this.customerRepo = customerRepo;
		this.creditService = creditService;
		initializeCustomers();
	}
	
	public void initializeCustomers() {
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer();
        customer1.setCustomerId("customer-1");
        customer1.setName("Clarisse Hannond");

        Customer customer2 = new Customer();
        customer2.setCustomerId("customer-2");
        customer2.setName("Bill Giacovelli");

        Customer customer3 = new Customer();
        customer3.setCustomerId("customer-3");
        customer3.setName("Colline Rive");

        Customer customer4 = new Customer();
        customer4.setCustomerId("customer-4");
        customer4.setName("Bernice Heading");

        Customer customer5 = new Customer();
        customer5.setCustomerId("customer-5");
        customer5.setName("Zack Dugan");

        Customer customer6 = new Customer();
        customer6.setCustomerId("customer-6");
        customer6.setName("Rupert Tessington");

        Customer customer7 = new Customer();
        customer7.setCustomerId("customer-7");
        customer7.setName("Allina Clench");
        
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);

        for (Customer customer : customers) {
            customer.setCreditScore(creditService.getCreditScore(customer.getCustomerId()));
        }
        
        customerRepo.saveAll(customers);
	}
}
