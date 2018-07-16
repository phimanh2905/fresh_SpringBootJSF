package com.xamthien.DAO;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xamthien.model.TacGia;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author dangt
 */
public class TacgiaDAO {

    @SuppressWarnings("unchecked")
    public List<TacGia> getAllTacGia() {
        List<TacGia> list = null;
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from TacGia";
            Query que = session.createQuery(hql);
            list = que.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TacGia getTacGiaByID(int id) {
    	 TacGia bk = null;
         try {
             Configuration configuration = new Configuration().configure();
             SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();

             //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             Transaction transaction = session.beginTransaction();
             String hql = "from TacGia where id = "+id;
             Query que = session.createQuery(hql);
             bk = (TacGia)que.uniqueResult();
             transaction.commit();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertTacGiat(TacGia sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sp);
        transaction.commit();
        //session.close();
    }

    
    public void updateTacGia(TacGia sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(sp);
        transaction.commit();
        //session.close();
    }
    public void deleteTacGia(TacGia sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(sp);
        transaction.commit();
        //session.close();
    }
   
   

}