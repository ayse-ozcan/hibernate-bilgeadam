package com.ayseozcan.utility;


import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MyFactoryRepository<T, ID> implements ICrud<T, ID> {

    private EntityManager entityManager;
    private CriteriaBuilder builder;
    private Session ss;
    private Transaction tt;
    private T t;

    public MyFactoryRepository(T t){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        builder = entityManager.getCriteriaBuilder();
        this.t = t;
    }

    public void openSession(){
        ss = HibernateUtility.getFACTORY().openSession();
        tt = ss.beginTransaction();
    }
    public void closeSession(){
        tt.commit();
        ss.close();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public CriteriaBuilder getBuilder() {
        return builder;
    }


    @Override
    public <S extends T> S save(S entity) {
        try{
            openSession();
            ss.save(entity);
            closeSession();
            return entity;
        }catch(Exception exception){
            throw exception;
        }
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        try{
            openSession();
            entities.forEach(entity->{
                ss.save(entity);
            });
            closeSession();
            return entities;
        }catch(Exception exception){
            throw exception;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
        Root<T> root = (Root<T>)criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(builder.equal(root.get("id"), id));
        T result =  entityManager.createQuery(criteria).getSingleResult();
        return Optional.of(result);
    }

    @Override
    public boolean existById(ID id) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
        Root<T> root = (Root<T>)criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(builder.equal(root.get("id"), id));
        List<T> result = entityManager.createQuery(criteria).getResultList();
        return !result.isEmpty(); // exist -> kayıt var mı // isempty -> boş mu ?
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
        Root<T> root = (Root<T>)criteria.from(t.getClass());
        criteria.select(root);
        List<T> result = entityManager.createQuery(criteria).getResultList();
        return result;
    }

    @Override
    public List<T> findByEntity(T entity) {
        List<T> result = null;
        Class cl = entity.getClass();
        Field[] fl = cl.getDeclaredFields();
        try{
            CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
            Root<T> root = (Root<T>)criteria.from(t.getClass());
            criteria.select(root);
            List<Predicate> sorguListesi = new ArrayList<>();

            for(int i=0; i<fl.length; i++){
                fl[i].setAccessible(true);
                if(fl[i].get(entity)!=null && !fl[i].getName().equals("id")){
                    if(fl[i].getType().isAssignableFrom(String.class))
                        sorguListesi.add(builder.like(root.get(fl[i].getName()),"%"+fl[i].get(entity)+"%" ));
                    else if(fl[i].getType().isAssignableFrom(Integer.class))
                        sorguListesi.add(builder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                    else
                        sorguListesi.add(builder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                }
            }

            criteria.where(sorguListesi.toArray(new Predicate[]{})); // {Predicates,Predicates ....}
            result = entityManager.createQuery(criteria).getResultList();
        }catch(Exception exception){
            System.out.println("beklenmeyen bir sorun oluştu...: "+ exception.toString());
        }


        return result;
    }

    @Override
    public List<T> findByColumAndValue(String column, Object value) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
        Root<T> root = (Root<T>)criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(builder.equal(root.get(column), value));
        List<T> result = entityManager.createQuery(criteria).getResultList();
        return result;
    }

    @Override
    public void deleteById(ID id) {
        try{
            T deleteEntity = null;
            CriteriaQuery<T> criteria = (CriteriaQuery<T>)builder.createQuery(t.getClass());
            Root<T> root = (Root<T>)criteria.from(t.getClass());
            criteria.select(root);
            criteria.where(builder.equal(root.get("id"), id));
            List<T> result = entityManager.createQuery(criteria).getResultList();
            if(!result.isEmpty())
                deleteEntity = (T)result.get(0);
            openSession();
            ss.delete(deleteEntity);
            closeSession();
        }catch(Exception exception){
            throw  exception;
        }
    }

    @Override
    public void delete(T entity) {
        openSession();
        ss.delete(entity);
        closeSession();
    }

    @Override
    public <S extends T> S update(S entity) {
        try{
            openSession();
            ss.update(entity);
            closeSession();
            return entity;
        }catch(Exception exception){
            throw exception;
        }

    }
}

