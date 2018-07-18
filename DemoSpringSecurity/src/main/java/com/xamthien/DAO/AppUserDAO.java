package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("AppUserDao")
@Transactional(rollbackFor = Exception.class)
public class AppUserDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<AppUser> getAllAppUser() {
    	String hql = "FROM AppUser";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public AppUser getUserByID(long id) {
    	AppUser bk = null;
         try {
        	 session = getSession();
             String hql = "from  AppUser where userId = "+id;
             Query que = session.createQuery(hql);
             bk = (AppUser)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertAppUser(AppUser sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateAppUser(AppUser sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteAppUser(AppUser sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
