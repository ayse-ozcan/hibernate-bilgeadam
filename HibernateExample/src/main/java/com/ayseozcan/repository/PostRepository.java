package com.ayseozcan.repository;

import com.ayseozcan.entity.Information;
import com.ayseozcan.entity.Post;
import com.ayseozcan.entity.User;
import com.ayseozcan.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PostRepository {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    public PostRepository() {

        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }


    public List<Tuple> findPostCount(){
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.multiselect(root.get("userId"),criteriaBuilder.count(root)).groupBy(root.get("userId"));
        List<Tuple> postList = entityManager.createQuery(criteriaQuery).getResultList();
        postList.forEach(x->{
            System.out.println("userId: " + x.get(0) + "--" + "count: " + x.get(1));
        });

        return postList;
    }
}
