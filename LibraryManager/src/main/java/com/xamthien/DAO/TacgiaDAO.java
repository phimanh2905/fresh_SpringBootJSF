package com.xamthien.DAO;

import java.util.List;
import com.xamthien.model.TacGia;
import com.xamthien.model.Sach;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author xamthiens
 */
@Repository("tacgiaDao")
@Transactional(rollbackFor = Exception.class)
public class TacgiaDAO extends ModelDAO {
	Session session;
	
    @SuppressWarnings("unchecked")
    public List<TacGia> getAllTacGia() {
    	String hql = "FROM TacGia";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public TacGia getTacGiaByID(int id) {
    	 TacGia bk = null;
    	 try {
        	 session = getSession();
             String hql = "from TacGia where id = "+id;
             Query que = session.createQuery(hql);
             bk = (TacGia)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertTacGiat(TacGia sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateTacGia(TacGia sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteTacGia(TacGia sp) {
    	session = getSession();
        session.delete(sp);
    }

   

}