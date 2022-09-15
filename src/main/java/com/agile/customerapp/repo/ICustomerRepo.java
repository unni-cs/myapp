package com.agile.customerapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.customerapp.models.Customer;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer>  {

}
