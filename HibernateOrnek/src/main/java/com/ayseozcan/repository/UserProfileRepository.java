
package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.UserProfile;
import com.ayseozcan.utility.HibernateUtility;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserProfileRepository {
    
    private static Session ss;
    private static Transaction tr;
    
    private static EntityManager entityManager;
    private static CriteriaBuilder criteriaBuilder;
    
     public static void main(String[] args) {
        
         //save();
         entityManager = HibernateUtility.getFACTORY().createEntityManager();
         criteriaBuilder = entityManager.getCriteriaBuilder();
         //findAll();
         findByColumn();
         
    }
    
    public static void save(){
        
        ss = HibernateUtility.getFACTORY().openSession();
        tr = ss.beginTransaction();
        
        UserProfile userProfile;
        
        userProfile = new UserProfile("ayseozcan", "123", "ayse@gmail.com", "null", 1681732555000L, false);
        ss.save(userProfile);
        userProfile = new UserProfile("mertylmz", "1234", "mert@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("ece675", "12345", "ece@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("efetrk", "123456", "efe@gmail.com", "null", 1681732555000L, false);
        ss.save(userProfile);
        userProfile = new UserProfile("ege45", "1234567", "ege@gmail.com", "null", 1681732555000L, false);
        ss.save(userProfile);
        userProfile = new UserProfile("ada32", "12345678", "ada@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("aslioz", "123456789", "asli@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("dilara12", "1234567890", "dilara@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("cemcem", "01234560", "cem@gmail.com", "null", 1681732555000L, true);
        ss.save(userProfile);
        userProfile = new UserProfile("aylin78", "21234562", "aylin@gmail.com", "null", 1681732555000L, false);
        ss.save(userProfile);
        
        tr.commit();
        ss.close();
    }
    
    public static void findAll(){
        
        CriteriaQuery<UserProfile> criteriaQuery = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root = criteriaQuery.from(UserProfile.class);
        criteriaQuery.select(root);
        
        List<UserProfile> userList = entityManager.createQuery(criteriaQuery).getResultList();
        userList.forEach(System.out::println);
        
    }
    
    public static void findByColumn(){
        
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<UserProfile> root = criteriaQuery.from(UserProfile.class);
        criteriaQuery.select(root.get("username"));
        
        List<String> usernameList = entityManager.createQuery(criteriaQuery).getResultList();
        usernameList.forEach(System.out::println);
    }
    
   
}
