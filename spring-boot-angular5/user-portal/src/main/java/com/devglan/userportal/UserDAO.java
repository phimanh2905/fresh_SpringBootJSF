package com.devglan.userportal;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional(rollbackFor = Exception.class)
public class UserDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
    	String hql = "FROM User";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public User findById(long id) {
    	User bk = null;
         try {
        	 session = getSession();
             String hql = "from  User where id = "+id;
             Query que = session.createQuery(hql);
             bk = (User)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }
    

    public void create(User sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void update(User sp) {
    	session = getSession();
        session.update(sp);
    }
    public void delete(User sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
