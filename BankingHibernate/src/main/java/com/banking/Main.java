package com.banking;

import com.banking.app.Menu;
import com.banking.controller.UserController;
import com.banking.entity.Account;

public class Main {
    public static void main(String[] args) {

        //UserController userController = new UserController();
        //userController.saveUser();
        Menu menu = new Menu();
        menu.menu();
    }
}