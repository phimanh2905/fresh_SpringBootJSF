package com.xamthien.DAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("reservationDao")
@Transactional(rollbackFor = Exception.class)
public class ReservationDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<Reservation> getReservationByPhone(String phone) { 
    	String hql = "FROM Reservation r where r.customer.phone='"+phone+"'"; // and r.dateOfReservation <= r.flightSchedules.departureTime
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }


    public void insertReservation(Reservation sp) {
    	session = getSession();
        session.save(sp);
    }

//    public void insertReservation(long cusID, long flightID,long pmID,long sttID,String date) {
//    	String hql = "Insert into RESERVATION(RESERVATION(CID,DATE_OF_RESERVATION,FID,PID,RSID)) values ("+cusID+",'"+date+"',"+flightID+","+pmID+","+sttID+")";
//    	session = getSession();
//		Query que = session.createQuery(hql);
//		que.executeUpdate();
//    }
    public void updateReservation(Reservation sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteReservation(Reservation sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
