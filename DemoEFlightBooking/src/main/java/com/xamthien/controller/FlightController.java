package com.xamthien.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xamthien.model.*;
import com.xamthien.service.*;

@Controller
public class FlightController {
	
	@Autowired
	private FlightSchedulesService flightSchedulesService;
	
	@Autowired
	private PaymentMethodService paymentMethodService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ReservationStatusService statusService;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/")
	public String listSach(Model model) {	
		model.addAttribute("list", flightSchedulesService.getAllFlight());
		return "trangchu";
	}
	@RequestMapping("/saveFlightBooking")
	public String doSaveCustomer(HttpServletRequest req, Model model) {
		String msg = "";
		//@ModelAttribute("flightID") String flightID,@ModelAttribute("cusname") String cusname,
		//@ModelAttribute("cusphone") String cusphone,@ModelAttribute("cusemail") String cusemail,
		//@ModelAttribute("paymethod") String paymethodID,@ModelAttribute("stk") String stk,
		try
		{
			String flightID = req.getParameter("flightID");
			String cusname = req.getParameter("cusname");
			String cusphone = req.getParameter("cusphone");
			String cusemail = req.getParameter("cusemail");
			String paymethodID = req.getParameter("paymethod");
			String stk = req.getParameter("stk");
			System.out.println("====>>"+flightID+";"+cusname+";"+cusphone+";"+cusemail+";"+paymethodID+";"+stk);
//			if(flightID.trim().equals("") || cusname.trim().equals("") || cusphone.trim().equals("") )
//			{
				Customer cus = new Customer(cusname,cusphone,cusemail);
				customerService.insertCustomer(cus);
				
				FlightSchedules flight = flightSchedulesService.getFlightByID(Integer.parseInt(flightID));
				System.out.println(flight.getFFrom());
				PaymnetMethod pm = paymentMethodService.getPaymnetMethodByID(Integer.parseInt(paymethodID));
				System.out.println(pm.getPName());
				ReservationStatus stt= new ReservationStatus();
				if(stk==null || stk.trim().equals(""))
				{
					stt = statusService.geStatusByID(1);
				}
				else
				{
					stt = statusService.geStatusByID(2);
				}
				System.out.println(stt.getRsName());
				
				Date now = new Date();
				
				Reservation res = new Reservation(cus,flight,pm,stt,now);
				reservationService.insertReservation(res);
				
				msg = "Đặt vé thành công.";
				model.addAttribute("msg", msg);
				model.addAttribute("list", flightSchedulesService.getAllFlight());
//			}
//			else
//			{
//				throw new Exception();
//			}
		}
		catch (Exception e)
		{
			msg = "Đặt vé không thành công."+e;
			model.addAttribute("msg", msg);
			model.addAttribute("list", flightSchedulesService.getAllFlight());
		}
		return "trangchu";    
	}

	@RequestMapping("/chitiet/id={id}")
	public String doFlightBooking(@PathVariable int id, Model model) {
		FlightSchedules fl = flightSchedulesService.getFlightByID(id);
		model.addAttribute("flight", fl);	
		model.addAttribute("flightID", String.valueOf(id));
		model.addAttribute("listpayment", paymentMethodService.getAll());
		return "datve";
	}
}
