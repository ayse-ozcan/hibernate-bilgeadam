package com.ayseozcan.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void openSession() {
        ss = HibernateUtility.getFACTORY().openSession();
        tt = ss.beginTransaction();
    }

    public void closeSession() {
        tt.commit();
        ss.close();
    }

    @Override
    public <S extends T> S save(S entity) {
        try
        {
            openSession();
            ss.save(entity);
            closeSession();
            return entity;

        } catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        try
        {
            openSession();
            entities.forEach(entity ->
            {
                ss.save(entity);
            });
            closeSession();
            return entities;
        } catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Optional<T> findById(ID id) {

        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        T result = entityManager.createQuery(criteriaQuery).getSingleResult();
        return Optional.of(result);
    }

    @Override
    public boolean existById(ID id) {

        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
        return !result.isEmpty(); // exist -> kayit var mi? //isEmpty -> bos mu?

    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;

    }

    @Override
    public List<T> findByEtntity(T entity) {

        List<T> result = null;
        Class cl = entity.getClass();
        Field[] fl = cl.getDeclaredFields();
        try
        {
            CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
            criteriaQuery.select(root);
            List<Predicate> sorguListesi = new ArrayList<>();

            for (int i = 0; i < fl.length; i++)
            {
                fl[i].setAccessible(true);
                if (fl[i].get(entity) != null && !fl[i].getName().equals("id"))
                {
                    if (fl[i].getType().isAssignableFrom(String.class))
                    {
                        sorguListesi.add(criteriaBuilder.like(root.get(fl[i].getName()), "%" + fl[i].get(entity) + "%"));
                    } else if (fl[i].getType().isAssignableFrom(Integer.class))
                    {
                        sorguListesi.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                    } else
                    {
                        sorguListesi.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(entity)));
                    }

                }
            }
            criteriaQuery.where(sorguListesi.toArray(new Predicate[]
            {
            }));
            result = entityManager.createQuery(criteriaQuery).getResultList();
        } catch (Exception e)
        {
            System.out.println("beklenmeyen bir sorun olustu" + e.toString());
        }

        return result;
    }

    @Override
    public List<T> findByColumnAndValue(String column, Object value) {

        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get(column), value));
        List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;

    }

    @Override
    public void deleteById(ID id) {
        try
        {
            T deleteEntity = null;
            CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
            Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
            List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
            if (!result.isEmpty())
            {
                deleteEntity = (T) result.get(0);
            }
            openSession();
            ss.delete(deleteEntity);
            closeSession();
        } catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void delete(T entity) {
        openSession();
        ss.delete(entity);
        closeSession();
    }

}
