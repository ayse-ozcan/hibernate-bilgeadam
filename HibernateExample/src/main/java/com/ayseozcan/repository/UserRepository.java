package com.ayseozcan.repository;

import com.ayseozcan.entity.EGender;
import com.ayseozcan.entity.Information;
import com.ayseozcan.entity.User;
import com.ayseozcan.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class UserRepository {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public UserRepository() {

        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }
    public List<User> findAll(){

        CriteriaQuery<User> cq = criteriaBuilder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        List<User> userList = entityManager.createQuery(cq).getResultList();

        return userList;
    }

    public List<User> findNativeQuery(){

        String sql = "select * from tbluser";
        List<User> userList = entityManager.createNativeQuery(sql, User.class).getResultList();

        return userList;
    }

    public List<Information> findAllInformation(){

        CriteriaQuery<Information> informationCriteriaQuery = criteriaBuilder.createQuery(Information.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information"));
        List<Information> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();

        return informationList;
    }
    public List<String> findInformationByName(){

        CriteriaQuery<String> informationCriteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information").get("name"));

        List<String> infoList = entityManager.createQuery(informationCriteriaQuery).getResultList();

        return infoList;
    }

    public User findById(Long id){

        CriteriaQuery<User> cq = criteriaBuilder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(criteriaBuilder.equal(root.get("id"), id));

        User user = entityManager.createQuery(cq).getSingleResult();

        return user;
    }

    public User findByUsername(String username){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));

        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        if(users.isEmpty()){
            System.out.println("boyle bir kullanici bulunamadi");
            return null;
        }
        return users.get(0);

    }

    public List<User> startWithValue(String value){

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery .from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("information").get("name"), value+ "%"));
        List<User> userList = entityManager.createQuery(criteriaQuery ).getResultList();

        return userList;
    }

    public void multipleWhere(){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("postCount"), 5),
                criteriaBuilder.like(root.get("information").get("name"), "a%"))
        );
        List<User> userList = entityManager.createQuery(criteriaQuery).getResultList();
        userList.forEach(System.out::println);
    }

    public int sumPost() {

        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(criteriaBuilder.sum(root.get("postCount")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public int findMaxPost(){

        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(criteriaBuilder.max(root.get("postCount")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
    public User findMaxPost2(){

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("postCount")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }


    public List<Object[]> selectMoreColumn(){

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);

        Path<String> usernamePath = root.get("username");
        Path<String> genderPath = root.get("gender");
        Path<Integer> postPath = root.get("postCount");

        criteriaQuery.multiselect(criteriaBuilder.array(usernamePath,genderPath,postPath));
        List<Object[]> users = entityManager.createQuery(criteriaQuery).getResultList();
        users.forEach(x ->

        {System.out.println("username:" + x[0]+ " - gender" +x[1] + " postCount" +x[2]);
        });

        return users;
    }

    public List<Object[]> selectMoreColumn2(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("username"),root.get("eGender"),root.get("postCount"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Object[]> countGender(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("eGender"),criteriaBuilder.count(root)).groupBy(root.get("eGender"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Object[]> countGender2(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("username"),root.get("eGender"),root.get("postCount"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
