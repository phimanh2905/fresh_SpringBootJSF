package com.xamthien.bean;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.springframework.web.context.annotation.RequestScope;

import com.xamthien.model.Sach;
import com.xamthien.service.SachService;

@ManagedBean(name="sachbean")
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
		List<Sach> list = sachService.getAllSach();
		this.lst= new ListDataModel<Sach>(list); 
		return this.lst;
	}

	public void setLst(ListDataModel<Sach> lst) {
		this.lst = lst;
	}
	
}
