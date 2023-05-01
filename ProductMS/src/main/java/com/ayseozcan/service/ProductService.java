package com.ayseozcan.service;

import com.ayseozcan.entity.Product;
import com.ayseozcan.repository.ProductRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.util.List;

public class ProductService extends MyFactoryService<ProductRepository, Product, Long> {

    public ProductService(){
        super(new ProductRepository());
    }

    public List<Product> findAllLessThanTen(){
       return getRepository().listLessThanTen();
    }
}
