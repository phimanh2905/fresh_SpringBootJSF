package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("appRoleDao")
@Transactional(rollbackFor = Exception.class)
public class AppRoleDAO extends ModelDAO {
Session session;
	
    @SuppressWarnings("unchecked")
    public List<AppRole> getAllAppRole() {
    	String hql = "FROM AppRole";
    	session = getSession();
		Query que = session.createQuery(hql);
        return que.list();
    }
    public List<String> getRoleNames(Long userId) {
        String sql = "Select r.roleName from AppRole r where r.roleId in (select ur.appRole.roleId from UserRole ur where ur.AppUser.userId="+userId+")";
 
        //String hql = "from PgProducts p where p.pgCategories.categoryId =" + CATEGORY_ID + " and p.productStatus=1 and p.productId not in (select ps.pgProducts.productId from PgProductSales ps where  salesStatus = 1)";
 
        session = getSession();
		Query que = session.createQuery(sql);
        return que.list();
    }
    public AppRole getRoleByID(long id) {
    	AppRole bk = null;
         try {
        	 session = getSession();
             String hql = "from  AppRole where roleId = "+id;
             Query que = session.createQuery(hql);
             bk = (AppRole)que.uniqueResult();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return bk;
    }

    public void insertAppRole(AppRole sp) {
    	session = getSession();
        session.save(sp);
    }

    
    public void updateAppRole(AppRole sp) {
    	session = getSession();
        session.update(sp);
    }
    public void deleteAppRole(AppRole sp) {
    	session = getSession();
        session.delete(sp);
    }
   
}
