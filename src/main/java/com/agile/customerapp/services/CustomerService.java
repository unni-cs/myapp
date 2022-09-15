package com.agile.customerapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.customerapp.models.Customer;
import com.agile.customerapp.repo.ICustomerRepo;

@Service
public class CustomerService {
	private List<Customer> customers;
	private CreditService creditService;
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	public CustomerService() {
		customers = new ArrayList<>();
		creditService = new CreditService();
		//setCustomerInfo();
		
		
	}
	
	private void setCustomerInfo() {
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
    }
	
	public Iterable<Customer> getCustomers() {
//		Customer customer1 = new Customer();
//		customer1.setName("unni");
//		customer1.setCreditScore(100);
//		customer1.setCustomerId("unni");
//		Customer cust = customerRepo.save(customer1);
//		customers.add(cust);
		return customerRepo.findAll();
	}
}
