package com.ayseozcan.service;

import com.ayseozcan.entity.ProductDetail;
import com.ayseozcan.repository.ProductDetailRepository;
import com.ayseozcan.utility.MyFactoryService;

public class ProductDetailService extends MyFactoryService<ProductDetailRepository, ProductDetail,Long> {

    public ProductDetailService(){
        super(new ProductDetailRepository());
    }
}
