
package com.ayseozcan.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud<T,ID> extends IRepository<T, ID> {
  
  
    <S extends T> S save(S entity);
    <S extends T> S update(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional<T> findById(ID id);
    boolean existById(ID id);
    List<T> findAll();
    List<T> findByEtntity(T entity);
    List<T> findByColumnAndValue(String column, Object value);
    void deleteById(ID id);
    void delete(T entity);
    
}
