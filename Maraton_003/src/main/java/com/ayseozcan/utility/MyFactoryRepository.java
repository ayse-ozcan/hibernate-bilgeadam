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
    private CriteriaBuilder criteriaBuilder;
    private Session ss;
    private Transaction tt;
    private T t;

    public MyFactoryRepository(T t) {
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
        this.t = t;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    public Session getSs() {
        return ss;
    }

    public Transaction getTt() {
        return tt;
    }

    public T getT() {
        return t;
    }

    public void openSession() {


        ss = getEntityManager().unwrap(Session.class);
        //      ss = HibernateUtility.getSessionFactory().openSession();
        tt = ss.beginTransaction();


    }

    public void closeSession() {
        tt.commit();
        ss.close();

    }

    @Override
    public <S extends T> S save(S entity) {
        try {
            openSession();
            ss.save(entity);
            closeSession();
            return entity;
        } catch (Exception exception) {
            tt.rollback();
            throw exception;
        }
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entites) {
        try {
            openSession();
            entites.forEach(entity -> {
                ss.save(entity);
            });
            closeSession();
            return entites;
        } catch (Exception exception) {
            tt.rollback();
            throw exception;
        }
    }

    @Override
    public void delete(T entity) {
        try {
            openSession();
            ss.remove(entity);
            closeSession();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public EntityManager getEntityManager() {
        if (entityManager.isOpen()) {
            return entityManager;
        } else {
            return entityManager = HibernateUtility.getFACTORY().createEntityManager();
        }
    }

    @Override
    public void deleteById(ID id) {
        try {
            CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root = (Root<T>) criteria.from(t.getClass());
            criteria.select(root);
            criteria.where(criteriaBuilder.equal(root.get("id"), id));
            T deleteEntity = getEntityManager().createQuery(criteria).getSingleResult();
            openSession();
            ss.delete(deleteEntity);
            closeSession();
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        // select * from T
        openSession();
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"), id));
        List<T> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty()) return Optional.empty();
        closeSession();
        return Optional.of(result.get(0));
    }

    @Override
    public boolean existById(ID id) {
        try {
            CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root = (Root<T>) criteria.from(t.getClass());
            criteria.select(root);
            criteria.where(criteriaBuilder.equal(root.get("id"), id));
            List<T> result = getEntityManager().createQuery(criteria).getResultList();
            return !result.isEmpty();
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        openSession();
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        List<T> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        return result;
    }


    @Override
    public List<T> findByEntity(T entity) { //{Musteri{id=9, ad="mur",adres="Ankara",telefon=null ...}}
        List<T> result = null;
        Class cl = entity.getClass();
        Field[] fl = cl.getDeclaredFields();
        try {
            CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root = (Root<T>) criteria.from(t.getClass());
            criteria.select(root);
            List<Predicate> list = new ArrayList<>(); // kriter listesini tutacak
            for (int i = 0; i < fl.length; i++) {
                fl[i].setAccessible(true); // erişmek istediğim alan eğer erişime kapalı (private ise ) açıyoruz
                /**
                 * Eğer okumakta olduğun alan null değil ise ve aynı zamanda id kolonu değil ise
                 * kriter oluşturmaya başla diyoruz.
                 */
                if (fl[i].get(entity) != null && !fl[i].getName().equals("id")) {
                    /**
                     * Boolen, String, Long v.s. bu türlerin sorguları farklı olacaktır. bu nedenle
                     * bunları kontrol etmeniz gereklidir.
                     * String ad="muhammet"; -> DataType (String.class), DataName(ad), DataValue(muhammet)
                     * ad = "%mu%"
                     */
                    if (fl[i].getType().isAssignableFrom(String.class))
                        list.add(criteriaBuilder.like(root.get(fl[i].getName()), "%" + fl[i].get(entity) + "%"));
                    else if (fl[i].getType().isAssignableFrom(Long.class) && !fl[i].get(entity).equals(0))
                        list.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                    else
                        list.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                }
            }
            /**
             * select * from t where ad='%mur%' and adres='%Ankara%'
             */
            criteria.where(list.toArray(new Predicate[]{}));
            result = getEntityManager().createQuery(criteria).getResultList();
        } catch (Exception exception) {
            System.out.println("Beklenmeyen bir hata oluştu....: " + exception.toString());
        }
        return result;
    }


    public <S extends T> S update(S entity) {
        try {
            openSession();
            ss.update(entity);
            closeSession();
            return entity;
        } catch (Exception exception) {
            tt.rollback();
            throw exception;
        }
    }
}



