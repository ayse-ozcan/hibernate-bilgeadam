package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Customer;
import com.ayseozcan.service.CustomerService;

import java.util.HashMap;
import java.util.Optional;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(){
        this.customerService = new CustomerService();
    }

    public void register(){
       Customer customer = new Customer();
       String firstName = BAUtils.readString("isim ");
       String lastName = BAUtils.readString("soyisim ");
       String email = BAUtils.readString("email ");
       String password = BAUtils.readString("password ");
       String identity = BAUtils.readString("identity ");
       customer.setFirstName(firstName);
       customer.setLastName(lastName);
       customer.setEmail(email);
       customer.setPassword(password);
       customer.setIdentity(identity);
       customerService.save(customer);
    }

    public Customer login() {

        String identity = BAUtils.readString("identity");
        String password = BAUtils.readString("password");
        Optional<Customer> optionalCustomer = customerService.findByEntity(identity);
        Customer customer;
        if(optionalCustomer.isEmpty()){
            System.out.println("boyle bir kullanici bulunamadi");
        }else{
            customer = optionalCustomer.get();
            if(customer.getPassword().equals(password)){
                return customer;
            }else{
                System.out.println("hatali sifre");
            }
        }
        return null;
    }

    public void changeAccountType(Customer customer) {
        String accountType = BAUtils.readString("hangi uyelige gecmek istiyorsunuz");
        customerService.changeAccountType(customer, accountType);
    }
}
