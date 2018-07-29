package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("paymentMethodDAO")
@Transactional(rollbackFor = Exception.class)
public class PaymentMethodDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<PaymnetMethod> getAllPaymnetMethod() {
    	String hql = "FROM PaymnetMethod";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }
    public PaymnetMethod getPaymnetMethodByID(long id) {
    	PaymnetMethod bk = null;
         try {
        	 session = getSession();
             String hql = "from  PaymnetMethod where pid = "+id;
             Query que = session.createQuery(hql);
             bk = (PaymnetMethod)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }
    public void insertPaymnetMethod(PaymnetMethod sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updatePaymnetMethod(PaymnetMethod sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deletePaymnetMethod(PaymnetMethod sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
