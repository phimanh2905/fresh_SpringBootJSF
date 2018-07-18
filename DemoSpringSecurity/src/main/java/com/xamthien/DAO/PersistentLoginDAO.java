package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("PersistentLoginsDao")
@Transactional(rollbackFor = Exception.class)
public class PersistentLoginDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<PersistentLogins> getAllPersistentLogins() {
    	String hql = "FROM PersistentLogins";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public void insertPersistentLogins(PersistentLogins sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updatePersistentLogins(PersistentLogins sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deletePersistentLogins(PersistentLogins sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
