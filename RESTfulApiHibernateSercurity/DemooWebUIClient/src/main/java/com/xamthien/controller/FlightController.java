package com.xamthien.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.json.simple.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xamthien.model.*;
import com.xamthien.utils.ParseJsonUtils;

@Controller
public class FlightController {
	//private final String domain = "http://192.168.11.105:8090";
	private final String domain = "http://192.188.88.119:8090";
	//=========================================================================================================================================
	@RequestMapping("/saveFlightBooking")
	public String doSaveCustomer(HttpServletRequest req, Model model) throws IOException {
		String msg = "";
		try
		{
			String flightID = req.getParameter("flightID");
			String cusname = req.getParameter("cusname");
			String cusphone = req.getParameter("cusphone");
			String cusemail = req.getParameter("cusemail");
			String paymethodID = req.getParameter("paymethod");
			String stk = req.getParameter("stk");
			
//			if(flightID.trim().equals("") || cusname.trim().equals("") || cusphone.trim().equals("") )
//			{
				Customer cus = new Customer(cusname,cusphone,cusemail);
				boolean check = saveCustomer(cus);
				
				Customer cusf = getCustomerByPhone(cus.getPhone());
				
				int FlightID = Integer.parseInt(flightID);
				
				int PayID = Integer.parseInt(paymethodID);
				
				
				if(check==false)
				{
					msg = "Đặt vé không thành công.";
				}
				else
				{
					int SttID=0;
					if(stk==null || stk.trim().equals(""))
					{
						SttID = 1;
					}
					else
					{
						SttID = 2;
					}
					
					
					Date now = new Date();
					
					//Reservation res = new Reservation(cusf,flight,pm,stt,now);
					check = saveReservation(cusf.getCid(),FlightID,PayID,SttID,now.getTime());
					if(check)
					{
						msg = "Đặt vé thành công.";
					}
					else
					{
						msg = "Đặt vé không thành công.";
					}
				}
				
				

		}
		catch (Exception e)
		{
			msg = "Đặt vé không thành công."+e;
			//model.addAttribute("list", getLstFlight(model,msg));
		}
		finally {
			model.addAttribute("list", getAllLstFlight());
			model.addAttribute("msg", msg);
		}
		//return "redirect:/index"; 
		return "trangchu";
	}
	//===================
	public Customer getCustomerByPhone(String phone) throws IOException
	{
		String Jsonpath = domain+"/api/customer/"+phone;
		Customer cus = new Customer();
        cus = (Customer) new ParseJsonUtils().get(Jsonpath, cus);
        return cus;
	}
	//===================
	public PaymnetMethod getpaymentMethodByID(int id) throws IOException
    {
		String Jsonpath = domain+"/api/paymentmethod/"+id;
        PaymnetMethod pm = new PaymnetMethod();
        pm = (PaymnetMethod) new ParseJsonUtils().get(Jsonpath, pm);
        return pm;
    }
	//======================
	public ReservationStatus getStatusByID(int id) throws IOException
    {
		String Jsonpath = domain+"/api/reservation_status/"+id;
        ReservationStatus stt = new ReservationStatus();
        stt = (ReservationStatus) new ParseJsonUtils().get(Jsonpath, stt);
        return stt;
    }
	//==========================================
	public boolean saveCustomer(Customer cus) throws IOException
    {
		boolean ckeck = true;
		JSONObject json = new JSONObject();
		json.put("cname", cus.getCName());  
    	json.put("phone", cus.getPhone());    
    	json.put("email", cus.getEmail());    
    	  

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    //HttpPost request = new HttpPost(domain+"/api/customer");
    		HttpPost request = new HttpPost(domain+"/api/customer");
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    ckeck = true;
    	} catch (Exception ex) {
    		ckeck = false;
    	} finally {
    	    httpClient.close();
    	}
    	return ckeck;
    }
	public boolean saveReservation(int CustomerID,int FlightID,int PayID,int SttID,long date) throws IOException
    {
		boolean ckeck = true;
		JSONObject json = new JSONObject();
    	 
//    	json.put("customer",new ParseJsonUtils().toJsonString(res.getCustomer()));    
//    	json.put("flightSchedules", new ParseJsonUtils().toJsonString(res.getFlightSchedules()));    
//    	json.put("paymnetMethod", new ParseJsonUtils().toJsonString(res.getPaymnetMethod()));   
//    	json.put("reservationStatus", new ParseJsonUtils().toJsonString(res.getReservationStatus()));
    	
    	json.put("customerID",CustomerID);    
    	json.put("flightSchedulesID", FlightID);    
    	json.put("paymnetMethodID", PayID);   
    	json.put("reservationStatusID", SttID);
    	json.put("dateOfReservation", date);

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    	try {
    	    //HttpPost request = new HttpPost(domain+"/api/reservation");
    		HttpPost request = new HttpPost(domain+"/api/reservation");
    	    StringEntity params = new StringEntity(json.toString());
    	    request.addHeader("content-type", "application/json");
    	    request.setEntity(params);
    	    httpClient.execute(request);
    	    ckeck = true;
    	} catch (Exception ex) {
    		ckeck = false;
    	} finally {
    	    httpClient.close();
    	}
    	return ckeck;
    }
	
    //============================================================================================================================================
	@RequestMapping("/searchx")
	public String search() {
		return "search";
	}
	@RequestMapping("/search")
	public void searchFlightBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String phone = request.getParameter("txtsearch");
		response.setCharacterEncoding("utf-8");
		try {
            List<Reservation> rs = searchReservationByPhone(phone);
            
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
                			+ "<td>"+hh.getDateOfReservation()+"</td>"
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
	public List<Reservation> searchReservationByPhone(String phone) throws IOException
    {
        String Jsonpath = domain+"/api/reservation_p/"+phone;
        List<Reservation> lst = (List<Reservation>) (Object) new ParseJsonUtils().getLst(Jsonpath, new Reservation());
		//resp.getWriter().println("xxx");
        return lst;
    }
	//============================================================================================================================================
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
    	
        return "loginPage";
    }
	@RequestMapping(value = "/manager/flight", method = RequestMethod.GET)
    public String xxx(Model model,Principal principal,HttpSession session) throws IOException {
		String userName = principal.getName();
        session.setAttribute("userName", userName);
        
        
        String Jsonpath = domain+"/api/flights";
        List<FlightSchedules> lst = (List<FlightSchedules>) (Object) new ParseJsonUtils().getLst(Jsonpath, new FlightSchedules());
		model.addAttribute("list", lst);
		model.addAttribute("newflight", new FlightSchedules());
        return "chuyenbay";
    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal,HttpSession session) {
 
        if (principal != null) {
        	String userName = principal.getName();
            session.setAttribute("userName", userName);
 
            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền truy cập vào đây!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
		
		return "redirect:/index";
    }
	
//	@RequestMapping("/testpost")
//    public void post(HttpServletRequest req,HttpServletResponse resp) throws IOException
//    {//var obj= {'empNo':id,'empName':name,'position':pos};
//		resp.setCharacterEncoding("utf-8");
//    	String id = req.getParameter("idx");
//    	String name = req.getParameter("namex");
//    	String pos = req.getParameter("posx");
//    	JSONObject json = new JSONObject();
//    	json.put("empNo", id);    
//    	json.put("empName", name);    
//    	json.put("position", pos);    
//
//    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//    	try {
//    	    //HttpPost request = new HttpPost("http://192.188.88.119:8080/employee");
//    		HttpPost request = new HttpPost("http://192.168.11.105:8080/employee");
//    	    StringEntity params = new StringEntity(json.toString());
//    	    request.addHeader("content-type", "application/json");
//    	    request.setEntity(params);
//    	    httpClient.execute(request);
//    	    resp.getWriter().println("Thêm thành công");
//    	} catch (Exception ex) {
//    	    // handle exception here
//    	} finally {
//    	    httpClient.close();
//    	}
//    }
//	@RequestMapping("/testput")
//    public void put(HttpServletRequest req,HttpServletResponse resp) throws IOException
//    {//var obj= {'empNo':id,'empName':name,'position':pos};
//		resp.setCharacterEncoding("utf-8");
//    	String id = req.getParameter("idx");
//    	String name = req.getParameter("namex");
//    	String pos = req.getParameter("posx");
//    	JSONObject json = new JSONObject();
//    	json.put("empNo", id);    
//    	json.put("empName", name);    
//    	json.put("position", pos);    
//
//    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//    	try {
//    	    HttpPut request = new HttpPut("http://192.188.88.119:8080/employee/"+id);
//    	    StringEntity params = new StringEntity(json.toString());
//    	    request.addHeader("content-type", "application/json");
//    	    request.setEntity(params);
//    	    httpClient.execute(request);
//    	    resp.getWriter().println("Sửa thành công");
//    	} catch (Exception ex) {
//    	    // handle exception here
//    	} finally {
//    	    httpClient.close();
//    	}
//    }
//	@RequestMapping("/testdelete")
//    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException
//    {//var obj= {'empNo':id,'empName':name,'position':pos};
//    	resp.setCharacterEncoding("utf-8");
//    	String id = req.getParameter("idx");   
//
//    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//    	try {
//    	    HttpDelete request = new HttpDelete("http://192.188.88.119:8080/employee/"+id);
//
//    	    request.addHeader("content-type", "application/json");
//    	    httpClient.execute(request);
//    	    resp.getWriter().println("Xóa thành công");
//    	} catch (Exception ex) {
//    		resp.getWriter().println("Xóa không thành công");
//    	} finally {
//    	    httpClient.close();
//    	}
//    }
	//=======================================================================================================================================
	@RequestMapping(value = {"/","/index"})
    public String getLstFlight(Model model,String msg) throws IOException
    {
        List<FlightSchedules> lst = getAllLstFlight();
    	model.addAttribute("msg", msg);
    	model.addAttribute("list", lst);
		//resp.getWriter().println("xxx");
        return "trangchu";
    }
	public List<FlightSchedules> getAllLstFlight() throws IOException
    {
		String Jsonpath = domain+"/api/flights";
        List<FlightSchedules> lst = (List<FlightSchedules>) (Object) new ParseJsonUtils().getLst(Jsonpath, new FlightSchedules());
		//resp.getWriter().println("xxx");
        return lst;
    }
	//========================================================================================================================================
	@RequestMapping("/chitiet/id={id}")
	public String doFlightBooking(@PathVariable int id, Model model) throws IOException {
		FlightSchedules fl = getFlightByID(id);
		model.addAttribute("flight", fl);	
		model.addAttribute("flightID", String.valueOf(id));
		model.addAttribute("listpayment", getLstPaymentMethod());
		return "datve";
	}
	public FlightSchedules getFlightByID(int id) throws IOException
    {
		String Jsonpath = domain+"/api/flight/"+id;
        FlightSchedules flight = new FlightSchedules();
        flight = (FlightSchedules) new ParseJsonUtils().get(Jsonpath, flight);
        return flight;
    }
	public List<PaymnetMethod> getLstPaymentMethod() throws IOException
    {
		String Jsonpath = domain+"/api/paymentmethods";
        List<PaymnetMethod> lst = (List<PaymnetMethod>) (Object) new ParseJsonUtils().getLst(Jsonpath, new PaymnetMethod());
		
        return lst;
    }
	//=======================================================================================================================================
}
