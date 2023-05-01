package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Category;
import com.ayseozcan.entity.Customer;
import com.ayseozcan.entity.Product;
import com.ayseozcan.service.CategoryService;
import com.ayseozcan.service.ProductService;

import java.util.Optional;

public class ProductController {

    private ProductService productService;

    private CategoryService categoryService;
    public ProductController(){
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }

    public void save(){
        Product product1 = new Product();
        String productName = BAUtils.readString("product name ");
        double productFiyat = BAUtils.readDouble("fiyat ");
        int productStok = BAUtils.readInt("stok ");
        long categoryId = BAUtils.readInt("category id");
        Optional<Category> optionalCategory = categoryService.findById(categoryId);
        if(optionalCategory.isPresent()){
            product1.setName(productName);
            product1.setPrice(productFiyat);
            product1.setStock(productStok);
            product1.setCategory(optionalCategory.get());
            productService.save(product1);
        }else{
            System.out.println("boyle bir kategori bulunmamaktadir");
        }

    }

    public void findAll(){

        /**
         * List<Product> products = productService.findAll();
         * products.forEach(System.out::println);
         */

        productService.findAll().forEach(System.out::println);
    }

    public void buyProduct(Customer customer) {

        productService.findAll().forEach(x->{
            System.out.println("name: " + x.getName() + " stok: " + x.getStock() + " id: " + x.getId());
        });
        long id = BAUtils.readInt("almak istediginiz urunun id si");
        int adet = BAUtils.readInt("kac adet almak istiyorsunuz?");
        Product product;
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isEmpty()){
            System.out.println("boyle bir urun bulunamadi");
        }else{
            product = optionalProduct.get();
            if(product.getStock()>= adet){
                product.getCustomers().add(customer);
                product.setStock(product.getStock() - adet);
                productService.update(product);
                System.out.println("urun satin alindi");
            }else{
                System.out.println("stokta " + product.getStock() + " urun kalmistir");
            }
        }
    }
    public void findAllLessThanTen(){
        productService.findAllLessThanTen().forEach(x-> System.out.println(x.getName()+ " " + x.getStock()));
    }


}
