package com.ayseozcan.service;

import com.ayseozcan.entity.AccountType;
import com.ayseozcan.entity.Customer;
import com.ayseozcan.repository.CustomerRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.util.Optional;

public class CustomerService extends MyFactoryService<CustomerRepository, Customer, Long> {

    public CustomerService(){
        super(new CustomerRepository());
    }
    public Optional<Customer> findByEntity(String identity){
        return getRepository().findByEntity(identity);
    }

    public void changeAccountType(Customer customer, String accountType) {
        AccountType accountType1 = AccountType.valueOf(accountType);
        if(accountType1 == AccountType.GOLD){
            customer.setAccountType(AccountType.GOLD);
            update(customer);
        }else if(accountType1 == AccountType.PREMIUM){
            customer.setAccountType(AccountType.PREMIUM);
            update(customer);
        }
    }
}
