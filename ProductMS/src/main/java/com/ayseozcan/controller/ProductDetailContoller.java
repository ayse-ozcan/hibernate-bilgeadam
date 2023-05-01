package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Product;
import com.ayseozcan.entity.ProductDetail;
import com.ayseozcan.service.ProductDetailService;
import com.ayseozcan.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductDetailContoller {

    ProductDetailService productDetailService;
    private ProductService productService;

    public ProductDetailContoller(){
        this.productDetailService = new ProductDetailService();
        this.productService = new ProductService();
    }

    public void evaluateProduct(){

        long productId = BAUtils.readInt("degerlendirmek istediginiz urunun id si");
        String comment = BAUtils.readString("yorumunuz");
        int puan = BAUtils.readInt("puaniniz");
        Optional<Product> optionalProduct = productService.findById(productId);
        if(optionalProduct.isEmpty()){
            System.out.println("boyle bir urun bulunamadi");
        }else{
            ProductDetail productDetail = new ProductDetail();
            productDetail.setComment(comment);
            productDetail.setPuan(puan);

            //optionalProduct.get().getProductDetails().add(productDetail);
            productDetail.setProduct(optionalProduct.get());
            productDetailService.save(productDetail);
        }
    }

    public void findEvaluateProductId() {

        long id = BAUtils.readInt("degerlendirmelerini listeleyeceginiz urunun id si");
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isEmpty()) {
            System.out.println("boyle bir urun bulunamadi");
        } else {
            optionalProduct.get().getProductDetails().forEach(x -> System.out.println("yapilan yorum: " + x.getComment()
                    + " urun puani: " + x.getPuan()));
        }
    }
}
