package com.xamthien.DAO;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xamthien.model.Sach;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
/**
 *
 * @author dangt
 */
@Repository("sachDao")
public class SachDAO {

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
             Configuration configuration = new Configuration().configure();
             SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();

             //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             Transaction transaction = session.beginTransaction();
             String hql = "from Sach where id = "+id;
             Query que = session.createQuery(hql);
             bk = (Sach)que.uniqueResult();
             transaction.commit();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertSacht(Sach sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sp);
        transaction.commit();
        //session.close();
    }

    
    public void updateSach(Sach sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(sp);
        transaction.commit();
        //session.close();
    }
    public void deleteSach(Sach sp) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(sp);
        transaction.commit();
        //session.close();
    }
   
    

}