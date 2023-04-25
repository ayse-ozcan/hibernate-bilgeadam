package com.ayseozcan.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tbluser")
public class User {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(length = 32, nullable = false )
    private String password;

    @Embedded
    private Information information;

    @Column(name = "cinsiyet")
    @Enumerated(EnumType.STRING)
    private EGender eGender;

    @ElementCollection
    private List<String> interests;

    @ElementCollection
    private Map<EAddressType,Address> address;

    public User() {

    }

    private int postCount;

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", information=" + information +
                ", eGender=" + eGender +
                ", interests=" + interests +
                ", address=" + address +
                ", postCount=" + postCount +
                '}';
    }

    public User(String username, String password, Information information, EGender eGender,
                List<String> interests, Map<EAddressType,Address> address, int postCount) {
        this.username = username;
        this.password = password;
        this.information = information;
        this.eGender = eGender;
        this.interests = interests;
        this.address = address;
        this.postCount = postCount;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
    }
}

