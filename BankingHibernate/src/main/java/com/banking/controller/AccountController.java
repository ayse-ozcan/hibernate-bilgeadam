package com.banking.controller;

import com.banking.app.BAUtils;
import com.banking.entity.Account;
import com.banking.entity.User;
import com.banking.service.AccountService;

public class AccountController {
    private AccountService accountService;
    public AccountController(){
        this.accountService =new AccountService();
    }
    public void createAccount(User user) {
        //Account account = new Account();
        //account.setUser(user);
        Account account  = new Account(user);
        accountService.save(account);
    }

    public void transferMoney(User user) {
        user.getAccounts().forEach(x-> System.out.println("Hesap no: "+ x.getAccountNo()));
        String fromAccountNo = BAUtils.readString("Hangi hesaptan gonderilecek");
        String toAccountNo = BAUtils.readString("Hangi hesaba gonderilecek ");
        double amount = BAUtils.readDouble("gonderilecek miktar");
        accountService.transferMoney(fromAccountNo,toAccountNo,amount,user);
    }
}
