
package com.ayseozcan.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbluserprofile")
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, unique = true, nullable = false, insertable = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    private String authority;
    @Column(length = 50, nullable = false)
    private Long createat;
    @Column(nullable = false)
    private boolean isenabled;

    public UserProfile() {
    }

    public UserProfile(Long id, String username, String password, String email, String authority, Long createat, boolean isenabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
        this.createat = createat;
        this.isenabled = isenabled;
    }

    public UserProfile(String username, String password, String email, String authority, Long createat, boolean isenabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
        this.createat = createat;
        this.isenabled = isenabled;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public boolean isIsenabled() {
        return isenabled;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", authority=" + authority + ", createat=" + createat + ", isenabled=" + isenabled + '}';
    }
    
    
    
    
}
