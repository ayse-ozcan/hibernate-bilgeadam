package com.ayseozcan.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbladmins")
public class Admin extends User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Admin() {
    }


}


