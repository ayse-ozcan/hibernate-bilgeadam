package com.ayseozcan.repository;

import com.ayseozcan.entity.Product;
import com.ayseozcan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepository extends MyFactoryRepository<Product, Long> {

    public ProductRepository(){
        super(new Product());
    }

    public List<Product> listLessThanTen(){
        openSession();
        CriteriaQuery<Product> criteriaQuery = getCriteriaBuilder()
                .createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        criteriaQuery.where(getCriteriaBuilder().lessThanOrEqualTo(root.get("stock"), 10));
        List<Product> result = getEntityManager().createQuery(criteriaQuery).getResultList();
        closeSession();
        return result;

    }
}
