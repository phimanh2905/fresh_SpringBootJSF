package com.xamthien.controller;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xamthien.model.*;
import com.xamthien.service.*;
import com.xamthien.utils.WebUtils;

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
	@RequestMapping("/searchx")
	public String search() {
		return "search";
	}
	@RequestMapping("/search")
	public void searchFlightBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String phone = request.getParameter("txtsearch");
		response.setCharacterEncoding("utf-8");
		try {
            List<Reservation> rs = reservationService.getReservationByPhone(phone);
            
            String strtext = "";
            if(rs != null)
            {
            	int stt =1;
                for (Reservation hh : rs) 
                {
                	strtext+= "<tr> "
                			+ "<td>"+stt+"</td> "
                			+ "<td>"+hh.getFlightSchedules().getFFrom()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getFTo()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getDepartureTime()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getArrivalTime()+"</td>"
                			+ "<td>"+hh.getFlightSchedules().getAirline().getAName()+"</td>"
                			+ "<td>"+"99K"+"</td>"
                			+ "<td>"+hh.getReservationStatus().getRsName()+"</td>"
                			+ "</tr>";
                	stt++;
                }
            }
            else
            {
            	strtext="Không có dữ liệu hiển thị.";
            }
            response.getWriter().print(strtext);
        } catch (Exception ex) {
            response.getWriter().print("Lỗi truy vấn dữ liệu : " + ex.getMessage());
        }
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
    	
        return "loginPage";
    }
	@RequestMapping(value = "/manager/xxx", method = RequestMethod.GET)
    public String xxx(Model model) {
    	
        return "loginPage";
    }
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal,HttpSession session) {
 
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        session.setAttribute("userName", userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        //String userInfo = WebUtils.toString(loginedUser);
        //model.addAttribute("userInfo", userInfo);
        
        model.addAttribute("list", flightSchedulesService.getAllFlight());
		return "trangchu";
    }
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền truy cập vào đây!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
		model.addAttribute("list", flightSchedulesService.getAllFlight());
		return "trangchu";
    }
}
