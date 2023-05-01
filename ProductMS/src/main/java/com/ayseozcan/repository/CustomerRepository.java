package com.ayseozcan.repository;

import com.ayseozcan.entity.Customer;
import com.ayseozcan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class CustomerRepository extends MyFactoryRepository<Customer, Long> {

    public CustomerRepository(){
        super(new Customer());
    }

    public Optional<Customer> findByEntity(String identity){
        openSession();
        CriteriaQuery<Customer> criteria = getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> root = criteria.from(Customer.class);
        criteria.select(root).where(getCriteriaBuilder().equal(root.get("identity"), identity));
        List<Customer> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty())
            return Optional.empty();
        closeSession();
        return Optional.of(result.get(0));
    }



}
