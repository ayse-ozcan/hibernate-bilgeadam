package com.ayseozcan.app;

import com.ayseozcan.controller.CategoryController;
import com.ayseozcan.controller.CustomerController;
import com.ayseozcan.controller.ProductController;
import com.ayseozcan.controller.ProductDetailContoller;
import com.ayseozcan.entity.Customer;

import java.util.HashMap;

public class Menu {

    private CategoryController categoryController;
    private ProductController productController;
    private CustomerController customerController;
    private ProductDetailContoller productDetailContoller;

    public Menu(){
        this.categoryController = new CategoryController();
        this.productController = new ProductController();
        this.customerController = new CustomerController();
        this.productDetailContoller = new ProductDetailContoller();
    }
    public void menu(){
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Admin");
        menuItems.put(2, "Customer");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                adminMenu();
                break;
            case 2:
                customerMenu();
                break;
        }
    }

    private void adminMenu(){
        HashMap<Integer, String> menuItems = new HashMap<>();
        while(true){
            menuItems.put(1, "Kategori ekle");
            menuItems.put(2, "Urun ekle");
            menuItems.put(3, "Urun listele");
            menuItems.put(4, "Menuye don");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    categoryController.save();
                    break;
                case 2:
                    productController.save();
                    break;
                case 3 :
                    productController.findAll();
                    break;
                case 4:
                    menu();
                    break;
            }
        }
    }

    private void customerMenu(){
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Kayit ol");
        menuItems.put(2, "Giris Yap");

        int key = BAUtils.menu(menuItems);
        switch (key){
            case 1:
                customerController.register();
                break;
            case 2:
                Customer customer = customerController.login();
                if(customer != null){
                    customerManager(customer);
                }
                break;
        }
    }
    private void customerManager(Customer customer) {
        System.out.println(customer.getFirstName());
        HashMap<Integer, String> menuItems = new HashMap<>();
        while(true){
            menuItems.put(1, "Satin al");
            menuItems.put(2, "urunu degerlendir-(YORUM/PUAN)");
            menuItems.put(3, "stogu azalan urunleri listele");
            menuItems.put(4, "urun yorum ve puanlarini listele");
            menuItems.put(5, "hesabimi yukselt");


            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    productController.buyProduct(customer);
                    break;
                case 2:
                    productDetailContoller.evaluateProduct();
                    break;
                case 3:
                    productController.findAllLessThanTen();
                case 4:
                    productDetailContoller.findEvaluateProductId();
                case 5:
                    customerController.changeAccountType(customer);
            }
        }
    }
}
