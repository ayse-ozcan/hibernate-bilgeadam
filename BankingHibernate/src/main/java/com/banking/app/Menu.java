package com.banking.app;

import com.banking.controller.AccountController;
import com.banking.controller.UserController;
import com.banking.entity.User;

import java.util.HashMap;

public class Menu {

        private UserController userController;
        private AccountController accountController;
        public Menu(){
            this.userController = new UserController();
            this.accountController = new AccountController();
        }
        public void menu(){
            HashMap<Integer, String> menuItems = new HashMap<>();
            menuItems.put(1, "Register");
            menuItems.put(2, "Login");
            int key = BAUtils.menu(menuItems);

            switch (key){
                case 1:
                    userController.saveUser();
                    break;
                case 2:
                    User user = userController.login();
                    accountManagement(user);
                    break;
            }
        }

    public void accountManagement(User user){
        HashMap<Integer, String> menuItems = new HashMap<>();

        while(true){
            menuItems.put(1, "Hesap olustur");
            menuItems.put(2, "Para transferi");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    accountController.createAccount(user);
                    break;
                case 2:
                    accountController.transferMoney(user);
                    break;
            }
        }
    }
}
