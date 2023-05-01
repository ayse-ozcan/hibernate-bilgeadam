package com.ayseozcan;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.app.Menu;
import com.ayseozcan.utility.HibernateUtility;

public class Main {
    public static void main(String[] args) {

        //HibernateUtility.getFACTORY().openSession();
        Menu menu = new Menu();
        menu.menu();
    }
}