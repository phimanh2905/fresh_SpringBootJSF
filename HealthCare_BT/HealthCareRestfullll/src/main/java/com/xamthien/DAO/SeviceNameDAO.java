package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("serviceNameDao")
@Transactional(rollbackFor = Exception.class)
public class SeviceNameDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<Services> getAll() {
    	String hql = "FROM Services";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public Services getServicesByName(String name) {
    	Services bk = null;
         try {
        	 session = getSession();
             String hql = "from  Services where name = '"+name+"'";
             Query que = session.createQuery(hql);
             bk = (Services)que.list().get(0);
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insert(Services sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void update(Services sp) {
    	session = getSession();
        session.update(sp);
    }
    public void delete(Services sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
