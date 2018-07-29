package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("PaymentSttDao")
@Transactional(rollbackFor = Exception.class)
public class PaymentStatusDAO extends ModelDAO {
	Session session;

    public ReservationStatus getReservationStatusByID(long id) {
    	ReservationStatus bk = null;
         try {
        	 session = getSession();
             String hql = "from  ReservationStatus where rsid = "+id;
             Query que = session.createQuery(hql);
             bk = (ReservationStatus)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

   
   
}
