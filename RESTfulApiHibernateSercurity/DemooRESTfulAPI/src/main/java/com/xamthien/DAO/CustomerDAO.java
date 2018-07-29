package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("customerDao")
@Transactional(rollbackFor = Exception.class)
public class CustomerDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<Customer> getAllCustomer() {
    	String hql = "FROM Customer";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }

    public Customer getCustomerByID(long id) {
    	Customer bk = null;
         try {
        	 session = getSession();
             String hql = "from  Customer where cid = "+id;
             Query que = session.createQuery(hql);
             bk = (Customer)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }
    public Customer getCustomerByPhone(String phone) {
    	Customer bk = null;
         try {
        	 session = getSession();
             String hql = "from  Customer where phone = '"+phone+"' order by cid DESC";
             Query que = session.createQuery(hql);
             bk = (Customer)que.list().get(0);
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertCustomer(Customer sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateCustomer(Customer sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteCustomer(Customer sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
