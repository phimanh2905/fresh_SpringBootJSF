package com.xamthien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xamthien.model.*;
import com.xamthien.service.*;

@RestController
public class PaymentMethodController {
	@Autowired
    private PaymentMethodService paymentMethodService;
 
  
    @RequestMapping(value = "/api/paymentmethods",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public List<PaymnetMethod> getAll() {
        List<PaymnetMethod> list = paymentMethodService.getAll();
        return list;
    }
    
    @RequestMapping(value = "/api/paymentmethod/{pid}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public PaymnetMethod getPaymentMethodByID(@PathVariable("pid") String pid) {
        PaymnetMethod pm = paymentMethodService.getPaymnetMethodByID(Integer.parseInt(pid));
        return pm;
    }
}
