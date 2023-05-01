package com.ayseozcan.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblcustomers")
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    @Column(unique = true)
    private String identity;

    @ManyToMany(mappedBy = "customers")
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.NORMAL;

    public Customer(String firstName, String lastName, String email, String password, String identity) {
        super(firstName, lastName, email);
        this.password = password;
        this.identity = identity;
        //accountType = AccountType.NORMAL;
    }

    public Customer() {

    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", products=" + products +
                '}';
    }
}
