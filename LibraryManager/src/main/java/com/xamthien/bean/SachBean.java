package com.xamthien.bean;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.xamthien.DAO.SachDAO;
import com.xamthien.model.Sach;
import com.xamthien.service.SachService;

import de.fred4jupiter.spring.boot.jsf.scope.ScopeName;

@ManagedBean(name="sachbean")
@Component
@RequestScope
public class SachBean {
	@ManagedProperty(value="#{sachService}")
	private SachService sachService;
	
	private ListDataModel<Sach> lst = null;

	public SachService getSachService() {
		return sachService;
	}

	public void setSachService(SachService sachService) {
		this.sachService = sachService;
	}

	public ListDataModel<Sach> getLst() {
		//List<Sach> list = sachService.getAllSach();
		List<Sach> list = new SachDAO().getAllSach();
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
