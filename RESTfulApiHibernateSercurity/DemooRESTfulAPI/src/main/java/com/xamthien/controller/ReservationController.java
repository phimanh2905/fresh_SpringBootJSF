package com.xamthien.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.model.*;
import com.xamthien.service.*;

@RestController
public class ReservationController {
	@Autowired
    private CustomerService customerService;
	@Autowired
    private FlightSchedulesService flightService;
	@Autowired
    private PaymentMethodService paymentMethodService;
	@Autowired
    private ReservationStatusService reservationStatusService;
	@Autowired
    private ReservationService reservationService;
 
  
    @RequestMapping(value = "/api/reservation_p/{phone}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public List<Reservation> getReservationByPhone(@PathVariable("phone") String phone) {
        List<Reservation> list = reservationService.getReservationByPhone(phone);
        return list;
    }
    
    @RequestMapping(value = "/api/reservation",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public void saveReservation(@RequestBody String json,HttpServletResponse response) throws IOException, ParseException {
    	response.setCharacterEncoding("utf-8");
//    	ObjectMapper mapper = new ObjectMapper();
//    	Reservation res = mapper.readValue(json, Reservation.class);
    	
    	System.out.println(json);
    	
    	JSONParser parser = new JSONParser();
    	JSONObject objson = (JSONObject) parser.parse(json);
    	
    	long customerID = (long) objson.get("customerID");
    	long flightSchedulesID = (long)  objson.get("flightSchedulesID");
    	long paymnetMethodID = (long)  objson.get("paymnetMethodID");
    	long reservationStatusID = (long)  objson.get("reservationStatusID");
    	long dateOfReservation = (long) (objson.get("dateOfReservation")) ;
    	
    	Customer cus = customerService.geCustomerByID(customerID);
    	FlightSchedules flight = flightService.getFlightByID(flightSchedulesID);
    	PaymnetMethod pm = paymentMethodService.getPaymnetMethodByID(paymnetMethodID);
    	ReservationStatus stt = reservationStatusService.geStatusByID(reservationStatusID);
    	Date booking_date = new Date(dateOfReservation);
//    	SimpleDateFormat xxx = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    	String day = xxx.format(booking_date);
    	
    	Reservation ticket = new Reservation(cus, flight, pm, stt, booking_date);
    	
    	
        reservationService.insertReservation(ticket);
        //reservationService.insertReservationx(customerID, flightSchedulesID, paymnetMethodID, reservationStatusID, day);
        response.getWriter().println("Đặt vé thành công."); 
    }
}
