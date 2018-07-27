package com.xamthien.DAO;
import java.util.List;

import com.xamthien.DAO.ModelDAO;
import com.xamthien.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional(rollbackFor = Exception.class)
public class UserDAO extends ModelDAO {
	Session session;
	
	public AppUser getUserByName(String name)
	{
		AppUser us = null;
		String hql = "FROM AppUser where username='"+name+"'";
    	session = getSession();
		Query que = session.createQuery(hql);
		us = (AppUser) que.uniqueResult();
		return us;
	}
}
