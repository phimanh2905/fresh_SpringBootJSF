package com.xamthien.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.model.*;
import com.xamthien.service.*;
@CrossOrigin(origins = "*", maxAge = 3600)
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
    
    @RequestMapping(value = "/api/ps",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public void update(@Valid @RequestBody String json,HttpServletResponse response) throws IOException {
    	response.setCharacterEncoding("utf-8");
    	ObjectMapper mapper = new ObjectMapper();
    	PaymnetMethod pm = mapper.readValue(json, PaymnetMethod.class);
    	paymentMethodService.insertPaymnetMethod(pm);;
        response.getWriter().println("Thêm thành công"); 
    	//return cus;
    }
}
