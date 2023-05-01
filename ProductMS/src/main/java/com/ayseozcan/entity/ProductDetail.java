package com.ayseozcan.entity;

import javax.persistence.*;

@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int puan;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    public ProductDetail(String comment, int puan) {
        this.comment = comment;
        this.puan = puan;
    }

    public ProductDetail() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", puan=" + puan +
                ", product=" + product +
                '}';
    }
}
