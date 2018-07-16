package com.xamthien.DAO;

import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.Sach;
import com.xamthien.model.TacGia;
import com.xamthien.service.SachService;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
/**
 *
 * @author xamthien
 */
@Repository("sachDao")
public class SachDAO extends ModelDAO {
	Session session;
	
//    @SuppressWarnings("unchecked")
//    public List<Sach> getAllSach() {
//        List<Sach> list = null;
//        try {
//        	session = getSession();
//            String hql = "from Sach";
//            Query que = session.createQuery(hql);
//            list = que.list();
//            //transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    @SuppressWarnings("unchecked")
    public List<Sach> getAllSach() {
        List<Sach> list = null;
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from Sach";
            Query que = session.createQuery(hql);
            list = que.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Sach getSachByID(int id) {
    	 Sach bk = null;
         try {
        	 session = getSession();
             String hql = "from Sach where id = "+id;
             Query que = session.createQuery(hql);
             bk = (Sach)que.uniqueResult();
             //transaction.commit();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertSacht(Sach sp) {
    	session = getSession();
        session.save(sp);
        
        //transaction.commit();
        //session.close();
    }

    
    public void updateSach(Sach sp) {
    	session = getSession();
        session.update(sp);
        //transaction.commit();
        //session.close();
    }
    public void deleteSach(Sach sp) {
    	session = getSession();
        session.delete(sp);
        //transaction.commit();
        //session.close();
    }
   
//    public static void main(String[] args) {
//		List<Sach> lst = new SachDAO().getAllSach();
//		for(Sach bk :lst)
//		{
//			System.out.println(bk.getName());
//		}
//		
//	}
}