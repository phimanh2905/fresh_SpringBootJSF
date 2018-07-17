package com.xamthien.bean;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.xamthien.DAO.SachDAO;
import com.xamthien.model.Sach;
import com.xamthien.service.SachService;



@ManagedBean(name="sachbean")
@RequestScope
public class SachBean {
	@Autowired
	private SachService sachService;
	
	private ListDataModel<Sach> lst = null;

	public SachService getSachService() {
		return sachService;
	}

	public void setSachService(SachService sachService) {
		this.sachService = sachService;
	}
	//@RequestMapping("/sach")
	public ListDataModel<Sach> getLst() {
		List<Sach> list = sachService.getAllSach();
		//List<Sach> list = new SachDAO().getAllSach();
		this.lst= new ListDataModel<Sach>(list); 
		return this.lst;
	}

	public void setLst(ListDataModel<Sach> lst) {
		this.lst = lst;
	}
	//done
	//todo
	//diffcult
//	public static void main(String[] args) {
//		ListDataModel<Sach> lst = new SachBean().getLst();
//		for(Sach bk :lst)
//		{
//			System.out.println(bk.getName());
//		}
//	}
}
