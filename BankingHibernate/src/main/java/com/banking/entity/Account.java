package com.banking.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "tbl_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private String accountNo = generateRandomAccountNo();
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Account(User user) {
        this.user = user;
    }

    private String generateRandomAccountNo() {

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
