package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional
public class PaymentMethodService {
	@Autowired
	private PaymentMethodDAO paymentMethodDAO;
	
	public List<PaymnetMethod> getAll() {
        return paymentMethodDAO.getAllPaymnetMethod();
    }

    public void insertPaymnetMethod(PaymnetMethod sp) {
        this.paymentMethodDAO.insertPaymnetMethod(sp);;
    }
    public PaymnetMethod getPaymnetMethodByID(int ID) {
       return paymentMethodDAO.getPaymnetMethodByID(ID);
    }
    
    public void updatePaymnetMethod(PaymnetMethod sp) {
        this.paymentMethodDAO.updatePaymnetMethod(sp);;
    }
    public void deletePaymnetMethod(PaymnetMethod sp) {
        this.paymentMethodDAO.deletePaymnetMethod(sp);;
    }
}
