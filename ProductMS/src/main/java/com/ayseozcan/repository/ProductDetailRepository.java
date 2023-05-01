package com.ayseozcan.repository;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Product;
import com.ayseozcan.entity.ProductDetail;
import com.ayseozcan.utility.MyFactoryRepository;

import java.util.List;
import java.util.Optional;

public class ProductDetailRepository extends MyFactoryRepository<ProductDetail, Long> {

    public ProductDetailRepository(){
        super(new ProductDetail());
    }


}
