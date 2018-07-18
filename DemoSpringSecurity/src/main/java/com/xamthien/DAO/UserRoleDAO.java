package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("UserRoleDao")
@Transactional(rollbackFor = Exception.class)
public class UserRoleDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<UserRole> getAllUserRole() {
    	String hql = "FROM UserRole";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public UserRole getUserRoleByID(long id) {
    	UserRole bk = null;
         try {
        	 session = getSession();
             String hql = "from  UserRole where id = "+id;
             Query que = session.createQuery(hql);
             bk = (UserRole)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertUserRole(UserRole sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateUserRole(UserRole sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteUserRole(UserRole sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
