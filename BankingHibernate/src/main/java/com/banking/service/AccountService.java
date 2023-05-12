package com.banking.service;

import com.banking.entity.Account;
import com.banking.entity.User;
import com.banking.repository.AccountRepository;
import com.banking.utility.MyFactoryService;

import java.util.Optional;

public class AccountService extends MyFactoryService<AccountRepository, Account,Long> {
    public AccountService(){
        super(new AccountRepository());
    }

    public void transferMoney(String fromAccountNo, String toAccountNo, double amount, User user) {
        Optional<Account> optionalFromAccount = getRepository().findByAccountByAccountNo(fromAccountNo);
        Optional<Account> optionalToAccount = getRepository().findByAccountByAccountNo(toAccountNo);

        if(optionalFromAccount.get().getBalance() < amount){
            System.out.println("bakiye yetersiz");
        }

        if(optionalFromAccount.isEmpty() || optionalToAccount.isEmpty()){
            System.out.println("hesap no lari kontrol edin");
        } else {
            optionalFromAccount.get().setBalance(optionalFromAccount.get().getBalance() - amount);
            optionalToAccount.get().setBalance(optionalToAccount.get().getBalance() + amount);
            getRepository().update(optionalFromAccount.get());
            getRepository().update(optionalToAccount.get());
            System.out.println("para gonderme islemi basarili");
        }
    }
}

