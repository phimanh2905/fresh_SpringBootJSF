package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("FlightSchedulesDao")
@Transactional(rollbackFor = Exception.class)
public class FlightSchedulesDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<FlightSchedules> getAllFlightSchedules() {
    	String hql = "FROM FlightSchedules";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }
//    public List<String> getRoleNames(Long userId) {
//        String sql = "Select r.roleName from FlightSchedules r where r.roleId in (select ur.FlightSchedules.roleId from UserRole ur where ur.appUser.userId="+userId+")";
//        session = getSession();
//		Query que = session.createQuery(sql);
//        return que.list();
//    }
    public FlightSchedules getFlightSchedulesByID(long id) {
    	FlightSchedules bk = null;
         try {
        	 session = getSession();
             String hql = "from  FlightSchedules where fid = "+id;
             Query que = session.createQuery(hql);
             bk = (FlightSchedules)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertFlightSchedules(FlightSchedules sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateFlightSchedules(FlightSchedules sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteFlightSchedules(FlightSchedules sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
