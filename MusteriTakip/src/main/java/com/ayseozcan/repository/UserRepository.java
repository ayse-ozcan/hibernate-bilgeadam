
package com.ayseozcan.repository;

import com.ayseozcan.entity.User;
import com.ayseozcan.utility.MyFactoryRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public class UserRepository extends MyFactoryRepository<User, Long>{
    
    public UserRepository(){
        super(new User());
    }
    
    public boolean isUser(String username, String password){
       
        /**
         * select count(*)>0 from tbl_user where username=? and password=?
         * "select count(*)>0 from tbluser where username= '"+username+"' and pwd='"+12345+"'";
         */
        
        CriteriaQuery<User> criteriaQuery = getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where
        (getCriteriaBuilder().and(getCriteriaBuilder().equal(root.get("username"), username), 
                getCriteriaBuilder().equal(root.get("password"), password)));
      
        List<User> userList = getEntityManager().createQuery(criteriaQuery).getResultList();
        return !userList.isEmpty();
    }
}
